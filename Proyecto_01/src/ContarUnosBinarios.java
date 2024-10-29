public class ContarUnosBinarios {

    private static int contarUnos(int n) {
        if (n == 0) {
            return 0;
        }
        return contarUnos(n / 2) + (n % 2);
    }

    public static void main(int n) {
        System.out.println("\nEl número de unos en la representación binaria de " + n + " es: " + contarUnos(n));
    }
}
