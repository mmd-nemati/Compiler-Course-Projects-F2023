package main.ast.node.expression.values;

import main.ast.type.Type;
import main.visitor.IVisitor;
import main.visitor.Visitor;

public class IntValue extends Value {
    private int constant;

    public IntValue(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }

    public void setConstant(int constant) {
        this.constant = constant;
    }

    @Override
    public String toString(){
        return "IntValue";

    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
