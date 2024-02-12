package main.ast.node.declaration;

import main.ast.node.expression.Expression;
import main.ast.node.expression.Identifier;
import main.ast.node.declaration.VarDeclaration;
import main.ast.type.Type;
import main.visitor.IVisitor;

public class GlobalVarDeclaration extends Declaration {
    private Type type;
    private Identifier identifier;
    private int length = 0; // > 0 means array
    private Expression value = null;

    public GlobalVarDeclaration() {
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    @Override
    public Type getType() {
        return type;
    }
    @Override
    public void setType(Type type) {
        this.type = type;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isArray() {
        return this.length > 0;
    }

    public Expression getValue() { return this.value; }

    public void setValue(Expression value) { this.value = value; }

    @Override
    public String toString() { VarDeclaration a = new VarDeclaration(); return a.getClass().getSimpleName(); }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
