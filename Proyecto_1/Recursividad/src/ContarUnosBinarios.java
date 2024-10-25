public class ContarUnosBinarios {

    public static int contarUnos(int n) {
        if (n == 0) {
            return 0;
        }
        return contarUnos(n / 2) + (n % 2);
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println("El número de unos en la representación binaria de " + n + " es: " + contarUnos(n));
    }
}
