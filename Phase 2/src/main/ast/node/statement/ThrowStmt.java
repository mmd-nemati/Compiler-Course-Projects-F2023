package main.ast.node.statement;

import main.ast.node.expression.Expression;
import main.visitor.IVisitor;

public class ThrowStmt extends Statement {
    private Expression throwedExpression;

    public ThrowStmt(Expression throwedExpression) {
        this.throwedExpression = throwedExpression;
    }

    public Expression getReturnedExpr() {
        return throwedExpression;
    }

    public void setReturnedExpr(Expression throwedExpression) {
        this.throwedExpression = throwedExpression;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
