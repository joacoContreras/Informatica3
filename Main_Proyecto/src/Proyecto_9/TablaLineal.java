package Proyecto_9;

import java.util.Scanner;

class TablaLineal {
    private int[] tabla;
    private int size;

    // Constructor: inicializa la tabla con un tamaño específico
    public TablaLineal(int size) {
        this.size = size;
        this.tabla = new int[size];
        // Inicializar todas las posiciones como -1, para indicar que están vacías
        for (int i = 0; i < size; i++) {
            tabla[i] = -1;
        }
    }

    // Función hash simple (hash = clave % tamañoTabla)
    private int funcionHash(int clave) {
        return clave % size;
    }

    // Insertar una clave en la tabla hash
    public void insertar(int clave) {
        int indice = funcionHash(clave);

        // Exploración lineal para encontrar una posición vacía
        while (tabla[indice] != -1) {  // Mientras la posición esté ocupada
            indice = (indice + 1) % size;  // Mover al siguiente índice (ciclo circular)
        }

        // Insertar la clave en la posición vacía encontrada
        tabla[indice] = clave;
        System.out.println("Elemento " + clave + " insertado.");
    }

    // Eliminar una clave de la tabla hash
    public void eliminar(int clave) {
        int indice = funcionHash(clave);
        boolean encontrado = false;

        // Exploración lineal para buscar la clave
        for (int i = 0; i < size; i++) {
            int pos = (indice + i) % size;
            if (tabla[pos] == clave) {
                tabla[pos] = -1;  // Marcar como vacía
                encontrado = true;
                System.out.println("Elemento " + clave + " eliminado.");
                break;
            } else if (tabla[pos] == -1) {
                // Si encuentra un espacio vacío antes de la clave, no está en la tabla
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Elemento " + clave + " no encontrado en la tabla.");
        }
    }

    // Mostrar la tabla hash
    public void mostrarTabla() {
        System.out.println("Contenido de la tabla hash:");
        for (int i = 0; i < size; i++) {
            System.out.println("Índice " + i + ": " + tabla[i]);
        }
    }

    public static void main() {
        Scanner consola = new Scanner(System.in);

        System.out.print("Ingrese el tamaño de la tabla hash: ");
        int size = consola.nextInt();
        TablaLineal tablaHash = new TablaLineal(size);

        boolean activo = true;
        while (activo) {
            System.out.println("\n--- Menú Tabla Hash con Exploración Lineal ---");
            System.out.println("1. Insertar clave");
            System.out.println("2. Mostrar tabla");
            System.out.println("3. Eliminar clave");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = consola.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la clave a insertar: ");
                    int claveInsertar = consola.nextInt();
                    tablaHash.insertar(claveInsertar);
                    break;
                case 2:
                    tablaHash.mostrarTabla();
                    break;
                case 3:
                    System.out.print("Ingrese la clave a eliminar: ");
                    int claveEliminar = consola.nextInt();
                    tablaHash.eliminar(claveEliminar);
                    break;
                case 0:
                    activo = false;
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
