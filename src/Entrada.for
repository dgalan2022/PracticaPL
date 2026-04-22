PROGRAM EntradaCompleta;

! ── Constantes (PARAMETER) ──────────────────────────────
INTEGER , PARAMETER :: MAX = 100;
INTEGER , PARAMETER :: MIN = -50;
REAL    , PARAMETER :: PI = 3.1415;
INTEGER , PARAMETER :: FLAG_B = b'1010';
INTEGER , PARAMETER :: FLAG_O = o'17';
INTEGER , PARAMETER :: FLAG_H = z'FF';
INTEGER , PARAMETER :: VERDAD = .TRUE.;
INTEGER , PARAMETER :: FALSO  = .FALSE.;

! ── Variables del programa principal ────────────────────
INTEGER :: contador = 0;
INTEGER :: resultado;
INTEGER :: i;
REAL    :: promedio;
CHARACTER(10) :: nombre = 'Hola';

INTERFACE
  SUBROUTINE ImprimirValor
    ( valor )
    INTEGER , INTENT(IN) valor;
  END SUBROUTINE ImprimirValor

  SUBROUTINE Incrementar
    ( n )
    INTEGER , INTENT(INOUT) n;
  END SUBROUTINE Incrementar

  SUBROUTINE ObtenerMax
    ( a , b , res )
    INTEGER , INTENT(IN) a;
    INTEGER , INTENT(IN) b;
    INTEGER , INTENT(OUT) res;
  END SUBROUTINE ObtenerMax

  FUNCTION Sumar
    ( a , b )
    INTEGER :: Sumar;
    INTEGER , INTENT(IN) a;
    INTEGER , INTENT(IN) b;
  END FUNCTION Sumar

  FUNCTION Promedio
    ( a , b )
    REAL :: Promedio;
    INTEGER , INTENT(IN) a;
    INTEGER , INTENT(IN) b;
  END FUNCTION Promedio

END INTERFACE

! ── Sentencias del main ──────────────────────────────────
contador = 0;
resultado = Sumar(3, 5);
promedio = Promedio(10, 20);

! IF sin THEN
IF (contador == 0) contador = contador + 1;

! IF THEN ENDIF
IF (resultado > 0) THEN
  resultado = resultado * 2;
ENDIF

! IF THEN ELSE ENDIF
IF (promedio >= 10.0) THEN
  contador = contador + 1;
ELSE
  contador = contador - 1;
ENDIF

! IF con operador logico .AND.
IF (contador > 0 .AND. resultado /= 0) THEN
  resultado = resultado + contador;
ENDIF

! IF con .OR.
IF (contador == 0 .OR. resultado == 0) THEN
  contador = 1;
ENDIF

! IF con .NOT.
IF (.NOT. .FALSE.) THEN
  contador = contador + 1;
ENDIF

! DO WHILE
DO WHILE (contador < 10)
  contador = contador + 1;
ENDDO

! DO (bucle for)
DO i = 1, 10, 1
  resultado = resultado + i;
ENDDO

! SELECT CASE
SELECT CASE (contador)
  CASE (1)
    resultado = 100;
  CASE (2)
    resultado = 200;
  CASE DEFAULT
    resultado = 0;
END SELECT

! CALL procedimiento IN
CALL ImprimirValor(resultado);

! CALL procedimiento INOUT
CALL Incrementar(contador);

! CALL procedimiento OUT
CALL ObtenerMax(resultado, contador, resultado);

END PROGRAM EntradaCompleta

! ── Implementacion de subprogramas ───────────────────────

SUBROUTINE ImprimirValor (valor)
  INTEGER , INTENT(IN) valor;
  CALL MostrarPantalla(valor);
END SUBROUTINE ImprimirValor

SUBROUTINE Incrementar (n)
  INTEGER , INTENT(INOUT) n;
  n = n + 1;
END SUBROUTINE Incrementar

SUBROUTINE ObtenerMax (a, b, res)
  INTEGER , INTENT(IN) a;
  INTEGER , INTENT(IN) b;
  INTEGER , INTENT(OUT) res;
  IF (a > b) THEN
    res = a;
  ELSE
    res = b;
  ENDIF
END SUBROUTINE ObtenerMax

FUNCTION Sumar (a, b) INTEGER :: Sumar;
  INTEGER , INTENT(IN) a;
  INTEGER , INTENT(IN) b;
  INTEGER :: suma;
  suma = a + b;
  Sumar = suma;
END FUNCTION Sumar

FUNCTION Promedio (a, b) REAL :: Promedio;
  INTEGER , INTENT(IN) a;
  INTEGER , INTENT(IN) b;
  REAL :: prom;
  prom = a + b;
  Promedio = prom;
END FUNCTION Promedio