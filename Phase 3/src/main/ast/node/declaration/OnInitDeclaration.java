package main.ast.node.declaration;

import main.ast.node.expression.Identifier;
import main.ast.node.statement.Statement;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class OnInitDeclaration extends Declaration {
    private Identifier tradeName;
    private ArrayList<Statement> body = new ArrayList<>();

    public OnInitDeclaration() {
    }

    public Identifier getTradeName() {
        return tradeName;
    }

    public void setTradeName(Identifier tradeName) {
        this.tradeName = tradeName;
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

    public String toString() {
        return "OnInitDeclaration";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

