package main.ast.node.declaration;

import main.ast.node.expression.Identifier;
import main.ast.node.statement.Statement;
import main.ast.type.Type;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class FunctionDeclaration extends Declaration {
    private Type returnType;
    private Identifier name;
    private ArrayList<VarDeclaration> args = new ArrayList<>();
    private ArrayList<Statement> body = new ArrayList<>();

    public FunctionDeclaration() {
    }


    public Identifier getName() {
        return name;
    }

    public Type getReturnType() {
        return returnType;
    }

    public ArrayList<VarDeclaration> getArgs() {
        return args;
    }

    public void setArgs(ArrayList<VarDeclaration> args) {
        this.args = args;
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

    public void addArg(VarDeclaration arg) {
        this.args.add(arg);
    }

    public void setName(Identifier name) {
        this.name = name;
    }

    public void setReturnType(Type returnType) {
        this.returnType = returnType;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
