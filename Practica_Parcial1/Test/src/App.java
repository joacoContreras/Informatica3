public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int n = 10;
        Recursiva(n - 1);
        Recursiva2(n);    
        n = 4;
        int [] array = {1,2,3,4,5,6,7,8,9,10};
        int sum = Recursiva3(n, array, array.length-1);
        System.out.println("\nResultado de la suma con parametro "+ n + " es: "+ sum);
    }
        

    public static void Recursiva(int n) {
        if (n == 0) {
            return;
        }
        if (n % 2 == 1) {
            System.out.println(n);      
        }
        Recursiva(n-1);
    }

    public static void Recursiva2(int n) {
        if (n > 0) {
            System.out.print("*"); // Imprime un asterisco
            Recursiva2(n - 1); // Llama a la función recursivamente con n - 1
        }
    }

    public static int Recursiva3(int parametro, int[] array, int i) {
        if (i >= 0) {
            int sum = (array[i] > parametro)? parametro : 0;
            return sum + Recursiva3(parametro, array, i-1);
        }
        return 0;
    }
}