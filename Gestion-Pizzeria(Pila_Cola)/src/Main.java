import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pizzeria pizzeria = new Pizzeria(100); // Definimos la capacidad máxima de la cola
        pizzeria.generarPedidos();
        Scanner consola = new Scanner(System.in);
        boolean sistemaActivo = true;

        do {
            System.out.println("Bienvenido al Sistema de Pizzeria");
            System.out.println("----------------------------------------------------------------");
            System.out.println("1- Gestionar pedidos");
            System.out.println("2- Salir");
            System.out.println("Opcion: ");
            int opcion = consola.nextInt();
            consola.nextLine();

            if (opcion == 1) {
                System.out.println("1- Agregar pedido");
                System.out.println("2- Eliminar pedidos (dequeue)");
                System.out.println("3- Ver primer pedido (top)");
                System.out.println("4- Listar todos los pedidos");
                System.out.println("Opcion: ");
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

                    default:
                        break;
                }
            } else if (opcion == 2) {
                sistemaActivo = false;
            }

        } while (sistemaActivo);
    }
}
