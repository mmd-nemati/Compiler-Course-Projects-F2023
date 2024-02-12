// Generated from E:/Programming/Java/UTL-Phase3/src/main/grammar/UTL.g4 by ANTLR 4.13.1
package parsers;

    import main.ast.node.*;
    import main.ast.node.declaration.*;
    import main.ast.node.statement.*;
    import main.ast.node.expression.*;
    import main.ast.node.expression.operators.*;
    import main.ast.node.expression.values.*;
    import main.ast.type.primitiveType.*;
    import main.ast.type.complexType.*;
    import main.ast.type.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link UTLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface UTLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link UTLParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(UTLParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(UTLParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(UTLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(UTLParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#funcVarDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncVarDeclaration(UTLParser.FuncVarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(UTLParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#mainDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainDeclaration(UTLParser.MainDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#initDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitDeclaration(UTLParser.InitDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#startDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartDeclaration(UTLParser.StartDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#assignStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStatement(UTLParser.AssignStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(UTLParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(UTLParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(UTLParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#tryCatchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryCatchStatement(UTLParser.TryCatchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#continueBreakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueBreakStatement(UTLParser.ContinueBreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(UTLParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#throwStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStatement(UTLParser.ThrowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(UTLParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(UTLParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(UTLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(UTLParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(UTLParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#complexType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplexType(UTLParser.ComplexTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#complexValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplexValue(UTLParser.ComplexValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#allType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllType(UTLParser.AllTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#espetialFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEspetialFunction(UTLParser.EspetialFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#espetialVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEspetialVariable(UTLParser.EspetialVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#espetialMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEspetialMethod(UTLParser.EspetialMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link UTLParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(UTLParser.AssignContext ctx);
}