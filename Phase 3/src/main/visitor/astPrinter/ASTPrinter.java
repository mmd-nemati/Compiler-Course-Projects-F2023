package main.visitor.astPrinter;

import main.ast.node.Program;
import main.ast.node.declaration.*;
import main.ast.node.expression.*;
import main.ast.node.expression.values.BoolValue;
import main.ast.node.expression.values.FloatValue;
import main.ast.node.expression.values.IntValue;
import main.ast.node.expression.values.StringValue;
import main.ast.node.expression.values.TradeValue;
import main.ast.node.statement.*;
import main.ast.node.expression.Expression;
import main.ast.node.expression.Identifier;
import main.ast.node.statement.ExpressionStmt;
import main.ast.node.statement.Statement;
import main.visitor.Visitor;

public class ASTPrinter extends Visitor<Void> {
    public void messagePrinter(int line, String message) {
        System.out.println("Line:" + line + ":" + message);
    }

    @Override
    public Void visit(Program program) {
        messagePrinter(program.getLine(), program.toString());
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
    public Void visit(ExpressionStmt expressionStmt) {
        expressionStmt.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        messagePrinter(binaryExpression.getLine(), binaryExpression.toString());
        binaryExpression.getLeft().accept(this);
        binaryExpression.getRight().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryExpression unaryExpression) {
        messagePrinter(unaryExpression.getLine(), unaryExpression.toString());
        unaryExpression.getOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(FunctionCall functionCall) {
        messagePrinter(functionCall.getLine(), functionCall.toString());
        functionCall.getFunctionName().accept(this);
        for (Expression expression : functionCall.getArgs()) {
            expression.accept(this);
        }
        return null;
    }

    public Void visit(MethodCall methodCall) {
        messagePrinter(methodCall.getLine(), methodCall.toString());
        methodCall.getInstance().accept(this);
        methodCall.getFunctionName().accept(this);
        for (Expression expression : methodCall.getArgs()) {
            expression.accept(this);
        }
        return null;
    }

    public Void visit(BoolValue boolValue) {
        messagePrinter(boolValue.getLine(), boolValue.toString());
        return null;
    }

    public Void visit(IntValue intValue) {
        messagePrinter(intValue.getLine(), intValue.toString());
        return null;
    }

    public Void visit(FloatValue floatValue) {
        messagePrinter(floatValue.getLine(), floatValue.toString());
        return null;
    }

    public Void visit(StringValue stringValue) {
        messagePrinter(stringValue.getLine(), stringValue.toString());
        return null;
    }

    public Void visit(TradeValue tradeValue) {
        messagePrinter(tradeValue.getLine(), tradeValue.toString());
        return null;
    }

    @Override
    public Void visit(MainDeclaration mainDeclaration) {
        messagePrinter(mainDeclaration.getLine(), mainDeclaration.toString());
        for (Statement statement : mainDeclaration.getBody()) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(OnInitDeclaration onInitDeclaration) {
        messagePrinter(onInitDeclaration.getLine(), onInitDeclaration.toString());
        onInitDeclaration.getTradeName().accept(this);
        for (Statement statement : onInitDeclaration.getBody()) {
            statement.accept(this);
        }
        return null;
    }

    public Void visit(OnStartDeclaration onStartDeclaration) {
        messagePrinter(onStartDeclaration.getLine(), onStartDeclaration.toString());
        onStartDeclaration.getTradeName().accept(this);
        for (Statement statement : onStartDeclaration.getBody()) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FunctionDeclaration functionDeclaration) {
        messagePrinter(functionDeclaration.getLine(), functionDeclaration.toString());
        if (functionDeclaration.getName() != null)
            functionDeclaration.getName().accept(this);
        for (VarDeclaration varDeclaration : functionDeclaration.getArgs())
            varDeclaration.accept(this);
        for (Statement statement : functionDeclaration.getBody())
            statement.accept(this);
        return null;
    }

    @Override
    public Void visit(Identifier identifier) {
        messagePrinter(identifier.getLine(), identifier.toString());
        return null;
    }

    @Override
    public Void visit(ArrayIdentifier arrayIdentifier) {
        messagePrinter(arrayIdentifier.getLine(), arrayIdentifier.toString());
        arrayIdentifier.getIndex().accept(this);
        return null;
    }

    @Override
    public Void visit(AssignStmt assignStmt) {
        messagePrinter(assignStmt.getLine(), assignStmt.toString());
        if (assignStmt.getLValue() != null)
            assignStmt.getLValue().accept(this);
        if (assignStmt.getRValue() != null)
            assignStmt.getRValue().accept(this);
        return null;
    }

    @Override
    public Void visit(VarDeclaration varDeclaration) {
        messagePrinter(varDeclaration.getLine(), varDeclaration.toString());
        if (varDeclaration.getRValue() != null)
            varDeclaration.getRValue().accept(this);
        return null;
    }

    @Override
    public Void visit(ContinueBreakStmt continueBreakStmt) {
        messagePrinter(continueBreakStmt.getLine(), continueBreakStmt.toString());
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        messagePrinter(returnStmt.getLine(), returnStmt.toString());
        if (returnStmt.getReturnedExpr() != null)
            returnStmt.getReturnedExpr().accept(this);
        return null;
    }

    @Override
    public Void visit(IfElseStmt ifElseStmt) {
        messagePrinter(ifElseStmt.getLine(), ifElseStmt.toString());
        if (ifElseStmt.getCondition() != null)
            ifElseStmt.getCondition().accept(this);
        for (Statement statement : ifElseStmt.getThenBody())
            statement.accept(this);
        for (Statement statement : ifElseStmt.getElseBody())
            statement.accept(this);
        return null;
    }

    @Override
    public Void visit(WhileStmt whileStmt) {
        messagePrinter(whileStmt.getLine(), whileStmt.toString());
        if (whileStmt.getCondition() != null)
            whileStmt.getCondition().accept(this);
        for (Statement statement : whileStmt.getBody())
            statement.accept(this);
        return null;
    }

    @Override
    public Void visit(ForStmt forStmt) {
        messagePrinter(forStmt.getLine(), forStmt.toString());
        for (Statement statement : forStmt.getInit())
            statement.accept(this);
        if (forStmt.getCondition() != null)
            forStmt.getCondition().accept(this);
        for (Expression expression : forStmt.getUpdate())
            expression.accept(this);
        for (Statement statement : forStmt.getBody())
            statement.accept(this);
        return null;
    }


    @Override
    public Void visit(TryCatchStmt tryCatchStmt) {
        messagePrinter(tryCatchStmt.getLine(), tryCatchStmt.toString());
        for (Statement statement : tryCatchStmt.getTryBlock())
            statement.accept(this);
        for (Statement statement : tryCatchStmt.getCatchBlock())
            statement.accept(this);
        return null;
    }

    @Override
    public Void visit(ThrowStmt throwStmt) {
        messagePrinter(throwStmt.getLine(), throwStmt.toString());
        if (throwStmt.getReturnedExpr() != null)
            throwStmt.getReturnedExpr().accept(this);
        return null;
    }

    @Override
    public Void visit(VarAccess varAccess) {
        messagePrinter(varAccess.getLine(), varAccess.toString());
        if (varAccess.getInstance() != null) {
            if (varAccess.getVariable() != null) {
                varAccess.getInstance().accept(this);
                varAccess.getVariable().accept(this);
            }
        }
        return null;
    }
}

