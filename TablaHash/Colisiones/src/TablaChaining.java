public class TablaChaining {
    import java.util.LinkedList;

class TablaHashEncadenada {
    private LinkedList<Integer>[] tabla;
    private int size;

    // Constructor: inicializa la tabla con un tamaño específico
    public TablaHashEncadenada(int size) {
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
}

// Ejemplo de uso:
public class Main {
    public static void main(String[] args) {
        TablaHashEncadenada tablaHash = new TablaHashEncadenada(10);

        // Insertar claves en la tabla hash
        tablaHash.insertar(15);
        tablaHash.insertar(25);  // Ambas colisionan en el índice 5
        tablaHash.insertar(35);  // Colisiona también en el índice 5

        // Mostrar la tabla hash
        tablaHash.mostrarTabla();
    }
}

}
