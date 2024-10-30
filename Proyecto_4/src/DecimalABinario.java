import java.util.Stack;
import java.util.Scanner;

public class DecimalABinario {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese un número decimal: ");
        int numero = scanner.nextInt();
        
        String binario = convertirABinario(numero);
        System.out.println("El número en binario es: " + binario);
    }

    public static String convertirABinario(int numero) {
        Stack<Integer> pila = new Stack<>();
        
        // Dividir sucesivamente el número por 2 y almacenar los restos en la pila
        while (numero > 0) {
            pila.push(numero % 2);
            numero = numero / 2;
        }
        
        // Construir la representación en binario
        StringBuilder binario = new StringBuilder();
        while (!pila.isEmpty()) {
            binario.append(pila.pop());
        }
        
        return binario.toString();
    }
    
}
