package main.ast.node.statement;

import main.visitor.IVisitor;
import main.visitor.Visitor;
import main.ast.node.expression.Expression;

// Line -> '='
public class AssignStmt extends Statement {
    private Expression lValue;
    private Expression rValue;

    public AssignStmt(Expression lValue, Expression rValue) {
        this.lValue = lValue;
        this.rValue = rValue;
    }

    public Expression getLValue() {
        return lValue;
    }

    public void setLValue(Expression lValue) {
        this.lValue = lValue;
    }

    public Expression getRValue() {
        return rValue;
    }

    public void setRValue(Expression rValue) {
        this.rValue = rValue;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
