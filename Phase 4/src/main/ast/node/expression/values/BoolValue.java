package main.ast.node.expression.values;

import main.visitor.IVisitor;

public class BoolValue extends Value {
    private boolean constant;

    public BoolValue(boolean constant) {
        this.constant = constant;
    }

    public boolean getConstant() {
        return constant;
    }

    public void setConstant(boolean constant) {
        this.constant = constant;
    }

    @Override
    public String toString(){
        return "BoolValue";

    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
