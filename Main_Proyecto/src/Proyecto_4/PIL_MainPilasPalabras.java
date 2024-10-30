package Proyecto_4;

import java.util.Scanner;

public class PIL_MainPilasPalabras {
    public static void main() {
        // Pruebas de la pila
        PIL_PilasPalabras<String> pila = new PIL_PilasPalabras();
        boolean sistemaActivo = true;
        Scanner consola = new Scanner(System.in);
        do {
            System.out.println("\nBienvenido al sistema Pila de Palabras");
            System.out.println("---------------------------------------");
            System.out.println("0. Salir");
            System.out.println("1. Ingresar Palabra");
            System.out.println("2. Desapilar e Imprimir en orden inverso Palabras");
            System.out.println("Tu opcion: "); 
            int opcion = consola.nextInt();
            consola.nextLine();
            switch (opcion) {
                case 0:
                    sistemaActivo = false;
                    break;

                case 1:
                    System.out.print("Ingresar Palabra: ");
                    String palabra = consola.nextLine();
                    pila.push(palabra);
                    break;


                case 2:
                    pila.desapilarEImprimirInverso();
                    break;
            
                default:
                    System.out.println("Error....");
                    break;
            }
        } while (sistemaActivo);
    }

}
