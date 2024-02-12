package main.compileError.name;

import main.compileError.CompileError;

public class VariableRedefinition extends CompileError {
    int line;
    String name;
    public VariableRedefinition(int line, String name){
        this.line = line;
        this.name = name;
    }

    public String getMessage(){
        return "Line:" + line + ":Redefinition of variable " + name;
    }
}
