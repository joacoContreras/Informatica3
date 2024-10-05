import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Ingresa un numero entero para calcular Fibonacci: " );
        Scanner consola = new Scanner(System.in);
        int numero = consola.nextInt();
        consola.nextLine();
        int n = recursiva(numero);
        System.out.println("Fibonacci de " + numero + " es: " + n);
        consola.close();
    }

    private static int recursiva(int n){
        if (n <= 0) {
            return 0;  // Caso base: F(0) = 0

        } else if (n == 1) {
            return 1;  // Caso base: F(1) = 1

        } else {

            return recursiva(n - 1) + recursiva(n - 2);  // Recursión
        }
    }

}
