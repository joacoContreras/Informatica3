package Proyecto_9;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class linkedhashmap_E {
    public static void main(String[] args) {
        // Crear un LinkedHashMap
        LinkedHashMap<String, MyObject> linkedHashMap = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de objetos a agregar:");
        int cantidadObjetos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea
        // Solicitar datos al usuario
        for (int i = 1; i <= cantidadObjetos; i++) {
            System.out.print("Ingresa la clave para el objeto " + i + ": ");
            String key = scanner.nextLine();

            System.out.print("Ingresa el nombre para el objeto " + i + ": ");
            String name = scanner.nextLine();

            System.out.print("Ingresa el valor para el objeto " + i + ": ");
            int value = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            // Agregar el objeto al LinkedHashMap
            linkedHashMap.put(key, new MyObject(name, value));
        }

        // Imprimir la LinkedHashMap completa
        System.out.println("LinkedHashMap completa: " + linkedHashMap);

        // Imprimir un elemento específico
        System.out.print("Ingresa la clave del elemento que quieres ver: ");
        String searchKey = scanner.nextLine();
        System.out.println("Elemento con clave '" + searchKey + "': " + linkedHashMap.get(searchKey));

        // Borrar un elemento
        System.out.print("Ingresa la clave del elemento que quieres borrar: ");
        String removeKey = scanner.nextLine();
        linkedHashMap.remove(removeKey);
        System.out.println("LinkedHashMap después de borrar '" + removeKey + "': " + linkedHashMap);

        
    }
}