grammar UTL;

@header{
    import main.ast.node.*;
    import main.ast.node.declaration.*;
    import main.ast.node.statement.*;
    import main.ast.node.expression.*;
    import main.ast.node.expression.operators.*;
    import main.ast.node.expression.values.*;
    import main.ast.type.primitiveType.*;
    import main.ast.type.complexType.*;
    import main.ast.type.*;
}
// Parser rules
// do not change first rule (program) name
program returns [Program pro] : {$pro = new Program(); $pro.setLine(0);}
    ( globalVarDeclaration { $pro.addGlobalVar($globalVarDeclaration.globalVarDecRet); }
    | functionDeclaration { $pro.addFunction($functionDeclaration.funcDecRet); }
    | initDeclaration { $pro.addInit($initDeclaration.initDecRet); }
    | startDeclaration { $pro.addStart($startDeclaration.startDecRet); }
    )* mainDeclaration { $pro.setMain($mainDeclaration.mainDecRet); }
    ;


statement returns [Statement statementRet] :
          ( varDeclaration { $statementRet = $varDeclaration.varDecRet; }
          | functionDeclaration { $statementRet = $functionDeclaration.funcDecRet; }
          | assignStatement { $statementRet = $assignStatement.assignStmtRet; }
          | continueBreakStatement { $statementRet = $continueBreakStatement.continueBreakStmtRet; }
          | returnStatement { $statementRet = $returnStatement.returnStmtRet; }
          | ifStatement { $statementRet = $ifStatement.ifStmtRet; }
          | whileStatement { $statementRet = $whileStatement.whileStmtRet; }
          | forStatement { $statementRet = $forStatement.forStmtRet; }
          | tryCatchStatement { $statementRet = $tryCatchStatement.tryCatchStmtRet; }
          | throwStatement { $statementRet = $throwStatement.throwStmtRet; }
          | expression SEMICOLON { $statementRet = new ExpressionStmt($expression.expressionRet); }
          );

//TODO save expression?
globalVarDeclaration returns [GlobalVarDeclaration globalVarDecRet] : { $globalVarDecRet = new GlobalVarDeclaration(); }
    allType { $globalVarDecRet.setType($allType.allTypeRet); }
    (LBRACK INT_LITERAL RBRACK { $globalVarDecRet.setLength($INT_LITERAL.int); })?
    id = identifier (ASSIGN e = expression { $globalVarDecRet.setValue($e.expressionRet); })? SEMICOLON
    {
        $globalVarDecRet.setIdentifier($id.idRet);
        $globalVarDecRet.setLine($id.idRet.getLine());
    }
    ;

//TODO save expression?
varDeclaration returns [VarDeclaration varDecRet] : { $varDecRet = new VarDeclaration(); }
    allType { $varDecRet.setType($allType.allTypeRet); }
    (LBRACK INT_LITERAL RBRACK { $varDecRet.setLength($INT_LITERAL.int); })?
    id = identifier (ASSIGN e = expression { $varDecRet.setValue($e.expressionRet); })? SEMICOLON
    {
        $varDecRet.setIdentifier($id.idRet);
        $varDecRet.setLine($id.idRet.getLine());
    }
    ;

functionDeclaration returns [FunctionDeclaration funcDecRet] : { $funcDecRet = new FunctionDeclaration(); }
    primitiveType { $funcDecRet.setReturnType($primitiveType.primitiveTypeRet); }
    funcName = identifier { $funcDecRet.setName($funcName.idRet); $funcDecRet.setLine($funcName.idRet.getLine()); }
    LPAREN
        (
            allType { VarDeclaration arg = new VarDeclaration(); }
            (LBRACK INT_LITERAL RBRACK { arg.setLength($INT_LITERAL.int); })?
            argName = identifier { arg.setType($allType.allTypeRet);
                                   arg.setIdentifier($argName.idRet);
                                   arg.setLine($argName.idRet.getLine());
                                   $funcDecRet.addArg(arg);
                                 }

        (COMMA allType { arg = new VarDeclaration(); }
            (LBRACK INT_LITERAL RBRACK { arg.setLength($INT_LITERAL.int); })?
            argName = identifier { arg.setType($allType.allTypeRet);
                                   arg.setIdentifier($argName.idRet);
                                   $funcDecRet.addArg(arg);  })*
        )?
    RPAREN (THROW EXCEPTION)? (LBRACE (statement { $funcDecRet.addStatement($statement.statementRet); })* RBRACE | statement { $funcDecRet.addStatement($statement.statementRet); });

