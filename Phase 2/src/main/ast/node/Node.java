package main.ast.node;

import main.visitor.IVisitor;
import main.ast.type.*;
import main.visitor.Visitor;

public abstract class Node {

    private int line;
    private Type type;

    public void setType(Type type) { this.type = type; };

    public Type getType() { return null; };

    public void setLine(int line_num) {
        this.line = line_num;
    }

    public int getLine() {
        return this.line;
    }

    public abstract <T> T accept(IVisitor<T> visitor);
}
