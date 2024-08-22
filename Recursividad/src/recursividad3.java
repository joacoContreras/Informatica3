
public class recursividad3 {
    // Función recursiva para calcular el n-ésimo número de Fibonacci
public static int fibonacci(int n) {
    if (n <= 0) {
        return 0;  // Caso base: F(0) = 0
    } else if (n == 1) {
        return 1;  // Caso base: F(1) = 1
    } else {
        return fibonacci(n - 1) + fibonacci(n - 2);  // Recursión
    }
}

// Método principal para probar la función
public static void main(String[] args) {
    int n = 8;  // Ejemplo: calcular el sexto número de Fibonacci
    System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
}
}
