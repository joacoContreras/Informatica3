import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class App {
    public static void main(String[] args) {
        Queue<Integer> cola = new LinkedList<>();
        
        // Agregar elementos a la cola
        cola.offer(4);
        cola.offer(2);
        cola.offer(8);
        cola.offer(5);
        cola.offer(1);
        
        System.out.println("Cola antes de ordenar:");
        mostrarCola(cola);

        // Ordenar la cola
        ordenarCola(cola);

        System.out.println("Cola después de ordenar:");
        mostrarCola(cola);
    }
    
    // Método para ordenar una cola usando una pila auxiliar
    public static void ordenarCola(Queue<Integer> cola) {
        Stack<Integer> pila = new Stack<>();
        
        // Desencolar todos los elementos de la cola y almacenarlos en la pila
        while (!cola.isEmpty()) {
            int temp = cola.poll();
            
            // Colocar en orden ascendente usando la pila
            while (!pila.isEmpty() && pila.peek() > temp) {
                cola.offer(pila.pop());
            }
            
            pila.push(temp);
        }
        
        while (!pila.isEmpty()) {
            cola.offer(pila.pop());
        }
    }

    public static void mostrarCola(Queue<Integer> cola) {
        for (int elem : cola) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

}
