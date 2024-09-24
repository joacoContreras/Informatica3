public class QuickSort {
    public static void main(String[] args) {
        int[] array = {1, 2, 66, 44, 7, 534, 90, 44};
        Ordenar(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void Ordenar(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // Encuentra el indice de la particion
            Ordenar(arr, low, pi - 1);
            Ordenar(arr, pi + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Tomamos ultimo elemento como pivote
        int i = low; // Indice del menor elemento
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        int temp = array[i];
        array[i] = array[high];
        array[high] = temp;
        return i;
    }
}
