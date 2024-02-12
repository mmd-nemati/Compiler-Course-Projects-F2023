package main.compileError.type;

import main.compileError.CompileError;

public class UnsupportedOperandType extends CompileError {
    int line;
    String name;
    public UnsupportedOperandType(int line, String name){
        this.line = line;
        this.name = name;
    }
    public String getMessage(){
        return "Line:" + line + ":Unsupported operand type for operator " + name;
    }
}
