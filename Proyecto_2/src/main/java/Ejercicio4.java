public class Ejercicio4 extends Ejercicio1 {

    public static void measureTime(Runnable sortMethod, String methodName, int length) {
        long startTime = System.nanoTime();
        sortMethod.run();
        long endTime = System.nanoTime();
        System.out.println(methodName + " (" + length + " elementos): " + (endTime - startTime) + " ns");
    }

    public static void main(String[] args) {
        Integer[] array100 = Ejercicio3.generateRandomArray(100);
        Integer[] array1000 = Ejercicio3.generateRandomArray(1000);
        Integer[] array10000 = Ejercicio3.generateRandomArray(10000);

        
        measureTime(() -> insertionSort(array100.clone()), "Inserción", 100);
        measureTime(() -> insertionSort(array1000.clone()), "Inserción", 1000);
        measureTime(() -> insertionSort(array10000.clone()), "Inserción", 10000);

        measureTime(() -> shellSort(array100.clone()), "Shellsort", 100);
        measureTime(() -> shellSort(array1000.clone()), "Shellsort", 1000);
        measureTime(() -> shellSort(array10000.clone()), "Shellsort", 10000);

        measureTime(() -> quickSort(array100.clone(), 0, array100.length - 1), "Quicksort", 100);
        measureTime(() -> quickSort(array1000.clone(), 0, array1000.length - 1), "Quicksort", 1000);
        measureTime(() -> quickSort(array10000.clone(), 0, array10000.length - 1), "Quicksort", 10000);
    }
}
  