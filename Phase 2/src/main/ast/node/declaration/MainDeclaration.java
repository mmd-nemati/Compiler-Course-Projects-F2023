package main.ast.node.declaration;

import java.util.ArrayList;

import main.ast.node.statement.Statement;
import main.visitor.IVisitor;

public class MainDeclaration extends Declaration {
    private ArrayList<VarDeclaration> mainTrades = new ArrayList<>();
    private ArrayList<Statement> body = new ArrayList<>();

    public MainDeclaration(){
    }

    public ArrayList<VarDeclaration> getMainTrades(){
        return this.mainTrades;
    }

    public void setMainTrades(ArrayList<VarDeclaration> mainTrades) {
        this.mainTrades = mainTrades;
    }

    public void addTradeInstantiation(VarDeclaration tradeInstantiation) {
        mainTrades.add(tradeInstantiation);
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
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
