package main.visitor.typeAnalyzer;

import main.ast.node.Program;
import main.ast.node.declaration.*;
import main.ast.node.expression.*;
import main.ast.node.statement.*;
import main.ast.type.Type;
import main.ast.type.complexType.TradeType;
import main.ast.type.primitiveType.BoolType;
import main.compileError.CompileError;
import main.compileError.type.ConditionTypeNotBool;
import main.symbolTable.SymbolTable;
import main.symbolTable.itemException.ItemNotFoundException;
import main.symbolTable.symbolTableItems.*;
import main.visitor.Visitor;

import java.util.ArrayList;

public class TypeAnalyzer extends Visitor<Void> {
    public ArrayList<CompileError> typeErrors = new ArrayList<>();
    TypeChecker expressionTypeChecker = new TypeChecker(typeErrors);

    @Override
    public Void visit(Program program) {
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
        try {
            OnInitItem onInitItem = (OnInitItem) SymbolTable.root.get(OnInitItem.START_KEY + onInitDeclaration.getTradeName().getName());
            SymbolTable.push(onInitItem.getOnInitSymbolTable());
        } catch (ItemNotFoundException e) {
            // pass
        }
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
        try {
            OnStartItem onStartItem = (OnStartItem) SymbolTable.root.get(OnStartItem.START_KEY + onStartDeclaration.getTradeName().getName());
            SymbolTable.push(onStartItem.getOnStartSymbolTable());
        } catch (ItemNotFoundException e) {
            // pass
        }
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
        try {
            MainItem mainItem = (MainItem) SymbolTable.root.get(MainItem.START_KEY + "main"); // "main" is the key for main function in SymbolTable
            SymbolTable.push(mainItem.getMainSymbolTable());
        } catch (ItemNotFoundException e) {
            // pass
        }
        for (Statement stmt : mainDeclaration.getBody())
            stmt.accept(this);
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(FunctionDeclaration functionDeclaration) {
        try {
            FunctionItem functionItem = (FunctionItem) SymbolTable.root.get(FunctionItem.START_KEY + functionDeclaration.getName().getName());
            SymbolTable.push(functionItem.getFunctionSymbolTable());
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
        Expression exp = varDeclaration.getRValue();
        if (exp != null) {
            exp.accept(expressionTypeChecker);
        }
        return null;
    }

    @Override
    public Void visit(IfElseStmt ifElseStmt) {
        Type conditionType = ifElseStmt.getCondition().accept(expressionTypeChecker);
        if (!(conditionType instanceof BoolType)) {
            typeErrors.add(new ConditionTypeNotBool(ifElseStmt.getLine()));
        }
        ifElseStmt.getThenBody().forEach(statement -> statement.accept(this));
        ifElseStmt.getElseBody().forEach(statement -> statement.accept(this));
        return null;
    }

    @Override
    public Void visit(WhileStmt whileStmt) {
        Type conditionType = whileStmt.getCondition().accept(expressionTypeChecker);
        if (!(conditionType instanceof BoolType)) {
            typeErrors.add(new ConditionTypeNotBool(whileStmt.getLine()));
        }
        whileStmt.getBody().forEach(statement -> statement.accept(this));
        return null;
    }

    @Override
    public Void visit(ForStmt forStmt) {
        Type conditionType = forStmt.getCondition().accept(expressionTypeChecker);
        if (!(conditionType instanceof BoolType)) {
            typeErrors.add(new ConditionTypeNotBool(forStmt.getLine()));
        }
        forStmt.getUpdate().forEach(statement -> statement.accept(this));
        forStmt.getBody().forEach(statement -> statement.accept(this));
        return null;
    }

    @Override
    public Void visit(AssignStmt assignStmt) {
        assignStmt.getLValue().accept(this);
        assignStmt.getRValue().accept(this);
        return null;
    }

    @Override
    public Void visit(ExpressionStmt expressionStmt) {
        expressionStmt.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        Expression returnedExpr = returnStmt.getReturnedExpr();
        if (returnedExpr != null) {
            returnedExpr.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ThrowStmt throwStmt) {
        throwStmt.getReturnedExpr().accept(this);
        return null;
    }

    @Override
    public Void visit(TryCatchStmt tryCatchStmt) {
        tryCatchStmt.getTryBlock().forEach(statement -> statement.accept(this));
        tryCatchStmt.getCatchBlock().forEach(statement -> statement.accept(this));
        return null;
    }

    @Override
    public Void visit(ArrayIdentifier arrayIdentifier) {
        arrayIdentifier.getIndex().accept(this);
        return null;
    }

    @Override
    public Void visit(FunctionCall functionCall) {
        functionCall.getArgs().forEach(expression -> expression.accept(this));
        return null;
    }

    @Override
    public Void visit(MethodCall methodCall) {
        methodCall.getInstance().accept(this);
        methodCall.getArgs().forEach(expression -> expression.accept(this));
        return null;
    }

    @Override
    public Void visit(VarAccess varAccess) {
        varAccess.getInstance().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryExpression unaryExpression) {
        unaryExpression.getOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        binaryExpression.accept(expressionTypeChecker);
        return null;
    }
}

