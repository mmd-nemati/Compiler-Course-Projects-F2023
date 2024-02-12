package main.compileError.name;

import main.compileError.CompileError;

public class MethodRedefinition extends CompileError {
    int line;
    String name;
    public MethodRedefinition(int line, String name){
        this.line = line;
        this.name = name;
    }

    public String getMessage(){
        return "Line:" + line + ":Redefinition of method " + name;
    }
}
