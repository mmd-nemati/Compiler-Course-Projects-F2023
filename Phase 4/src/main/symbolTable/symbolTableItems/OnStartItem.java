package main.symbolTable.symbolTableItems;

import main.ast.node.declaration.OnInitDeclaration;
import main.ast.node.declaration.OnStartDeclaration;
import main.symbolTable.SymbolTable;

public class OnStartItem extends SymbolTableItem {

    protected SymbolTable onStartSymbolTable;
    protected OnStartDeclaration onStartDeclaration;
    public static final String START_KEY = "OnStart_";

    public OnStartItem(OnStartDeclaration onStartDeclaration)
    {
        this.name = onStartDeclaration.getTradeName().getName();
        this.onStartDeclaration = onStartDeclaration;
    }
    
    public void setOnStartSymbolTable(SymbolTable onStartSymbolTable)
    {
        this.onStartSymbolTable = onStartSymbolTable;
    }

    public SymbolTable getOnStartSymbolTable()
    {
        return onStartSymbolTable;
    }

    public void setName(String name)
    {
        this.name = name;
        this.onStartDeclaration.getTradeName().setName(name);
    }

    public void setDeclaration(OnStartDeclaration onStartDeclaration)
    {
        this.onStartDeclaration = onStartDeclaration;
    }

    public OnStartDeclaration getDeclaration()
    {
        return onStartDeclaration;
    }

    @Override
    public String getKey()
    {
        return OnStartItem.START_KEY + this.name;
    }
}



