package main.ast.node.statement;

import main.visitor.IVisitor;

public class ContinueBreakStmt extends Statement {
    private String token;

    public ContinueBreakStmt(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    @Override
    public String toString() {
        return "ContinueBreakStmt " + token;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
