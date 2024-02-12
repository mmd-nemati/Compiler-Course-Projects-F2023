package main.visitor.codeGenerator;

import main.ast.node.Program;
import main.ast.node.declaration.*;
import main.ast.node.statement.*;
import main.ast.type.Type;
import main.ast.type.primitiveType.*;
import main.ast.type.primitiveType.BoolType;
import main.compileError.CompileError;
import main.symbolTable.SymbolTable;
import main.symbolTable.itemException.*;
import main.symbolTable.symbolTableItems.*;
import main.visitor.Visitor;
import main.ast.node.expression.values.*;
import main.ast.node.expression.*;
import main.ast.node.expression.operators.*;
import main.visitor.typeAnalyzer.*;
import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class CodeGenerator extends Visitor<String> {
    TypeChecker expressionTypeChecker;
    TypeAnalyzer typeAnalyzer;
    private final HashMap<String, Integer> indexes = new HashMap<>();
    private final HashMap<String, Type> funcsReturnType = new HashMap<>();
    private String outputPath;
    private FileWriter currentFile;
    public ArrayList<CompileError> typeErrors;
    Program program;
    private int labelNum = -1;
    private boolean isGlobal;
    private boolean isAssignment;
    private int indexOf(String var) {
        if (!indexes.containsKey(var)) {
            indexes.put(var, indexes.size());
            return indexes.size() - 1;
        }
        return indexes.get(var);
    }
    private void clear() {
        indexes.clear();
        indexes.put("null", 0);
    }

    private String getLabelStr() {
        labelNum++;
        return "Label_" + labelNum;
    }

    public CodeGenerator(Program program_) {
        program = program_;
        isGlobal = true;
        typeErrors = new ArrayList<CompileError>();
        typeAnalyzer = new TypeAnalyzer();
        this.expressionTypeChecker = new TypeChecker(typeErrors);
        this.prepareOutputFolder();
        createFile();
    }

    private void prepareOutputFolder() {
        this.outputPath = "output/";
        String jasminPath = "utilities/jarFiles/jasmin.jar";
        String listClassPath = "utilities/codeGenerationUtilityClasses/List.j";
        String fptrClassPath = "utilities/codeGenerationUtilityClasses/Fptr.j";
        try{
            File directory = new File(this.outputPath);
            File[] files = directory.listFiles();
            if(files != null)
                for (File file : files)
                    file.delete();
            directory.mkdir();
        }
        catch(SecurityException e) {
            // pass
        }
        copyFile(jasminPath, this.outputPath + "jasmin.jar");
        copyFile(listClassPath, this.outputPath + "List.j");
        copyFile(fptrClassPath, this.outputPath + "Fptr.j");
    }

    private void copyFile(String toBeCopied, String toBePasted) {
        try {
            File readingFile = new File(toBeCopied);
            File writingFile = new File(toBePasted);
            InputStream readingFileStream = new FileInputStream(readingFile);
            OutputStream writingFileStream = new FileOutputStream(writingFile);
            byte[] buffer = new byte[1024];
            int readLength;
            while ((readLength = readingFileStream.read(buffer)) > 0)
                writingFileStream.write(buffer, 0, readLength);
            readingFileStream.close();
            writingFileStream.close();
        } catch (IOException e) { }
    }

    private void createFile() {
        try {
            String path = this.outputPath + "output" + ".j";
            File file = new File(path);
            boolean created = file.createNewFile();
            if (!created)
                throw new IOException();
            this.currentFile = new FileWriter(path);
        } catch (IOException e) {
            //pass
        }
    }

    private void addCommand(String command) {
        try {
            command = String.join("\n\t\t", command.split("\n"));
            if(command.startsWith("Label_"))
                this.currentFile.write("\t" + command + "\n");
            else if(command.startsWith("."))
                this.currentFile.write(command + "\n");
            else
                this.currentFile.write("\t\t" + command + "\n");
            this.currentFile.flush();
        } catch (IOException e) {}
    }

    private String makeTypeSignature(Type t) {
        if (t instanceof IntType)
            return "I";
        else if (t instanceof BoolType)
            return "Z";
        else if (t instanceof FloatType)
            return "F";
        else if (t instanceof StringType)
            return "Ljava/lang/String;";

        return "V";
    }
    private void appendOutput(ArrayList<String> commands) {
        for (String command : commands)
            addCommand(command);
    }
    @Override
    public String visit(Program program) {
        appendOutput(new ArrayList<>(Arrays.asList(".class public UTL", ".super java/lang/Object", "\n")));
        clear();
        for (VarDeclaration varDec : program.getVars()) {
            addCommand(varDec.accept(this));
        }
        isGlobal = false;
        appendOutput(new ArrayList<>(Arrays.asList("\n", ".method public <init>()V",
                "aload_0", "invokespecial java/lang/Object/<init>()V", "return", ".end method", "\n")));
        for (FunctionDeclaration func : program.getFunctions()) {
            clear();
            func.accept(this);
        }
        for (OnInitDeclaration onInit : program.getInits()) {
            clear();
            onInit.accept(this);
        }
        for (OnStartDeclaration onStart : program.getStarts()) {
            clear();
            onStart.accept(this);
        }
        clear();
        program.getMain().accept(this);
        return null;
    }
    @Override
    public String visit(OnInitDeclaration onInitDeclaration) {
        try {
            OnInitItem onStartItem = (OnInitItem) SymbolTable.root.get(OnInitItem.START_KEY + onInitDeclaration.getTradeName().getName());
            SymbolTable.push(onStartItem.getOnInitSymbolTable());
        } catch (ItemNotFoundException e) {
            // pass
        }
        indexOf(onInitDeclaration.getTradeName().getName());
        StringBuilder commands = new StringBuilder();
        commands.append(".method public OnInit")
                .append("(LTrade;)V\n")
                .append(".limit stack ")
                .append("128\n")
                .append(".limit locals ")
                .append("128\n");

        for (var stmt : onInitDeclaration.getBody())
            commands.append(stmt.accept(this));

        if (!String.join(" ", commands.toString().split("\n")).endsWith("return"))
            commands.append("return\n");

        commands.append(".end method\n\n\n");

        for (var comm : commands.toString().split("\n"))
            addCommand(comm);

        addCommand("\n");
        SymbolTable.pop();
        return null;
    }

    @Override
    public String visit(OnStartDeclaration onStartDeclaration) {
        try {
            OnStartItem onStartItem = (OnStartItem) SymbolTable.root.get(OnStartItem.START_KEY + onStartDeclaration.getTradeName().getName());
            SymbolTable.push(onStartItem.getOnStartSymbolTable());
        } catch (ItemNotFoundException e) {
            // pass
        }
        indexOf(onStartDeclaration.getTradeName().getName());
        List<String> bodyStmts = new ArrayList<String>();
        for (var stmt : onStartDeclaration.getBody())
                bodyStmts.add(stmt.accept(this));

        StringBuilder commands = new StringBuilder();

        commands.append(".method public OnStart")
                .append("(LTrade;)V\n")
                .append(".limit stack ")
                .append("128\n")
                .append(".limit locals ")
                .append("128\n");

        for (String stmt : bodyStmts)
            commands.append(stmt).append('\n');

        if (!String.join(" ", commands.toString().split("\n")).endsWith("return"))
            commands.append("return\n");

        commands.append(".end method\n\n\n");

        for (var comm : commands.toString().split("\n"))
            addCommand(comm);

        addCommand("\n");
        SymbolTable.pop();
        return null;
    }

    @Override
    public String visit(MainDeclaration mainDeclaration) {
        try {
            MainItem mainItem = (MainItem) SymbolTable.root.get(MainItem.START_KEY + "main");
            SymbolTable.push(mainItem.getMainSymbolTable());
        } catch (ItemNotFoundException e) {
            // pass
        }

        List<String> bodyStmts = new ArrayList<String>();
        for (var stmt : mainDeclaration.getBody())

                bodyStmts.add(stmt.accept(this));

        StringBuilder commands = new StringBuilder();
        commands.append(".method public static Main([Ljava/lang/String;)V\n") // TODO
                .append(".limit stack ")
                .append("128\n")
                .append(".limit locals ")
                .append("128\n");

        for (String stmt : bodyStmts)
            commands.append(stmt).append('\n');

        if (!String.join(" ", commands.toString().split("\n")).endsWith("return"))
            commands.append("return\n");
        commands.append(".end method\n\n");

        for (var comm : commands.toString().split("\n"))
            addCommand(comm);


        addCommand("\n");
        SymbolTable.pop();
        return null;
    }
    @Override
    public String visit(FunctionDeclaration functionDeclaration) {
        try {
            FunctionItem functionItem = (FunctionItem) SymbolTable.root.get(FunctionItem.START_KEY + functionDeclaration.getName().getName());
            SymbolTable.push(functionItem.getFunctionSymbolTable());
        } catch (ItemNotFoundException e) {
            // pass
        }

        Type returnType = functionDeclaration.getReturnType();
        String name = functionDeclaration.getName().getName();
        funcsReturnType.put(name, returnType);
        ArrayList<String> argsTypeSign = new ArrayList<String>();

        for (VarDeclaration arg : functionDeclaration.getArgs()) {
            argsTypeSign.add(makeTypeSignature(arg.getType()));
            indexOf(arg.getIdentifier().getName());
        }

        List<String> bodyStmts = new ArrayList<String>();
        for (var stmt : functionDeclaration.getBody())
                bodyStmts.add(stmt.accept(this));

        StringBuilder commands = new StringBuilder();
        commands.append(".method public ");

        commands.append(name).append('(');
        for (String arg : argsTypeSign)
            commands.append(arg);

        commands.append(')')
                .append(makeTypeSignature(returnType))
                .append('\n')
                .append(".limit stack ")
                .append("128\n")
                .append(".limit locals ")
                .append("128\n");

        for (String stmt : bodyStmts)
            commands.append(stmt).append('\n');

        if (returnType instanceof VoidType &&
                !String.join(" ", commands.toString().split("\n")).endsWith("return"))
            commands.append("return\n");

        commands.append(".end method\n\n\n");

        for (var comm : commands.toString().split("\n"))
            addCommand(comm);

        addCommand("\n");
        SymbolTable.pop();
        return null;
    }
    @Override
    public String visit(VarDeclaration varDeclaration) {
        List<String> commands = new ArrayList<>();
        String name = varDeclaration.getIdentifier().getName();
        Type type = varDeclaration.getType();
        isAssignment = true;
        if (isGlobal) {
            commands.add(".field public " + name + " " + makeTypeSignature(type));
        }
        else {
            int index = indexOf(name);
            Expression rValue = varDeclaration.getRValue();
            if (type instanceof IntType || type instanceof BoolType) {
                if (rValue != null) {
                    commands.add(rValue.accept(this));
                    commands.add("istore " + index + "\n");
                }
            }
            if (type instanceof FloatType) {
                if (rValue != null) {
                    commands.add(rValue.accept(this));
                    commands.add("fstore " + index + "\n");
                }
            }
            else {
                if (rValue != null) {
                    commands.add(rValue.accept(this));
                    commands.add("astore " + index + "\n");
                }
            }
        }
//        addCommand(String.join("\n",commands));
        isAssignment = false;
        return String.join("\n",commands);
    }
    @Override
    public String visit(ExpressionStmt expressionStmt) {
        return expressionStmt.getExpression().accept(this);
    }
    @Override
    public String visit(AssignStmt assignStmt) {
        List<String> commands = new ArrayList<>();
        Type typeR = assignStmt.getRValue().accept(expressionTypeChecker);
        isAssignment = true;

        int index = indexOf(((Identifier) assignStmt.getLValue()).getName());
        if (assignStmt.getLValue() instanceof ArrayIdentifier) {
            commands.add("aload " + index);
            commands.add(((ArrayIdentifier) assignStmt.getLValue()).getIndex().accept(this));
            commands.add(assignStmt.getRValue().accept(this));
            if (typeR instanceof IntType || typeR instanceof BoolType)
                commands.add("iastore");
            else
                commands.add("aastore");
        }
        else {
            commands.add(assignStmt.getRValue().accept(this));
            commands.add("istore " + index);
        }

        isAssignment = false;
        return String.join("\n",commands);
    }
    @Override
    public String visit(WhileStmt whileStmt) {
        ArrayList<String> commands = new ArrayList<String>();

        String startL = getLabelStr();
        String exitL = getLabelStr();

        commands.add(startL + ":");
        if (whileStmt.getCondition() != null) {
            commands.add(whileStmt.getCondition().accept(this));
            commands.add("ifeq " + exitL);
        }

        for (Statement statement : whileStmt.getBody())
            commands.add(statement.accept(this));

        commands.add("goto " + startL);
        commands.add(exitL + ":");
        return String.join("\n",commands);
    }
    @Override
    public String visit(FunctionCall funcCall) {
        List<String> commands = new ArrayList<>();
        String name = funcCall.getFunctionName().getName();
        String returnTypeSign = makeTypeSignature(funcsReturnType.get(name));
        switch (name)
        {
            case "Print" ->{
                commands.add("getstatic java/lang/System/out Ljava/io/PrintStream;");
                for(var arg : funcCall.getArgs()) {
                    commands.add(arg.accept(this));
                    Type type = arg.accept(expressionTypeChecker);
                    if (type instanceof IntType)
                        commands.add("invokevirtual java/io/PrintStream/println(I)V");
                    else if (type instanceof BoolType)
                        commands.add("invokevirtual java/io/PrintStream/println(Z)V");
                    else if (type instanceof StringType)
                        commands.add("invokevirtual java/io/PrintStream/println(V)V");
                }
            }
            case "Connect" -> {
                for(var arg : funcCall.getArgs())
                    commands.add(arg.accept(this));

                commands.add("invokestatic LYourClass/Connect(Ljava/lang/String;Ljava/lang/String;)V");
            }
            case "Observe" -> {
                for(var arg : funcCall.getArgs())
                    commands.add(arg.accept(this));

                commands.add("invokestatic LYourClass/Observe(Ljava/lang/String;)LTrade;");
            }
            case "Order" -> {
                commands.add("new Order");
                commands.add("dup");
                for (var arg : funcCall.getArgs())
                    commands.add(arg.accept(this));
                commands.add("invokespecial Order/<init>(Ljava/lang/String;III)V");
            }
            case "GetCandle" -> {
                for (var arg : funcCall.getArgs())
                    commands.add(arg.accept(this));
                commands.add("invokevirtual LYourClass/GetCandle(I)V");
            }
            default -> {
                ArrayList<String> argsTypeSign = new ArrayList<String>();
                for (var arg : funcCall.getArgs()) {
                    commands.add(arg.accept(this));
                    argsTypeSign.add(makeTypeSignature(arg.getType()));
                }
                commands.add("invokestatic LYourClass/" + name + "(" + String.join("", argsTypeSign) + ")" +
                        returnTypeSign);
                if (!isAssignment) commands.add("pop\n");
            }
        }

        return String.join("\n",commands);
    }
    @Override
    public String visit(IfElseStmt conditionalStmt) {
        ArrayList<String> commands = new ArrayList<>();
        commands.add(conditionalStmt.getCondition().accept(this));

        String thenL = getLabelStr();
        String elseL = getLabelStr();
        String exitL = getLabelStr();

        commands.add("ifeq" + " " + elseL);
        commands.add(thenL + ":");
        for (var stmt : conditionalStmt.getThenBody())
            commands.add(stmt.accept(this));

        commands.add("goto " + exitL);
        commands.add(elseL + ":");
        if (!conditionalStmt.getElseBody().isEmpty())
            for (var stmt : conditionalStmt.getElseBody())
                commands.add(stmt.accept(this));

        commands.add(exitL + ":");
        return String.join("\n",commands);
    }
    @Override
    public String visit(MethodCall methodCall) {
        ArrayList<String> commands = new ArrayList<String>();
        ArrayList<String> argsTypeSign = new ArrayList<String>();
        int index = indexOf(((Identifier) methodCall.getInstance()).getName());
        commands.add("aload " + index);
        for (var arg : methodCall.getArgs()) {
            commands.add(arg.accept(this));
            argsTypeSign.add(makeTypeSignature(arg.getType()));
        }

        commands.add("invokevirtual Order/" + methodCall.getFunctionName().getName() + "(" +
                String.join("",argsTypeSign) + ")V");

        return String.join("\n", commands);

    }
    @Override
    public String visit(VarAccess varAccess) {
        ArrayList<String> commands = new ArrayList<String>();
        String name = ((Identifier) varAccess.getInstance()).getName();
        String variable = varAccess.getVariable().getName();
        int index = indexOf(name);

        commands.add("aload " + index);
        switch (variable) {
            case "Bid" -> commands.add("invokevirtual LTrade/getBid()F");
            case "Ask" -> commands.add("invokevirtual LTrade/getAsk()D");
            case "Digits" -> commands.add("invokevirtual LTrade/getDigits()I");
            case "Candles" -> commands.add("invokevirtual LTrade/getCandlesNum()I");
            case "Time" -> commands.add("invokevirtual LCandle/getTime()Ljava/lang/String");
            case "Open" -> commands.add("invokevirtual LCandle/getOpenTimePrice()F");
            case "Close" -> commands.add("invokevirtual LCandle/getCloseTimePrice()F");
            case "High" -> commands.add("invokevirtual LCandle/getHigh()F");
            case "Low" -> commands.add("invokevirtual LCandle/getLow()F");
            case "Volume" -> commands.add("invokevirtual LCandle/getVolume()D");
            default -> commands.add("invokevirtual LYourClass/get" + variable + "()V");
        }

        return String.join("\n", commands);
    }
    @Override
    public String visit(ReturnStmt returnStmt) {
        Expression returnedExpr = returnStmt.getReturnedExpr();
        Type type = returnedExpr.accept(expressionTypeChecker);
        ArrayList<String> commands = new ArrayList<>();

        if(type instanceof VoidType) {
            commands.add("return");
        }
        else {
            commands.add(returnedExpr.accept(this));
            if (type instanceof IntType || type instanceof BoolType)
                commands.add("ireturn");
            else if (type instanceof FloatType)
                commands.add("freturn");
            else
                commands.add("areturn");
        }

        return String.join("\n",commands);
    }
    @Override
    public String visit(NullValue nullValue) {
        return "ldc null";
    }
    @Override
    public String visit(IntValue intValue) {
        return "bipush " + intValue.getConstant();
    }
    @Override
    public String visit(FloatValue floatValue) {
        return "ldc " + floatValue.getConstant();
    }
    @Override
    public String visit(BoolValue boolValue) {
        return boolValue.getConstant() ?
                "ldc " + 1 :
                "ldc " + 0;
    }
    @Override
    public String visit(StringValue stringValue) {
        return "ldc "  + stringValue.getConstant();
    }
    @Override
    public String visit(TradeValue tradeValue) {
        return "ldc \""  + tradeValue.getConstant() + "\"";
    }
    @Override
    public String visit(UnaryExpression unaryExpression) {
        List<String> stmts = new ArrayList<>();
        stmts.add(unaryExpression.getOperand().accept(this));
        switch (unaryExpression.getUnaryOperator()) {
            case BIT_NOT -> {
                stmts.add("ldc -1");
                stmts.add("ixor");
            }
            case MINUS -> {
                stmts.add("ineg");
            }
            case NOT -> {
                stmts.add("ldc 1");
                stmts.add("ixor");
            }
            case INC -> {
                stmts.add("ldc 1");
                stmts.add("iadd");
            }
            case DEC -> {
                stmts.add("ldc -1");
                stmts.add("iadd");
            }
        }
        return String.join("\n", stmts);
    }
    @Override
    public String visit(BinaryExpression binaryExpression) {
        ArrayList<String> stmts = new ArrayList<>();
        Type typeL = binaryExpression.getLeft().accept(expressionTypeChecker);
//        Type typeR = binaryExpression.getRight().accept(expressionTypeChecker);
        stmts.add(binaryExpression.getLeft().accept(this));
        BinaryOperator op = binaryExpression.getBinaryOperator();

        if (!(op == BinaryOperator.AND || op == BinaryOperator.OR)) // short circuit
            stmts.add(binaryExpression.getRight().accept(this));

        switch (binaryExpression.getBinaryOperator()) {
            case PLUS -> stmts.add("iadd");
            case MINUS -> stmts.add("isub");
            case MULT -> stmts.add("imul");
            case DIV -> stmts.add("idiv");
            case MOD -> stmts.add("irem");
            case BIT_OR -> stmts.add("ior");
            case BIT_AND -> stmts.add("iand");
            case BIT_XOR -> stmts.add("ixor");
            case L_SHIFT -> stmts.add("lshl");
            case R_SHIFT -> stmts.add("lshr");
            case EQ -> {
                String L1 = getLabelStr();
                String exitL = getLabelStr();
               if (typeL instanceof IntType || typeL instanceof BoolType)
               {
                   stmts.add("if_icmpeq " + L1);
                   stmts.add("ldc 0");
                   stmts.add("goto " + exitL);
                   stmts.add(L1 + ":");
                   stmts.add("ldc 1");
                   stmts.add(exitL + ":");
               }
               else
               {
                   stmts.add("if_acmpeq " + L1);
                   stmts.add("ldc 0");
                   stmts.add("goto " + exitL);
                   stmts.add(L1 + ":");
                   stmts.add("ldc 1");
                   stmts.add(exitL + ":");
               }
            }
            case NEQ -> {
                String L1 = getLabelStr();
                String exitL = getLabelStr();
                if (binaryExpression.getLeft() instanceof IntValue
                    || binaryExpression.getLeft() instanceof BoolValue)
                {
                    stmts.add("if_icmpne " + L1);
                    stmts.add("ldc 0");
                    stmts.add("goto " + exitL);
                    stmts.add(L1 + ":");
                    stmts.add("ldc 1");
                    stmts.add(exitL + ":");
                }
                else {
                    stmts.add("if_acmpne " + L1);
                    stmts.add("ldc 0");
                    stmts.add("goto " + exitL);
                    stmts.add(L1 + ":");
                    stmts.add("ldc 1");
                    stmts.add(exitL + ":");
                }
            }
            case GT -> {
                String L1 = getLabelStr();
                String exitL = getLabelStr();
                stmts.add("if_icmpgt " + L1);
                stmts.add("ldc 0");
                stmts.add("goto " + exitL);
                stmts.add(L1 + ":");
                stmts.add("ldc 1");
                stmts.add(exitL + ":");
            }
            case LT -> {
                String L1 = getLabelStr();
                String exitL = getLabelStr();
                stmts.add("if_icmplt " + L1);
                stmts.add("ldc 0");
                stmts.add("goto " + exitL);
                stmts.add(L1 + ":");
                stmts.add("ldc 1");
                stmts.add(exitL + ":");
            }
            case AND -> {
                String elseL = getLabelStr();
                String exitL = getLabelStr();
                stmts.add("--ifeq " + elseL);
                stmts.add(binaryExpression.getRight().accept(this));
                stmts.add("--ifeq " + elseL);
                stmts.add("ldc 1");
                stmts.add("goto " + exitL);
                stmts.add(elseL + ":");
                stmts.add("ldc 0");
                stmts.add(exitL + ":");
            }
            case OR -> {
                String elseL = getLabelStr();
                String exitL = getLabelStr();
                stmts.add("--ifne " + elseL);
                stmts.add(binaryExpression.getRight().accept(this));
                stmts.add("--ifne " + elseL);
                stmts.add("ldc 0");
                stmts.add("goto " + exitL);
                stmts.add(elseL + ":");
                stmts.add("ldc 1");
                stmts.add(exitL + ":");
            }

            default -> {
            }
        }
        return String.join("\n", stmts);
    }
    @Override
    public String visit(Identifier identifier) {
        Type type = identifier.accept(expressionTypeChecker);
        String typeSign = "a";
        if (type instanceof IntType)
            typeSign = "i";
        else if (type instanceof FloatType)
            typeSign = "f";

        return typeSign + "load " + indexOf(identifier.getName());
    }
    @Override
    public String visit(ArrayIdentifier arrayIdentifier) {
        ArrayList<String> commands = new ArrayList<>();

        commands.add("aload " + indexOf(arrayIdentifier.getName()));
        commands.add(arrayIdentifier.getIndex().accept(this));
        commands.add("iaload");

        return String.join("\n", commands);
    }

}