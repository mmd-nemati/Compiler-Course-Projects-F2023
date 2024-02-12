grammar UTL;

utl
    : (function | comment | init SEMICOLON| declaration SEMICOLON)*
      main
      (function | comment | init SEMICOLON| declaration SEMICOLON)*;


comment
    : SINGLELINECOMMENT
    | MULTILINECOMMENT;

main
     : type
       MAIN
       LPAR
       RPAR
       LBRACE
       statement*
       RBRACE
      ;

statement
    :
    (
          return_function
        | function_call                 { System.out.println("FunctionCall"); }
        | print_function_call           { System.out.println("Built-in:print"); }
        | primitive_function_call       { System.out.println("FunctionCall"); }
        | expr
        | init
        | declaration
        | assignment
        | schedule?
        | throw_exception
    ) SEMICOLON
    | comment
    | if_condition
    | for_loop
    | while_loop
    | try_catch
    ;

type
    : INT
    | BOOLEAN
    | FLOAT
    | DOUBLE
    | STRING
    | VOID
    | CANDLE
    | TRADE
    ;

bool_val
    : TRUE
    | FALSE
    ;

num_val
    : MINUS?
    (
          INT_VAL
        | DECIMAL_VAL
        | bool_val
    )
    ;

method_and_atribute
    :
    (
          OPEN
        | CLOSE
    )
    LPAR RPAR
    | ASK
    | BID
    | DIGITS
    | TIME
    | CANDLES
    | HIGH
    | LOW
    | VOLUME
    | TYPE_METHOD
    ;


non_num_val
    : STRING_VAL
    ;

init
    : array_init
    | var_init
    | order_init
    | exception_init
    ;

get_candle
    : GETCANDLE
      LPAR
      expr
      RPAR
    ;

var_init
    : var_declaration
      ASSIGN      { System.out.println("Operator:="); }
      (expr | non_num_val)
    ;

array_init
    : array_declaration
      ASSIGN      { System.out.println("Operator:="); }
      (expr | non_num_val)
    ;

label_val
    : STATIC
    | SHARED
    ;

declaration
    :
    (
          array_declaration
        | var_declaration
        | order_declaration
        | exception_declaration
    )
    ;

array_declaration
    : (label_val)? type
      LBRACKET
      size = num_val
      RBRACKET
      name = IDENTIFIER { System.out.println("ArrayDec:" + $name.text + ":" + $size.text); }
    ;

var_declaration
    :
    (label_val)? type
    name = IDENTIFIER { System.out.println("VarDec:" + $name.text); }
    ;

order
    : order_construct access?
    | order_declaration
    | order_init;

order_construct
    :  ORDER
       LPAR
       (BUY|SELL) COMMA
       expr COMMA
       expr COMMA
       expr
       RPAR
    ;

order_declaration
    : label_val?
      ORDER
      name = IDENTIFIER   { System.out.println("VarDec:" + $name.text); }
    ;

order_init
    : order_declaration
    ASSIGN      { System.out.println("Operator:="); }
    order_construct
    ;

exception
    : exception_construct access?
    | exception_declaration
    | exception_init;

exception_construct
    : EXCEPTION
      LPAR
      exctype = num_val  { System.out.println("ErrorControl:" + $exctype.text); }
      COMMA
      (IDENTIFIER | non_num_val)
      RPAR
    ;

exception_declaration
    : label_val? EXCEPTION
    name = IDENTIFIER   { System.out.println("VarDec:" + $name.text); }
    ;

exception_init
    : exception_declaration
    ASSIGN      { System.out.println("Operator:="); }
    exception_construct
    ;

if_statement
    : expr
    | function_call
    | var_init
    | order_init
    | exception_init
    | ((STATIC|SHARED)? (
        | var_declaration
        | order_declaration
        | exception_declaration
        ))
    | assignment
    | primitive_function_call
    | order
    | exception
    | comment
    ;

if_body
    : statement
    | function_body
    ;

