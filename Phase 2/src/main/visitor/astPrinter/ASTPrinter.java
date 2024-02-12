package main.visitor.astPrinter;

import main.ast.node.Program;
import main.ast.node.declaration.*;
import main.ast.node.expression.*;
import main.ast.node.expression.values.*;
import main.ast.node.statement.*;
import main.visitor.Visitor;

import java.lang.reflect.Method;

public class ASTPrinter extends Visitor<Void> {
    public void messagePrinter(int line, String message){
        System.out.println("Line:" + line + ":" + message);
    }

    @Override
    public Void visit(Program program) {
        messagePrinter(program.getLine(), program.getClass().getSimpleName());
        for (GlobalVarDeclaration globalVarDeclaration : program.getGlobalVars())
            globalVarDeclaration.accept(this);
        for (FunctionDeclaration functionDeclaration : program.getFunctions())
            functionDeclaration.accept(this);
        for (OnInitDeclaration onInitDeclaration : program.getInits())
            onInitDeclaration.accept(this);
        for (OnStartDeclaration onStartDeclaration : program.getStarts())
            onStartDeclaration.accept(this);
        program.getMain().accept(this);
        return null;
    }
    // ------------------------------------------------------------------------
    // declarations:
    @Override
    public Void visit(FunctionDeclaration functionDeclaration) {
        messagePrinter(functionDeclaration.getLine(), functionDeclaration.getClass().getSimpleName());
        functionDeclaration.getName().accept(this);
        for (VarDeclaration arg : functionDeclaration.getArgs())
            arg.accept(this);
        for (Statement statement : functionDeclaration.getBody())
            statement.accept(this);

        return null;
    }
    @Override
    public Void visit(MainDeclaration mainDeclaration) {
        messagePrinter(mainDeclaration.getLine(), mainDeclaration.getClass().getSimpleName());
        for (Statement statement: mainDeclaration.getBody())
            statement.accept(this);
        for (VarDeclaration varDec: mainDeclaration.getMainTrades())
            varDec.accept(this);

        return null;
    }
    @Override
    public Void visit(OnInitDeclaration onInitDeclaration) {
        messagePrinter(onInitDeclaration.getLine(), onInitDeclaration.getClass().getSimpleName());
        onInitDeclaration.getTradeName().accept(this);
        for (Statement statement : onInitDeclaration.getBody())
            statement.accept(this);

        return null;
    }
    @Override
    public Void visit(OnStartDeclaration onStartDeclaration) {
        messagePrinter(onStartDeclaration.getLine(), onStartDeclaration.getClass().getSimpleName());
        onStartDeclaration.getTradeName().accept(this);
        for (Statement statement : onStartDeclaration.getBody())
            statement.accept(this);

        return null;
    }
    @Override
    public Void visit(VarDeclaration varDeclaration) {
        messagePrinter(varDeclaration.getLine(), varDeclaration.getClass().getSimpleName() + " " +
                varDeclaration.getIdentifier().getName());
        if (varDeclaration.getValue() != null)
            varDeclaration.getValue().accept(this);

        return null;
    }
    @Override
    public Void visit(GlobalVarDeclaration globalVarDeclaration) {
        messagePrinter(globalVarDeclaration.getLine(), globalVarDeclaration.toString() + " " +
                globalVarDeclaration.getIdentifier().getName());
        if (globalVarDeclaration.getValue() != null)
            globalVarDeclaration.getValue().accept(this);

        return null;
    }
    // ------------------------------------------------------------------------
    // expressions:
    @Override
    public Void visit(ArrayIdentifier arrayIdentifier) {
        messagePrinter(arrayIdentifier.getLine(), arrayIdentifier.getClass().getSimpleName() + " " + arrayIdentifier.getName());
        arrayIdentifier.getIndex().accept(this);

        return null;
    }
    @Override
    public Void visit(BinaryExpression binaryExpression) {
        messagePrinter(binaryExpression.getLine(), binaryExpression.getClass().getSimpleName() + " " + binaryExpression.getBinaryOperator().toString());
        binaryExpression.getLeft().accept(this);
        binaryExpression.getRight().accept(this);
        return null;
    }
    @Override
    public Void visit(FunctionCall functionCall) {
        messagePrinter(functionCall.getLine(), functionCall.getClass().getSimpleName());
        functionCall.getFunctionName().accept(this);
        for (Expression arg : functionCall.getArgs())
            arg.accept(this);

        return null;
    }
    @Override
    public Void visit(Identifier identifier) {
        messagePrinter(identifier.getLine(), identifier.getClass().getSimpleName() + " " + identifier.getName());

        return null;
    }
    @Override
    public Void visit(MethodCall methodCall) {
        messagePrinter(methodCall.getLine(), methodCall.getClass().getSimpleName());
        methodCall.getInstance().accept(this);
        methodCall.getFunctionName().accept(this);
        for (Expression arg : methodCall.getArgs())
            arg.accept(this);

        return null;
    }
    @Override
    public Void visit(UnaryExpression unaryExpression) {
        messagePrinter(unaryExpression.getLine(), unaryExpression.getClass().getSimpleName() + " " + unaryExpression.getUnaryOperator().toString());
        unaryExpression.getOperand().accept(this);
        return null;
    }
    @Override
    public Void visit(VarAccess varAccess) {
        messagePrinter(varAccess.getLine(), varAccess.getClass().getSimpleName());
        varAccess.getInstance().accept(this);
        varAccess.getVariable().accept(this);

        return null;
    }
    @Override
    public Void visit(BoolValue value) {
        messagePrinter(value.getLine(), value.getClass().getSimpleName());

        return null;
    }
    @Override
    public Void visit(FloatValue value) {
        messagePrinter(value.getLine(), value.getClass().getSimpleName());

        return null;
    }

