public class Cola<T> {
    private Nodo<T> frente;  
    private Nodo<T> finalCola;  

    public Cola() {
        this.frente = null;
        this.finalCola = null;
    }

    public void enqueue(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        if (finalCola == null) {
            // Si la cola está vacía, el nuevo nodo es el frente y el final
            frente = finalCola = nuevoNodo;
        } else {
            // Enlazar el último nodo al nuevo nodo y actualizar el final
            finalCola.siguiente = nuevoNodo;
            finalCola = nuevoNodo;
        }
        System.out.println("Elemento " + valor + " encolado en la cola.");
    }

    public T dequeue() {
        if (frente == null) {
            System.out.println("La cola está vacía.");
            return null;
        }
        
        T valor = frente.valor;
        frente = frente.siguiente;

        if (frente == null) {
            finalCola = null;  // Si la cola queda vacía, actualizar finalCola a null
        }
        
        System.out.println("Elemento " + valor + " desencolado de la cola.");
        return valor;
    }

    public T top() {
        if (frente == null) {
            System.out.println("La cola está vacía.");
            return null;
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
        
        Nodo<T> actual = frente;
        System.out.print("Elementos en la cola: ");
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}