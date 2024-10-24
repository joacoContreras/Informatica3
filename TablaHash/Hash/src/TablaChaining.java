import java.util.LinkedList;

public class TablaChaining {
    private LinkedList<Integer>[] tabla;
    private int size;

    // Constructor: inicializa la tabla con un tamaño específico
    public TablaChaining(int size) {
        this.size = size;
        tabla = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    // Función hash simple
    private int funcionHash(int clave) {
        return clave % size;
    }

    // Insertar una clave en la tabla hash
    public void insertar(int clave) {
        int indice = funcionHash(clave);
        tabla[indice].add(clave);
    }

    // Mostrar la tabla hash
    public void mostrarTabla() {
        for (int i = 0; i < size; i++) {
            System.out.println("Índice " + i + ": " + tabla[i]);
        }
    }

    public boolean eliminar(int clave) {
        int indice = funcionHash(clave);
        LinkedList<Integer> lista = tabla[indice];  // Obtener la lista en la posición índice

        // Intentar eliminar la clave de la lista
        boolean eliminado = lista.remove(Integer.valueOf(clave));  // remove devuelve true si lo eliminó
        return eliminado;
    }

    public boolean buscar(int clave) {
        int indice = funcionHash(clave);
        LinkedList<Integer> lista = tabla[indice];  // Obtener la lista en la posición índice

        // Recorrer la lista para buscar la clave
        for (int valor : lista) {
            if (valor == clave) {
                return true;  // Clave encontrada
            }
        }
        return false;  // Clave no encontrada
    }
}
