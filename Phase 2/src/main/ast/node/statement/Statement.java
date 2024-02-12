package main.ast.node.statement;

import main.ast.node.Node;
import main.ast.node.expression.Identifier;

public abstract class Statement extends Node {
    private Identifier identifier;

    public void setIdentifier(Identifier identifier) { this.identifier = identifier; }

    public  Identifier getIdentifier() { return this.identifier; }
}
