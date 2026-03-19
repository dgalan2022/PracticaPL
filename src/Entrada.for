PROGRAM prueba_completa;

! Declaracion de constantes
INTEGER , PARAMETER :: bloque = 1024;
REAL , PARAMETER :: PI = 3.141592, E = 2.718281;
CHARACTER (2) , PARAMETER :: S = 'SI', N = 'NO';

! Declaracion de variables
INTEGER :: var1, var2 = 24;
REAL :: var3;
CHARACTER :: var4, var5 = 'hola', var6;
CHARACTER (10) :: var7, var8;

! Cabecera de funciones y procedimientos
INTERFACE

SUBROUTINE proc1 ( c, d, e )
    REAL , INTENT ( OUT ) c;
    INTEGER , INTENT ( IN ) d;
    INTEGER , INTENT ( INOUT ) e;
END SUBROUTINE proc1

SUBROUTINE proc2
END SUBROUTINE proc2

FUNCTION fun1 ( a, b )
    INTEGER :: fun1;
    INTEGER , INTENT ( IN ) a;
    INTEGER , INTENT ( IN ) b;
END FUNCTION fun1

END INTERFACE

! Sentencias del programa principal
var1 = 5;
var2 = var1 + 3;
var3 = 1.5;
var2 = var1 * var2 + 24;
CALL proc2;
CALL proc1 ( var3, var1, var2 );
var1 = fun1 ( var1, var2 );

END PROGRAM prueba_completa

! Implementacion de procedimientos y funciones
SUBROUTINE proc2
    INTEGER :: local1;
    local1 = 0;
END SUBROUTINE proc2

SUBROUTINE proc1 ( c, d, e )
    REAL , INTENT ( OUT ) c;
    INTEGER , INTENT ( IN ) d;
    INTEGER , INTENT ( INOUT ) e;
    INTEGER :: local2;
    local2 = d + e;
    c = 3.14;
END SUBROUTINE proc1

FUNCTION fun1 ( a, b )
    INTEGER :: fun1;
    INTEGER , INTENT ( IN ) a;
    INTEGER , INTENT ( IN ) b;
    INTEGER :: resultado;
    resultado = a + b;
    fun1 = resultado + 1;
END FUNCTION fun1