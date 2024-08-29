
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Pizzeria pizzeria = new Pizzeria();
        pizzeria.generarPedidos();
        Scanner consola = new Scanner(System.in);
        boolean sistemaActivo = true;
        do {
            System.out.println("Bienvenido al Sistema de Pizzeria");
        System.out.println("----------------------------------------------------------------");
        System.out.println("1- Gestionar pedidos");
        System.out.println("2- Ordenamiento de pedidos");
        System.out.println("3- Capturas de tiempos de ejecucion");
        System.out.println("4- Salir");
        System.out.println("Opcion: ");
        int opcion = consola.nextInt();
        consola.nextLine();
        
        if (opcion == 1) {
            System.out.println("1- Agregar pedido");
            System.out.println("2- Eliminar pedidos");
            System.out.println("3- Actualizar pedidos");
            System.out.println("4- Listar todos los pedidos");
            opcion = consola.nextInt();
            consola.nextLine();
            System.out.println("Opcion: ");
            switch (opcion) {
                case 1: 
                    pizzeria.agregarPedido();
                    break;

                case 2: 
                    pizzeria.imprimirPedidos();
                    System.out.println("Ingrese id del pedido a eliminar: ");
                    int idBuscar = consola.nextInt();
                    consola.nextLine();
                    pizzeria.eliminarPedido(idBuscar);
                    break;

                case 3: 
                    pizzeria.imprimirPedidos();
                    System.out.println("Ingresa del pedido a actualizar: ");
                    int idBuscar2 = consola.nextInt();
                    consola.nextLine();
                    System.out.println("Ingrese el nuevo nombre del cliente:");
                    String nuevoNombre = consola.nextLine();
                    consola.nextLine();
                    System.out.println("Ingrese nuevo monto total:");
                    double nuevoMonto = consola.nextDouble();
                    consola.nextLine();
                    float nuevoTemp = consola.nextFloat();
                    consola.nextLine();
                    pizzeria.editarPedido(idBuscar2, nuevoNombre, nuevoMonto, nuevoTemp);
                    break;
                case 4:
                    pizzeria.imprimirPedidos();
                    break;
            
                default:
                    break;
            }
        } else if(opcion == 2) {
            System.out.println("1- Ordenar Lista por Tiempo de Preparacion");
            System.out.println("2- Ordenar Lista por Monto");
            System.out.println("3- Ordenar Lista por Nombre de cliente");
            System.out.println("Tu opcion:");
            int opcion2 = consola.nextInt();
            consola.nextLine();
            switch (opcion2) {
                case 1:
                    Ordenador.ordenarPorTiempoPreparacion(pizzeria.getPedidos());
                    System.out.println("Lista de Pedidos ordenada por Tiempo de Preparacion:");
                    pizzeria.imprimirPedidos();
                    break;

                case 2:
                    Ordenador.shellsort(pizzeria.getPedidos());
                    System.out.println("Lista de Pedidos ordenada por Monto:");
                    pizzeria.imprimirPedidos();
                    break;
                
                case 3:
                    Ordenador.quicksortPorNombre(pizzeria.getPedidos(),  0, pizzeria.getPedidos().size() - 1);
                    System.out.println("Lista de Pedidos ordenada por Nombre de Cliente:");
                    pizzeria.imprimirPedidos();
                    break;
            
                default:
                    break;
            }
        } else if(opcion == 3) {
            // Tamaños de las listas
            int[] tamanos = {100, 1000, 10000};

            // Crear una instancia de MedidorTiempos
            TiempoOrdenamiento medidor = new TiempoOrdenamiento();
            int highest = pizzeria.getPedidos().size() - 1;
            // Medir y mostrar los tiempos de ordenamiento
            TiempoOrdenamiento.medirTiemposOrdenamiento(tamanos, pizzeria.getPedidos(),highest);
        }
        else if(opcion == 4)
            sistemaActivo = false;

        } while (sistemaActivo == true);
        
        
    }

}


