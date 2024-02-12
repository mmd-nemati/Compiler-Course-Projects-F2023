package main.compileError.type;

import main.compileError.CompileError;

public class ConditionTypeNotBool extends CompileError {
    int line;
    public ConditionTypeNotBool(int line){
        this.line = line;
    }
    public String getMessage(){
        return "Line:" + line + ":Condition must be bool";
    }
}
