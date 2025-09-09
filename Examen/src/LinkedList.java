class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class LinkedList {

    Node head;
    public LinkedList() {
        this.head = null;
    }

    public void push(int data){
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            System.out.println("Valor agregado con exito...");
        }
        else{
            Node current = head;
            while(current != null) {
                current = current.next;
            }
            current = newNode;
            System.out.println("Valor agregado con exito...");
        }
    }

    public Node searchList(int espData, Node current){
        if (current == null) {
            return null;
        }

        if (current.data == espData) {
                return current;
            }

        return searchList(espData, current.next);
    }
}
