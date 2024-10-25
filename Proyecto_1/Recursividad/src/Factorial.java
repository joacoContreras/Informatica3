import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        
        System.out.println("Ingresa un numero entero para calcular el factorial: " );
        Scanner consola = new Scanner(System.in);
        int numero = consola.nextInt();
        consola.nextLine();
        int n = recursiva(numero);
        System.out.println("El factorial de " + numero + " es: " + n);
        consola.close();
    }
    
    private static int recursiva(int numero){
        if (numero == 1) {
            return 1;
        }
        int n = numero * recursiva(numero - 1);  // Recursividad
        return n;
    }
}




