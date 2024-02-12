package main.ast.node.statement;

import main.ast.node.expression.Expression;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class WhileStmt extends Statement {
    private Expression condition;
    private ArrayList<Statement> body = new ArrayList<>();

    public WhileStmt(Expression condition) {
        this.condition = condition;
    }

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    public ArrayList<Statement> getBody() {
        return body;
    }

    public void setBody(ArrayList<Statement> body) {
        this.body = body;
    }

    public void addBody(Statement statement) {
        this.body.add(statement);
    }

    @Override
    public String toString() {
        return "WhileStmt";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
