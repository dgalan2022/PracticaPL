PROGRAM OkSubprogramas;
INTEGER :: resultado;
INTERFACE
  FUNCTION Doble ( n ) INTEGER :: Doble;
    INTEGER , INTENT(IN) n;
  END FUNCTION Doble
  SUBROUTINE Resetear ( v )
    INTEGER , INTENT(OUT) v;
  END SUBROUTINE Resetear
  SUBROUTINE Incrementar ( v )
    INTEGER , INTENT(INOUT) v;
  END SUBROUTINE Incrementar
  SUBROUTINE Vacio
  END SUBROUTINE Vacio
END INTERFACE
resultado = Doble(4);
CALL Resetear(resultado);
CALL Incrementar(resultado);
CALL Vacio;
END PROGRAM OkSubprogramas

FUNCTION Doble (n) INTEGER :: Doble;
  INTEGER , INTENT(IN) n;
  INTEGER :: aux;
  aux = n * 2;
  Doble = aux;
END FUNCTION Doble

SUBROUTINE Resetear (v)
  INTEGER , INTENT(OUT) v;
  v = 0;
END SUBROUTINE Resetear

SUBROUTINE Incrementar (v)
  INTEGER , INTENT(INOUT) v;
  v = v + 1;
END SUBROUTINE Incrementar

SUBROUTINE Vacio
INTEGER :: x;
x = 0;
END SUBROUTINE Vacio
