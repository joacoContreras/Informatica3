public class QuickSort {
    public static void main(String[] args) {
        LinkedList lista = new LinkedList();
        lista.insertarFinal(4);
        lista.insertarFinal(99);
        lista.insertarFinal(41);
        lista.insertarFinal(1);
        lista.insertarFinal(3);
        System.out.println("Lista sin ordenar");
        lista.imprimirLista();
        Ordenar(lista, 0, lista.contarElementos()-1);
        System.out.println("Lista ordenada por quickSort:");
        lista.imprimirLista();
        System.out.println("Lista ordenada por ShellSort:");
        ShellSort(lista);
        lista.imprimirLista();
    }

    private static void Ordenar(LinkedList lista, int low, int high) {
        if (low < high) {
            int pi = partition(lista, low, high); // Encuentra el indice de la particion
            Ordenar(lista, low, pi - 1);
            Ordenar(lista, pi + 1, high);
        }
    }

    public static int partition(LinkedList lista, int low, int high) {
        Nodo pivot = lista.obtenerElemento(high); // Tomamos ultimo elemento como pivote
        int dataPivot = pivot.data;
        int i = low; // Indice del menor elemento
        for (int j = low; j < high; j++) {
            if (lista.obtenerElemento(j).data <= dataPivot) {
                int temp = lista.obtenerElemento(i).data;
                lista.obtenerElemento(i).data = lista.obtenerElemento(j).data;
                lista.obtenerElemento(j).data = temp;
                i++;
            }
        }
        int temp =lista.obtenerElemento(i).data;
        lista.obtenerElemento(i).data = lista.obtenerElemento(high).data;
        lista.obtenerElemento(high).data = temp;
        return i;
    }

    private static void ShellSort(LinkedList lista){
        int n = lista.contarElementos() - 1;
        for (int intervalo = n/2; intervalo > 0; intervalo /= 2) {
            Nodo tempNodo = lista.obtenerElemento(intervalo);
            int temp = tempNodo.data;
            int j;
            for (j = intervalo; j >= intervalo && lista.obtenerElemento(j-intervalo).data < temp; j-= intervalo) {
                lista.obtenerElemento(j).data = lista.obtenerElemento(j - intervalo).data;
            }
            lista.obtenerElemento(j).data = temp;
        }
    }
}
