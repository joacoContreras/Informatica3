package Proyecto_2;

import java.util.Scanner;

public class Ejercicio2 {

    public static <AnyType> void mostrarArray(AnyType[] array) {
        for (AnyType element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ejecutando Ejercicio 2...");

        System.out.print("Ingrese el tamaño del array de enteros: ");
        int intSize = scanner.nextInt();
        scanner.nextLine();

        Integer[] intArray = new Integer[intSize];
        System.out.println("Ingrese los elementos del array de enteros:");
        for (int i = 0; i < intSize; i++) {
            intArray[i] = scanner.nextInt();
        }
        System.out.println("Array de enteros:");
        mostrarArray(intArray);

        System.out.print("Ingrese el tamaño del array de doubles: ");
        int doubleSize = scanner.nextInt();
        scanner.nextLine();

        Double[] doubleArray = new Double[doubleSize];
        System.out.println("Ingrese los elementos del array de doubles:");
        for (int i = 0; i < doubleSize; i++) {
            doubleArray[i] = scanner.nextDouble();
        }
        System.out.println("Array de doubles:");
        mostrarArray(doubleArray);

        System.out.print("Ingrese el tamaño del array de strings: ");
        int stringSize = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer
        String[] stringArray = new String[stringSize];
        System.out.println("Ingrese los elementos del array de strings:");
        for (int i = 0; i < stringSize; i++) {
            stringArray[i] = scanner.nextLine();
        }
        System.out.println("Array de strings:");
        mostrarArray(stringArray);
        
    }
}