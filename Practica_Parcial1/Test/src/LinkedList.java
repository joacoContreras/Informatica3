class Nodo{
    int data;
    Nodo next;

    public Nodo(int data){
        this.data = data;
        this.next = null;
    }
}
class LinkedList {
    private Nodo head;
    public LinkedList(){
        this.head = null;
    }
    // Método para insertar un nodo al inicio de la lista
    public void insertarInicio(int data) {
        Nodo nuevoNodo = new Nodo(data);
        nuevoNodo.next = head;
        head = nuevoNodo;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Método para insertar un nodo al final de la lista
    public void insertarFinal(int data) {
        Nodo nuevoNodo = new Nodo(data);
        if (head == null) {
            head = nuevoNodo;
        } else {
            Nodo temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = nuevoNodo;
        }
    }

    // Método para eliminar el primer nodo con un valor dado
    public void eliminar(int data) {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        if (head.data == data) {
            head = head.next;  // Eliminar el primer nodo
            return;
        }

        Nodo temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Elemento no encontrado.");
        } else {
            temp.next = temp.next.next;  // Saltar el nodo que contiene el valor a eliminar
        }
    }

    // Método para imprimir todos los elementos de la lista
    public void imprimirLista() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void priorizar(int target) {
        if (isEmpty()) {
            System.out.println("La lista esta vacia");
            return;
        }
        else if (head.data == target) {
            System.out.println("El valor a buscar ya se encuntra en la primera posicion");
            imprimirLista();
            return;
        }
        Nodo current = head;
        Nodo prev = null;

        while (current.data != target && current.next != null) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("No se ha encontrado el valor ingresado");
        } else {
            if (prev != null) {
                prev.next = current.next;
                current.next = head;
                head = current;
            }
            System.out.println("El valor se ha movido a la primera posicion:");
            imprimirLista();
        }

    }
}
