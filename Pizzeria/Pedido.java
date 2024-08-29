public class Pedido {
    private Cliente cliente;
    private double precioTotal;
    private int tiempoPreparacion; // en minutos

    public Pedido(Cliente cliente, double precioTotal, int tiempoPreparacion) {
        this.cliente = cliente;
        this.precioTotal = precioTotal;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    @Override
    public String toString() {
        return "Pedido de " + cliente.getNombre() + " - Precio: " + precioTotal + " - Tiempo de preparación: " + tiempoPreparacion + " min";
    }
}
