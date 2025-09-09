public class SumaRecursiva {

    // Función recursiva para sumar los números de un arreglo
    public static int sumarArreglo(int[] arr, int n) {
        // Caso base: Si el tamaño es 0, la suma es 0
        if (n == 0) {
            return 0;
        }
        // Caso recursivo: sumar el último elemento con la suma del resto
        return arr[n - 1] + sumarArreglo(arr, n - 1);
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        int[] numeros = {1, 2, 3, 4, 5};
        int resultado = sumarArreglo(numeros, numeros.length);
        System.out.println("La suma del arreglo es: " + resultado);
    }
}
