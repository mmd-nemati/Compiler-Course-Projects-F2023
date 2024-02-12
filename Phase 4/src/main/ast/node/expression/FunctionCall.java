package main.ast.node.expression;

import main.visitor.IVisitor;

import java.util.ArrayList;

public class FunctionCall extends Expression {
    private Identifier functionName;
    private ArrayList<Expression> args = new ArrayList<>();

    public FunctionCall(Identifier functionName) {
        this.functionName = functionName;
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
    public String toString(){
        return "FunctionCall";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
