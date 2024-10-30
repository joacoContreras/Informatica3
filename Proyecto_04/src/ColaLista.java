public class ColaLista {
    private NodoColaLista frente;  
    private NodoColaLista finalCola;  

    // Constructor
    public ColaLista() {
        this.frente = null;
        this.finalCola = null;
    }

    // Encolar un elemento en la cola
    public void enqueue(int valor) {
        NodoColaLista nuevoNodo = new NodoColaLista(valor);
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

    // Desencolar el elemento en el frente de la cola
    public void dequeue() {
        if (frente == null) {
            System.out.println("La cola está vacía.");
            return;
        }
        
        int valor = frente.valor;
        frente = frente.siguiente;

        if (frente == null) {
            finalCola = null;  // Si la cola queda vacía, actualizar finalCola a null
        }
        
        System.out.println("Elemento " + valor + " desencolado de la cola.");
    }

    // Ver el elemento en el frente sin desencolarlo
    public Integer top() {
        if (frente == null) {
            System.out.println("La cola está vacía.");
            return null;
        }
        return frente.valor;
    }

    // Verificar si la cola está vacía
    public boolean isEmpty() {
        return frente == null;
    }

    // Desencolar y Sumar todos los elementos
    public void dequeueSum() {
        if (frente == null) {
            System.out.println("La cola está vacía.");
            
        } else {
            int sum = 0;
            while (frente != null) 
            {
                sum += frente.valor;
                frente = frente.siguiente;
            }
            
            if (frente == null) 
            {
                finalCola = null;  // Si la cola queda vacía, actualizar finalCola a null
            }
            System.out.println("La sumatoria de todos los elementos de la cola es: " + sum);
        }
    }

    
}
