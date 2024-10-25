import java.util.Scanner;

public class SumasSucesivas {
    public static void main(String[] args) {
        System.out.println("Ingresa dos números enteros para calcular el producto mediante sumas sucesivas:");
        Scanner consola = new Scanner(System.in);
        int num1 = consola.nextInt();
        int num2 = consola.nextInt();
        int resultado = recursiva(num1, num2); // Llamada a la función recursiva
        System.out.println(" = "+num1 + " x " + num2 + " = " + resultado);
        consola.close();
    }

    private static int recursiva(int n1, int n2) {
        if (n2 == 0) {
            return 0; // Caso base
        } else {
            System.out.print(n1);
            if (n2 - 1 != 0) {
                System.out.print(" + ");
            }
            return n1 + recursiva(n1, n2 - 1); // Sumar n1 hasta n2 veces
        }
    }
}
