package main.symbolTable.symbolTableItems;

import main.ast.node.declaration.OnInitDeclaration;
import main.symbolTable.SymbolTable;

public class OnInitItem extends SymbolTableItem {
        
    protected SymbolTable onInitSymbolTable;
    protected OnInitDeclaration onInitDeclaration;
    public static final String START_KEY = "OnInit_";

    public OnInitItem(OnInitDeclaration onInitDeclaration)
    {
        this.name = onInitDeclaration.getTradeName().getName();
        this.onInitDeclaration = onInitDeclaration;
    }
    
    public void setOnInitSymbolTable(SymbolTable onInitSymbolTable)
    {
        this.onInitSymbolTable = onInitSymbolTable;
    }

    public SymbolTable getOnInitSymbolTable()
    {
        return onInitSymbolTable;
    }

    public void setName(String name)
    {
        this.name = name;
        this.onInitDeclaration.getTradeName().setName(name);
    }

    public void setActorDeclaration(OnInitDeclaration onInitDeclaration)
    {
        this.onInitDeclaration = onInitDeclaration;
    }

    public OnInitDeclaration getDeclaration()
    {
        return onInitDeclaration;
    }

    @Override
    public String getKey()
    {
        return OnInitItem.START_KEY + this.name;
    }
}
