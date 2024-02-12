package main.visitor.nameAnalyzer;

import main.ast.node.Program;
import main.ast.node.declaration.*;
import main.ast.node.statement.Statement;
import main.ast.type.complexType.TradeType;
import main.ast.type.primitiveType.VoidType;
import main.compileError.CompileError;
import main.compileError.name.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.itemException.ItemAlreadyExistsException;
import main.symbolTable.itemException.ItemNotFoundException;
import main.symbolTable.symbolTableItems.*;
import main.visitor.Visitor;

import java.util.ArrayList;

public class NameAnalyzer extends Visitor<Void> {

    public ArrayList<CompileError> nameErrors = new ArrayList<>();

    @Override
    public Void visit(Program program) {
        SymbolTable.root = new SymbolTable();
        SymbolTable.push(SymbolTable.root);

        for (GlobalVarDeclaration globalVarDeclaration : program.getGlobalVars())
            globalVarDeclaration.accept(this);
        for (FunctionDeclaration functionDeclaration : program.getFunctions())
            functionDeclaration.accept(this);
        for (OnInitDeclaration onInitDeclaration : program.getInits())
            onInitDeclaration.accept(this);
        for (OnStartDeclaration onStartDeclaration : program.getStarts())
            onStartDeclaration.accept(this);
        for (VarDeclaration trade : program.getMain().getMainTrades())
            trade.accept(this);
        program.getMain().accept(this);
        return null;
    }

    @Override
    public Void visit(OnInitDeclaration onInitDeclaration) {
        OnInitItem onInitItem = new OnInitItem(onInitDeclaration);
        SymbolTable onInitSymbolTable = new SymbolTable(SymbolTable.top, onInitDeclaration.getTradeName().getName());
        onInitItem.setOnInitSymbolTable(onInitSymbolTable);

        // TODO check the onInit name is redundant or not , if it is redundant change its name and put it
        while (true) {
            try {
                SymbolTable.top.put(onInitItem);
                break;
            } catch (ItemAlreadyExistsException e) {
                if (!onInitItem.getName().endsWith("#"))
                    nameErrors.add(new PrimitiveFunctionRedefinition(onInitDeclaration.getLine(),
                            onInitDeclaration.getTradeName().getName()));
                onInitItem.setName(onInitItem.getName() + "#");
            }
        }
        // TODO push onInit symbol table
        SymbolTable.push(onInitSymbolTable);

        VarDeclaration tradeDec = new VarDeclaration();
        tradeDec.setType(new TradeType());
        tradeDec.setIdentifier(onInitDeclaration.getTradeName());
        tradeDec.accept(this);

        // TODO visit statements
        for (Statement statement : onInitDeclaration.getBody())
            statement.accept(this);

        // TODO pop onInit symbol table
        SymbolTable.pop();

        return null;
    }

    @Override
    public Void visit(OnStartDeclaration onStartDeclaration) {
        OnStartItem onStartItem = new OnStartItem(onStartDeclaration);
        SymbolTable onStartSymbolTable = new SymbolTable(SymbolTable.top, onStartDeclaration.getTradeName().getName());
        onStartItem.setOnStartSymbolTable(onStartSymbolTable);

        // TODO check the onSnit name is redundant or not , if it is redundant change its name and put it
        while (true) {
            try {
                SymbolTable.top.put(onStartItem);
                break;
            } catch (ItemAlreadyExistsException e) {
                if (!onStartItem.getName().endsWith("#"))
                    nameErrors.add(new PrimitiveFunctionRedefinition(onStartDeclaration.getLine(),
                            onStartDeclaration.getTradeName().getName()));
                onStartItem.setName(onStartItem.getName() + "#");
            }
        }
        // TODO push onSnit symbol table
        SymbolTable.push(onStartSymbolTable);

        VarDeclaration tradeDec = new VarDeclaration();
        tradeDec.setType(new TradeType());
        tradeDec.setIdentifier(onStartDeclaration.getTradeName());
        tradeDec.accept(this);

        // TODO visit statements
        for (Statement statement : onStartDeclaration.getBody())
            statement.accept(this);

        // TODO pop onSnit symbol table
        SymbolTable.pop();

        return null;
    }

    @Override
    public Void visit(MainDeclaration mainDeclaration) {
        //TODO
        for (Statement statement : mainDeclaration.getBody())
            statement.accept(this);

        return null;
    }

    @Override
    public Void visit(FunctionDeclaration functionDeclaration) {
        var functionItem = new FunctionItem(functionDeclaration);
        var functionSymbolTable = new SymbolTable(SymbolTable.top, functionDeclaration.getName().getName());
        functionItem.setHandlerSymbolTable(functionSymbolTable);

        try {
            SymbolTable.top.put(functionItem);
        } catch (ItemAlreadyExistsException e) {
            nameErrors.add(new MethodRedefinition(functionDeclaration.getLine(),
                    functionDeclaration.getName().getName()));
        }
        try {
            SymbolTable.top.get("Variable_" + functionDeclaration.getName().getName());
            nameErrors.add(new FunctionVariableConflict(functionDeclaration.getLine(), functionDeclaration.getName().getName()));
        }
        catch (ItemNotFoundException e) {

        }
        SymbolTable.push(functionSymbolTable);

        for (VarDeclaration varDec : functionDeclaration.getArgs()) {
            varDec.accept(this);
        }

        for (var stmt : functionDeclaration.getBody()) {
            stmt.accept(this);
        }

        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(VarDeclaration varDeclaration) {
        var variableItem = new VariableItem(varDeclaration.getIdentifier().getName(), varDeclaration.getType());

        try {
            SymbolTable.top.get("Function_" + varDeclaration.getIdentifier().getName());
            nameErrors.add(new FunctionVariableConflict(varDeclaration.getLine(), varDeclaration.getIdentifier().getName()));
        }
        catch (ItemNotFoundException e) {

        }
        SymbolTable currentTable = SymbolTable.top;
        try {
            currentTable.put(variableItem);
        } catch (ItemAlreadyExistsException e) {
            nameErrors.add(new VariableRedefinition(varDeclaration.getLine(),
                    varDeclaration.getIdentifier().getName()));
        }

        return null;
    }

    @Override
    public Void visit(GlobalVarDeclaration globalVarDeclaration) {
        var variableItem = new VariableItem(globalVarDeclaration.getIdentifier().getName(), globalVarDeclaration.getType());

        try {
            SymbolTable.top.get("Function_" + globalVarDeclaration.getIdentifier().getName());
            nameErrors.add(new FunctionVariableConflict(globalVarDeclaration.getLine(), globalVarDeclaration.getIdentifier().getName()));
        }
        catch (ItemNotFoundException e) {

        }
        SymbolTable currentTable = SymbolTable.top;
        try {
            currentTable.put(variableItem);
        } catch (ItemAlreadyExistsException e) {
            nameErrors.add(new GlobalVariableRedefinition(globalVarDeclaration.getLine(),
                    globalVarDeclaration.getIdentifier().getName()));
        }

        return null;
    }
}

