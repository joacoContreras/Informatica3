package Proyecto_1;

public class SumasSucesivas {
    public static void main(int num1, int num2) {
        int resultado = recursiva(num1, num2);
        System.out.println(" = "+ num1 + " x " + num2 + " = " + resultado);
        
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
