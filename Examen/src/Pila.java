class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class Pila {
    Node top;
    public Pila() {
        this.top = null;
    }

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public void Reemplazar(Pila pila, int viejo, int nuevo) {
        if (top == null) {
            System.out.println("La pila esta vacia...");
        }
        Node current = top;
        while (current != null ) {
            if (current.data == viejo) {
                current.data = nuevo;
            }
            current = current.next;
        }
    }
}
