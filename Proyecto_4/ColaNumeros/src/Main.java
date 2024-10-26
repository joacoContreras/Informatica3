import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Pruebas de la pila
        Cola cola = new Cola();
        boolean sistemaActivo = true;
        Scanner consola = new Scanner(System.in);
        do {
            System.out.println("Bienvenido al sistema Cola de Numeros");
            System.out.println("---------------------------------------");
            System.out.println("0. Salir");
            System.out.println("1. Ingresar Numero");
            System.out.println("2. Desencolar y Sumar todos los numeros");
            System.out.println("Tu opcion: "); 
            int opcion = consola.nextInt();
            consola.nextLine();
            switch (opcion) {
                case 0:
                    sistemaActivo = false;
                    break;

                case 1:
                    System.out.print("Ingresar Numero: ");
                    int num = consola.nextInt();
                    consola.nextLine();
                    cola.enqueue(num);
                    break;

                case 2:
                    int sum = cola.dequeue();
                    System.out.println("La sumatoria de los numeros de la cola es: " + sum);
                    break;
            
                default:
                    System.out.println("Error....");
                    break;
            }
        } while (sistemaActivo);

        consola.close(); 
    }

}
