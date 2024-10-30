package Proyecto_01;

public class PotenciaDeNumero {

    public static void pow(int n, int potencia2) {
        
        int  resultado = recursiva(n, potencia2);
        System.out.println("\n* "+ n +" ^ "+ potencia2 +" = " + resultado);
    }

    private static int recursiva(int numero, int potencia){
        if (numero == 1 || potencia == 0) {
            return 1;
        }
        if (potencia == 1) {
            return numero;
        }
        int n = numero * recursiva(numero, potencia-1);  // Recursividad
        return n;
    }
}
