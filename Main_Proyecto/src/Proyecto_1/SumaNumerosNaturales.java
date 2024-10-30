package Proyecto_1;

public class SumaNumerosNaturales {

    public static void suma(int n) {

        int resultado = recursiva(n);
        System.out.println("\nLa suma de los primeros "+ n + " numeros es: " + resultado);
    }

    private static int recursiva(int numero) {
        if (numero == 1) {
            return 1;
        }
        int n = numero + recursiva(numero - 1);  // Recursividad
        return n;
    }
}
