package main.ast.node.statement;

import main.ast.node.expression.Expression;
import main.visitor.IVisitor;

public class ExpressionStmt extends Statement {
    private Expression expression;

    public ExpressionStmt(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public String toString(){return "ExpressionStmt";}
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
