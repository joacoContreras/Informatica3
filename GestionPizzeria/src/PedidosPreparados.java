public class PedidosPreparados {
    private Pedido[] pilaPedidos;
    private int top;
    private int capacidadMaxima;

    // Constructor
    public PedidosPreparados(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.pilaPedidos = new Pedido[capacidadMaxima];
        this.top = -1;
    }

    public boolean push(Pedido pedido) {
        if (top == capacidadMaxima - 1) {
            System.out.println("La pila de pedidos preparados esta lleno");
            return false;
        }
        pilaPedidos[++top] = pedido;
        System.out.println("Pedido preparado y agregado a la pila.");
        return true;
    }

    public Pedido pop() {
        if (top == -1) {
            System.out.println("No hay pedidos preparados.");
            return null;
        }
        return pilaPedidos[top--];
    }

    public Pedido peek() {
        if (top == -1) {
            System.out.println("No hay pedidos preparados");
            return null;
        }
        return pilaPedidos[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void makeEmpty() {
        top = -1;
    }

    public int contarPedidosPreparados() {
        return top + 1;
    }
}
