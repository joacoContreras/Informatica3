// Nodo de la lista enlazada
class NodoCola {
    int data;
    NodoCola next;

    // Constructor del nodo
    public NodoCola(int data) {
        this.data = data;
        this.next = null;
    }
}

// Implementación de Cola con lista enlazada
class Cola {
    private NodoCola front, rear; // front: frente de la cola, rear: final de la cola

    // Constructor inicializa la cola vacía
    public Cola() {
        front = rear = null;
    }

    // Método para insertar (enqueue) un elemento en la cola
    public void enqueue(int value) {
        NodoCola nuevoNodo = new NodoCola(value);

        // Si la cola está vacía, tanto front como rear apuntan al nuevo nodo
        if (isEmpty()) {
            front = rear = nuevoNodo;
            System.out.println(value + " ha sido insertado en la cola.");
            return;
        }

        // Añadir el nuevo nodo al final y mover rear al nuevo nodo
        rear.next = nuevoNodo;
        rear = nuevoNodo;
        System.out.println(value + " ha sido insertado en la cola.");
    }

    // Método para eliminar (dequeue) el elemento del frente de la cola
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return -1;
        }
        int valorEliminado = front.data; // Guardar el valor del nodo frente
        front = front.next; // Mover front al siguiente nodo

        // Si front llega a null, significa que la cola está vacía
        if (front == null) {
            rear = null;
        }
        System.out.println(valorEliminado + " ha sido eliminado de la cola.");
        return valorEliminado;
    }

    // Método para consultar el valor en el frente sin eliminarlo
    public int peek() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return -1;
        }
        return front.data;
    }

    // Método para verificar si la cola está vacía
    public boolean isEmpty() {
        return front == null;
    }

    // Método para imprimir la cola
    public void imprimirCola() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return;
        }
        NodoCola actual = front;
        System.out.println("Elementos en la cola:");
        while (actual != null) {
            System.out.print(actual.data + " ");
            actual = actual.next;
        }
        System.out.println();
    }
}
