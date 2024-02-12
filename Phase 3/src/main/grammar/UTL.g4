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
    ( varDeclaration { $pro.addVar($varDeclaration.varDecRet); }
    | functionDeclaration { $pro.addFunction($functionDeclaration.funcDecRet); }
    | initDeclaration { $pro.addInit($initDeclaration.initDecRet); }
    | startDeclaration { $pro.addStart($startDeclaration.startDecRet); }
    )* mainDeclaration { $pro.setMain($mainDeclaration.mainDecRet); }
    EOF;

identifier returns [Identifier identRet]:{ $identRet = new Identifier("");} ID{ $identRet.setName($ID.text); $identRet.setLine($ID.line);};

statement returns [Statement statementRet] :
     ( varDeclaration { $statementRet = $varDeclaration.varDecRet; }
     | functionDeclaration { $statementRet = $functionDeclaration.funcDecRet; }
     | assignStatement { $statementRet = $assignStatement.assignStmtRet; }
     | continueBreakStatement { $statementRet = $continueBreakStatement.contBreakRet; }
     | returnStatement { $statementRet = $returnStatement.retStmtRet; }
     | ifStatement { $statementRet = $ifStatement.ifStmtRet; }
     | whileStatement { $statementRet = $whileStatement.whileStmtRet; }
     | forStatement { $statementRet = $forStatement.forStmtRet; }
     | tryCatchStatement { $statementRet = $tryCatchStatement.tryCatchStmtRet; }
     | throwStatement { $statementRet = $throwStatement.throwStmtRet; }
     | expression SEMICOLON { ExpressionStmt expret = new ExpressionStmt($expression.expressionRet);$statementRet = expret; }
     );

varDeclaration returns [VarDeclaration varDecRet] : { $varDecRet = new VarDeclaration(); }
    allType { $varDecRet.setType($allType.allTypeRet); }
    (LBRACK INT_LITERAL RBRACK { $varDecRet.setLength(Integer.parseInt($INT_LITERAL.text)); })?
    i1=identifier (ASSIGN expression {$varDecRet.setRValue($expression.expressionRet);})? SEMICOLON { $varDecRet.setIdentifier($identifier.identRet); $varDecRet.setLine($i1.identRet.getLine());};

funcVarDeclaration returns [VarDeclaration funcVarDecRet] : { $funcVarDecRet = new VarDeclaration(); }
    allType { $funcVarDecRet.setType($allType.allTypeRet); }
    (LBRACK INT_LITERAL RBRACK { $funcVarDecRet.setLength(Integer.parseInt($INT_LITERAL.text)); })?
    i1=identifier (ASSIGN expression {$funcVarDecRet.setRValue($expression.expressionRet);})? { $funcVarDecRet.setIdentifier($identifier.identRet); $funcVarDecRet.setLine($i1.identRet.getLine());};


functionDeclaration returns [FunctionDeclaration funcDecRet] : { $funcDecRet = new FunctionDeclaration(); }
    primitiveType { $funcDecRet.setReturnType($primitiveType.primTypeRet); }
    i1=identifier { $funcDecRet.setName($identifier.identRet); $funcDecRet.setLine($i1.identRet.getLine()); }
    LPAREN  (funcVarDeclaration{ $funcDecRet.addArg($funcVarDeclaration.funcVarDecRet);}
    (COMMA funcVarDeclaration{ $funcDecRet.addArg($funcVarDeclaration.funcVarDecRet); })*)?
    RPAREN (THROW EXCEPTION)? (LBRACE (statement { $funcDecRet.addStatement($statement.statementRet); })* RBRACE | statement { $funcDecRet.addStatement($statement.statementRet);});

mainDeclaration returns [ MainDeclaration mainDecRet] : { $mainDecRet = new MainDeclaration(); }
    VOID MAIN LPAREN RPAREN (LBRACE (statement {$mainDecRet.setLine($MAIN.line);$mainDecRet.addStatement($statement.statementRet);})* RBRACE | statement{ $mainDecRet.addStatement($statement.statementRet);});

initDeclaration returns [OnInitDeclaration initDecRet] : {$initDecRet = new OnInitDeclaration();}
    VOID ONINIT LPAREN TRADE identifier {$initDecRet.setLine($ONINIT.line); $initDecRet.setTradeName($identifier.identRet);} RPAREN
    (THROW EXCEPTION)? (LBRACE (statement{$initDecRet.addStatement($statement.statementRet);})*  RBRACE | statement {$initDecRet.addStatement($statement.statementRet);});

