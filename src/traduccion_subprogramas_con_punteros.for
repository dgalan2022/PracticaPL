PROGRAM TraduccionSubprogramas;
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
END INTERFACE
resultado = Doble(4);
CALL Resetear(resultado);
CALL Incrementar(resultado);
END PROGRAM TraduccionSubprogramas

FUNCTION Doble (n) INTEGER :: Doble;
  INTEGER , INTENT(IN) n;
  Doble = n * 2;
END FUNCTION Doble

SUBROUTINE Resetear (v)
  INTEGER , INTENT(OUT) v;
  v = 0;
END SUBROUTINE Resetear

SUBROUTINE Incrementar (v)
  INTEGER , INTENT(INOUT) v;
  v = v + 1;
END SUBROUTINE Incrementar