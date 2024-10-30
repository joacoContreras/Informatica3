import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        boolean sistemaActivo = true;
        do {
            System.out.println("Bienvenido al sistema Tablas Hash");
            System.out.println("---------------------------------");
            System.out.println("0. Salir");
            System.out.println("1. Tabla Lineal");
            System.out.println("2. Tabla Cuadratica");
            System.out.println("3. Tabla Chaining");
            System.out.println("Tu opcion: ");
            int opcion = consola.nextInt();
            consola.nextLine();
            switch (opcion) {
                case 0:
                    sistemaActivo = false;
                    break;
                case 1: 
                    TablaLineal.main();
                    break;
                case 2:
                    TablaHashCuadratica.main();
                    break;
                case 3:
                    TablaChaining.main();
                    break;
                default:
                    System.out.println("Error...");
                    break;
            }
        } while (sistemaActivo);
    
    }
}
