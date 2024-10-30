package Proyecto_3;

import java.util.Scanner;

// Clase Pila
class Pila2 {
    private char[] elementos;
    private int tope;

    // Constructor que define el tamaño de la pila
    public Pila2(int capacidad) {
        elementos = new char[capacidad];
        tope = -1;
    }

    // Método para agregar un elemento a la pila
    public void push2(char c) {
        if (tope < elementos.length - 1) {
            elementos[++tope] = c;
        } else {
            System.out.println("Pila llena, no se puede agregar más elementos");
        }
    }

    // Método para retirar el último elemento agregado de la pila
    public char pop2() {
        if (isEmpty2()) {
            System.out.println("Pila vacía, no se puede eliminar ningún elemento");
            return '\0'; // Caracter nulo en caso de error
        }
        return elementos[tope--];
    }

    // Método para verificar si la pila está vacía
    public boolean isEmpty2() {
        return tope == -1;
    }
}

// Clase Principal para verificar el balanceo de paréntesis
public class Equilibrado {

    // Método para verificar si una expresión está equilibrada
    public static boolean verificarBalanceo(String expresion) {
        // Crear la pila con un tamaño igual a la longitud de la expresión
        Pila2 pila = new Pila2(expresion.length());

        // Recorrer cada carácter de la expresión
        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);

            // Si el carácter es un paréntesis de apertura, lo añadimos a la pila
            if (caracter == '(') {
                pila.push2(caracter);
            }
            // Si es un paréntesis de cierre, verificamos que haya una apertura correspondiente
            else if (caracter == ')') {
                if (pila.isEmpty2()) {
                    return false; // No hay apertura para este cierre
                }
                pila.pop2(); // Quita el paréntesis de apertura correspondiente de la pila
            }
        }

        // Al final, la pila debe estar vacía si todos los paréntesis están balanceados
        return pila.isEmpty2();
    }

    // Método principal para probar el balanceo de paréntesis
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de expresiones que desea ingresar:");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea
        for(int i=0;i<cantidad;i++){
            System.out.println("Ingrese la expresión para verificar si está equilibrada:");
            String expresion = scanner.nextLine();
            System.out.println("¿La expresión 1 está equilibrada? " + verificarBalanceo(expresion));
        }
      
    }
}
