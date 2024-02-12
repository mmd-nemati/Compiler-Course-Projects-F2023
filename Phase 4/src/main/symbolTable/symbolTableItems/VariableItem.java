package main.symbolTable.symbolTableItems;

import main.ast.node.declaration.VarDeclaration;
import main.ast.type.Type;

public class VariableItem extends SymbolTableItem {

	protected Type type;
	protected VarDeclaration varDeclaration;
    public static final String START_KEY = "Variable_";

	public VariableItem(String name, Type type) {
		this.name = name;
	    this.type = type;
	}
	
    public VariableItem(VarDeclaration varDeclaration)
    {
        this.name = varDeclaration.getIdentifier().getName();
        this.type = varDeclaration.getType();
        this.varDeclaration = varDeclaration;
    }

	public String getName() {
		return name;
	}

	public void setName(String name)
    {
        this.name = name;
        varDeclaration.getIdentifier().setName(name);
    }

	public Type getType() {
		return type;
	}

    public void setType(Type type) {
        this.type = type;
    }

    public VarDeclaration getVarDeclaration()
    {
        return varDeclaration;
    }
    
    public void setVarDeclaration(VarDeclaration varDeclaration)
    {
        this.varDeclaration = varDeclaration;
    }

    @Override
    public String getKey() {
        return VariableItem.START_KEY + this.name;
    }
}
