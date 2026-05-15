grammar Grupo11;

prog
    : PROGRAM_KW IDENT ';' dcllist cabecera sentlist END_KW PROGRAM_KW IDENT subproglist EOF
    ;

dcllist
    :
    | dcl dcllist
    ;

dcl
    : tipo ',' PARAMETER_KW '::' IDENT '=' simpvalue ctelist ';'
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
    : INTEGER_KW
    | REAL_KW
    | CHARACTER_KW charlength
    ;

charlength :  | '(' NUM_INT_CONST ')' ;

cabecera
    :
    | INTERFACE_KW cablist END_KW INTERFACE_KW
    ;

cablist     : decsubprog cablistRest ;
cablistRest :  | decsubprog cablistRest ;
decsubprog  : decproc | decfun ;

decproc
    : SUBROUTINE_KW IDENT formal_paramlist dec_s_paramlist END_KW SUBROUTINE_KW IDENT
    ;

formal_paramlist :  | '(' nomparamlist ')' ;
nomparamlist     : IDENT nomparamlistRest ;
nomparamlistRest :  | ',' IDENT nomparamlistRest ;

dec_d_paramlist
    : tipo ',' INTENT_KW '(' tipoparam ')' IDENT ';'
    ;

dec_s_paramlist
    :
    | dec_d_paramlist dec_s_paramlist
    ;

tipoparam : IN_KW | OUT_KW | INOUT_KW ;

decfun
    : FUNCTION_KW IDENT '(' nomparamlist ')' tipo '::' IDENT ';'
      dec_f_paramlist END_KW FUNCTION_KW IDENT
    ;

dec_f_paramlist
    :
    | dec_d_paramlist dec_f_paramlist
    ;

sentlist     : sent sentlistRest ;
sentlistRest :  | sent sentlistRest ;

sent
    : IDENT '=' exp ';'
    | proc_call ';'
    | IF_KW '(' expcond ')' sent
    | IF_KW '(' expcond ')' THEN_KW sentlist ENDIF_KW
    | IF_KW '(' expcond ')' THEN_KW sentlist ELSE_KW sentlist ENDIF_KW
    | DO_KW WHILE_KW '(' expcond ')' sentlist ENDDO_KW
    | DO_KW IDENT '=' doval ',' doval ',' doval sentlist ENDDO_KW
    | SELECT_KW CASE_KW '(' exp ')' casos END_KW SELECT_KW
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
    | CASE_KW '(' etiquetas ')' sentlist casos
    | CASE_KW DEFAULT_KW sentlist
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

proc_call     : CALL_KW IDENT subpparamlist ;
subpparamlist :  | '(' exp explist ')' ;

subproglist :  | subprog subproglist ;
subprog     : codproc | codfun ;

codproc
    : SUBROUTINE_KW IDENT formal_paramlist dec_s_paramlist
      dcllist sentlist
      END_KW SUBROUTINE_KW IDENT
    ;

codfun
    : FUNCTION_KW IDENT '(' nomparamlist ')' tipo '::' IDENT ';'
      dec_f_paramlist
      dcllist sentlist
      IDENT '=' exp ';'
      END_KW FUNCTION_KW IDENT
    ;

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
