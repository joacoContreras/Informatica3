import java.util.Scanner;

public class PotenciaDeNumero {
    public static void main(String[] args) {
        System.out.println("Ingresa un numero entero para calcular la potencia: " );
        Scanner consola = new Scanner(System.in);
        int numero = consola.nextInt();
        consola.nextLine();
        System.out.println("Ingresa la potencia: ");
        int potencia = consola.nextInt();
        consola.nextLine();
        int n = recursiva(numero, potencia);
        System.out.println("Resultado = " + n);
        consola.close();
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
