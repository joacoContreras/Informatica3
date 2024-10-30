package Proyecto_01;

public class ImprimirInverso {
    public static void imprimirInverso(int[] array, int indice) {
        if (indice < 0) {
            return;
        }
        System.out.print(array[indice] + " ");
        imprimirInverso(array, indice - 1);
    }

    public static void main(int[] array) {
        
        System.out.print("Arreglo en orden inverso: ");
        imprimirInverso(array, array.length - 1);
        System.out.println("\n");
    }
}
