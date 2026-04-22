PROGRAM ErrorSubrutina;
INTERFACE
  SUBROUTINE Calcular ( x )
    INTEGER , INTENT(IN) x;
  END SUBROUTINE Calcular
END INTERFACE
CALL Calcular(5);
END PROGRAM ErrorSubrutina

SUBROUTINE Calcular (x)
  INTEGER , INTENT(IN) x;
  x = x + 1;
END SUBROUTINE NombreMal