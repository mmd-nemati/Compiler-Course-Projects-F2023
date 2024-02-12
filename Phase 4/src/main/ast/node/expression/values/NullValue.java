package main.ast.node.expression.values;

import main.visitor.IVisitor;

public class NullValue extends Value {
    private int constant;

    public NullValue() {
        this.constant = Integer.parseInt(null);
    }

    public Object getConstant() {
        return null;
    }

//    public void setConstant(boolean constant) {
//        this.constant = constant;
//    }

    @Override
    public String toString(){
        return "NullValue";

    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