    @Override
    public Void visit(TradeValue value) {
        messagePrinter(value.getLine(), value.getClass().getSimpleName() + " " + value.getConstant());

        return null;
    }
    @Override
    public Void visit(IntValue value) {
        messagePrinter(value.getLine(), value.getClass().getSimpleName());

        return null;
    }
    @Override
    public Void visit(StringValue value) {
        messagePrinter(value.getLine(), value.getClass().getSimpleName());

        return null;
    }
    // ------------------------------------------------------------------------
    // statements:
    @Override
    public Void visit(AssignStmt assignStmt) {
        messagePrinter(assignStmt.getLine(), assignStmt.getClass().getSimpleName());
        assignStmt.getLValue().accept(this);
        assignStmt.getRValue().accept(this);

        return null;
    }
    @Override
    public Void visit(ContinueBreakStmt continueBreakStmt) {
        messagePrinter(continueBreakStmt.getLine(), continueBreakStmt.getClass().getSimpleName() + " " + continueBreakStmt.getToken());

        return null;
    }
    @Override
    public Void visit(ExpressionStmt expressionStmt) {
//        messagePrinter(expressionStmt.getLine(), expressionStmt.getClass().getSimpleName());
        expressionStmt.getExpression().accept(this);

        return null;
    }
    @Override
    public Void visit(ForStmt forStmt) {
        messagePrinter(forStmt.getLine(), forStmt.getClass().getSimpleName());
        for (Statement init : forStmt.getInit())
            init.accept(this);
        forStmt.getCondition()  .accept(this);
        for (Expression update : forStmt.getUpdate())
            update.accept(this);
        for (Statement statement : forStmt.getBody())
            statement.accept(this);

        return null;
    }
    @Override
    public Void visit(IfElseStmt ifElseStmt) {
        messagePrinter(ifElseStmt.getLine(), ifElseStmt.getClass().getSimpleName());
        ifElseStmt.getCondition().accept(this);
        for (Statement statement : ifElseStmt.getThenBody())
            statement.accept(this);
        for (Statement statement : ifElseStmt.getElseBody())
            statement.accept(this);

        return null;
    }
    @Override
    public Void visit(ReturnStmt returnStmt) {
        messagePrinter(returnStmt.getLine(), returnStmt.getClass().getSimpleName());
        returnStmt.getReturnedExpr().accept(this);

        return null;
    }
    @Override
    public Void visit(ThrowStmt throwStmt) {
        messagePrinter(throwStmt.getLine(), throwStmt.getClass().getSimpleName());
        throwStmt.getReturnedExpr().accept(this);

        return null;
    }
    @Override
    public Void visit(TryCatchStmt tryCatchStmt) {
        messagePrinter(tryCatchStmt.getLine(), tryCatchStmt.getClass().getSimpleName());
        for (Statement statement : tryCatchStmt.getThenBody())
            statement.accept(this);
        for (Statement statement : tryCatchStmt.getElseBody())
            statement.accept(this);

        return null;
    }
    @Override
    public Void visit(WhileStmt whileStmt) {
        messagePrinter(whileStmt.getLine(), whileStmt.getClass().getSimpleName());
        whileStmt.getCondition().accept(this);
        for (Statement statement : whileStmt.getBody())
            statement.accept(this);

        return null;
    }
}

