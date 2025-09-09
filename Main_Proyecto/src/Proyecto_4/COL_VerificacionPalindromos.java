package Proyecto_4;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class COL_VerificacionPalindromos {

        public static boolean esPalindromo(String texto) {
        Queue<Character> cola = new LinkedList<>();
        Stack<Character> pila = new Stack<>();

        // Elimina todos los caracteres que no sean letras o números del texto original y convierte todos los caracteres
        // a minúsculas para realizar una comparación insensible a mayúsculas y minúsculas.
        String textoLimpio = texto.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Agregar caracteres a la cola y la pila
        for (char ch : textoLimpio.toCharArray()) {
            cola.offer(ch); // Agregar al final de la cola
            pila.push(ch);  // Agregar a la cima de la pila
        }

        // Comparar los caracteres en la cola y la pila
        while (!cola.isEmpty()) {
            if (!cola.poll().equals(pila.pop())) {
                return false; // Si no coinciden, no es un palíndromo
            }
        }

        return true; // Si todos coinciden, es un palíndromo
    }
}
