grammar NavasMartinez;

//PALABRAS RESERVADAS (Keywords)
//Nota: Las palabras reservadas de tu lenguaje (como 'if', 'while', etc.) deben ir definidas AQUÍ, ANTES de la regla IDENT. 
//De esta forma, el lexer les dará prioridad y no las confundirá con identificadores.
//EJEMPLO:
//IF_KW   : 'if' ;
//THEN_KW : 'then' ;


//CONSTANTES LITERALES (Cadenas de texto)
//Permiten cualquier carácter. Si el delimitador aparece dentro, debe estar duplicado ('') o ("").

STRING_CONST
    : '\'' ( '\'\'' | ~['] )* '\''
    | '"'  ( '""'   | ~["] )* '"'
    ;

//CONSTANTES NUMÉRICAS (Reales y Enteros)
//IMPORTANTE: NUM_REAL_CONST debe declararse antes que NUM_INT_CONST para que el analizador léxico intente emparejar primero la versión más larga (el real).

NUM_REAL_CONST
    : '-'? DIGIT+ '.' DIGIT+ ( [eE] '-'? DIGIT+ )?  //Punto fijo y Mixto
    | '-'? DIGIT+ [eE] '-'? DIGIT+                  //Exponencial
    ;

NUM_INT_CONST
    : '-'? DIGIT+
    ;

//Regla fragmentada para reutilizar el concepto de dígito internamente
fragment DIGIT
    : [0-9]
    ;

//IDENTIFICADORES
//Obligatorio empezar por letra, seguido de letras, dígitos o guiones bajos.
//Alfabeto inglés (sin eñes ni acentos).

IDENT
    : [a-zA-Z] [a-zA-Z0-9_]*
    ;

//COMENTARIOS Y ESPACIOS EN BLANCO

//Comentarios: empiezan con '!' y terminan al final de la línea. Se ignoran (skip).
COMMENT
    : '!' ~[\r\n]* -> skip
    ;

//Ignorar espacios en blanco, tabulaciones y saltos de línea
WS
    : [ \t\r\n]+ -> skip
    ;
