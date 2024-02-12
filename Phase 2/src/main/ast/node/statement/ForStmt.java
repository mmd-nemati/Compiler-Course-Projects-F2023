package main.ast.node.statement;

import main.ast.node.expression.Expression;
import main.visitor.IVisitor;

import java.util.ArrayList;

// Line -> IF
public class ForStmt extends Statement {
    private ArrayList<Statement> init = new ArrayList<>();
    private Expression condition;
    private ArrayList<Expression> update = new ArrayList<>();
    private ArrayList<Statement> body = new ArrayList<>();

    public ForStmt() {}

    public ArrayList<Statement> getInit() {
        return init;
    }

    public void setInit(ArrayList<Statement> init) {
        this.init = init;
    }

    public void addInit(Statement statement) {
        this.init.add(statement);
    }

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    public ArrayList<Expression> getUpdate() {
        return update;
    }

    public void setUpdate(ArrayList<Expression> update) {
        this.update = update;
    }

    public void addUpdate(Expression expression) {
        this.update.add(expression);
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
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
