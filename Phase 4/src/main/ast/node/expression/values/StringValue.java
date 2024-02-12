package main.ast.node.expression.values;

import main.ast.type.Type;
import main.visitor.IVisitor;
import main.visitor.Visitor;

public class StringValue extends Value {
    private String constant;

    public StringValue(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }

    @Override
    public String toString(){
        return "StringValue";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
