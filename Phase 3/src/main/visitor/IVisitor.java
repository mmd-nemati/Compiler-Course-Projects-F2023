package main.visitor;

import main.ast.node.Program;
import main.ast.node.declaration.*;
import main.ast.node.expression.*;
import main.ast.node.expression.values.*;
import main.ast.node.statement.*;

public interface IVisitor<T> {
    T visit(Program program);

    T visit(MainDeclaration mainDeclarationActors);

    T visit(OnInitDeclaration onInitDeclaration);

    T visit(OnStartDeclaration onStartDeclaration);

    T visit(FunctionDeclaration functionDeclaration);

    T visit(VarDeclaration varDeclaration);

    T visit(UnaryExpression unaryExpression);

    T visit(BinaryExpression binaryExpression);

    T visit(VarAccess varAccess);

    T visit(Identifier identifier);

    T visit(ArrayIdentifier arrayIdentifier);

    T visit(IntValue value);

    T visit(TradeValue value);
    T visit(StringValue value);

    T visit(BoolValue boolValue);

    T visit(FloatValue floatValue);

    T visit(FunctionCall functionCall);

    T visit(MethodCall methodCall);

    T visit(IfElseStmt conditional);

    T visit(AssignStmt assignStmt);

    T visit(ForStmt forStmt);

    T visit(WhileStmt whileStmt);

    T visit(ContinueBreakStmt continueBreakStmt);

    T visit(ExpressionStmt expressionStmt);

    T visit(ReturnStmt returnStmt);

    T visit(ThrowStmt throwStmt);

    T visit(TryCatchStmt tryCatchStmt);
}