startDeclaration returns [OnStartDeclaration startDecRet]: {$startDecRet = new OnStartDeclaration(null);}
    VOID ONSTART LPAREN TRADE{$startDecRet.setLine($VOID.line);} identifier {$startDecRet.setTradeName($identifier.identRet);}
    RPAREN (THROW EXCEPTION)? (LBRACE (statement {$startDecRet.addStatement($statement.statementRet);})* RBRACE | statement {$startDecRet.addStatement($statement.statementRet);});

assignStatement returns [AssignStmt assignStmtRet] : {$assignStmtRet = new AssignStmt(null,null);}
    (i1=identifier {$assignStmtRet.setLValue($i1.identRet);}|( i2=identifier LBRACK ex1=expression RBRACK{ArrayIdentifier arrayRet = new ArrayIdentifier($i2.identRet.getName(),$ex1.expressionRet);arrayRet.setLine($i2.identRet.getLine());$assignStmtRet.setLValue(arrayRet);})) assign ex2 = expression {$assignStmtRet.setRValue($ex2.expressionRet);} SEMICOLON{$assignStmtRet.setLine($SEMICOLON.line);};

ifStatement returns [IfElseStmt ifStmtRet] : {$ifStmtRet = new IfElseStmt(null);}
    IF {$ifStmtRet.setLine($IF.line);} LPAREN expression {$ifStmtRet.setCondition($expression.expressionRet);} RPAREN (LBRACE (statement {$ifStmtRet.addThenStatement($statement.statementRet);})* RBRACE | statement{$ifStmtRet.addThenStatement($statement.statementRet);}) (ELSE (LBRACE (statement{$ifStmtRet.addElseStatement($statement.statementRet);})* RBRACE | statement{$ifStmtRet.addElseStatement($statement.statementRet);}))?;

whileStatement returns [WhileStmt whileStmtRet] : {$whileStmtRet = new WhileStmt(null);}
    WHILE {$whileStmtRet.setLine($WHILE.line);} LPAREN expression {$whileStmtRet.setCondition($expression.expressionRet);} RPAREN (LBRACE (statement {$whileStmtRet.addBody($statement.statementRet);})* RBRACE | statement{$whileStmtRet.addBody($statement.statementRet);});

forStatement returns [ForStmt forStmtRet] : {$forStmtRet = new ForStmt();}
    FOR {$forStmtRet.setLine($FOR.line);} LPAREN statement {$forStmtRet.addInit($statement.statementRet);} expression {$forStmtRet.setCondition($expression.expressionRet);} SEMICOLON (expression{$forStmtRet.addUpdate($expression.expressionRet);})? RPAREN (LBRACE (statement {$forStmtRet.addBody($statement.statementRet);})* RBRACE | statement {$forStmtRet.addBody($statement.statementRet);});

tryCatchStatement returns [TryCatchStmt tryCatchStmtRet] : {$tryCatchStmtRet = new TryCatchStmt();}
    TRY {$tryCatchStmtRet.setLine($TRY.line);} (LBRACE (statement{$tryCatchStmtRet.addThenStatement($statement.statementRet);})* RBRACE | statement{$tryCatchStmtRet.addThenStatement($statement.statementRet);}) (CATCH EXCEPTION ID (LBRACE (statement{$tryCatchStmtRet.addElseStatement($statement.statementRet);})* RBRACE | statement{$tryCatchStmtRet.addElseStatement($statement.statementRet);}))?;

continueBreakStatement returns [ContinueBreakStmt contBreakRet] :
    (BREAK {$contBreakRet = new ContinueBreakStmt($BREAK.text);$contBreakRet.setLine($BREAK.line);}
    | CONTINUE {$contBreakRet = new ContinueBreakStmt($CONTINUE.text); $contBreakRet.setLine($CONTINUE.line);}) SEMICOLON;

returnStatement returns [ReturnStmt retStmtRet] :
    RETURN expression {$retStmtRet = new ReturnStmt($expression.expressionRet);$retStmtRet.setLine($RETURN.line);}SEMICOLON;

throwStatement returns [ThrowStmt throwStmtRet]:
    THROW expression{$throwStmtRet = new ThrowStmt($expression.expressionRet);$throwStmtRet.setLine($THROW.line);} SEMICOLON;

functionCall returns [FunctionCall funcCallRet]: {$funcCallRet = new FunctionCall(null);}
    (espetialFunction {$funcCallRet.setFunctionName($espetialFunction.name);}
    | complexValue{$funcCallRet.setFunctionName($complexValue.compTypeRet);}
    | identifier{$funcCallRet.setFunctionName($identifier.identRet);}) LPAREN (expression{$funcCallRet.addArg($expression.expressionRet);}
    (COMMA expression{$funcCallRet.addArg($expression.expressionRet);})*)? RPAREN{$funcCallRet.setLine($LPAREN.line);};

