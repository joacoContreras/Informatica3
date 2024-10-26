public class Cola {
    private Nodo frente;  
    private Nodo finalCola;  

    public Cola() {
        this.frente = null;
        this.finalCola = null;
    }

    public void enqueue(Integer valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (finalCola == null) {
            // Si la cola está vacía, el nuevo nodo es el frente y el final
            frente = finalCola = nuevoNodo;
        } else {
            // Enlazar el último nodo al nuevo nodo y actualizar el final
            finalCola.siguiente = nuevoNodo;
            finalCola = nuevoNodo;
        }
        System.out.println("Elemento " + valor + " encolado.");
    }

    public int dequeue() {
        if (frente == null) {
            System.out.println("La cola está vacía.");
            return 0;
        }
        int sum = 0;
        while (frente != null) {
            sum += frente.valor;
            frente = frente.siguiente;
        }
        

        if (frente == null) {
            finalCola = null;  // Si la cola queda vacía, actualizar finalCola a null
        }
        return sum;
    }

    public int top() {
        if (frente == null) {
            System.out.println("La cola está vacía.");
            return 0;
        }
        return frente.valor;
    }

    public boolean isEmpty() {
        return frente == null;
    }

    public void mostrarCola() {
        if (frente == null) {
            System.out.println("La cola está vacía.");
            return;
        }
        
        Nodo actual = frente;
        System.out.print("Elementos en la cola: ");
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}