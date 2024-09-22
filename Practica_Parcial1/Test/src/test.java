import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<Integer> listaEnteros = new ArrayList<Integer>();
        listaEnteros.add(5);
        listaEnteros.add(3);
        listaEnteros.add(4);
        listaEnteros.add(7);
        int parametro = 4;
        int sum = Recursiva2(listaEnteros, listaEnteros.size() - 1,4);
        char[] array = {'a', 'b', 'c', 'd', 'e'};
        int cont = Recursiva(array, array.length - 1); // Comenzar desde el último índice
        System.out.println("La cantidad de vocales dentro del arreglo es " + cont);
        System.out.println("La suma del arreglo de enteros es: " + sum);
    }

    public static int Recursiva(char[] array, int index) {
        // Caso base: si el índice es menor que 0
        if (index < 0) {
            return 0; // No hay más elementos, retornar 0
        }

        // Verificar si el carácter actual es una vocal
        int cont = (array[index] == 'a' || array[index] == 'e' || array[index] == 'i' ||
                    array[index] == 'o' || array[index] == 'u') ? 1 : 0;

        // Sumar el resultado de la llamada recursiva al contador actual
        return cont + Recursiva(array, index - 1);
    }

    public static int Recursiva2(ArrayList<Integer> listaEnteros, int i, int parametro) {
        if (i < 0) {
            return 0;
        }
        int sum = (listaEnteros.get(i) > parametro) ? listaEnteros.get(i) : 0;
        return sum + Recursiva2(listaEnteros, i-1, parametro);
    }
}
