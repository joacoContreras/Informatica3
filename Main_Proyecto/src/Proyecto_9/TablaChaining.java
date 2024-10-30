package Proyecto_9;

import java.util.LinkedList;
import java.util.Scanner;

public class TablaChaining {
    private LinkedList<Integer>[] tabla;
    private int size;

    // Constructor: inicializa la tabla con un tamaño específico
    public TablaChaining(int size) {
        this.size = size;
        tabla = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    // Función hash simple
    private int funcionHash(int clave) {
        return clave % size;
    }

    // Insertar una clave en la tabla hash
    public void insertar(int clave) {
        int indice = funcionHash(clave);
        tabla[indice].add(clave);
        System.out.println("Elemento " + clave + " insertado.");
    }

    // Eliminar una clave de la tabla hash
    public boolean eliminar(int clave) {
        int indice = funcionHash(clave);
        LinkedList<Integer> lista = tabla[indice];
        boolean eliminado = lista.remove(Integer.valueOf(clave));
        if (eliminado) {
            System.out.println("Elemento " + clave + " eliminado.");
        } else {
            System.out.println("Elemento " + clave + " no encontrado.");
        }
        return eliminado;
    }

    // Buscar una clave en la tabla hash
    public boolean buscar(int clave) {
        int indice = funcionHash(clave);
        LinkedList<Integer> lista = tabla[indice];
        boolean encontrado = lista.contains(clave);
        if (encontrado) {
            System.out.println("Elemento " + clave + " encontrado.");
        } else {
            System.out.println("Elemento " + clave + " no encontrado.");
        }
        return encontrado;
    }

    // Mostrar la tabla hash
    public void mostrarTabla() {
        System.out.println("Contenido de la tabla hash:");
        for (int i = 0; i < size; i++) {
            System.out.println("Índice " + i + ": " + tabla[i]);
        }
    }

    // Método para solicitar un entero de entrada
    private static int solicitarEntero(Scanner scanner) {
        System.out.print("Ingrese un número entero: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada no válida. Intente nuevamente.");
            scanner.next();  // Limpiar entrada no válida
        }
        return scanner.nextInt();
    }

    public static void main() {
        Scanner consola = new Scanner(System.in);
        System.out.print("Ingresar tamaño de la tabla hash: ");
        int size = solicitarEntero(consola);

        TablaChaining tablaHashChaining = new TablaChaining(size);
        boolean hashActivo = true;

        do {
            System.out.println("\n--- Menú Tabla Hash con Chaining ---");
            System.out.println("0. Salir");
            System.out.println("1. Inserción");
            System.out.println("2. Búsqueda");
            System.out.println("3. Eliminación");
            System.out.println("4. Mostrar Tabla");
            System.out.print("Elige una opción: ");
            int opcion = consola.nextInt();

            switch (opcion) {
                case 0:
                    hashActivo = false;
                    break;
                case 1:
                    System.out.print("Ingrese elemento a insertar: ");
                    int elementoInsertar = solicitarEntero(consola);
                    tablaHashChaining.insertar(elementoInsertar);
                    break;
                case 2:
                    System.out.print("Ingrese clave a buscar: ");
                    int claveBuscar = solicitarEntero(consola);
                    tablaHashChaining.buscar(claveBuscar);
                    break;
                case 3:
                    System.out.print("Ingrese clave de elemento a eliminar: ");
                    int claveEliminar = solicitarEntero(consola);
                    tablaHashChaining.eliminar(claveEliminar);
                    break;
                case 4:
                    tablaHashChaining.mostrarTabla();
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (hashActivo);

    }
}
