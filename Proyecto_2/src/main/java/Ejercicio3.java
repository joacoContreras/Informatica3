import java.util.Arrays;
import java.util.Random;

public class Ejercicio3 {
    public static Integer[] generateRandomArray(int tamano) {
        Random rand = new Random();
        Integer[] array = new Integer[tamano];
        for (int i = 0; i < tamano; i++) {
            array[i] = rand.nextInt(1000); 
        }
        return array;
    }

    public static void main(String[] args) {
        int tamano = 10; 
        Integer[] randomArray = generateRandomArray(tamano);

        System.out.println("Array generado aleatoriamente:");
        System.out.println(Arrays.toString(randomArray));
    }
}
