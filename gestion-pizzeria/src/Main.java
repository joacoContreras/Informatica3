import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pizzeria pizzeria = new Pizzeria(100); // Capacidad de la cola
        pizzeria.generarPedidos();
        Scanner consola = new Scanner(System.in);
        boolean sistemaActivo = true;

        do {
            System.out.println("Bienvenido al Sistema de Pizzeria");
            System.out.println("----------------------------------------------------------------");
            System.out.println("1- Gestionar pedidos");
            System.out.println("2- Ordenamiento de pedidos");
            System.out.println("3- Capturas de tiempos de ejecución");
            System.out.println("4- Salir");
            System.out.println("Opción: ");
            int opcion = consola.nextInt();
            consola.nextLine();

            // Gestión de Pedidos
            if (opcion == 1) {
                System.out.println("1- Agregar pedido");
                System.out.println("2- Eliminar pedidos (dequeue)");
                System.out.println("3- Ver primer pedido (top)");
                System.out.println("4- Listar todos los pedidos");
                System.out.println("5- Preparar Pedido");
                System.out.println("6- Ver ultimo pedido Preparado");
                System.out.println("7- Procesar pedido preparado");
                System.out.println("8- Volver a encolar Pedido de la pila");
                System.out.println("Opción: ");
                opcion = consola.nextInt();
                consola.nextLine();

                switch (opcion) {
                    case 1:
                        pizzeria.agregarPedido();
                        break;
                    case 2:
                        Pedido pedidoEliminado = pizzeria.dequeue();
                        if (pedidoEliminado != null) {
                            System.out.println("Pedido eliminado: " + pedidoEliminado);
                        }
                        break;
                    case 3:
                        Pedido pedidoFrente = pizzeria.top();
                        if (pedidoFrente != null) {
                            System.out.println("Pedido al frente: " + pedidoFrente);
                        }
                        break;
                    case 4:
                        pizzeria.imprimirPedidos();
                        break;
                    case 5:
                    // Primer pedido en la cola es el primero en ser preparado o agregado a la pila
                        pizzeria.prepararPedido();
                        break;
                    case 6:
                    // Imprime stack top
                        pizzeria.verPedidoPreparado();
                        break;
                    case 7:
                    // Imprime el ultimo pedido en haber ingresadp a la pila y lo elimina
                        pizzeria.procesarPedidoPreparado();
                        break;
                    case 8:
                    // Vuelve a la cola el stack top
                        pizzeria.re_enqueue();
                        break;
                    default:
                        break;
                }

            // Ordenamiento de Pedidos
            } else if (opcion == 2) {
                System.out.println("1- Ordenar Lista por Tiempo de Preparación");
                System.out.println("2- Ordenar Lista por Monto");
                System.out.println("3- Ordenar Lista por Nombre de Cliente");
                System.out.println("Tu opción:");
                int opcion2 = consola.nextInt();
                consola.nextLine();
                switch (opcion2) {
                    case 1:
                        Ordenador.ordenarPorTiempoPreparacion(pizzeria.getPedidos());
                        System.out.println("Lista de Pedidos ordenada por Tiempo de Preparación:");
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

            // Captura de Tiempos de Ejecución
            } else if (opcion == 3) {
                // Tamaños de las listas
                int[] tamanos = {100, 1000, 10000};

                // Crear una instancia de MedidorTiempos
                int highest = pizzeria.getPedidos().size() - 1;

                // Medir y mostrar los tiempos de ordenamiento
                TiempoOrdenamiento.medirTiemposOrdenamiento(tamanos, pizzeria.getPedidos(), highest);
            }

            // Salir del Programa
            else if (opcion == 4)
                sistemaActivo = false;

        } while (sistemaActivo);
    }
}
