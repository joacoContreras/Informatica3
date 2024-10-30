package Proyecto_7;

import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ejecutar Punto 2 (Main)");
            System.out.println("2. Ejecutar Punto 3 (Main2)");
            System.out.println("3. Ejecutar Punto 4 (Main3)");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ejecutando Punto 2...");
                    Main.ejecutar();
                    break;
                case 2:
                    System.out.println("Ejecutando Punto 3...");
                    Main2.ejecutar();
                    break;
                case 3:
                    System.out.println("Ejecutando Punto 4...");
                    Main3.ejecutar();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción entre 1 y 4.");
                    break;
            }
            System.out.println();  
        }
        
    }
}
