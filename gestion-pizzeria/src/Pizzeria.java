import java.util.ArrayList;
import java.util.Random;
public class Pizzeria {
    // Generador de números aleatorios
    Random rand = new Random();
    private ArrayList<Pedido> pedidos;

    public Pizzeria() {
        pedidos = new ArrayList<>();
    }

    public void generarPedidos() {

        // Lista de nombres y apellidos de ejemplo
        String[] nombres = {"Juan ", "Carlos ", "Pepe ", "Esteban ", "Lucas "};
        String[] apellidos = {"Gutierrez", "Ramirez", "Gonzalez", "Puch", "Lilias"};
        for (int i = 0; i < nombres.length; i++) {
            String nombreAleatorio = nombres[i];
            String apellidoAleatorio = apellidos[i];
            double costoAleatorio = 10 + (1990) * rand.nextDouble(); // Genera costo entre 10 y 2000
            float prepTiempoAleatorio = 15 + (45) * rand.nextFloat(); // Genera tiempo de preparación entre 15 y 60 minutos
            int idAleatorio = rand.nextInt(900000) + 100000; // Genera un ID aleatorio de 6 dígitos
            pedidos.add(new Pedido(nombreAleatorio + apellidoAleatorio, costoAleatorio, prepTiempoAleatorio, idAleatorio));
        }
    }

    public void imprimirPedidos() {
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
    }
}