if_condition
    : IF     { System.out.println("Conditional:if"); }
      LPAR
      (if_statement SEMICOLON)*
      if_statement
      RPAR
      if_body
      (
        ELSE    { System.out.println("Conditional:else"); }
        function_body
      )?
    ;

loop_statement
    : expr
    | function_call
    | init
    | declaration
    | assignment
    | primitive_function_call
    | order
    | exception
    | comment
    ;

if_condition_in_loop
    : IF    { System.out.println("Conditional:if"); }
      LPAR
      (if_statement SEMICOLON)*
      if_statement
      RPAR
      loop_body
      (
        ELSE    { System.out.println("Conditional:else"); }
        loop_body
      )?
    ;

single_line_loop_statement
    :
    (
        statement | if_condition_in_loop
        | BREAK SEMICOLON    { System.out.println("Control:break"); }
        | CONTINUE SEMICOLON     { System.out.println("Control:continue"); }
      )
    ;

loop_body
    : single_line_loop_statement
    |
    (
        LBRACE
        single_line_loop_statement*
        RBRACE
    )
    ;

while_loop
    : WHILE   { System.out.println("Loop:while"); }
      LPAR
      if_statement
      RPAR
      loop_body
    ;

for_loop
    : FOR     { System.out.println("Loop:for"); }
      LPAR
      loop_statement?
      SEMICOLON
      loop_statement?
      SEMICOLON
      loop_statement?
      RPAR
      (
          single_line_loop_statement
          | loop_body
       )
    ;

throw_exception
    : THROW
    (
        exception_construct
       | expr
    )
    ;


try_catch
    : TRY
      function_body
      CATCH EXCEPTION IDENTIFIER
      function_body
    ;

schedule
    : AT SCHEDULE
     ((LPAR pre_and_par RPAR) | pre_and_par)
     (
         (PREORDER | PARALLEL)
         ((LPAR pre_and_par RPAR) | pre_and_par)
     )*  { System.out.println("ConcurrencyControl:Schedule"); }
    ;

pre_and_par
    :
    (
        IDENTIFIER
        (PREORDER | PARALLEL)
        IDENTIFIER
    )
    | IDENTIFIER
    ;

array
    : IDENTIFIER
    LBRACKET
    (
         array
       | expr_bitwise_and_or_xor
    )
    RBRACKET
    ;

access
    :
    (
        IDENTIFIER
        | exception_construct
        | order_construct
        | array
    )
    DOT
    method_and_atribute
    ;

function_call
    : IDENTIFIER
    LPAR
    (expr
    (COMMA expr)*
    )?
    RPAR
    ;

return_function
    : RETURN
    (expr | non_num_val)?
    ;

function_OnInit
    : type
      ONINIT
      LPAR
      TRADE
      IDENTIFIER
      RPAR
      (THROW EXCEPTION)?
      function_body
    ;

function_OnStart
    : type
      ONSTART
      LPAR
      TRADE
      IDENTIFIER
      RPAR
      (THROW EXCEPTION)?
      function_body
    ;

connect
    : CONNECT
      LPAR
      non_num_val
      COMMA
      non_num_val
      RPAR
    ;

observe
    : OBSERVE
      LPAR
      non_num_val
      RPAR
    ;

refresh_rate
    : REFRATE
      LPAR
      RPAR
    ;

terminate
    : TERMINATE
      LPAR
      RPAR
    ;

print_function_call
    : PRINT
      LPAR
      (expr | non_num_val)
      RPAR
    ;

primitive_function_call
    : connect
    | get_candle
    | observe
    | refresh_rate
    | terminate
    ;

function
    : function_OnInit
    | function_OnStart
    | function_prototype
    ( THROW EXCEPTION )?
    ( SEMICOLON | function_body )
    ;

function_prototype
     : type
       name = IDENTIFIER  { System.out.println("MethodDec:" + $name.text); }
       LPAR
       (type IDENTIFIER (COMMA type IDENTIFIER)*)*
       RPAR
     ;