methodCall returns [MethodCall methodCallRet] : {$methodCallRet = new MethodCall(null,null);}
    (identifier {$methodCallRet.setInstance($identifier.identRet);}
    | (identifier LBRACK expression RBRACK){ArrayIdentifier arrayRet = new ArrayIdentifier($identifier.identRet.getName(),$expression.expressionRet); $methodCallRet.setInstance(arrayRet);})DOT {$methodCallRet.setLine($DOT.line);} espetialMethod{$methodCallRet.setFunctionName($espetialMethod.name);} LPAREN (expression{$methodCallRet.addArg($expression.expressionRet);} (COMMA expression{$methodCallRet.addArg($expression.expressionRet);})*)? RPAREN;

expression returns [Expression expressionRet] :
    value {$expressionRet = $value.valRet;}
    | exp1=expression DOT espetialVariable {VarAccess varaccRet = new VarAccess($exp1.expressionRet,$espetialVariable.name);varaccRet.setLine($DOT.line); $expressionRet = varaccRet;}
    | exp1=expression { UnaryOperator op = UnaryOperator.NOT; Integer line;}(INC {op = UnaryOperator.INC; line = $INC.line;} | DEC{op = UnaryOperator.DEC;line= $DEC.line;}) {UnaryExpression unaryexpr = new UnaryExpression(op,$exp1.expressionRet);unaryexpr.setLine(line);$expressionRet = unaryexpr;}
    | { UnaryOperator op = UnaryOperator.NOT;Integer line;}(NOT {op = UnaryOperator.NOT;line = $NOT.line;}| MINUS{op = UnaryOperator.MINUS;line = $MINUS.line;} | BIT_NOT {op = UnaryOperator.BIT_NOT;line=$BIT_NOT.line;}| INC{op = UnaryOperator.INC;line = $INC.line;} | DEC{op = UnaryOperator.DEC;line= $DEC.line;}) expression {UnaryExpression unaryexpr = new UnaryExpression(op,$expression.expressionRet);unaryexpr.setLine(line);$expressionRet = unaryexpr;}
    | exp1=expression{ BinaryOperator op = BinaryOperator.PLUS; Integer line;} (MULT {op = BinaryOperator.MULT; line = $MULT.line;}| DIV{op = BinaryOperator.DIV; line = $DIV.line;} | MOD{op = BinaryOperator.MULT; line = $MOD.line;}) exp2=expression {BinaryExpression binaryexpr = new BinaryExpression($exp1.expressionRet,$exp2.expressionRet,op);binaryexpr.setLine(line);$expressionRet = binaryexpr;}
    | exp1=expression { BinaryOperator op = BinaryOperator.PLUS; Integer line;}(PLUS {op = BinaryOperator.PLUS; line = $PLUS.line;}| MINUS{op = BinaryOperator.MINUS;line = $MINUS.line;}) exp2=expression{BinaryExpression binaryexpr = new BinaryExpression($exp1.expressionRet,$exp2.expressionRet,op);binaryexpr.setLine(line);$expressionRet = binaryexpr;}
    | exp1=expression { BinaryOperator op = BinaryOperator.PLUS; Integer line;}(L_SHIFT {op = BinaryOperator.L_SHIFT; line = $L_SHIFT.line;}| R_SHIFT{op = BinaryOperator.R_SHIFT;line = $R_SHIFT.line;}) exp2=expression{BinaryExpression binaryexpr = new BinaryExpression($exp1.expressionRet,$exp2.expressionRet,op);binaryexpr.setLine(line);$expressionRet = binaryexpr;}
    | exp1=expression { BinaryOperator op = BinaryOperator.PLUS; Integer line;}(LT {op = BinaryOperator.LT; line = $LT.line;}| GT {op = BinaryOperator.GT; line = $GT.line;}) exp2=expression{BinaryExpression binaryexpr = new BinaryExpression($exp1.expressionRet,$exp2.expressionRet,op);binaryexpr.setLine(line);$expressionRet = binaryexpr;}
    | exp1=expression { BinaryOperator op = BinaryOperator.PLUS; Integer line;}(EQ {op = BinaryOperator.EQ;line = $EQ.line;}| NEQ {op = BinaryOperator.NEQ;line = $NEQ.line;}) exp2=expression{BinaryExpression binaryexpr = new BinaryExpression($exp1.expressionRet,$exp2.expressionRet,op);binaryexpr.setLine(line);$expressionRet = binaryexpr;}
    | exp1=expression { BinaryOperator op = BinaryOperator.PLUS; Integer line;}(BIT_AND {op = BinaryOperator.BIT_AND;line = $BIT_AND.line;}| BIT_OR {op =  BinaryOperator.BIT_OR; line = $BIT_OR.line;}| BIT_XOR{op = BinaryOperator.BIT_XOR; line = $BIT_XOR.line;}) exp2=expression{BinaryExpression binaryexpr = new BinaryExpression($exp1.expressionRet,$exp2.expressionRet,op);binaryexpr.setLine(line);$expressionRet = binaryexpr;}
    | exp1=expression AND { BinaryOperator op = BinaryOperator.AND; Integer line = $AND.line;}exp2=expression{BinaryExpression binaryexpr = new BinaryExpression($exp1.expressionRet,$exp2.expressionRet,op);binaryexpr.setLine(line);$expressionRet = binaryexpr;}
    | exp1=expression OR { BinaryOperator op = BinaryOperator.OR; Integer line = $OR.line;}exp2=expression{BinaryExpression binaryexpr = new BinaryExpression($exp1.expressionRet,$exp2.expressionRet,op);binaryexpr.setLine(line);$expressionRet = binaryexpr;}
    | i1=identifier {$expressionRet = $i1.identRet;}
    | i2=identifier(LBRACK expression RBRACK){ArrayIdentifier arrayRet = new ArrayIdentifier($i2.identRet.getName(),$expression.expressionRet);arrayRet.setLine($i2.identRet.getLine()); $expressionRet = arrayRet;}
    | LPAREN expression RPAREN {$expressionRet = $expression.expressionRet;}
    | functionCall {$expressionRet = $functionCall.funcCallRet;}
    | methodCall {$expressionRet = $methodCall.methodCallRet;};

