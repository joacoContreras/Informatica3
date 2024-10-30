package Proyecto2;
import java.util.Arrays;

public class Ejercicio1 {


    public static <AnyType extends Comparable<? super AnyType>> void insertionSort(AnyType[] a) {
        for (int p = 1; p < a.length; p++) {
            AnyType tmp = a[p];
            int j = p;
            for (; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

    
    
    
    public static <AnyType extends Comparable<? super AnyType>> void shellSort(AnyType[] v) {
        int n = v.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                AnyType temp = v[i];
                int j;
                for (j = i; j >= gap && temp.compareTo(v[j - gap]) < 0; j -= gap) {
                    v[j] = v[j - gap];
                }
                v[j] = temp;
            }
        }
    }
    
    
    
    

    public static <AnyType extends Comparable<? super AnyType>> void quickSort(AnyType[] v, int left, int right) {
        if (left >= right) return;
        AnyType pivot = v[(left + right) / 2];
        int i = left, j = right;
        while (i <= j) {
            while (v[i].compareTo(pivot) < 0) i++;
            while (v[j].compareTo(pivot) > 0) j--;
            if (i <= j) {
                AnyType temp = v[i];
                v[i] = v[j];
                v[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j) quickSort(v, left, j);
        if (i < right) quickSort(v, i, right);
    }
    
    
    public static <AnyType> void mostrarArray(AnyType[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        

   
        Integer[] intArray = {3, 5, 1, 4, 2};
        System.out.println("Array de enteros original:");
        mostrarArray(intArray);

        insertionSort(intArray);
        System.out.println("Array de enteros ordenado con Insertion Sort:");
        mostrarArray(intArray);

        shellSort(intArray);
        System.out.println("Array de enteros ordenado con Shell Sort:");
        mostrarArray(intArray);

        quickSort(intArray, 0, intArray.length - 1);
        System.out.println("Array de enteros ordenado con Quick Sort:");
        mostrarArray(intArray);

       
        Double[] doubleArray = {3.5, 1.2, 4.8, 2.0, 5.1};
        System.out.println("\nArray de doubles original:");
        mostrarArray(doubleArray);

        insertionSort(doubleArray);
        System.out.println("Array de doubles ordenado con Insertion Sort:");
        mostrarArray(doubleArray);

        shellSort(doubleArray);
        System.out.println("Array de doubles ordenado con Shell Sort:");
        mostrarArray(doubleArray);

        quickSort(doubleArray, 0, doubleArray.length - 1);
        System.out.println("Array de doubles ordenado con Quick Sort:");
        mostrarArray(doubleArray);

       
        String[] stringArray = {"apple", "orange", "banana", "grape", "cherry"};
        System.out.println("\nArray de strings original:");
        mostrarArray(stringArray);

        insertionSort(stringArray);
        System.out.println("Array de strings ordenado con Insertion Sort:");
        mostrarArray(stringArray);

        shellSort(stringArray);
        System.out.println("Array de strings ordenado con Shell Sort:");
        mostrarArray(stringArray);

        quickSort(stringArray, 0, stringArray.length - 1);
        System.out.println("Array de strings ordenado con Quick Sort:");
        mostrarArray(stringArray);
    }
}
