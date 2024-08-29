
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Pizzeria pizzeria = new Pizzeria();
        pizzeria.generarPedidos();
        Scanner consola = new Scanner(System.in);

        System.out.println("Bienvenido al Sistema de Pizzeria");
        System.out.println("----------------------------------------------------------------");
        System.out.println("1- Gestionar pedidos");
        System.out.println("2- Ordenamiento de pedidos");
        System.out.println("3- Capturas de tiempos de ejecucion");
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

                case 4:
                    pizzeria.imprimirPedidos();
                    break;
            
                default:
                    break;
            }
        }
        
    }

}


