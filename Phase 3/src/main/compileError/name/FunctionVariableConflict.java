package main.compileError.name;

import main.compileError.CompileError;

public class FunctionVariableConflict extends CompileError {
    int line;
    String name;
    public FunctionVariableConflict(int line, String name){
        this.line = line;
        this.name = name;
    }

    public String getMessage(){
        return "Line:" + line + ":Name of variable " + name + " conflicts with the function's name";
    }
}
