import Proyecto_1.Main1;
import Proyecto_2.Main2;
import Proyecto_3.Main3;
import Proyecto_4.Main4;
import Proyecto_5y6.Main5;
import Proyecto_7.Main7;
import Proyecto_8.Main8;
import Proyecto_9.Main9;

import java.util.Scanner;
public class Menu {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        boolean activo = true;
        do {
            System.out.println("\n--- Menú Principal Proyectos ---");
            System.out.println("1. Proyecto 1 - Recursividad");
            System.out.println("2. Proyecto 2 - Ordenamiento");
            System.out.println("3. Proyecto 3 - Pila y Cola con arreglo ");
            System.out.println("4. Proyecto 4 - Pila y Cola con Lista");
            System.out.println("5. Proyecto 5 y 6 - Arbol Binario");
            System.out.println("6. Proyecto 7 - Arbol AVG ");
            System.out.println("7. Proyecto 8 - Arbol RojiNegro ");
            System.out.println("8. Proyecto 9 - Heap, Hash, Librerias Nativas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = consola.nextInt();
            consola.nextLine();

            switch (opcion) {
                case 1:
                    Proyecto_1.Main1.main(args);
                    break;
                case 2:
                    Proyecto_2.Main2.main(args);
                    break;
                case 3:
                    Proyecto_3.Main3.main(args);
                    break;
                case 4:
                    Proyecto_4.Main4.main(args);
                case 5:
                    Proyecto_5y6.Main5.main(args);
                case 6:
                    Proyecto_7.Main7.main(args);
                case 7:
                    Proyecto_8.Main8.main(args);
                case 9:
                    Proyecto_9.Main9.main(args);
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
}
