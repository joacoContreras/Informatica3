public class Main {
    public static void main(String[] args) {
        MonticuloMax monticulo = new MonticuloMax();
        MonticuloMin monticulo2 = new MonticuloMin();
        for (int i = 0; i < 20; i++) {
            monticulo.insertar(i);
            monticulo2.insertar(i);
        }
        System.out.print("Heap Max: ");
        monticulo.mostrarMonticulo();  // Debería mostrar el montículo máximo
        System.out.print("Heap Min: ");
        monticulo2.mostrarMonticulo();

        System.out.println("Máximo eliminado de heap Max: " + monticulo.eliminarMax());
        System.out.print("Heap Max: ");
        monticulo.mostrarMonticulo();  // Debería mostrar el montículo después de eliminar el máximo
        int min = monticulo2.primerElemento();
        System.out.println("Primer elemento de heap Min: " + min);

    }
}
