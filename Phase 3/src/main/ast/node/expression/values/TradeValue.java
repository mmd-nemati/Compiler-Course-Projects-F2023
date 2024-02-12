package main.ast.node.expression.values;

import main.ast.type.Type;
import main.visitor.IVisitor;
import main.visitor.Visitor;

public class TradeValue extends Value {
    private String constant;

    public TradeValue(String constant) {
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
        return "TradeValue " + constant;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
