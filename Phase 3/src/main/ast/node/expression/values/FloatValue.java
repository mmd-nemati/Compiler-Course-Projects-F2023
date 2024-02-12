package main.ast.node.expression.values;

import main.visitor.IVisitor;

public class FloatValue extends Value {
    private float constant;

    public FloatValue(float constant) {
        this.constant = constant;
    }

    public float getConstant() {
        return constant;
    }

    public void setConstant(float constant) {
        this.constant = constant;
    }

    @Override
    public String toString(){
        return "FloatValue";

    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