identifier returns [Identifier idRet] :
    ID { $idRet = new Identifier($ID.text); $idRet.setLine($ID.line); };

mainDeclaration returns [MainDeclaration mainDecRet] : { $mainDecRet = new MainDeclaration(); }
    VOID MAIN { $mainDecRet.setLine($MAIN.line); } LPAREN RPAREN
    (LBRACE
    (s = statement
    {
       if ($s.statementRet instanceof VarDeclaration)
       {
           if ($s.statementRet.getType() instanceof TradeType)
           {
                VarDeclaration tradeDec = new VarDeclaration();
                tradeDec.setIdentifier($s.statementRet.getIdentifier());
                tradeDec.setType($s.statementRet.getType());
                tradeDec.setLine($s.statementRet.getLine());
                $mainDecRet.addTradeInstantiation(tradeDec);
           }
           else
               $mainDecRet.addStatement($s.statementRet);
       }
       else
           $mainDecRet.addStatement($s.statementRet);
     })*
     RBRACE |
    s = statement
    {
        if ($s.statementRet instanceof VarDeclaration)
        {
           if ($s.statementRet.getType() instanceof TradeType)
           {
                VarDeclaration tradeDec = new VarDeclaration();
                tradeDec.setIdentifier($s.statementRet.getIdentifier());
                tradeDec.setType($s.statementRet.getType());
                tradeDec.setLine($s.statementRet.getLine());
                $mainDecRet.addTradeInstantiation(tradeDec);
           }
            else
                $mainDecRet.addStatement($s.statementRet);
        }
        else
          $mainDecRet.addStatement($s.statementRet);
    }
    );

initDeclaration returns [OnInitDeclaration initDecRet] : { $initDecRet = new OnInitDeclaration(); }
    VOID ONINIT { $initDecRet.setLine($ONINIT.line); } LPAREN TRADE
    tradeName = identifier { $initDecRet.setTradeName($tradeName.idRet); }
    RPAREN (THROW EXCEPTION)? (LBRACE (statement { $initDecRet.addStatement($statement.statementRet); })* RBRACE | statement { $initDecRet.addStatement($statement.statementRet); });

startDeclaration returns [OnStartDeclaration startDecRet] :
    VOID ONSTART { int line = $ONSTART.line; } LPAREN TRADE
    tradeName = identifier { $startDecRet = new OnStartDeclaration($tradeName.idRet); $startDecRet.setLine(line); }
    RPAREN (THROW EXCEPTION)? (LBRACE (statement { $startDecRet.addStatement($statement.statementRet); })* RBRACE | statement { $startDecRet.addStatement($statement.statementRet); });

assignStatement returns [AssignStmt assignStmtRet] :
    tmpLval = identifier { Identifier lval; ArrayIdentifier arrLval; boolean isArr = false;}
    (LBRACK idx = expression RBRACK
    {
//        arrLval = new ArrayIdentifier($tmpLval.idRet.getName(), $idx.expressionRet);
        isArr = true;
    }
    )?
    a = assign
//    a = (ASSIGN | ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN | MOD_ASSIGN)
    rval = expression SEMICOLON
    {

        if (isArr) {
            arrLval = new ArrayIdentifier($tmpLval.idRet.getName(), $idx.expressionRet);
            arrLval.setLine($tmpLval.idRet.getLine());
            $assignStmtRet = new AssignStmt(arrLval, $rval.expressionRet);
        }
        else {
            lval = new Identifier($tmpLval.idRet.getName());
            lval.setLine($tmpLval.idRet.getLine());
            $assignStmtRet = new AssignStmt(lval, $rval.expressionRet);
        }
        $assignStmtRet.setLine($a.start.getLine());
    };

