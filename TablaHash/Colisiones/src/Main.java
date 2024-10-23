public class Main {
    public static void main(String[] args) {
        TablaHashLineal tablaHash = new TablaHashLineal(10);

        // Insertar claves en la tabla hash
        tablaHash.insertar(15);
        tablaHash.insertar(25);  // Colisión en 15%10 y 25%10
        tablaHash.insertar(35);  // Otra colisión en 35%10

        // Mostrar la tabla hash
        tablaHash.mostrarTabla();
    }
    }
}
