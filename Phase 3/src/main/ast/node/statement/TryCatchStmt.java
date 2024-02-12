package main.ast.node.statement;

import main.visitor.IVisitor;

import java.util.ArrayList;

public class TryCatchStmt extends Statement {
    private ArrayList<Statement> tryBlock = new ArrayList<>();
    private ArrayList<Statement> catchBlock = new ArrayList<>();

    public TryCatchStmt() {
    }


    public ArrayList<Statement> getTryBlock() {
        return tryBlock;
    }

    public void setTryBlock(ArrayList<Statement> tryBlock) {
        this.tryBlock = tryBlock;
    }

    public ArrayList<Statement> getCatchBlock() {
        return catchBlock;
    }

    public void setCatchBlock(ArrayList<Statement> catchBlock) {
        this.catchBlock = catchBlock;
    }

    public void addThenStatement(Statement statement) {
        this.tryBlock.add(statement);
    }

    public void addElseStatement(Statement statement) {
        this.catchBlock.add(statement);
    }

    @Override
    public String toString() {
        return "TryCatchStmt";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