ifStatement returns [IfElseStmt ifStmtRet] :
    IF LPAREN e = expression RPAREN
    {
        $ifStmtRet = new IfElseStmt($e.expressionRet);
        $ifStmtRet.setLine($IF.line);
    }
    (LBRACE (s = statement { $ifStmtRet.addThenStatement($s.statementRet); })* RBRACE | s = statement { $ifStmtRet.addThenStatement($s.statementRet); })
    (ELSE
    (LBRACE (s = statement { $ifStmtRet.addElseStatement($s.statementRet); })* RBRACE | s = statement { $ifStmtRet.addElseStatement($s.statementRet); })
    )?
    ;

whileStatement returns [WhileStmt whileStmtRet] :
    WHILE LPAREN e = expression RPAREN
    {
        $whileStmtRet = new WhileStmt($e.expressionRet);
        $whileStmtRet.setLine($WHILE.line);
    }
    (LBRACE (s = statement { $whileStmtRet.addBody($s.statementRet); })* RBRACE | s = statement { $whileStmtRet.addBody($s.statementRet); })
    ;

forStatement returns [ForStmt forStmtRet] : { $forStmtRet = new ForStmt(); }
    FOR LPAREN i = statement c = expression SEMICOLON (u = expression { $forStmtRet.addUpdate($u.expressionRet); })? RPAREN
    {
        $forStmtRet.addInit($i.statementRet);
        $forStmtRet.setCondition($c.expressionRet);
        $forStmtRet.setLine($FOR.line);
    }
    (LBRACE (s = statement { $forStmtRet.addBody($s.statementRet); })* RBRACE | s = statement { $forStmtRet.addBody($s.statementRet); })
    ;

tryCatchStatement returns [TryCatchStmt tryCatchStmtRet] : { $tryCatchStmtRet = new TryCatchStmt(); }
    TRY { $tryCatchStmtRet.setLine($TRY.line); }
    (LBRACE (s = statement { $tryCatchStmtRet.addThenStatement($s.statementRet); })* RBRACE | s = statement { $tryCatchStmtRet.addThenStatement($s.statementRet); })
    (CATCH EXCEPTION ID
    (LBRACE (s = statement { $tryCatchStmtRet.addElseStatement($s.statementRet); })* RBRACE | s = statement { $tryCatchStmtRet.addElseStatement($s.statementRet); })
    )?
    ;

continueBreakStatement returns [ContinueBreakStmt continueBreakStmtRet] :
    txt = (BREAK | CONTINUE)
    {
        $continueBreakStmtRet = new ContinueBreakStmt($txt.text);
        $continueBreakStmtRet.setLine($txt.line);
    }
    SEMICOLON
    ;

returnStatement returns [ReturnStmt returnStmtRet] :
    RETURN e = expression
    {
        $returnStmtRet = new ReturnStmt($e.expressionRet);
        $returnStmtRet.setLine($RETURN.line);
    }
    SEMICOLON
    ;

throwStatement returns [ThrowStmt throwStmtRet] :
    THROW e = expression
    {
        $throwStmtRet = new ThrowStmt($e.expressionRet);
        $throwStmtRet.setLine($THROW.line);
    }
    SEMICOLON
    ;

functionCall returns [FunctionCall funcCallRet] :
    { Identifier funcName; }
    (
      sf = specialFunction  { funcName = new Identifier($sf.text); funcName.setLine($sf.start.getLine()); }
    | ct = complexType      { funcName = new Identifier($ct.text); funcName.setLine($ct.start.getLine()); }
    | id = identifier       { funcName = $id.idRet; funcName.setLine($id.idRet.getLine()); }
    ) { $funcCallRet = new FunctionCall(funcName); }

    LPAREN { $funcCallRet.setLine($LPAREN.line); }
    (e = expression       { $funcCallRet.addArg($e.expressionRet); }
    (COMMA e = expression { $funcCallRet.addArg($e.expressionRet); })*)?
    RPAREN
    ;

