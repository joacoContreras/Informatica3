public class RepasoParcial {
    public static void main(String[] args) {
        final int N = 10;
        Pila pila = new Pila();
        for (int i = 0; i < 20; i++) {
            pila.push(i);
        }
        pila.imprimirPila();
        Cola cola = new Cola();
        cola.enqueue(15);
        cola.enqueue(10);
        eliminar(cola, pila);
        pila.imprimirPila();
        System.out.println();
        enterosImpares(N-1);
        System.out.println();
        asteriscos(N);
    }

    private static void eliminar(Cola cola, Pila pila) {
        Pila pilaTemp = new Pila();

        while (cola.isEmpty() == false) {
            int posicionEliminar = cola.dequeue();
            int index = pila.contarElementos() - 1;

            while (index != posicionEliminar && !pila.isEmpty()) {
                pilaTemp.push(pila.pop());
                index--;
            }

            if (!pila.isEmpty()) {
                System.out.println("Elemento eliminado: " + pila.pop());
            }
            else {
                System.out.println("Posicion " + posicionEliminar + " fuera de rango.");
            }
            while (!pilaTemp.isEmpty()) {
                pila.push(pilaTemp.pop());
            }
        }

    }

    private static void enterosImpares(int n){
        if (n == 0) {
            return;
        }
        else if (n % 2 == 0) {
            System.out.print(n + " ");
        }
        enterosImpares(n-1);
    }

    private static void asteriscos(int N) {
        if (N > 0) {
            System.out.print("* ");
            asteriscos(N-1);
        }
        return;
    }
}

