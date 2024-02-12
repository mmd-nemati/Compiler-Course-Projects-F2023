package main.symbolTable.symbolTableItems;

import main.ast.node.declaration.MainDeclaration;
import main.ast.node.declaration.OnInitDeclaration;
import main.symbolTable.SymbolTable;

public class MainItem extends SymbolTableItem {

    protected SymbolTable mainSymbolTable;
    protected MainDeclaration mainDeclaration;
    public static final String START_KEY = "Main_";

    public MainItem(MainDeclaration mainDeclaration)
    {
        this.mainDeclaration = mainDeclaration;
    }
    
    public void setMainSymbolTable(SymbolTable mainSymbolTable)
    {
        this.mainSymbolTable = mainSymbolTable;
    }

    public SymbolTable getMainSymbolTable()
    {
        return mainSymbolTable;
    }


    public void setDeclaration(MainDeclaration mainDeclaration)
    {
        this.mainDeclaration = mainDeclaration;
    }

    public MainDeclaration getDeclaration()
    {
        return mainDeclaration;
    }

    @Override
    public String getKey()
    {
        return MainItem.START_KEY + "main";
    }
}