methodCall returns [MethodCall methodCallRet] :
    { Identifier ins; ArrayIdentifier arrIns; boolean isArr = false; }
    id = identifier
    (LBRACK idx = expression RBRACK
    {
        isArr = true;
    }
    )?

    DOT sm = specialMethod
    {
        Identifier funcName = new Identifier($sm.text);
        funcName.setLine($sm.start.getLine());
        if (isArr) {
            arrIns = new ArrayIdentifier($id.idRet.getName(), $idx.expressionRet);
            arrIns.setLine($id.idRet.getLine());
            $methodCallRet = new MethodCall(arrIns, funcName);
        }
        else {
            ins = new Identifier($id.idRet.getName());
            ins.setLine($id.idRet.getLine());
            $methodCallRet = new MethodCall(ins, funcName);

        }
        $methodCallRet.setLine($id.idRet.getLine());

    }
    LPAREN
    (e = expression       { $methodCallRet.addArg($e.expressionRet); }
    (COMMA e = expression { $methodCallRet.addArg($e.expressionRet); })*)?
    RPAREN
    ;

expression returns [Expression expressionRet] :
                val = value
                {
                    $expressionRet = $val.valueRet;
                    $expressionRet.setLine($val.valueRet.getLine());
                }
           |
                e = expression DOT sv = specialVariable
                {
                    Identifier varName = new Identifier($sv.text);
                    varName.setLine($sv.start.getLine());
                    VarAccess varAccess = new VarAccess($e.expressionRet, varName);
                    varAccess.setLine($e.expressionRet.getLine());
                    $expressionRet = varAccess;
                }
           |
                e = expression
                { UnaryOperator uop; }
                (
                  opr = INC { uop = UnaryOperator.INC; }
                | opr = DEC { uop = UnaryOperator.DEC; }
                )
                {
                    UnaryExpression ue = new UnaryExpression(uop, $e.expressionRet);
                    $expressionRet = ue;
                    $expressionRet.setLine($opr.getLine());
                }
           |
                { UnaryOperator uop; }
                (
                  opr = NOT       { uop = UnaryOperator.NOT; }
                | opr = MINUS     { uop = UnaryOperator.MINUS; }
                | opr = BIT_NOT   { uop = UnaryOperator.BIT_NOT; }
                | opr = INC       { uop = UnaryOperator.INC; }
                | opr = DEC       { uop = UnaryOperator.DEC; }
                )
                e = expression
                {
                    UnaryExpression ue = new UnaryExpression(uop, $e.expressionRet);
                    $expressionRet = ue;
                    $expressionRet.setLine($opr.getLine());
                }
           |
               lval = expression
               { BinaryOperator bop; }
               (
                 opr = MULT { bop = BinaryOperator.MULT; }
               | opr = DIV  { bop = BinaryOperator.DIV; }
               | opr = MOD  { bop = BinaryOperator.MOD; }
               )
               rval = expression
               {
                    BinaryExpression be = new BinaryExpression($lval.expressionRet, $rval.expressionRet, bop);
                    $expressionRet = be;
                    $expressionRet.setLine($opr.getLine());
               }
           |
               lval = expression
               { BinaryOperator bop; }
               (
                 opr = PLUS     { bop = BinaryOperator.PLUS; }
               | opr = MINUS    { bop = BinaryOperator.MINUS; }
               )
               rval = expression
               {
                    BinaryExpression be = new BinaryExpression($lval.expressionRet, $rval.expressionRet, bop);
                    $expressionRet = be;
                    $expressionRet.setLine($opr.getLine());
               }
           |
               lval = expression
               { BinaryOperator bop; }
               (
                 opr = L_SHIFT      { bop = BinaryOperator.L_SHIFT; }
               | opr = R_SHIFT      { bop = BinaryOperator.R_SHIFT; }
               )
               rval = expression
               {
                    BinaryExpression be = new BinaryExpression($lval.expressionRet, $rval.expressionRet, bop);
                    $expressionRet = be;
                    $expressionRet.setLine($opr.getLine());
               }
           |
               lval = expression
               { BinaryOperator bop; }
               (
                 opr = LT      { bop = BinaryOperator.LT; }
               | opr = GT      { bop = BinaryOperator.GT; }
               )
               rval = expression
               {
                    BinaryExpression be = new BinaryExpression($lval.expressionRet, $rval.expressionRet, bop);
                    $expressionRet = be;
                    $expressionRet.setLine($opr.getLine());
               }
           |
               lval = expression
               { BinaryOperator bop; }
               (
                 opr = EQ      { bop = BinaryOperator.EQ; }
               | opr = NEQ     { bop = BinaryOperator.NEQ; }
               )
               rval = expression
               {
                    BinaryExpression be = new BinaryExpression($lval.expressionRet, $rval.expressionRet, bop);
                    $expressionRet = be;
                    $expressionRet.setLine($opr.getLine());
               }
           |
               lval = expression
               { BinaryOperator bop; }
               (
                 opr = BIT_AND  { bop = BinaryOperator.BIT_AND; }
               | opr = BIT_OR   { bop = BinaryOperator.BIT_OR; }
               | opr = BIT_XOR  { bop = BinaryOperator.BIT_XOR; }
               )
               rval = expression
               {
                    BinaryExpression be = new BinaryExpression($lval.expressionRet, $rval.expressionRet, bop);
                    $expressionRet = be;
                    $expressionRet.setLine($opr.getLine());
               }
           |
               lval = expression
               { BinaryOperator bop; }
               (
                 opr = AND  { bop = BinaryOperator.AND; }
               )
               rval = expression
               {
                    BinaryExpression be = new BinaryExpression($lval.expressionRet, $rval.expressionRet, bop);
                    $expressionRet = be;
                    $expressionRet.setLine($opr.getLine());
               }
           | expression OR expression
               lval = expression
               { BinaryOperator bop = BinaryOperator.OR; }
               (
                 opr = OR  { bop = BinaryOperator.OR; }
               )
               rval = expression
               {
                    BinaryExpression be = new BinaryExpression($lval.expressionRet, $rval.expressionRet, bop);
                    $expressionRet = be;
                    $expressionRet.setLine($opr.getLine());
               }
           | arrId = identifier LBRACK idx = expression RBRACK
               {
                    ArrayIdentifier ai = new ArrayIdentifier($arrId.idRet.getName(), $idx.expressionRet);
                    ai.setLine($arrId.idRet.getLine());
                    $expressionRet = ai;
                    $expressionRet.setLine(ai.getLine());
               }
           | id = identifier
               {
                    $expressionRet = $id.idRet;
                    $expressionRet.setLine($id.idRet.getLine());
               }
           | LPAREN e = expression RPAREN
               {
                    $expressionRet = $e.expressionRet;
                    $expressionRet.setLine($LPAREN.line);
               }
           | fc = functionCall
               {
                    $expressionRet = $fc.funcCallRet;
                    $expressionRet.setLine($fc.funcCallRet.getLine());
               }
           | mc = methodCall
               {
                    $expressionRet = $mc.methodCallRet;
                    $expressionRet.setLine($mc.methodCallRet.getLine());
               }
           ;

