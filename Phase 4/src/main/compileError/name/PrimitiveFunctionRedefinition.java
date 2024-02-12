package main.compileError.name;

import main.compileError.CompileError;

public class PrimitiveFunctionRedefinition extends CompileError {
    int line;
    String name;
    public PrimitiveFunctionRedefinition(int line, String name){
        this.line = line;
        this.name = name;
    }

    public String getMessage(){
        return "Line:" + line + ":Redefinition of primitive function:" + name;
    }
}
