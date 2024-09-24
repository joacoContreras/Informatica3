class Nodo{
    int data;
    Nodo next;

    public Nodo(int data){
        this.data = data;
        this.next = null;
    }
}
class Pila {
    private Nodo top;

    public Pila() {
        top = null;
    }

    public void push(int value) {
        Nodo nuevoNodo = new Nodo(value);
        nuevoNodo.next = top;
        top = nuevoNodo;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("La pila esta vacia");
            return -1;
        }
        int valorEliminado = top.data;
        top = top.next;
        return valorEliminado;
    }
    public boolean isEmpty() {
        return top == null;
    }

    public void imprimirPila() {
        if (isEmpty()) {
            System.out.println("La pila esta vacia.");
            return;
        }
        System.out.println("Elementos de la pila:");
        Nodo temp = top;
        System.out.println("top -> ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
            
        }
        System.out.println("NULL");
    }

    public int contarElementos() {
        int contador = 0;
        if (isEmpty()) {
            System.out.println("Pila vacia");
            return contador;
        }
        Nodo temp = top;
        while (temp != null) {
            contador++;
            temp = temp.next;
        }
        return contador;
    }
}
