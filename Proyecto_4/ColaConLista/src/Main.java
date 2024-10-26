public class Main {
    public static void main(String[] args) {
        Cola<Integer> cola = new Cola<>();

        // Probar operaciones de cola
        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);
        cola.mostrarCola();

        System.out.println("Elemento en el frente: " + cola.top());
        
        cola.dequeue();
        cola.mostrarCola();

        System.out.println("Elemento en el frente después de dequeue: " + cola.top());
        
        cola.dequeue();
        cola.dequeue();
        cola.mostrarCola();
    }
    
}

