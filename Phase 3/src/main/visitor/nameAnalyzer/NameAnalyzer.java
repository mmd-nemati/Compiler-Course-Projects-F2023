package main.visitor.nameAnalyzer;

import main.ast.node.Program;
import main.ast.node.declaration.*;
import main.ast.node.statement.ForStmt;
import main.ast.node.statement.Statement;
import main.ast.type.complexType.TradeType;
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
        for (VarDeclaration varDeclaration : program.getVars())
            varDeclaration.accept(this);
        for (FunctionDeclaration functionDeclaration : program.getFunctions())
            functionDeclaration.accept(this);
        for (OnInitDeclaration onInitDeclaration : program.getInits())
            onInitDeclaration.accept(this);
        for (OnStartDeclaration onStartDeclaration : program.getStarts())
            onStartDeclaration.accept(this);
        program.getMain().accept(this);
        return null;
    }

    @Override
    public Void visit(OnInitDeclaration onInitDeclaration) {
        OnInitItem onInitItem = new OnInitItem(onInitDeclaration);
        SymbolTable onInitSymbolTable = new SymbolTable(SymbolTable.top, onInitDeclaration.getTradeName().getName());
        onInitItem.setOnInitSymbolTable(onInitSymbolTable);
        try {
            SymbolTable.root.put(onInitItem);
        } catch (ItemAlreadyExistsException e) {
            if (!onInitItem.getKey().endsWith("$"))
                nameErrors.add(new PrimitiveFunctionRedefinition(onInitDeclaration.getLine(), onInitItem.getDeclaration().getTradeName().getName()));
            onInitItem.setName(onInitItem.getKey() + "$");
        }
        SymbolTable.push(onInitSymbolTable);
        VarDeclaration initArg = new VarDeclaration();
        initArg.setIdentifier(onInitDeclaration.getTradeName());
        initArg.setType(new TradeType());
        initArg.accept(this);
        for (Statement stmt : onInitDeclaration.getBody())
            stmt.accept(this);
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(OnStartDeclaration onStartDeclaration) {
        OnStartItem onStartItem = new OnStartItem(onStartDeclaration);
        SymbolTable onStartSymbolTable = new SymbolTable(SymbolTable.top, onStartDeclaration.getTradeName().getName());
        onStartItem.setOnStartSymbolTable(onStartSymbolTable);
        try {
            SymbolTable.root.put(onStartItem);
        } catch (ItemAlreadyExistsException e) {
            if (!onStartItem.getKey().endsWith("$"))
                nameErrors.add(new PrimitiveFunctionRedefinition(onStartDeclaration.getLine(), onStartDeclaration.getTradeName().getName()));
            onStartItem.setName(onStartItem.getKey() + "$");
        }
        SymbolTable.push(onStartSymbolTable);
        VarDeclaration initArg = new VarDeclaration();
        initArg.setIdentifier(onStartDeclaration.getTradeName());
        initArg.setType(new TradeType());
        initArg.accept(this);
        for (Statement stmt : onStartDeclaration.getBody())
            stmt.accept(this);
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(MainDeclaration mainDeclaration) {
        MainItem mainItem = new MainItem(mainDeclaration);
        SymbolTable mainSymbolTable = new SymbolTable(SymbolTable.top, "main");
        mainItem.setMainSymbolTable(mainSymbolTable);
        SymbolTable.push(mainSymbolTable);
        for (Statement stmt : mainDeclaration.getBody())
            stmt.accept(this);
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(FunctionDeclaration functionDeclaration) {
        FunctionItem functionItem = new FunctionItem(functionDeclaration);
        SymbolTable functionSymbolTable = new SymbolTable(SymbolTable.top, functionDeclaration.getName().getName());
        functionItem.setFunctionSymbolTable(functionSymbolTable);
        try {
            SymbolTable.top.put(functionItem);
        } catch (ItemAlreadyExistsException e) {
            nameErrors.add(new MethodRedefinition(functionItem.getFunctionDeclaration().getLine(), functionItem.getFunctionDeclaration().getName().getName()));
        }
        SymbolTable.push(functionSymbolTable);
        try {
            SymbolTable.top.get("Variable_" + functionDeclaration.getName().getName());
            nameErrors.add(new FunctionVariableConflict(functionDeclaration.getLine(), functionDeclaration.getName().getName()));
        } catch (ItemNotFoundException e) {
            // pass
        }
        for (VarDeclaration varDeclaration : functionDeclaration.getArgs())
            varDeclaration.accept(this);
        for (Statement stmt : functionDeclaration.getBody())
            stmt.accept(this);
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(VarDeclaration varDeclaration) {
        VariableItem varItem = new VariableItem(varDeclaration);
        try {
            SymbolTable.top.get("Function_" + varDeclaration.getIdentifier().getName());
            nameErrors.add(new FunctionVariableConflict(varDeclaration.getLine(), varDeclaration.getIdentifier().getName()));
        } catch (ItemNotFoundException e) {
            // pass
        }
        try {
            SymbolTable.top.put(varItem);
        } catch (ItemAlreadyExistsException e) {
            if (!varItem.getName().endsWith("$"))
                nameErrors.add(new VariableRedefinition(varDeclaration.getLine(), varDeclaration.getIdentifier().getName()));
            varItem.setName(varItem.getName() + "$");
        }
        return null;
    }

    @Override
    public Void visit(ForStmt forStmt) {
        for (Statement stmt : forStmt.getInit())
            stmt.accept(this);
        return null;
    }
}