value returns [Value valueRet] :
      i  = INT_LITERAL      { $valueRet = new IntValue($i.int); $valueRet.setLine($i.getLine()); }
    | f  = FLOAT_LITERAL    { $valueRet = new FloatValue(Float.parseFloat($f.text)); $valueRet.setLine($f.getLine()); }
    | b  = BOOL_LITERAL     { $valueRet = new BoolValue(Boolean.valueOf($b.text)); $valueRet.setLine($b.getLine()); }
    | s  = STRING_LITERAL   { $valueRet = new StringValue($s.text); $valueRet.setLine($s.getLine()); }
    | se = SELL             { $valueRet = new TradeValue("SELL"); $valueRet.setLine($se.getLine()); }
    | bu = BUY              { $valueRet = new TradeValue("BUY"); $valueRet.setLine($bu.getLine()); }
    ;

primitiveType returns [Type primitiveTypeRet] :
      FLOAT     { $primitiveTypeRet = new FloatType(); }
    | DOUBLE    { $primitiveTypeRet = new DoubleType(); }
    | INT       { $primitiveTypeRet = new IntType(); }
    | BOOL      { $primitiveTypeRet = new BoolType(); }
    | STRING    { $primitiveTypeRet = new StringType(); }
    | VOID      { $primitiveTypeRet = new VoidType(); }
    ;

