package Proyecto_9;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<MyObject> arrayList = new ArrayList<>();

        System.out.println("Ingrese la cantidad de objetos a agregar:");
        int cantidadObjetos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea

        // Ingresar los datos del usuario
        for (int i = 0; i < cantidadObjetos; i++) {
            System.out.println("Ingrese el nombre del objeto " + (i + 1) + ": ");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el precio del objeto " + (i + 1) + ": ");
            int precio = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            arrayList.add(new MyObject(nombre, precio));
        }

        // Imprimir la ArrayList completa
        System.out.println("ArrayList completa: " + arrayList);

        // Imprimir un elemento específico
        System.out.println("Ingrese el indice del elemento que desea ver:");
        int objeto = scanner.nextInt();
        System.out.println("Elemento en ese indice es: " + arrayList.get(objeto));

        // Borrar un elemento en el índice 1
        System.out.println("Ingrese el indice del elemento a eliminar:");
        int eliminar = scanner.nextInt();
        arrayList.remove(eliminar);
        System.out.println("ArrayList después de borrar el elemento en el indice queda: " + arrayList);
        
        // Imprimir la ArrayList completa
        System.out.println("ArrayList completa: " + arrayList);
    }
}