function_body
     : LBRACE
       statement *
       RBRACE
     ;

assignment
    : (IDENTIFIER | array)
    (
          ASSIGN    { System.out.println("Operator:="); }
        | MULTEQ    { System.out.println("Operator:*="); }
        | DIVEQ     { System.out.println("Operator:/="); }
        | MINEQ     { System.out.println("Operator:-="); }
        | PLEQ      { System.out.println("Operator:+="); }
        | MODEQ     { System.out.println("Operator:%="); }
    )
    expr
    ;


expr
    : expr_logic_or
    ;

expr_logic_or
    : expr_logic_and expr_logic_or_util
    ;

expr_logic_or_util
    : LGOR expr_logic_and expr_logic_or_util    { System.out.println("Operator:||"); }
    |
    ;

expr_logic_and
    : expr_bitwise_and_or_xor expr_logic_and_util
    ;

expr_logic_and_util
    : LGAND expr_bitwise_and_or_xor expr_logic_and_util     { System.out.println("Operator:&&"); }
    |
    ;

expr_bitwise_and_or_xor
    : expr_rel_eq_neq expr_bitwise_and_or_xor_util
    ;

expr_bitwise_and_or_xor_util
    : BITOR expr_rel_eq_neq expr_bitwise_and_or_xor_util      { System.out.println("Operator:|"); }
    | BITAND expr_rel_eq_neq expr_bitwise_and_or_xor_util     { System.out.println("Operator:&"); }
    | BITXOR expr_rel_eq_neq expr_bitwise_and_or_xor_util     { System.out.println("Operator:^"); }
    |
    ;

expr_rel_eq_neq
    : expr_rel_cmp expr_rel_eq_neq_util
    ;

expr_rel_eq_neq_util
    : EQL expr_rel_cmp expr_rel_eq_neq_util      { System.out.println("Operator:=="); }
    | NEQ expr_rel_cmp expr_rel_eq_neq_util      { System.out.println("Operator:!="); }
    |
    ;

expr_rel_cmp
    : expr_bit_shift expr_rel_cmp_util
    ;

expr_rel_cmp_util
    : GTR expr_bit_shift expr_rel_cmp_util      { System.out.println("Operator:>"); }
    | LES expr_bit_shift expr_rel_cmp_util      { System.out.println("Operator:<"); }
    |
    ;

expr_bit_shift
    : expr_arith_plus_minus expr_bit_shift_util
    ;

expr_bit_shift_util
    : RSH expr_arith_plus_minus expr_bit_shift_util      { System.out.println("Operator:>>"); }
    | LSH expr_arith_plus_minus expr_bit_shift_util      { System.out.println("Operator:<<"); }
    |
    ;

expr_arith_plus_minus
    : expr_arith_mult_div_mod expr_arith_plus_minus_util
    ;

expr_arith_plus_minus_util
    : PLUS expr_arith_mult_div_mod expr_arith_plus_minus_util       { System.out.println("Operator:+"); }
    | MINUS expr_arith_mult_div_mod expr_arith_plus_minus_util      { System.out.println("Operator:-"); }
    |
    ;

expr_arith_mult_div_mod
    : expr_unary_plus_minus_not_inc_dec expr_arith_mult_div_mod_util
    ;

expr_arith_mult_div_mod_util
    : MULT expr_unary_plus_minus_not_inc_dec expr_arith_mult_div_mod_util       { System.out.println("Operator:*"); }
    | DIV expr_unary_plus_minus_not_inc_dec expr_arith_mult_div_mod_util        { System.out.println("Operator:/"); }
    | MOD expr_unary_plus_minus_not_inc_dec expr_arith_mult_div_mod_util        { System.out.println("Operator:%"); }
    |
    ;

expr_unary_plus_minus_not_inc_dec
    : BITNOT expr_other     { System.out.println("Operator:~"); }
    | MINUS expr_other      { System.out.println("Operator:-"); }
    | LGNOT expr_other      { System.out.println("Operator:!"); }
    | INC expr_other        { System.out.println("Operator:++"); }
    | DEC expr_other        { System.out.println("Operator:--"); }
    | expr_other
    ;

