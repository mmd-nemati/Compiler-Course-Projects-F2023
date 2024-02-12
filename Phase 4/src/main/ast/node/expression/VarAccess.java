package main.ast.node.expression;

import main.visitor.IVisitor;

public class VarAccess extends Expression {
    private Expression instance;
    private Identifier variableName;

    public VarAccess(Expression instance, Identifier variableName) {
        this.instance = instance;
        this.variableName = variableName;
    }

    public Expression getInstance() {
        return instance;
    }

    public void setInstance(Expression instance) {
        this.instance = instance;
    }

    public Identifier getVariable() {
        return variableName;
    }

    public void setVariable(Identifier variableName) {
        this.variableName = variableName;
    }

    @Override
    public String toString() {
        return "VarAccess";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
