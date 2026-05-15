void main(void)
{
    int i, suma;
    suma = 0;
    if (suma == 0) {
        suma = 1;
    }
    if (i > 0) {
        suma = suma + i;
    } else {
        suma = 0;
    }
    while (suma < 10) {
        suma = suma + 1;
    }
    for (i = 1; i <= 5; i += 1) {
        suma = suma + i;
    }
    switch (suma) {
        case 1:
            suma = 100;
            break;
        default:
            suma = 0;
            break;
    }
}
