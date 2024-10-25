import java.util.Scanner;

public class ConteoRegresivo {
    public static void main(String[] args) {
        System.out.println("Ingresa un numero entero para calcular el Conteo Regresivo: " );
        Scanner consola = new Scanner(System.in);
        int numero = consola.nextInt();
        consola.nextLine();
        System.out.print("n = " + numero + ": ");
        recursiva(numero);
        consola.close();
    }

    private static void recursiva(int n){
        if (n > 0) {
            n -= 1;
            System.out.print(n +", ");
            recursiva(n);
        }
    }
}
