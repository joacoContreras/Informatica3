package Proyecto_8;
import java.util.Scanner;


public class Main8 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int op=0;
        do{
            System.out.println("1. Inserción en un Árbol Rojinegro y Eliminación en un Árbol Rojinegro");
            System.out.println("2. Verificación de Propiedades y Altura Negra");
            System.out.println("Seleccione una opcion:");
            int seleccion=scanner.nextInt();
            switch(seleccion){
                case 1:
                    RedBlackTree.main(args);
                    break;
                case 2:
                    ArbolRojinegro13.main(args);
                    break;
                default:
                    System.out.println("La opcion ingresada no es correcta");
                    break;       
            }
            System.out.println("Desea seguir?(1=s1/2=no");
            op=scanner.nextInt();
        }while(op!=2);              
    }
}
