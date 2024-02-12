package main.ast.node.declaration;

import java.util.ArrayList;

import main.ast.node.statement.Statement;
import main.visitor.IVisitor;

public class MainDeclaration extends Declaration {
    private ArrayList<Statement> body = new ArrayList<>();

    public MainDeclaration() {
    }

    public ArrayList<Statement> getBody() {
        return body;
    }

    public void setBody(ArrayList<Statement> body) {
        this.body = body;
    }

    public void addStatement(Statement statement) {
        this.body.add(statement);
    }

    @Override
    public String toString() {
        return "MainDeclaration";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
