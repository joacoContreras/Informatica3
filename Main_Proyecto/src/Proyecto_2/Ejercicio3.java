package Proyecto_2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio3 {

    public static Integer[] generateRandomArray(int tamano) {
        Random rand = new Random();
        Integer[] array = new Integer[tamano];
        for (int i = 0; i < tamano; i++) {
            array[i] = rand.nextInt(1000);
        }
        return array;
    }

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ejecutando Ejercicio 3...");
        
        System.out.print("Ingrese el tamaño del array: ");
        int tamano = scanner.nextInt();
        scanner.nextLine();
        Integer[] randomArray = generateRandomArray(tamano);

        System.out.println("Array generado aleatoriamente:");
        System.out.println(Arrays.toString(randomArray));

    }
}