package main;

import main.ast.node.Program;
import main.compileError.CompileError;
import main.visitor.astPrinter.ASTPrinter;
import main.visitor.nameAnalyzer.NameAnalyzer;
import main.visitor.typeAnalyzer.TypeAnalyzer;
import org.antlr.v4.runtime.*;
import parsers.*;

import java.io.IOException;

public class UTL {
    public static void main(String[] args) throws IOException {
        CharStream reader = CharStreams.fromFileName(args[0]);
        UTLLexer lexer = new UTLLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        UTLParser parser = new UTLParser(tokens);
        Program program = parser.program().pro;
        NameAnalyzer nameAnalyzer = new NameAnalyzer();
        nameAnalyzer.visit(program);
        TypeAnalyzer typeAnalyzer = new TypeAnalyzer();
        typeAnalyzer.visit(program);
        if (!typeAnalyzer.typeErrors.isEmpty()){
            for(CompileError compileError: typeAnalyzer.typeErrors)
                System.out.println(compileError.getMessage());
        }
    }
}
