package main.symbolTable.symbolTableItems;

import main.ast.node.declaration.FunctionDeclaration;
import main.ast.node.declaration.VarDeclaration;
import main.ast.type.Type;
import main.symbolTable.SymbolTable;

import java.util.ArrayList;

public class FunctionItem extends SymbolTableItem {

    protected ArrayList<Type> argTypes = new ArrayList<>();
    protected SymbolTable handlerSymbolTable;
    protected FunctionDeclaration functionDeclaration;
    public static final String START_KEY = "Function_";

    public FunctionItem(String name, ArrayList<Type> argTypes) {
        this.name = name;
        this.argTypes = argTypes;
    }

    public FunctionItem(FunctionDeclaration functionDeclaration) {
        this.name = functionDeclaration.getName().getName();
        this.argTypes = new ArrayList<>();
        for (VarDeclaration arg : functionDeclaration.getArgs())
            argTypes.add(arg.getType());
        this.functionDeclaration = functionDeclaration;
    }

    public void setHandlerSymbolTable(SymbolTable symbolTable) {
        this.handlerSymbolTable = symbolTable;
    }

    public SymbolTable getHandlerSymbolTable() {
        return this.handlerSymbolTable;
    }

    public void setFunctionDeclaration(FunctionDeclaration functionDeclaration) {
        this.functionDeclaration = functionDeclaration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        functionDeclaration.getName().setName(name);
    }

    public FunctionDeclaration getFunctionDeclaration() {
        return functionDeclaration;
    }

    @Override
    public String getKey() {
        return FunctionItem.START_KEY + this.name;
    }
}
