package Proyecto_9;

import java.util.HashMap;
import java.util.Scanner;

public class HashMap_C {

    public static void main(String[] args) {
        // Crear un HashMap
        HashMap<String, MyObject> hashMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de objetos a agregar:");
        int cantidadObjetos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea
        // Ingresar elementos en el HashMap
        for (int i = 1; i <= cantidadObjetos; i++) {
            System.out.println("Ingrese el nombre del usuario" + i + ": ");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el número de telefono" + i + ": ");
            int numero = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada
            hashMap.put("telefono" + i, new MyObject(nombre, numero));
        }

        // ii. Imprimir el HashMap completo
        System.out.println("HashMap completo: " + hashMap);

        // iii. Imprimir un elemento específico
        System.out.println("Ingrese el telefono que desea ver: ");
        String key = scanner.nextLine();
        System.out.println(key + "= " + hashMap.get(key));

        // iv. Borrar un elemento
        System.out.println("Ingrese el telefono que desea eliminar: ");
        key = scanner.nextLine();
        hashMap.remove(key);
        System.out.println("HashMap después de borrar '" + key + "': " + hashMap);
    }
}