package Proyecto_3;

import java.util.Scanner;


public class Main3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int op=0;
        do{
            System.out.println("1. Implementación de una Pila.");
            System.out.println("2. Comprobación de Palíndromos.");
            System.out.println("3. Expresiones Matemáticas.");
            System.out.println("4. Implementación de una Cola.");
            System.out.println("5. Ordenar una Cola");
            System.out.println("Seleccione una opcion:");
            int seleccion=scanner.nextInt();
            switch(seleccion){
                case 1:
                    Pila_con_Array.main(args);
                    break;
                case 2:
                    Palindromo.main(args);
                    break;
                case 3:
                    Equilibrado.main(args);
                    break;
                case 4:
                    Cola_con_Array.main(args);
                    break;
                case 5:
                    Cola_Ordenada.main(args);
                    break;
            }
            System.out.println("Desea seguir con el menu?(1=si/2=no)");
            op=scanner.nextInt(); 
        }while(op!=2);
    }
}
