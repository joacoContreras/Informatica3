public class Factorial {
    public static int funcion(int numero){
        if (numero<=1) {
                return 1;

        } else {
                return numero*funcion(numero-1);
        }
    }

    public static void imprimir(int n){
        int resultado = funcion(n);
        System.out.println("\n* " + n +"!"+ " = " + resultado);
    }
}