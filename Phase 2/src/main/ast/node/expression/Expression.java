package main.ast.node.expression;

import main.ast.type.Type;
import main.ast.node.Node;
import main.ast.node.statement.Statement;

public abstract class Expression extends Node{
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}