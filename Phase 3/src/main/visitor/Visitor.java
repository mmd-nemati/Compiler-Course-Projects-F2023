package main.visitor;

import main.ast.node.Program;
import main.ast.node.declaration.*;
import main.ast.node.expression.*;
import main.ast.node.expression.values.*;
import main.ast.node.statement.*;

public class Visitor<T> implements IVisitor<T> {

    @Override
    public T visit(Program program) {
        return null;
    }

    @Override
    public T visit(OnInitDeclaration onInitDeclaration) {
        return null;
    }

    @Override
    public T visit(OnStartDeclaration onStartDeclaration) {
        return null;
    }

    @Override
    public T visit(FunctionDeclaration functionDeclaration) {
        return null;
    }

    @Override
    public T visit(VarDeclaration varDeclaration) {
        return null;
    }

    @Override
    public T visit(MainDeclaration mainDeclarationActors) {
        return null;
    }

    @Override
    public T visit(UnaryExpression unaryExpression) {
        return null;
    }

    @Override
    public T visit(BinaryExpression binaryExpression) {
        return null;
    }

    @Override
    public T visit(VarAccess varAccess) {
        return null;
    }

    @Override
    public T visit(Identifier identifier) {
        return null;
    }

    @Override
    public T visit(ArrayIdentifier arrayIdentifier) {
        return null;
    }

    @Override
    public T visit(IntValue value) {
        return null;
    }

    @Override
    public T visit(StringValue value) {
        return null;
    }

    @Override
    public T visit(BoolValue boolValue) {
        return null;
    }

    @Override
    public T visit(FloatValue floatValue) {
        return null;
    }

    @Override
    public T visit(TradeValue tradeValue) {
        return null;
    }

    @Override
    public T visit(IfElseStmt conditional) {
        return null;
    }

    @Override
    public T visit(FunctionCall functionCall) {
        return null;
    }

    @Override
    public T visit(MethodCall methodCall) {
        return null;
    }

    @Override
    public T visit(AssignStmt assignStmt) {
        return null;
    }

    @Override
    public T visit(ForStmt forStmt) {
        return null;
    }

    @Override
    public T visit(WhileStmt whileStmt) {
        return null;
    }

    @Override
    public T visit(ContinueBreakStmt continueBreakStmt) {
        return null;
    }

    @Override
    public T visit(ExpressionStmt expressionStmt) {
        return null;
    }

    @Override
    public T visit(ReturnStmt returnStmt) {
        return null;
    }

    @Override
    public T visit(ThrowStmt throwStmt) {
        return null;
    }

    @Override
    public T visit(TryCatchStmt tryCatchStmt) {
        return null;
    }
}
