package main.symbolTable.symbolTableItems;

import main.ast.node.declaration.OnInitDeclaration;
import main.symbolTable.SymbolTable;

public class MainItem extends SymbolTableItem {

    protected SymbolTable mainSymbolTable;
    protected OnInitDeclaration onInitDeclaration;
    public static final String START_KEY = "Main_";

    public MainItem(OnInitDeclaration onInitDeclaration)
    {
        this.name = onInitDeclaration.getTradeName().getName();
        this.onInitDeclaration = onInitDeclaration;
    }
    
    public void setMainSymbolTable(SymbolTable mainSymbolTable)
    {
        this.mainSymbolTable = mainSymbolTable;
    }

    public SymbolTable getMainSymbolTable()
    {
        return mainSymbolTable;
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

    public OnInitDeclaration getActorDeclaration()
    {
        return onInitDeclaration;
    }

    @Override
    public String getKey()
    {
        return MainItem.START_KEY + this.name;
    }
}
