package main.ast.node;

import main.ast.node.declaration.*;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class Program extends Node{
    private ArrayList<VarDeclaration> vars = new ArrayList<>();
    private ArrayList<GlobalVarDeclaration> globalVars = new ArrayList<>();
    private ArrayList<OnInitDeclaration> inits = new ArrayList<>();
    private ArrayList<OnStartDeclaration> starts = new ArrayList<>();
    private ArrayList<FunctionDeclaration> functions = new ArrayList<>();
    private MainDeclaration programMainDeclaration;

    public MainDeclaration getMain() {
        return this.programMainDeclaration;
    }

    public void setMain(MainDeclaration mainDeclarationActors) {
        this.programMainDeclaration = mainDeclarationActors;
    }

    public ArrayList<VarDeclaration> getVars() {
        return vars;
    }

    public ArrayList<GlobalVarDeclaration> getGlobalVars() { return globalVars; }

    public void setVars(ArrayList<VarDeclaration> vars) {
        this.vars = vars;
    }

    public void setGlobalVars(ArrayList<GlobalVarDeclaration> globalVars) {
        this.globalVars = globalVars;
    }

    public ArrayList<OnInitDeclaration> getInits() {
        return inits;
    }

    public void setInits(ArrayList<OnInitDeclaration> inits) {
        this.inits = inits;
    }

    public ArrayList<OnStartDeclaration> getStarts() {
        return starts;
    }

    public void setStarts(ArrayList<OnStartDeclaration> starts) {
        this.starts = starts;
    }

    public ArrayList<FunctionDeclaration> getFunctions() {
        return functions;
    }

    public void setFunctions(ArrayList<FunctionDeclaration> functions) {
        this.functions = functions;
    }

    public void addVar(VarDeclaration varDeclaration) {
        this.vars.add(varDeclaration);
    }

    public void addGlobalVar(GlobalVarDeclaration globalVarDeclaration) {
        this.globalVars.add(globalVarDeclaration);
    }

    public void addInit(OnInitDeclaration onInitDeclaration) {
        this.inits.add(onInitDeclaration);
    }

    public void addStart(OnStartDeclaration onStartDeclaration) {
        this.starts.add(onStartDeclaration);
    }

    public void addFunction(FunctionDeclaration functionDeclaration) {
        this.functions.add(functionDeclaration);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
