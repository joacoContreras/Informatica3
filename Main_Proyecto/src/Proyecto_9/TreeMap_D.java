package Proyecto_9;

import java.util.Scanner;
import java.util.TreeMap;
public class TreeMap_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, MyObject> treeMap = new TreeMap<>();
        
        System.out.println("Ingrese la cantidad de objetos a agregar:");
        int cantidadObjetos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea
        // Ingresar datos del usuario
        for (int i = 1; i <= cantidadObjetos; i++) {
            System.out.print("Ingrese el modelo del vehículo " + i + ": ");
            String modelo = scanner.nextLine();
            System.out.print("Ingrese el precio del vehículo " + i + ": ");
            int precio = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            treeMap.put("vehiculo"+i, new MyObject(modelo, precio));
        }

        System.out.println("TreeMap completo: " + treeMap);

        // Obtener y mostrar un vehículo específico
        System.out.print("Ingrese el nombre del vehículo a buscar: ");
        String vehiculoBuscar = scanner.nextLine();
        System.out.println("Vehículo " + vehiculoBuscar + ": " + treeMap.get(vehiculoBuscar));

        // Eliminar un vehículo
        System.out.print("Ingrese el nombre del vehículo a eliminar: ");
        String vehiculoEliminar = scanner.nextLine();
        treeMap.remove(vehiculoEliminar);

        System.out.println("TreeMap después de borrar el vehículo " + vehiculoEliminar + ": " + treeMap);

        scanner.close();
    }
}
