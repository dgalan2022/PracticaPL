PROGRAM OkExpresiones;
INTEGER :: a, b, c;
REAL :: r;
a = 1;
b = 2;
r = 3.5;
IF (a < b .AND. b > 0 .OR. .NOT. (a == b)) THEN
  c = (a + b) * 2 - 1;
ENDIF
c = c / (a + 1);
END PROGRAM OkExpresiones
