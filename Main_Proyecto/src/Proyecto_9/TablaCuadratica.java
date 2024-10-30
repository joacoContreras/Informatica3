package Proyecto_9;

import java.util.Scanner;

class TablaHashCuadratica {
    private int[] tabla;
    private int size;

    public TablaHashCuadratica(int size) {
        this.size = size;
        this.tabla = new int[size];
        for (int i = 0; i < size; i++) {
            tabla[i] = -1; // Indicador de posiciones vacías
        }
    }

    private int funcionHash(int clave) {
        return clave % size;
    }

    public void insertar(int clave) {
        int indice = funcionHash(clave);
        int i = 0;
        while (tabla[(indice + i * i) % size] != -1) {  // Exploración cuadrática
            i++;
        }
        tabla[(indice + i * i) % size] = clave;
        System.out.println("Elemento " + clave + " insertado.");
    }

    public void eliminar(int clave) {
        int indice = funcionHash(clave);
        int i = 0;
        boolean encontrado = false;

        // Exploración cuadrática para encontrar el elemento a eliminar
        while (tabla[(indice + i * i) % size] != -1) {
            int posicion = (indice + i * i) % size;
            if (tabla[posicion] == clave) {
                tabla[posicion] = -1;  // Marcar la posición como vacía
                System.out.println("Elemento " + clave + " eliminado.");
                encontrado = true;
                break;
            }
            i++;
        }

        if (!encontrado) {
            System.out.println("Elemento " + clave + " no encontrado en la tabla.");
        }
    }

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
        TablaHashCuadratica tablaHash = new TablaHashCuadratica(size);

        boolean activo = true;
        while (activo) {
            System.out.println("\n--- Menú Tabla Hash con Exploración Cuadrática ---");
            System.out.println("0. Salir");
            System.out.println("1. Insertar clave");
            System.out.println("2. Mostrar tabla");
            System.out.println("3. Eliminar clave");
            System.out.print("Seleccione una opción: ");
            int opcion = consola.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la clave a insertar: ");
                    int claveInsertar = consola.nextInt();
                    tablaHash.insertar(claveInsertar);
                    break;
                case 2:            
                    System.out.println("0. Salir");
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