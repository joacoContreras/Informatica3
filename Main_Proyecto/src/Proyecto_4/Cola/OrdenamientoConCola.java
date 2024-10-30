package Cola;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class OrdenamientoConCola {
        public static void OrdenamientoCC() {
        boolean sistemaActivoOCC = true;
        Queue<Integer> cola = new LinkedList<>();
        do {
            System.out.println("Ordenamiento con Cola");
            System.out.println("---------------------");
            System.out.println("0. Salir");
            System.out.println("1. Enqueue");
            System.out.println("2. Ordenar Queue");
            Scanner consolaOCC = new Scanner(System.in);
            int opcionOCC = consolaOCC.nextInt();
            consolaOCC.nextLine();
            switch (opcionOCC) {
                case 0:
                    sistemaActivoOCC = false;
                    break;
                case 1:
                    cola.offer(Main.IngresarN());
                    break;
                case 2: 
                    System.out.println("Cola antes de ordenar:");
                    mostrarCola(cola);
                    ordenarCola(cola);
                    System.out.println("Cola después de ordenar:");
                    mostrarCola(cola);

            
                default:
                    break;
            }
        } while (sistemaActivoOCC);
    }

    // Método para ordenar una cola usando una pila auxiliar
    private static void ordenarCola(Queue<Integer> cola) {
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

    private static void mostrarCola(Queue<Integer> cola) {
        for (int elem : cola) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}

