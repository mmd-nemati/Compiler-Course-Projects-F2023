package main.visitor.typeAnalyzer;

import main.ast.node.expression.BinaryExpression;
import main.ast.node.expression.FunctionCall;
import main.ast.node.expression.Identifier;
import main.ast.node.expression.operators.BinaryOperator;
import main.ast.node.expression.values.BoolValue;
import main.ast.node.expression.values.FloatValue;
import main.ast.node.expression.values.IntValue;
import main.ast.node.expression.values.StringValue;
import main.ast.type.*;
import main.ast.type.primitiveType.BoolType;
import main.ast.type.primitiveType.FloatType;
import main.ast.type.primitiveType.IntType;
import main.ast.type.primitiveType.StringType;
import main.compileError.*;
import main.compileError.type.UnsupportedOperandType;
import main.symbolTable.SymbolTable;
import main.symbolTable.itemException.ItemNotFoundException;
import main.symbolTable.symbolTableItems.FunctionItem;
import main.symbolTable.symbolTableItems.SymbolTableItem;
import main.symbolTable.symbolTableItems.VariableItem;
import main.visitor.*;

import java.util.ArrayList;

public class TypeChecker extends Visitor<Type> {
    public ArrayList<CompileError> typeErrors;

    public TypeChecker(ArrayList<CompileError> typeErrors) {
        this.typeErrors = typeErrors;
    }

    @Override
    public Type visit(BinaryExpression binaryExpression) {
        Type tl = binaryExpression.getLeft().accept(this);
        Type tr = binaryExpression.getRight().accept(this);
        BinaryOperator operator = binaryExpression.getBinaryOperator();

        if (operator.equals(BinaryOperator.EQ) || operator.equals(BinaryOperator.NEQ)) {
            if (tl instanceof IntType && tr instanceof IntType)
                return new BoolType();
            else if (tl instanceof FloatType && tr instanceof FloatType)
                return new BoolType();
            else if (tl instanceof BoolType && tr instanceof BoolType)
                return new BoolType();
            else if (tl instanceof StringType && tr instanceof StringType)
                return new BoolType();
            else if (tl instanceof NoType || tr instanceof NoType)
                return new NoType();
            else {
                typeErrors.add(new UnsupportedOperandType(binaryExpression.getLine(), operator.toString()));
                return new NoType();
            }
        } else if (operator.equals(BinaryOperator.AND) || operator.equals(BinaryOperator.OR)) {
            if (tl instanceof BoolType && tr instanceof BoolType)
                return new BoolType();
            else if (tl instanceof NoType || tr instanceof NoType)
                return new NoType();
            else {
                typeErrors.add(new UnsupportedOperandType(binaryExpression.getLine(), operator.toString()));
                return new NoType();
            }
        } else if (operator.equals(BinaryOperator.LT) || operator.equals(BinaryOperator.GT)) {
            if (tl instanceof IntType && tr instanceof IntType)
                return new BoolType();
            else if (tl instanceof FloatType && tr instanceof FloatType)
                return new BoolType();
            else if (tl instanceof NoType || tr instanceof NoType)
                return new NoType();
            else {
                typeErrors.add(new UnsupportedOperandType(binaryExpression.getLine(), operator.toString()));
                return new NoType();
            }
        } else if (operator.equals(BinaryOperator.PLUS) || operator.equals(BinaryOperator.MINUS) || operator.equals(BinaryOperator.MULT) || operator.equals(BinaryOperator.DIV) || operator.equals(BinaryOperator.MOD)) {
            if (tl instanceof IntType && tr instanceof IntType)
                return new IntType();
            else if (tl instanceof FloatType && tr instanceof FloatType)
                return new FloatType();
            else if (tl instanceof NoType || tr instanceof NoType)
                return new NoType();
            else {
                typeErrors.add(new UnsupportedOperandType(binaryExpression.getLine(), operator.toString()));
                return new NoType();
            }
        } else if (operator.equals(BinaryOperator.BIT_AND) || operator.equals(BinaryOperator.BIT_OR) || operator.equals(BinaryOperator.BIT_XOR) || operator.equals(BinaryOperator.L_SHIFT) || operator.equals(BinaryOperator.R_SHIFT)) {
            if (tl instanceof IntType && tr instanceof IntType)
                return new IntType();
            else if (tl instanceof NoType || tr instanceof NoType)
                return new NoType();
            else {
                typeErrors.add(new UnsupportedOperandType(binaryExpression.getLine(), operator.toString()));
                return new NoType();
            }
        } else if (operator.equals(BinaryOperator.ASSIGN) || operator.equals(BinaryOperator.ADD_ASSIGN) || operator.equals(BinaryOperator.SUB_ASSIGN) || operator.equals(BinaryOperator.MUL_ASSIGN) || operator.equals(BinaryOperator.DIV_ASSIGN) || operator.equals(BinaryOperator.MOD_ASSIGN)) {
            if (tl instanceof IntType && tr instanceof IntType)
                return new IntType();
            else if (tl instanceof FloatType && tr instanceof FloatType)
                return new FloatType();
            else if (tl instanceof NoType || tr instanceof NoType)
                return new NoType();
            else {
                typeErrors.add(new UnsupportedOperandType(binaryExpression.getLine(), operator.toString()));
                return new NoType();
            }
        }
        return new NoType();
    }

    @Override
    public Type visit(Identifier identifier) {
        String idName = identifier.getName();
        try {
            SymbolTableItem item = SymbolTable.top.get(VariableItem.START_KEY + idName);
            return ((VariableItem) item).getType();
        } catch (ItemNotFoundException e) {
            // error variable not declared
            return new NoType();
        }
    }

    @Override
    public Type visit(FunctionCall funcCall) {
        String funcName = funcCall.getFunctionName().getName();
        try {
            SymbolTableItem item = SymbolTable.root.get(FunctionItem.START_KEY + funcName);
            return ((FunctionItem) item).getFunctionDeclaration().getReturnType();
        } catch (ItemNotFoundException e) {
            // error function not declared
            return new NoType();
        }
    }

    @Override
    public Type visit(IntValue value) {
        return new IntType();
    }

    @Override
    public Type visit(StringValue value) {
        return new StringType();
    }

    @Override
    public Type visit(BoolValue value) {
        return new BoolType();
    }

    @Override
    public Type visit(FloatValue value) {
        return new FloatType();
    }

}