value returns [Value valRet] :
    INT_LITERAL{$valRet= new IntValue(Integer.parseInt($INT_LITERAL.text));$valRet.setLine($INT_LITERAL.line);}
    | FLOAT_LITERAL{$valRet = new FloatValue(Float.parseFloat($FLOAT_LITERAL.text));$valRet.setLine($FLOAT_LITERAL.line);}
    | STRING_LITERAL{$valRet = new StringValue($STRING_LITERAL.text);$valRet.setLine($STRING_LITERAL.line);}
    | SELL{$valRet = new TradeValue($SELL.text);$valRet.setLine($SELL.line);}
    | BUY{$valRet = new TradeValue($BUY.text);$valRet.setLine($BUY.line);}
    ;

primitiveType returns [Type primTypeRet] :
    FLOAT {$primTypeRet = new FloatType();}
    | INT {$primTypeRet = new IntType();}
    | BOOL {$primTypeRet = new BoolType();}
    | STRING {$primTypeRet = new StringType();}
    | VOID {$primTypeRet = new VoidType();}
    ;

complexType returns [Type compTypeRet]:
    ORDER {$compTypeRet = new OrderType();}
    | TRADE{$compTypeRet = new TradeType();}
    | CANDLE{$compTypeRet = new CandleType();}
    | EXCEPTION{$compTypeRet = new ExceptionType();}
    ;



complexValue returns [Identifier compTypeRet]:
    (n=ORDER
    | n=TRADE
    | n=CANDLE
    | n=EXCEPTION)  {$compTypeRet = new Identifier(null);$compTypeRet.setName($n.text);$compTypeRet.setLine($n.line);}
    ;


allType returns [Type allTypeRet]: primitiveType{$allTypeRet = $primitiveType.primTypeRet;} | complexType {$allTypeRet = $complexType.compTypeRet;};

espetialFunction returns [Identifier name]: {$name = new Identifier(null);}(n=REFRESH_RATE | n=CONNECT | n=OBSERVE | n=GET_CANDLE | n=TERMINATE | n=PRINT){$name.setName($n.text);$name.setLine($n.line);};

espetialVariable returns [Identifier name]: {$name = new Identifier(null);} (n=ASK | n=BID | n=TIME | n=HIGH | n=LOW | n=DIGITS | n=VOLUME | n=TYPE | n=TEXT | n=OPEN | n=CLOSE){$name.setName($n.text);$name.setLine($n.line);};

espetialMethod returns [Identifier name]: {$name = new Identifier(null);} (n=OPEN | n=CLOSE){$name.setName($n.text);$name.setLine($n.line);};

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

COMMENT: (('//' ~('\r'|'\n')*) | ('/*' .*? '*/')) -> skip;
