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
    // Métodos getter y setter
    public String getNombre() {
        return nombre;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public float getPrepTiempo() {
        return prepTiempo;
    }

    public void setPrepTiempo(float prepTiempo) {
        this.prepTiempo = prepTiempo;
    }

    public int getId() {
        return id;
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