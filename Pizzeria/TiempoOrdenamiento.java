public class TiempoOrdenamiento {

    public static long medirTiempo(Runnable algoritmo) {
        long start = System.nanoTime();
        algoritmo.run();
        return System.nanoTime() - start;
    }
}