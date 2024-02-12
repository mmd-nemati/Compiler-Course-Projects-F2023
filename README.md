# UT Trade Language Compiler
##### Program Language & Compiler course project in fall 2023 at UT, lectured by Dr. Ghasemi.

---
## Overview:
 - UT Trade Language (UTL) is a language designed by PLC course team, to do algorithmic trading in crtyptocurrency market. 
 - UTL scripts need a broker to work properly. 
 - UTL is a storngly statically-typed language and supports standard types such as `int`, `float`, `boolean`, `string` and some complex new types such as `Candle` and `Trade` which are used in trading scripts.
 - It has most of basic programming structures, such as `local-global variable`, `function`, `while`, `for`, `try catch`, `Exception`, `if else`, `comment` and etc.
 - The overal structure is similliar to C++, having a Main function.
 - Full details are presented in the [documentation](https://github.com/MMDSour/PLC-CA/blob/main/PLC_Phase4/src/main/visitor/codeGenerator/CodeGenerator.java).
 - A sample code is given below.
  ``` java 
void Main() {
    try {
        Connect("username", "password");
        string market = "USDETH";
        Trade t1 = Observe(market);
        Trade t2 = Observe("");
        Trade t3 = Observe("IRRETH");
    }
    catch Exception e {
        if (e.Type == 1)
            Print("Login Failure!");
    }
    @schedule (t1 preorder t3) parallel t2;
    //@schedule (t1 parallel t2) preorder (t3 parallel t4);
 }
```
---
## Projects:

  <summary> <h4> We implemented the language complier using Antlr4 adnd Java in 4 phases.</h3></summary>

1. In [Phase 1](#phase-1---lexer-and-parser), the Lexical analyzer and Syntax analyzer paresr were developed using Antlr4.
2. [Phase 2](#phase-2---ast-and-name-analyzer) was dedicated to implementing generating AST from the input and also Name analyzer.
3. In [Phase 3](#phase-3---type-analyzer) *which in fact was practical exam* the implementing of the Type analyzer was completed.
4.  In [the last Phase](#phase-4---code-generation), we implemented the compilation of the program by generating Java Bytecode of the input script.


---
### Phase 1 - Lexer and Parser:
- In this phase all tokens of the language were described in Antlr which has a regular expression approach same as mentioned in the course. 
- Using these tokens we developed the grammer of the language. It is a LL(K) parser which we tried to guarantee no ambiguity.
- In the end we put some ```print``` as semantic actions in the grammer, so we can verify its correctness.
- A sample code for this phase:
```Antlr
// Parser

while_loop
    : WHILE   { System.out.println("Loop:while"); }
      LPAR
      if_statement
      RPAR
      loop_body
    ;
// Tokens

WHILE:      'while';
CONTINUE:   'continue';
BREAK:      'break';
RETURN:     'return';
IF:         'if';
ELSE:       'else';
```
### Phase 2 - AST and Name Analyzer:
- In this phase we modified the grammer file to also generate the AST and fill the nodes of the tree.
> Following steps all have a Visitor Pattern which was discussed in the course.
- After generating the AST and printing it, we use Symbol Table approach to store the names and check various naming error such as:
  - duplicate names of the variables
  - conflict names of the variables and functions
  - redefinition of the functions
  - etc...
- Sample codes for this part:
``` Antlr
// Grammer code for AST:

whileStatement returns [WhileStmt whileStmtRet] :
    WHILE LPAREN e = expression RPAREN
    {
        $whileStmtRet = new WhileStmt($e.expressionRet);
        $whileStmtRet.setLine($WHILE.line);
    }
    (LBRACE (s = statement { $whileStmtRet.addBody($s.statementRet); })* RBRACE | s = statement { $whileStmtRet.addBody($s.statementRet); })
    ;
```
``` Java
// Name Analyzer code:
@Override
public Void visit(VarDeclaration varDeclaration) {
    var variableItem = new VariableItem(varDeclaration.getIdentifier().getName(), varDeclaration.getType());
    try {
        SymbolTable.top.get("Function_" + varDeclaration.getIdentifier().getName());
        nameErrors.add(new FunctionVariableConflict(varDeclaration.getLine(), varDeclaration.getIdentifier().getName()));
    }
    catch (ItemNotFoundException e) { // pass }
    SymbolTable currentTable = SymbolTable.top;
    try {
        currentTable.put(variableItem);
    } catch (ItemAlreadyExistsException e) {
        nameErrors.add(new VariableRedefinition(varDeclaration.getLine(), varDeclaration.getIdentifier().getName()));
    }

    return null;
}
```
### Phase 3 - Type Analyzer:
- As mentioned above, this phase was a 2-hours long practical exam. So not much features were implemented.
- We use the Symbol Table to determine type of the expressions and statements. Also a No-Type approach was used for bad typing. Errors:
  - using a non-boolean for conditions
  - mis-matched type for operators like `+`
- A sample code for this phase:
``` Java
// Type checking code:
@Override
public Void visit(WhileStmt whileStmt) {
    Type conditionType = whileStmt.getCondition().accept(expressionTypeChecker);
    if (!(conditionType instanceof BoolType)) {
        typeErrors.add(new ConditionTypeNotBool(whileStmt.getLine()));
    }
    whileStmt.getBody().forEach(statement -> statement.accept(this));
    return null;
}
```
### Phase 4 - Code Generation:
- In this phase, the compiler can generate a Java Bytecode (in [Jasmin](https://jasmin.sourceforge.net/) syntax) which can be run by an assembler.
- Again we use a Visitor Pattern to visit each node of the AST and generate its corresponding bytecode.
- Some of the features of this code generation:
  - short-circuit implementation for ```&&``` and ```||``` operations
  - using of ```if_icmpeq``` for equity of integers
  - using of ```bipush``` for pushing values on the stack 
- A sample code for this phase:
``` Java
// Code generation code:
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
```
---
## Contributors:

- [Mohammad Souri](https://github.com/MMDSour)
- [Mohammad Nemati](https://github.com/mmd-nemati)
