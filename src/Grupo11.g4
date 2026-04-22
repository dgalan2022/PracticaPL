grammar Grupo11;

// ═══════════════════════════════════════════════════
// REGLAS SINTÁCTICAS
// ═══════════════════════════════════════════════════

prog
    : 'PROGRAM' IDENT ';' dcllist cabecera sentlist 'END' 'PROGRAM' IDENT subproglist EOF
    ;

dcllist : dcl* ;

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
    | NUM_INT_CONST_B
    | NUM_INT_CONST_O
    | NUM_INT_CONST_H
    | '.TRUE.'
    | '.FALSE.'
    ;

varlist     : IDENT init varlistRest ;
varlistRest :  | ',' IDENT init varlistRest ;
init        :  | '=' simpvalue ;

tipo
    : 'INTEGER'
    | 'REAL'
    | 'CHARACTER' charlength
    ;

charlength :  | '(' NUM_INT_CONST ')' ;

cabecera
    :
    | 'INTERFACE' cablist 'END' 'INTERFACE'
    ;

cablist    : decsubprog+ ;
decsubprog : decproc | decfun ;

decproc
    : 'SUBROUTINE' IDENT formal_paramlist dec_s_paramlist 'END' 'SUBROUTINE' IDENT
    ;

formal_paramlist :  | '(' nomparamlist ')' ;
nomparamlist     : IDENT nomparamlistRest ;
nomparamlistRest :  | ',' IDENT nomparamlistRest ;

dec_s_paramlist
    :
    | tipo ',' 'INTENT' '(' tipoparam ')' IDENT ';' dec_s_paramlist
    ;

tipoparam : 'IN' | 'OUT' | 'INOUT' ;

decfun
    : 'FUNCTION' IDENT '(' nomparamlist ')' tipo '::' IDENT ';'
      dec_f_paramlist 'END' 'FUNCTION' IDENT
    ;

dec_f_paramlist
    :
    | tipo ',' 'INTENT' '(' 'IN' ')' IDENT ';' dec_f_paramlist
    ;

// ── Sentencias ────────────────────────────────────────
sentlist : sent+ ;

sent
    : IDENT '=' exp ';'
    | proc_call ';'
    | 'IF' '(' expcond ')' sent
    | 'IF' '(' expcond ')' 'THEN' sentlist 'ENDIF'
    | 'IF' '(' expcond ')' 'THEN' sentlist 'ELSE' sentlist 'ENDIF'
    | 'DO' 'WHILE' '(' expcond ')' sentlist 'ENDDO'
    | 'DO' IDENT '=' doval ',' doval ',' doval sentlist 'ENDDO'
    | 'SELECT' 'CASE' '(' exp ')' casos 'END' 'SELECT'
    ;

doval : NUM_INT_CONST | IDENT ;

expcond     : factorcond expcondRest ;
expcondRest :  | oplog factorcond expcondRest ;

oplog : '.OR.' | '.AND.' | '.EQV.' | '.NEQV.' ;

factorcond
    : exp opcomp exp
    | '(' expcond ')'
    | '.NOT.' factorcond
    | '.TRUE.'
    | '.FALSE.'
    ;

opcomp : '<' | '>' | '<=' | '>=' | '==' | '/=' ;

casos
    :
    | 'CASE' '(' etiquetas ')' sentlist casos
    | 'CASE' 'DEFAULT' sentlist
    ;

etiquetas
    : simpvalue listaetiquetas
    | simpvalue ':' simpvalue
    | ':' simpvalue
    | simpvalue ':'
    ;

listaetiquetas :  | ',' simpvalue listaetiquetas ;

exp     : factor expRest ;
expRest :  | op factor expRest ;
op      : '+' | '-' | '*' | '/' ;

factor
    : simpvalue
    | '(' exp ')'
    | IDENT '(' exp explist ')'
    | IDENT
    ;

explist :  | ',' exp explist ;

proc_call    : 'CALL' IDENT subpparamlist ;
subpparamlist:  | '(' exp explist ')' ;

subproglist : (codproc | codfun)* ;

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

// ═══════════════════════════════════════════════════
// REGLAS LÉXICAS
// ═══════════════════════════════════════════════════

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
IF_KW         : 'IF' ;
THEN_KW       : 'THEN' ;
ELSE_KW       : 'ELSE' ;
ENDIF_KW      : 'ENDIF' ;
DO_KW         : 'DO' ;
WHILE_KW      : 'WHILE' ;
ENDDO_KW      : 'ENDDO' ;
SELECT_KW     : 'SELECT' ;
CASE_KW       : 'CASE' ;
DEFAULT_KW    : 'DEFAULT' ;

NUM_INT_CONST_B : 'b\'' [01]+        '\'' ;
NUM_INT_CONST_O : 'o\'' [0-7]+       '\'' ;
NUM_INT_CONST_H : 'z\'' [0-9A-Fa-f]+ '\'' ;

STRING_CONST
    : '\'' ( '\'\'' | ~['] )* '\''
    | '"'  ( '""'   | ~["] )* '"'
    ;

NUM_REAL_CONST
    : '-'? DIGIT+ '.' DIGIT+ ( [eE] '-'? DIGIT+ )?
    | '-'? DIGIT+ [eE] '-'? DIGIT+
    ;

NUM_INT_CONST : '-'? DIGIT+ ;

fragment DIGIT : [0-9] ;

IDENT   : [a-zA-Z] [a-zA-Z0-9_]* ;
COMMENT : '!' ~[\r\n]* -> skip ;
WS      : [ \t\r\n]+   -> skip ;