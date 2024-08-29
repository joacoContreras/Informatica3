import java.util.List;

public class Ordenamiento {

    public void ordenarPorTiempoPreparacion(List<Pedido> pedidos) {
        for (int i = 1; i < pedidos.size(); i++) {
            Pedido key = pedidos.get(i);
            int j = i - 1;
            while (j >= 0 && pedidos.get(j).getTiempoPreparacion() > key.getTiempoPreparacion()) {
                pedidos.set(j + 1, pedidos.get(j));
                j = j - 1;
            }
            pedidos.set(j + 1, key);
        }
    }

    public void shellsort(List<Pedido> pedidos) {
        int n = pedidos.size();
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Pedido temp = pedidos.get(i);
                int j;
                for (j = i; j >= gap && pedidos.get(j - gap).getPrecioTotal() > temp.getPrecioTotal(); j -= gap) {
                    pedidos.set(j, pedidos.get(j - gap));
                }
                pedidos.set(j, temp);
            }
        }
    }

    public void quicksortPorNombre(List<Pedido> pedidos, int low, int high) {
        if (low < high) {
            int pi = partition(pedidos, low, high);
            quicksortPorNombre(pedidos, low, pi - 1);
            quicksortPorNombre(pedidos, pi + 1, high);
        }
    }

    private int partition(List<Pedido> pedidos, int low, int high) {
        Pedido pivot = pedidos.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (pedidos.get(j).getCliente().getNombre().compareTo(pivot.getCliente().getNombre()) < 0) {
                i++;
                Pedido temp = pedidos.get(i);
                pedidos.set(i, pedidos.get(j));
                pedidos.set(j, temp);
            }
        }
        Pedido temp = pedidos.get(i + 1);
        pedidos.set(i + 1, pedidos.get(high));
        pedidos.set(high, temp);
        return i + 1;
    }
}
