import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Iterator;

public class Pizzeria {
    // Generador de números aleatorios
    Random rand = new Random();
    private ArrayList<Pedido> pedidos;
    Scanner consola = new Scanner(System.in);

    public Pizzeria() {
        pedidos = new ArrayList<>();
    }

    // Método para obtener la lista de pedidos
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
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

    public void agregarPedido() {
        System.out.println("Ingresar nombre completo de Cliente:");
        String cliente = consola.nextLine();
        System.out.println("Ingrese monto total del pedido:");
        double costo = consola.nextDouble();
        consola.nextLine();
        System.out.println("Ingrese el tiempo de preparacion:");
        float tiempo = consola.nextFloat();
        consola.nextLine();
        int id = rand.nextInt(900000) + 100000 + 1;
        pedidos.add(new Pedido(cliente, costo, tiempo, id));
        System.out.println("Pedido agregado existosamnete");
    }

    public boolean editarPedido(int id, String nuevoNombre, double nuevoCosto, float nuevoPrepTiempo) {
        Pedido pedido = buscarPedido(id);  // Busca el pedido por ID
        if (pedido != null) {
            // Actualiza los valores del pedido
            pedido.setNombre(nuevoNombre);
            pedido.setCosto(nuevoCosto);
            pedido.setPrepTiempo(nuevoPrepTiempo);
            System.out.println("Pedido editado exitosamente");
            return true;  // Edición exitosa
        }
        System.out.println("Pedido no encontrado");
        return false;  // Pedido no encontrado
    }

      // Método para eliminar un pedido por ID
        public boolean eliminarPedido(int id) {
        Iterator<Pedido> iterador = pedidos.iterator();
        while (iterador.hasNext()) {
            Pedido pedido = iterador.next();
            if (pedido.getId() == id) {
                iterador.remove();
                return true;
            }
        }
        return false;
    }

     // Método para buscar un pedido por ID
        public Pedido buscarPedido(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        System.out.println("Pedido no encontrado");
        return null; // Si no se encuentra el pedido, devolver null
    }

    // Método para contar el número total de pedidos
    public int contarPedidos() {
        return pedidos.size();
    }
}
