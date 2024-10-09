public class Main {
    public static void main(String[] args) {
        MonticuloMax monticulo = new MonticuloMax();

        monticulo.insertar(10);
        monticulo.insertar(15);
        monticulo.insertar(20);
        monticulo.insertar(17);

        monticulo.mostrarMonticulo();  // Debería mostrar el montículo máximo

        System.out.println("Máximo eliminado: " + monticulo.eliminarMax());
        monticulo.mostrarMonticulo();  // Debería mostrar el montículo después de eliminar el máximo
    }
}
