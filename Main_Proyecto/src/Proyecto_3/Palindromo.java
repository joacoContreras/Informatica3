package Proyecto_3;

import java.util.Scanner;

class Pila1 {
    private char[] stackArray;
    private int top;
    private int maxSize;

    // Constructor: Inicializa la pila con un tamaño máximo
    public Pila1(int size) {
        this.maxSize = size;
        this.stackArray = new char[size];
        this.top = -1; // Pila vacía
    }

    // Método para agregar un elemento en la cima de la pila
    public void push1(char value) {
        if (top == maxSize - 1) {
            System.out.println("Error: La pila está llena. No se puede agregar el elemento " + value);
        } else {
            stackArray[++top] = value;
        }
    }

    // Método para eliminar el elemento en la cima de la pila
    public char pop1() {
        if (isEmpty1()) {
            System.out.println("Error: La pila está vacía. No hay elementos para eliminar.");
            return '\0'; // Indicador de error
        } else {
            return stackArray[top--];
        }
    }

    // Método para verificar si la pila está vacía
    public boolean isEmpty1() {
        return top == -1;
    }
}

public class Palindromo{

    public static boolean esPalindromo(String str) {
        // Paso 1: Preparar la cadena
        str = str.replaceAll("\\s+", "").toLowerCase();
        int length = str.length();
        
        // Crear una pila con la mitad del tamaño de la cadena
        Pila1 pila = new Pila1(length / 2);

        // Paso 2: Llenar la pila con la primera mitad de la cadena
        for (int i = 0; i < length / 2; i++) {
            pila.push1(str.charAt(i));
        }

        // Paso 3: Comenzar a comparar la segunda mitad de la cadena
        for (int i = (length % 2 == 0) ? length / 2 : length / 2 + 1; i < length; i++) {
            char topChar = pila.pop1();
            if (topChar != str.charAt(i)) {
                return false; // No es un palíndromo
            }
        }

        return true; // Es un palíndromo
    }

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de expresiones que desea ingresar:");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea
        for(int i=0;i<cantidad;i++){
            System.out.println("Ingrese la expresión para verificar si está equilibrada:");
            String expresion = scanner.nextLine();
            System.out.println("¿Es '" + expresion + "' un palíndromo? " + esPalindromo(expresion));
        }
      
    }
}
