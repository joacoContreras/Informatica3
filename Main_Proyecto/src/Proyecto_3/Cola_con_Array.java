package Proyecto_3;
import java.util.Scanner;

// Clase Cola
class Cola {
    private int[] array;        // Arreglo que almacena los elementos de la cola
    private int front;          // Índice del elemento al frente de la cola
    private int back;           // Índice del último elemento de la cola
    private int currentSize;     // Tamaño actual de la cola
    private int capacidad;       // Capacidad máxima de la cola

    // Constructor que inicializa la cola con una capacidad dada
    public Cola(int capacidad) {
        this.capacidad = capacidad;
        array = new int[capacidad];
        front = 0;
        back = -1;
        currentSize = 0;
    }

    // Método para verificar si la cola está vacía
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Método para agregar un elemento al final de la cola
    public void enqueue(int x) {
        if (currentSize == capacidad) {
            System.out.println("La cola está llena. No se puede agregar el elemento.");
            return;
        }
        // Incrementar el índice de back y agregar el elemento
        back++;
        array[back] = x;
        currentSize++;
    }

    // Método para eliminar el elemento al frente de la cola
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("La cola está vacía. No se puede eliminar ningún elemento.");
            return -1; // Retornar -1 o un valor de error si la cola está vacía
        }
        // Almacenar el elemento en el frente y luego incrementar el índice de front
        int elementoFrente = array[front];
        front++;
        currentSize--;
        return elementoFrente;
    }

    // Método para ver el elemento al frente sin eliminarlo
    public int top() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return -1;
        }
        return array[front];
    }
     // Método para mostrar todos los elementos de la cola sin modificarlos
    public void mostrarCola() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return;
        }
        System.out.print("Elementos en la cola: ");
        for (int i = front; i <= back; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}


// Clase principal para probar la cola
public class Cola_con_Array {
    public static void main(String[] args) {
        // Crear una cola con capacidad de 5 elementos
        Cola cola = new Cola(5);
        Scanner scanner= new Scanner(System.in);
        
        for(int i=0;i<5;i++){
        System.out.println("ingrese valor del nodo:");
        int insertar= scanner.nextInt();
        cola.enqueue(insertar);
        }

        cola.mostrarCola();
        // Ver el elemento en el frente usando top
        System.out.println("Elemento en el frente: " + cola.top()); // Debería ser 10

        // Probar el método dequeue
        System.out.println("Elemento eliminado: " + cola.dequeue()); // Debería ser 10
        System.out.println("Elemento eliminado: " + cola.dequeue()); // Debería ser 20
        cola.mostrarCola();
        // Ver el elemento en el frente después de varias eliminaciones
        System.out.println("Elemento en el frente: " + cola.top()); // Debería ser 30

       
    }
}

