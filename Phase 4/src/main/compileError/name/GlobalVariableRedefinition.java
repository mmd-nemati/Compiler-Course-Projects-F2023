package main.compileError.name;

import main.compileError.CompileError;

public class GlobalVariableRedefinition extends CompileError {
    int line;
    String name;
    public GlobalVariableRedefinition(int line, String name){
        this.line = line;
        this.name = name;
    }

    public String getMessage(){
        return "Line:" + line + ":Redefinition of global variable " + name;
    }
}
