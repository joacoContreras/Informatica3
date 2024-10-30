package Proyecto_9;
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú de estructuras de datos");
            System.out.println("1. ArrayList");
            System.out.println("2. LinkedList");
            System.out.println("3. HashMap");
            System.out.println("4. TreeMap");
            System.out.println("5. LinkedHashMap");
            System.out.println("6. Salir");

            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarInformacionArrayList();
                    break;
                case 2:
                    mostrarInformacionLinkedList();
                    break;
                case 3:
                    mostrarInformacionHashMap();
                    break;
                case 4:
                    mostrarInformacionTreeMap();
                    break;
                case 5:
                    mostrarInformacionLinkedHashMap();
                    break;
                case 6:
                    System.out.println("Adiós!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, inténtelo de nuevo.");
            }
        } while (opcion != 6);
    }

    private static void mostrarInformacionArrayList() {
        System.out.println("ArrayList");
        System.out.println("Ventajas:");
        System.out.println("  - Acceso aleatorio rápido a elementos por índice (tiempo de acceso constante)");
        System.out.println("Desventajas:");
        System.out.println("  - Inserciones y eliminaciones en posiciones intermedias pueden ser lentas, ya que requieren el desplazamiento de elementos");
        System.out.println("Uso recomendado:");
        System.out.println("  - Ideal cuando se necesita un acceso rápido a elementos por índice y no se planea realizar muchas inserciones o eliminaciones");
    }

    private static void mostrarInformacionLinkedList() {
        System.out.println("LinkedList");
        System.out.println("Ventajas:");
        System.out.println("  - Eficiente en inserciones y eliminaciones al inicio o final, ya que solo requiere cambiar referencias de nodos");
        System.out.println("Desventajas:");
        System.out.println("  - Acceso a elementos específicos puede ser lento debido a la necesidad de recorrer la lista hasta el elemento deseado");
        System.out.println("Uso recomendado:");
        System.out.println("  - Útil cuando se realizan muchas inserciones y eliminaciones en ambos extremos de la lista y no se necesita un acceso rápido por índice");
    }

    private static void mostrarInformacionHashMap() {
        System.out.println("HashMap");
        System.out.println("Ventajas:");
        System.out.println("  - Búsqueda y actualizaciones rápidas (tiempo constante promedio) gracias a su estructura hash");
        System.out.println("Desventajas:");
        System.out.println("  - No mantiene un orden de los elementos");
        System.out.println("Uso recomendado:");
        System.out.println("  - Excelente para almacenar pares clave-valor cuando el orden de los elementos no es importante y se necesita acceso rápido");
    }

    private static void mostrarInformacionTreeMap() {
        System.out.println("TreeMap");
        System.out.println("Ventajas:");
        System.out.println("  - Mantiene el orden de los elementos según la clave y permite operaciones de rango eficiente");
        System.out.println("Desventajas:");
        System.out.println("  - Ligeramente más lento que HashMap debido al mantenimiento del orden");
        System.out.println("Uso recomendado:");
        System.out.println("  - Útil cuando es importante tener los elementos ordenados y realizar operaciones de rango en las claves");
    }

    private static void mostrarInformacionLinkedHashMap() {
        System.out.println("LinkedHashMap");
        System.out.println("Ventajas:");
        System.out.println("  - Proporciona acceso rápido similar a HashMap y mantiene el orden de inserción");
        System.out.println("Desventajas:");
        System.out.println("  - Consume ligeramente más memoria para mantener el orden de inserción");
        System.out.println("Uso recomendado:");
        System.out.println("  - Ideal para aplicaciones donde es importante mantener el orden de los elementos, como en cachés que dependen del orden de uso o de inserción");
    }
}