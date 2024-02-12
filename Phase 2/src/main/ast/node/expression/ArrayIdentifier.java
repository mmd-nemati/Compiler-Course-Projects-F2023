package main.ast.node.expression;

import main.visitor.IVisitor;

public class ArrayIdentifier extends Identifier {
    private Expression index;

    public ArrayIdentifier(String name, Expression index) {
        super(name);
        this.index = index;
    }

    public Expression getIndex() {
        return index;
    }

    public void setIndex(Expression index) {
        this.index = index;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
