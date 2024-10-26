public class Ejercicio2 {
    
    public static <AnyType> void mostrarArray(AnyType[] array) {
        for (AnyType element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
  
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Array de enteros:");
        mostrarArray(intArray);
        
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        System.out.println("Array de doubles:");
        mostrarArray(doubleArray);

        String[] stringArray = {"uno", "dos", "tres", "cuatro", "cinco"};
        System.out.println("Array de strings:");
        mostrarArray(stringArray);
    }
}
