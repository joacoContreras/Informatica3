import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Pizzeria pizzeria = new Pizzeria();
        Ordenamiento ordenador = new Ordenamiento();

        // Cargar algunos pedidos iniciales
        pizzeria.agregarPedido(new Pedido(new Cliente("Juan"), 150.0, 20));
        pizzeria.agregarPedido(new Pedido(new Cliente("Ana"), 200.0, 15));
        pizzeria.agregarPedido(new Pedido(new Cliente("Carlos"), 120.0, 30));

        int opcion;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1- Mostrar pedidos");
            System.out.println("2- Ordenar pedidos por tiempo de preparación");
            System.out.println("3- Ordenar pedidos por precio total");
            System.out.println("4- Ordenar pedidos por nombre del cliente");
            System.out.println("5- Cargar un nuevo pedido");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    mostrarPedidos(pizzeria);
                    break;
                case 2:
                    ordenador.ordenarPorTiempoPreparacion(pizzeria.getPedidos());
                    System.out.println("\nPedidos ordenados por tiempo de preparación:");
                    mostrarPedidos(pizzeria);
                    break;
                case 3:
                    ordenador.shellsort(pizzeria.getPedidos());
                    System.out.println("\nPedidos ordenados por precio total:");
                    mostrarPedidos(pizzeria);
                    break;
                case 4:
                    ordenador.quicksortPorNombre(pizzeria.getPedidos(), 0, pizzeria.getPedidos().size() - 1);
                    System.out.println("\nPedidos ordenados por nombre del cliente:");
                    mostrarPedidos(pizzeria);
                    break;
                case 5:
                    cargarPedido(pizzeria);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 7);
    }

    private static void mostrarPedidos(Pizzeria pizzeria) {
        System.out.println("\nLista de pedidos:");
        for (Pedido pedido : pizzeria.getPedidos()) {
            System.out.println(pedido);
        }
    }

    private static void cargarPedido(Pizzeria pizzeria) {
        System.out.println("\nIngrese el nombre del cliente:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el precio total del pedido:");
        double precioTotal = scanner.nextDouble();
        System.out.println("Ingrese el tiempo de preparación (en minutos):");
        int tiempoPreparacion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Pedido nuevoPedido = new Pedido(new Cliente(nombre), precioTotal, tiempoPreparacion);
        pizzeria.agregarPedido(nuevoPedido);
        System.out.println("Pedido agregado exitosamente.");
    }

   
}
