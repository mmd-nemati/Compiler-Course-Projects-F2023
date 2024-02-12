package main.ast.node.expression;

import main.visitor.IVisitor;

import java.util.ArrayList;

public class MethodCall extends Expression {
    private Expression instance;
    private Identifier functionName;
    private ArrayList<Expression> args = new ArrayList<>();

    public MethodCall(Expression instance, Identifier functionName) {
        this.instance = instance;
        this.functionName = functionName;
    }

    public Expression getInstance() {
        return instance;
    }

    public void setInstance(Expression instance) {
        this.instance = instance;
    }

    public Identifier getFunctionName() {
        return functionName;
    }

    public void setFunctionName(Identifier functionName) {
        this.functionName = functionName;
    }

    public void setArgs(ArrayList<Expression> args) {
        this.args = args;
    }

    public ArrayList<Expression> getArgs() {
        return args;
    }

    public void addArg(Expression arg) {
        this.args.add(arg);
    }

    @Override
    public String toString() {
        return "MethodCall";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
