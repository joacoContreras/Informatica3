import java.util.ArrayList;

public class MonticuloMin {
    private ArrayList<Integer> heap;

    public MonticuloMin() {
        heap = new ArrayList<>();
    }

    public int primerElemento(){
        return heap.get(0);
    }

    // Obtener el índice del padre
    private int padre(int i) {
        return (i - 1) / 2;
    }

    // Obtener el índice del hijo izquierdo
    private int hijoIzq(int i) {
        return 2 * i + 1;
    }

    // Obtener el índice del hijo derecho
    private int hijoDer(int i) {
        return 2 * i + 2;
    }

    // Insertar un nuevo valor en el montículo
    public void insertar(int valor) {
        heap.add(valor);
        int i = heap.size() - 1;

        // Reorganizar (Heapify down)
        while (i > 0 && heap.get(padre(i)) > heap.get(i)) {
            intercambiar(i, padre(i));
            i = padre(i);
        }
    }

    // Eliminar el elemento minimo (la raíz)
    public int eliminarMin() {
        if (heap.size() == 0) {
            throw new IllegalStateException("El montículo está vacío");
        }

        int min = heap.get(0);

        // Mover el último elemento a la raíz
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        // Reorganizar (Heapify down)
        heapify(0);

        return min;
    }

    // Método heapify para mantener la propiedad de montículo
    private void heapify(int i) {
        int izq = hijoIzq(i);
        int der = hijoDer(i);
        int menor = i;

        if (izq < heap.size() && heap.get(izq) > heap.get(menor)) {
            menor = izq;
        }

        if (der < heap.size() && heap.get(der) > heap.get(menor)) {
            menor = der;
        }

        if (menor != i) {
            intercambiar(i, menor);
            heapify(menor);
        }
    }

    // Método para intercambiar dos elementos en el arreglo
    private void intercambiar(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Método para mostrar el montículo
    public void mostrarMonticulo() {
        System.out.println(heap);
    }

    
}
