package Proyecto_3;

import java.util.Scanner;

class Pila {
    private int[] stackArray;
    private int top;
    private int maxSize;

    // Constructor: Inicializa la pila con un tamaño máximo
    public Pila(int size) {
        this.maxSize = size;
        this.stackArray = new int[size];
        this.top = -1;  // Pila vacía
    }

    // Método para agregar un elemento en la cima de la pila
    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Error: La pila está llena. No se puede agregar el elemento " + value);
        } else {
            stackArray[++top] = value;
           
        }
    }

    // Método para eliminar el elemento en la cima de la pila
    public int pop() {
        if (isEmpty()) {
            System.out.println("Error: La pila está vacía. No hay elementos para eliminar.");
            return -1;  // Indicador de error
        } else {
            System.out.println("Elemento " + stackArray[top] + " eliminado de la pila.");
            return stackArray[top--];
        }
    }

    // Método para ver el elemento en la cima sin eliminarlo
    public int top() {
        if (isEmpty()) {
            System.out.println("La pila está vacía.");
            return -1;  // Indicador de error
        } else {
            System.out.println("Elemento en la cima de la pila: " + stackArray[top]);
            return stackArray[top];
        }
    }

    // Método para verificar si la pila está vacía
    public boolean isEmpty() {
        return top == -1;
    }
     // Método para mostrar todos los elementos de la pila
    public void mostrarPila() {
        if (isEmpty()) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.print("Contenido de la pila: ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }
}

// Clase de prueba para la implementación de la pila
public class Pila_con_Array {
    public static void main(String[] args) {
        // Crear una pila de tamaño 5
        Pila miPila = new Pila(5);
        Scanner scanner= new Scanner(System.in);
        // Pruebas de las operaciones push, pop y top
        System.out.println("Ingrese la cantidad de objetos a agregar:");
        int cantidadObjetos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea
        for(int i=0;i<cantidadObjetos;i++){
            System.out.println("Ingrese el entero que desea agregar a la pila");
            int entero = scanner.nextInt();
            miPila.push(entero);
            scanner.nextLine();
        }
        miPila.mostrarPila();
        miPila.top();    
        miPila.pop();    
        miPila.pop();    
        miPila.top();    
    }
}
