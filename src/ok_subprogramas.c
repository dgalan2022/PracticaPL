int Doble(int n);
void Resetear(int *v);
void Incrementar(int *v);
void Vacio(void);

int Doble(int n)
{
    int aux;
    aux = n * 2;
    return aux;
}

void Resetear(int *v)
{
    *v = 0;
}

void Incrementar(int *v)
{
    *v = (*v) + 1;
}

void Vacio(void)
{
    int x;
    x = 0;
}

void main(void)
{
    int resultado;
    resultado = Doble(4);
    Resetear(&resultado);
    Incrementar(&resultado);
    Vacio();
}
