package main.compileError.name;

import main.compileError.CompileError;

public class IrregularDefenition extends CompileError {
    int line;
    String name;
    public IrregularDefenition(int line, String name){
        this.line = line;
        this.name = name;
    }

    public String getMessage(){
        return "Line " + line + ": Irregular definition of variable " + name;
    }
}
