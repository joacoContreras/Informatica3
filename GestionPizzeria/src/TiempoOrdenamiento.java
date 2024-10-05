import java.util.List;
public class TiempoOrdenamiento {
    
    // Método para medir y mostrar los tiempos de ejecución de los algoritmos de ordenamiento
    public static void medirTiemposOrdenamiento(int[] tamanos, List<Pedido> pedidos, int high) {
            
            // Medir tiempo de ordenamiento por nombre
            long tiempoInicio = System.nanoTime();
            Ordenador.ordenarPorTiempoPreparacion(pedidos);
            long tiempoFin = System.nanoTime();
            long duracionNombre = tiempoFin - tiempoInicio;
            System.out.println("Tiempo de ordenamiento por nombre: " + duracionNombre / 1_000_000 + " ms");

            
            // Medir tiempo de ordenamiento por costo
            tiempoInicio = System.nanoTime();
            Ordenador.shellsort(pedidos);
            tiempoFin = System.nanoTime();
            long duracionCosto = tiempoFin - tiempoInicio;
            System.out.println("Tiempo de ordenamiento por costo: " + duracionCosto / 1_000_000 + " ms");

            // Medir tiempo de ordenamiento por tiempo de preparación
            tiempoInicio = System.nanoTime();
            Ordenador.quicksortPorNombre(pedidos,0,high);
            tiempoFin = System.nanoTime();
            long duracionTiempo = tiempoFin - tiempoInicio;
            System.out.println("Tiempo de ordenamiento por tiempo de preparación: " + duracionTiempo / 1_000_000 + " ms");
        
    }
}