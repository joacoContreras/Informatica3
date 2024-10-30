package Proyecto_2;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el ejercicio a ejecutar (1, 2, 3 o 4): ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion) {
            case 1:
                Ejercicio1.ejecutar();
                break;
            case 2:
                Ejercicio2.ejecutar();
                break;
            case 3:
                Ejercicio3.ejecutar();
                break;
            case 4:
                Ejercicio4.ejecutar();
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
}
