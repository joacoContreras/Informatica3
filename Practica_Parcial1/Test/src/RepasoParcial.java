public class RepasoParcial {
    public static void main(String[] args) {
        final int N = 20;
        Cola cola = new Cola();
        for (int i = N; i >= 1; i--) {
            cola.enqueue(i);
            
        }
        cola.imprimirCola();

    }
}

