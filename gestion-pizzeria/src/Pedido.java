public class Pedido{
    private String nombreCliente;
    private double costo;
    private float prepTemp;
    private int idPedido;

    public Pedido(String nombreCliente, double costo, float prepTemp, int idPedido){
        this.nombreCliente = nombreCliente;
        this.costo = costo;
        this.prepTemp = prepTemp;
        this.idPedido = idPedido;
    }

    @Override
    public String toString(){
        return "Pedido{" + 
                "nombreCliente" + nombreCliente + 
                ", monto = " + costo + 
                ", Tiempo de Preparacion = " + prepTemp + 
                ", idPedido" + idPedido;
    }
}