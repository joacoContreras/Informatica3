import java.text.DecimalFormat;

class Pedido {
    private String nombre;
    private double costo;
    private float prepTiempo;
    private int id;

    // Formato para mostrar solo dos decimales
    private static final DecimalFormat df = new DecimalFormat("#.00");

    public Pedido(String nombre, double costo, float prepTiempo, int id) {
        this.nombre = nombre;
        this.costo = costo;
        this.prepTiempo = prepTiempo;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pedido {" +
                "nombre= " + nombre + '\'' +
                ", costo = " + df.format(costo) + "$" +
                ", tiempo de preparación = " + df.format(prepTiempo) +
                " minutos, ID= " + id +
                '}';
    }

    
}