expr_other
    : LPAR expr RPAR
    |
        (
              access
            | array
            | IDENTIFIER
        )
        (
              INC       { System.out.println("Operator:++"); }
            | DEC       { System.out.println("Operator:--"); }
        ) ?
    | function_call
    | primitive_function_call
    | num_val
    ;

// Keywords

MAIN:       'Main';
PRINT:      'Print';
FOR:        'for';
WHILE:      'while';
CONTINUE:   'continue';
BREAK:      'break';
RETURN:     'return';
IF:         'if';
ELSE:       'else';
PARALLEL:   'parallel';
PREORDER:   'preorder';
BUY:        'BUY';
SELL:       'SELL';
EXCEPTION:  'Exception';
TYPE:       'type';
TYPE_METHOD:       'Type';
TEXT:       'Text';

// Exceptions

TRY:        'try';
CATCH:      'catch';
THROW:      'throw';

// Predifined Functions

SCHEDULE:   'schedule';
CONNECT:    'Connect';
OBSERVE:    'Observe';
REFRATE:    'RefreshRate';
ONSTART:    'OnStart';
ONINIT:     'OnInit';
TERMINATE:  'Terminate';
GETCANDLE:  'GetCandle';

// Predifined Structures

CANDLE:     'Candle';

// Predifined Variables

ASK:        'Ask';
BID:        'Bid';
CANDLES:    'Candles';
DIGITS:     'Digits';
TRADE:      'Trade';
ORDER:      'Order';

// Predifined Lists

TIME:       'Time';
OPEN:       'Open';
CLOSE:      'Close';
HIGH:       'High';
LOW:        'Low';
VOLUME:     'Volume';

// Const and Global variables

STATIC:     'static';
SHARED:     'shared';

// Data Types

INT:        'int';
FLOAT:      'float';
DOUBLE:     'double';
BOOLEAN:    'bool';
STRING:     'string';
VOID:       'void';

// Values

NULL:        'null';
//ZERO:        '0';
TRUE:        'true';
FALSE:       'false';
INT_VAL:     [1-9][0-9]* | [0];
DECIMAL_VAL: INT_VAL '.' [0-9]+ | '0.' [0-9]*;
BOOLEAN_VAL: TRUE | FALSE;
STRING_VAL:   '"' ('\\' ["\\] | ~["\\\r\n])* '"';

// Parenthesis

LPAR:       '(';
RPAR:       ')';

// Access and Methods

DOT:        '.';

// Brackets

LBRACKET:   '[';
RBRACKET:   ']';

// Arithmetic Operators

INC:        '++';
DEC:        '--';
MULT:       '*';
DIV:        '/';
MOD:        '%';
PLUS:       '+';
MINUS:      '-';

// Bitwise Shift

RSH:        '>>';
LSH:        '<<';

// Relational Operators

GTR:        '>';
LES:        '<';
EQL:        '==';
NEQ:        '!=';

// Bitwise Operators

BITAND:     '&';
BITOR:      '|';
BITXOR:     '^';
BITNOT:     '~';

// Logical Operators

LGAND:      '&&';
LGOR:       '||';
LGNOT:      '!';

// Assigning Operators

ASSIGN:      '=';
MULTEQ:     '*=';
DIVEQ:      '/=';
MODEQ:      '%=';
PLEQ:       '+=';
MINEQ:      '-=';

// Symbols

COMMA:      ',';
LBRACE:     '{';
RBRACE:     '}';
COLON:      ':';
SEMICOLON:  ';';
AT:         '@';

// Other

IDENTIFIER: ([a-z]|[A-Z])[a-zA-Z0-9_]*;
SINGLELINECOMMENT:    '//' ~[\r\n]* -> skip;
MULTILINECOMMENT:     '/*' .*? '*/' -> skip;
WS:         [ \t\r\n]+ -> skip;
