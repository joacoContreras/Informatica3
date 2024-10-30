import java.util.Stack;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la expresión matemática: ");
        String expresion = scanner.nextLine();
        
        System.out.println(verificarBalance(expresion));
        scanner.close();
    }

    public static String verificarBalance(String expresion) {
        Stack<Character> pila = new Stack<>();
        
        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);
            
            // Si encontramos un paréntesis de apertura, lo agregamos a la pila
            if (caracter == '(') {
                pila.push(caracter);
            } 
            // Si encontramos un paréntesis de cierre
            else if (caracter == ')') {
                // Verificamos si la pila está vacía (paréntesis de cierre sin apertura)
                if (pila.isEmpty()) {
                    return "Paréntesis desbalanceados";
                }
                // Si no está vacía, sacamos un paréntesis de apertura de la pila
                pila.pop();
            }
        }
        
        // Si la pila está vacía, los paréntesis están balanceados
        if (pila.isEmpty()) {
            return "Paréntesis balanceados";
        } else {
            return "Paréntesis desbalanceados";
        }
    }

    
}
