public class ImprimirInverso {
    public static void imprimirInverso(int[] arreglo, int indice) {
        if (indice < 0) {
            return;
        }
        System.out.print(arreglo[indice] + " ");
        imprimirInverso(arreglo, indice - 1);
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5};
        System.out.print("Arreglo: ");
        for (int index = 0; index < arreglo.length; index++) {
            System.out.print(arreglo[index] + " ");
        }
        System.out.println("\n");
        System.out.print("Arreglo en orden inverso: ");
        imprimirInverso(arreglo, arreglo.length - 1);
    }
}
