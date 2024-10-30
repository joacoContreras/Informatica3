package Proyecto_9;
import java.util.Scanner;

public class Main9{
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        boolean op1= true; // Sistema Activo
        do{
            System.out.println("\nBienvenido al proyecto 9");
            System.out.println("------------------------");
            System.out.println("0. Salir");
            System.out.println("1. Montículo Binario");
            System.out.println("2. Tabla Hash");
            System.out.println("3. General con librerías nativas de Java.");
            System.out.println("4. Ventajas y Desventajas de las distintas estructuras de datos");
            System.out.println("Seleccione una opcion: ");
            int seleccion= scanner.nextInt();
            scanner.nextLine();
            switch(seleccion){
                case 1:
                    MainHeap.main(args);
                    break;
                case 2:
                    MainHash.main(args);
                    break;
                case 3:
                    int op=0;
                    do{
                        System.out.println("1-Implementar un ArrayList de un objeto.");
                        System.out.println("2-Implementar un LinkedList de un objeto.");
                        System.out.println("3-Implementar un HashMap de un objeto.");
                        System.out.println("4-Implementar un TreeMap de un objeto.");
                        System.out.println("5-Implementar un LinkedHashMap de un objeto.");
                        System.out.println("Seleccione una opcion: ");
                        int seleccion1= scanner.nextInt();
                        switch(seleccion1){
                            case 1:
                                ArrayList_A.main(args);
                                break;
                            case 2:
                                LinkedList_B.main(args);
                                break;
                            case 3:
                                HashMap_C.main(args);
                                break;
                            case 4:
                                TreeMap_D.main(args);
                                break;
                            case 5:
                                linkedhashmap_E.main(args);
                                break;
                            default:
                                System.out.println("La opcion ingresada no es valida.");
                
                        }       
                    System.out.println("Desea seguir con el menu?(1=si/2=no)");
                    op=scanner.nextInt();
                } while(op!=2);
                
                case 4:
                    Ejercicio4.main(args);
                    break;
                case 0:
                    op1 = false;
                    break;
            }
        } while(op1);
    }  
}
