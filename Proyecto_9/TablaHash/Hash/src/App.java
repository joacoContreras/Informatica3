public class App {
    public static void main(String[] args) {
        TablaChaining tablaHashChaining = new TablaChaining(10);

        // Insertar claves en la tabla hash
        tablaHashChaining.insertar(15);
        tablaHashChaining.insertar(25);  // Ambas colisionan en el índice 5
        tablaHashChaining.insertar(35);  // Colisiona también en el índice 5

        System.out.println("Tabla Chaining:");
        tablaHashChaining.mostrarTabla();

        System.out.println("Buscar por claves en tabla Chaining");
        System.out.println("\nBuscando clave 25: " + tablaHashChaining.buscar(25));
        System.out.println("Buscando clave 99: " + tablaHashChaining.buscar(99));
        System.out.println("Buscando clave 100: " + tablaHashChaining.buscar(100));  // No existe
        
        System.out.println("\nEliminar clave 25 y 100");
        System.out.println("Eliminando clave 25: " + tablaHashChaining.eliminar(25));
        System.out.println("Eliminando clave 100 (no existente): " + tablaHashChaining.eliminar(100));
        
    }
}
