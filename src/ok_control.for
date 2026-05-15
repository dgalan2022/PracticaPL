PROGRAM OkControl;
INTEGER :: i, suma;
suma = 0;
IF (suma == 0) suma = 1;
IF (i > 0) THEN
  suma = suma + i;
ELSE
  suma = 0;
ENDIF
DO WHILE (suma < 10)
  suma = suma + 1;
ENDDO
DO i = 1, 5, 1
  suma = suma + i;
ENDDO
SELECT CASE (suma)
  CASE (1)
    suma = 100;
  CASE DEFAULT
    suma = 0;
END SELECT
END PROGRAM OkControl
