package Proyecto_2;

import java.util.Scanner;

public class Ejercicio4 extends Ejercicio1 {

    public static void measureTime(Runnable sortMethod, String methodName, int length) {
        long startTime = System.nanoTime();
        sortMethod.run();
        long endTime = System.nanoTime();
        System.out.println(methodName + " (" + length + " elementos): " + (endTime - startTime) + " ns");
    }

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ejecutando Ejercicio 4...");
        
        System.out.print("Ingrese el tamaño del primer array: ");
        int size1 = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el tamaño del segundo array: ");
        int size2 = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el tamaño del tercer array: ");
        int size3 = scanner.nextInt();
        scanner.nextLine();

        Integer[] array1 = Ejercicio3.generateRandomArray(size1);
        Integer[] array2 = Ejercicio3.generateRandomArray(size2);
        Integer[] array3 = Ejercicio3.generateRandomArray(size3);

        measureTime(() -> insertionSort(array1.clone()), "Inserción", size1);
        measureTime(() -> insertionSort(array2.clone()), "Inserción", size2);
        measureTime(() -> insertionSort(array3.clone()), "Inserción", size3);

        measureTime(() -> shellSort(array1.clone()), "Shellsort", size1);
        measureTime(() -> shellSort(array2.clone()), "Shellsort", size2);
        measureTime(() -> shellSort(array3.clone()), "Shellsort", size3);

        measureTime(() -> quickSort(array1.clone(), 0, array1.length - 1), "Quicksort", size1);
        measureTime(() -> quickSort(array2.clone(), 0, array2.length - 1), "Quicksort", size2);
        measureTime(() -> quickSort(array3.clone(), 0, array3.length - 1), "Quicksort", size3);  
    }
}