package main.ast.node.expression.values;

import main.ast.type.Type;
import main.ast.node.expression.Expression;

public abstract class Value extends Expression {
    protected Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}