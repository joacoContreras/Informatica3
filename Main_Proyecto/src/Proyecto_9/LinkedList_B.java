package Proyecto_9;

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedList_B {
    public static void main(String[] args) {
        // Crear una LinkedList
        LinkedList<MyObject> linkedList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario el número de elementos a agregar
        System.out.print("Ingrese la cantidad de elementos que desea agregar: ");
        int numElements = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea

        // i. Agregar objetos ingresados por el usuario
        for (int i = 0; i < numElements; i++) {
            System.out.print("Ingrese el nombre del barrio: ");
            String name = scanner.nextLine();
            System.out.print("Ingrese la direccion(numerica): ");
            int value = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea
            linkedList.add(new MyObject(name, value));
        }

        // ii. Imprimir la LinkedList completa
        System.out.println("LinkedList completa: " + linkedList);

        // iii. Imprimir un elemento específico
        System.out.println("Ingrese el indice del elemento que desea ver:");
        int imprimir = scanner.nextInt();
        if (!linkedList.isEmpty()) {
            System.out.println("Elemento en ese indice es: " + linkedList.get(imprimir));
        } else {
            System.out.println("La LinkedList está vacía.");
        }

        // iv. Borrar un elemento si existen al menos 3 elementos
        System.out.println("Ingrese el indice del elemento que desea eliminar:");
        int cantidadObjetos = scanner.nextInt();
            linkedList.remove(2);
            System.out.println("LinkedList después de borrar el elemento en índice 2: " + linkedList);
        
    }
}
