class TablaHashLineal {
    private int[] tabla;
    private int size;

    // Constructor: inicializa la tabla con un tamaño específico
    public TablaHashLineal(int size) {
        this.size = size;
        this.tabla = new int[size];
        // Inicializar todas las posiciones como -1, para indicar que están vacías
        for (int i = 0; i < size; i++) {
            tabla[i] = -1;
        }
    }

    // Función hash simple (hash = clave % tamañoTabla)
    private int funcionHash(int clave) {
        return clave % size;
    }

    // Insertar una clave en la tabla hash
    public void insertar(int clave) {
        int indice = funcionHash(clave);

        // Exploración lineal para encontrar una posición vacía
        while (tabla[indice] != -1) {  // Mientras la posición esté ocupada
            indice = (indice + 1) % size;  // Mover al siguiente índice (ciclo circular)
        }

        // Insertar la clave en la posición vacía encontrada
        tabla[indice] = clave;
    }

    // Mostrar la tabla hash
    public void mostrarTabla() {
        for (int i = 0; i < size; i++) {
            System.out.println("Índice " + i + ": " + tabla[i]);
        }
    }
}

