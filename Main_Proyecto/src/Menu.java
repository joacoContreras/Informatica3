import Proyecto_01.Main;
import Proyecto_4.Main;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        boolean activo = true;

        do {
            // Mostrar el menú
            System.out.println("\n--- Menú Principal Proyectos ---");
            System.out.println("1. Proyecto 1 - Recursividad");
            System.out.println("2. ");
            System.out.println("3. ");
            System.out.println("4. ");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            // Leer la opción ingresada por el usuario
            int opcion = consola.nextInt();

            // Switch para manejar las opciones del menú
            switch (opcion) {
                case 1:
                    Proyecto_01.Main.main(args);
                    break;
                case 2:
                    
                    break;
                case 3:
                    break;
                case 4:
                    Proyecto_4.Main.main(args);
                case 0:
                    activo = false;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (activo);
    }

    // Método para ejecutar un archivo .jar externo
    public static void ejecutarJar(String nombreArchivo) {
        try {
            ProcessBuilder builder = new ProcessBuilder("java", "-jar", nombreArchivo);
            builder.inheritIO();  // Permitir que el proceso use la consola actual
            Process proceso = builder.start();
            proceso.waitFor();  // Esperar a que termine el proceso antes de volver al menú
        } catch (Exception e) {
            System.out.println("Error al ejecutar " + nombreArchivo + ": " + e.getMessage());
        }
    }
}
