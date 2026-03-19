grammar NavasMartinez;

// Reglas Sintácticas
// Axioma
prog
    : 'PROGRAM' IDENT ';' dcllist cabecera sentlist 'END' 'PROGRAM' IDENT subproglist EOF
    ;

// constantes y variables
dcllist
    : dcl*
    ;

dcl
    : tipo ',' 'PARAMETER' '::' IDENT '=' simpvalue ctelist ';'
    | tipo '::' varlist ';'
    ;

ctelist
    :
    | ',' IDENT '=' simpvalue ctelist
    ;

simpvalue
    : NUM_INT_CONST
    | NUM_REAL_CONST
    | STRING_CONST
    ;

varlist
    : IDENT init varlistRest
    ;

varlistRest
    :
    | ',' IDENT init varlistRest
    ;

init
    :
    | '=' simpvalue
    ;

tipo
    : 'INTEGER'
    | 'REAL'
    | 'CHARACTER' charlength
    ;

charlength
    :
    | '(' NUM_INT_CONST ')'
    ;

// Declaración de cabecera
cabecera
    :
    | 'INTERFACE' cablist 'END' 'INTERFACE'
    ;

cablist
    : decsubprog+
    ;

decsubprog
    : decproc
    | decfun
    ;

// Declaración de procedimiento
decproc
    : 'SUBROUTINE' IDENT formal_paramlist dec_s_paramlist 'END' 'SUBROUTINE' IDENT
    ;

formal_paramlist
    :
    | '(' nomparamlist ')'
    ;

nomparamlist
    : IDENT nomparamlistRest
    ;

nomparamlistRest
    :
    | ',' IDENT nomparamlistRest
    ;

dec_s_paramlist
    :
    | tipo ',' 'INTENT' '(' tipoparam ')' IDENT ';' dec_s_paramlist
    ;

tipoparam
    : 'IN'
    | 'OUT'
    | 'INOUT'
    ;

// Declaración de función
decfun
    : 'FUNCTION' IDENT '(' nomparamlist ')' tipo '::' IDENT ';'
      dec_f_paramlist 'END' 'FUNCTION' IDENT
    ;

dec_f_paramlist
    :
    | tipo ',' 'INTENT' '(' tipoparam ')' IDENT ';' dec_f_paramlist
    ;

// Sentencias
sentlist
    : sent+
    ;

sent
    : IDENT '=' exp ';'
    | proc_call ';'
    ;

exp
    : factor expRest
    ;

expRest
    :
    | op factor expRest
    ;

op
    : '+'
    | '-'
    | '*'
    | '/'
    ;

factor
    : simpvalue
    | '(' exp ')'
    | IDENT '(' exp explist ')'
    | IDENT
    ;

explist
    :
    | ',' exp explist
    ;

proc_call
    : 'CALL' IDENT subpparamlist
    ;

subpparamlist
    :
    | '(' exp explist ')'
    ;

//Implementación de funciones y procedimientos
subproglist
    : (codproc | codfun)*
    ;

codproc
    : 'SUBROUTINE' IDENT formal_paramlist dec_s_paramlist
      dcllist sentlist
      'END' 'SUBROUTINE' IDENT
    ;

codfun
    : 'FUNCTION' IDENT '(' nomparamlist ')' tipo '::' IDENT ';'
      dec_f_paramlist
      dcllist sentlist
      IDENT '=' exp ';'
      'END' 'FUNCTION' IDENT
    ;

// Reglas Léxicas

// Palabras reservadas
PROGRAM_KW    : 'PROGRAM' ;
END_KW        : 'END' ;
INTERFACE_KW  : 'INTERFACE' ;
SUBROUTINE_KW : 'SUBROUTINE' ;
FUNCTION_KW   : 'FUNCTION' ;
PARAMETER_KW  : 'PARAMETER' ;
INTENT_KW     : 'INTENT' ;
CALL_KW       : 'CALL' ;
INTEGER_KW    : 'INTEGER' ;
REAL_KW       : 'REAL' ;
CHARACTER_KW  : 'CHARACTER' ;
IN_KW         : 'IN' ;
OUT_KW        : 'OUT' ;
INOUT_KW      : 'INOUT' ;

// Constantes literales
STRING_CONST
    : '\'' ( '\'\'' | ~['] )* '\''
    | '"'  ( '""'   | ~["] )* '"'
    ;

// Constantes numéricas
NUM_REAL_CONST
    : '-'? DIGIT+ '.' DIGIT+ ( [eE] '-'? DIGIT+ )?
    | '-'? DIGIT+ [eE] '-'? DIGIT+
    ;

NUM_INT_CONST
    : '-'? DIGIT+
    ;

fragment DIGIT : [0-9] ;

// Identificadores
IDENT
    : [a-zA-Z] [a-zA-Z0-9_]*
    ;

// Comentarios
COMMENT
    : '!' ~[\r\n]* -> skip
    ;

// Espacios en blanco
WS
    : [ \t\r\n]+ -> skip
    ;