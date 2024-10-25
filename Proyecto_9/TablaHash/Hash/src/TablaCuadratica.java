class TablaHashCuadratica {
    private int[] tabla;
    private int size;

    public TablaHashCuadratica(int size) {
        this.size = size;
        this.tabla = new int[size];
        for (int i = 0; i < size; i++) {
            tabla[i] = -1; // Indicador de posiciones vacías
        }
    }

    private int funcionHash(int clave) {
        return clave % size;
    }

    public void insertar(int clave) {
        int indice = funcionHash(clave);
        int i = 0;
        while (tabla[(indice + i * i) % size] != -1) {  // Exploración cuadrática
            i++;
        }
        tabla[(indice + i * i) % size] = clave;
    }

    public void mostrarTabla() {
        for (int i = 0; i < size; i++) {
            System.out.println("Índice " + i + ": " + tabla[i]);
        }
    }
}