complexType returns [Type complexTypeRet] :
      ORDER     { $complexTypeRet = new OrderType(); }
    | TRADE     { $complexTypeRet = new TradeType(); }
    | CANDLE    { $complexTypeRet = new CandleType(); }
    | EXCEPTION { $complexTypeRet = new ExceptionType(); }
    ;

allType returns [Type allTypeRet] :
      pt = primitiveType    { $allTypeRet = $pt.primitiveTypeRet; }
    | ct = complexType      { $allTypeRet = $ct.complexTypeRet; }
    ;

specialFunction: REFRESH_RATE | CONNECT | OBSERVE | GET_CANDLE | TERMINATE | PRINT;

specialVariable: ASK | BID | TIME | HIGH | LOW | DIGITS | VOLUME | TYPE | TEXT | OPEN | CLOSE;

specialMethod: OPEN | CLOSE;

assign: ASSIGN | ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN | MOD_ASSIGN;

// Lexer rules
SPACES : [ \t\r\n]+ -> skip;
SEMICOLON : ';';
COMMA : ',';
COLON : ':';
DOT: '.';
LPAREN : '(';
RPAREN : ')';
LBRACE : '{';
RBRACE : '}';
LBRACK : '[';
RBRACK : ']';

PLUS : '+';
MINUS : '-';
MULT : '*';
DIV : '/';
MOD : '%';

AND : '&&';
OR: '||';
NOT: '!';

BIT_AND : '&';
BIT_OR : '|';
BIT_XOR : '^';
L_SHIFT : '<<';
R_SHIFT : '>>';
BIT_NOT : '~';

LT : '<';
GT : '>';
EQ : '==';
NEQ : '!=';

INC : '++';
DEC : '--';

ASSIGN : '=';
ADD_ASSIGN: '+=';
SUB_ASSIGN: '-=';
MUL_ASSIGN: '*=';
DIV_ASSIGN: '/=';
MOD_ASSIGN: '%=';

TRY : 'try';
THROW : 'throw';
CATCH : 'catch';
IF : 'if';
ELSE : 'else';
FOR: 'for';
WHILE : 'while';
BREAK : 'break';
CONTINUE : 'continue';
RETURN : 'return';

MAIN : 'Main';
ONINIT : 'OnInit';
ONSTART : 'OnStart';

FLOAT : 'float';
DOUBLE : 'double';
STRING: 'string';
BOOL: 'bool';
VOID: 'void';
INT : 'int';

BUY : 'BUY';
SELL : 'SELL';

ASK : 'Ask';
BID : 'Bid';
TIME : 'Time';
HIGH : 'High';
LOW : 'Low';
DIGITS : 'Digits';
VOLUME : 'Volume';
TYPE: 'Type';
TEXT: 'Text';
OPEN : 'Open';
CLOSE : 'Close';

TRADE: 'Trade';
ORDER: 'Order';
CANDLE: 'Candle';
EXCEPTION: 'Exception';

REFRESH_RATE : 'RefreshRate';
GET_CANDLE : 'GetCandle';
TERMINATE : 'Terminate';
CONNECT : 'Connect';
OBSERVE : 'Observe';
PRINT : 'Print';

ID : [a-zA-Z_][a-zA-Z_0-9]*;

INT_LITERAL : [1-9][0-9]* | '0';
FLOAT_LITERAL : [0-9]* '.' [0-9]+;
STRING_LITERAL : '"' (~["])* '"';
BOOL_LITERAL : 'True' | 'False';

COMMENT: (('//' ~('\r'|'\n')*) | ('/*' .*? '*/')) -> skip;
