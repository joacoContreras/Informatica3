package Proyecto_3;
import java.util.Scanner;

// Clase Cola1
class Cola1 {
    private int[] array;        // Arreglo que almacena los elementos de la cola
    private int front;          // Índice del primer elemento de la cola
    private int back;           // Índice del último elemento de la cola
    private int currentSize;    // Tamaño actual de la cola
    private int capacidad;      // Capacidad máxima de la cola

    // Constructor que inicializa la cola con una capacidad dada
    public Cola1(int capacidad) {
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

    // Método para verificar si la cola está llena
    public boolean isFull() {
        return currentSize == capacidad;
    }

    // Método para agregar un elemento al final de la cola
    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("La cola está llena. No se puede agregar el elemento.");
            return;
        }
        back++; // Incrementar back de forma lineal
        array[back] = x;
        currentSize++;
    }

    // Método para eliminar el elemento al frente de la cola
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("La cola está vacía. No se puede eliminar ningún elemento.");
            return -1; // Retornar -1 o un valor de error si la cola está vacía
        }
        int elementoFrente = array[front];
        front++; // Incrementar front de forma lineal
        currentSize--;
        // Si todos los elementos han sido eliminados, reiniciar front y back
        if (isEmpty()) {
            front = 0;
            back = -1;
        }
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

    // Método para transferir elementos a otra cola
    public void transferir(Cola1 otraCola) {
        while (!this.isEmpty()) {
            int elemento = this.dequeue();
            otraCola.enqueue(elemento);
        }
    }

    // Método Shellsort para ordenar el arreglo auxiliar
    public void shellsort() {
        int n = currentSize;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = array[front + i]; // Elemento a insertar
                int j;
                for (j = i; j >= gap && array[front + j - gap] > temp; j -= gap) {
                    array[front + j] = array[front + j - gap];
                }
                array[front + j] = temp;
            }
        }
    }
}

// Clase principal para probar la cola
public class Cola_Ordenada {
    public static void main(String[] args) {
        // Crear una cola con capacidad de 5 elementos
        Cola1 colaOriginal = new Cola1(5);
        Cola1 colaAuxiliar = new Cola1(5);
        
         Scanner scanner= new Scanner(System.in);
        
        for(int i=0;i<5;i++){
        System.out.println("ingrese valor del nodo:");
        int insertar= scanner.nextInt();
        colaOriginal.enqueue(insertar);
        }

        System.out.println("Cola Original:");
        colaOriginal.mostrarCola(); // Mostrar la cola original

        // Transferir elementos de la cola original a la cola auxiliar
        colaOriginal.transferir(colaAuxiliar);

        // Ordenar la cola auxiliar
        colaAuxiliar.shellsort();


        // Transferir de la cola auxiliar de nuevo a la cola original
        colaAuxiliar.transferir(colaOriginal);

        System.out.println("Cola Original después de ordenar los datos de forma ascendente:");
        colaOriginal.mostrarCola(); // Mostrar la cola original nuevamente
    }
}

