import java.util.Scanner;
import java.util.Random;

public class Pizzeria {
    private final Pedido[] colaPedidos; // Arreglo para almacenar la cola de pedidos
    private int capacidadMaxima=100;        // Capacidad máxima de la cola
    private int frente;                 // Índice del primer pedido (frente de la cola)
    private int finalCola;              // Índice del último pedido
    private int size;                   // Número actual de pedidos en la cola
    Scanner consola = new Scanner(System.in);
    Random rand = new Random();

    public Pizzeria(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.colaPedidos = new Pedido[capacidadMaxima];
        this.frente = 0;
        this.finalCola = -1;
        this.size = 0;
    }

    private int increment(int x){
        if(++x==100){
            x=0;
        }
        return x;
    }
    // Método para verificar si la cola está vacía
    public boolean isEmpty() {
        return size == 0;
    }

    // Método para verificar si la cola ha alcanzado su capacidad máxima
    public boolean isFull() {
        return size == capacidadMaxima;
    }

    // Método para agregar un pedido a la cola (enqueue)
    public boolean enqueue(Pedido pedido) {
        if (isFull()) {
            System.out.println("La cola de preparación está llena.");
            return false;
        }
        finalCola = increment(finalCola);
        colaPedidos[finalCola] = pedido;
        size++;
        return true;
    }

    // Método para remover el pedido al frente de la cola (dequeue)
    public Pedido dequeue() {
        if (isEmpty()) {
            System.out.println("No hay pedidos en la cola.");
            size--;
        }
        Pedido pedidoRemovido = colaPedidos[frente];
        frente = increment(frente);  
        return pedidoRemovido;
    }

    // Método para ver el pedido al frente de la cola sin removerlo (top)
    public Pedido top() {
        if (isEmpty()) {
            System.out.println("No hay pedidos en la cola.");
            return null;
        }
        return colaPedidos[frente];
    }

    // Método para generar pedidos aleatorios
    public void generarPedidos() {
        String[] nombres = {"Juan ", "Carlos ", "Pepe ", "Esteban ", "Lucas "};
        String[] apellidos = {"Gutierrez", "Ramirez", "Gonzalez", "Puch", "Lilias"};
        for (int i = 0; i < capacidadMaxima-50; i++) {
            String nombreAleatorio = nombres[rand.nextInt(nombres.length)];
            String apellidoAleatorio = apellidos[rand.nextInt(apellidos.length)];
            double costoAleatorio = 10 + (1990) * rand.nextDouble();
            float prepTiempoAleatorio = 15 + (45) * rand.nextFloat();
            int idAleatorio = rand.nextInt(900000) + 100000;
            Pedido nuevoPedido = new Pedido(nombreAleatorio + apellidoAleatorio, costoAleatorio, prepTiempoAleatorio, idAleatorio);
            enqueue(nuevoPedido);
        }
    }

    // Método para imprimir todos los pedidos de la cola
    public void imprimirPedidos() {
        if (isEmpty()) {
            System.out.println("No hay pedidos en la cola.");
            return;
        }
        int indiceActual = frente;
        for (int i = 0; i < size; i++) {
            System.out.println(colaPedidos[indiceActual]);
            indiceActual = (indiceActual + 1) % capacidadMaxima;  // Avanza de manera circular
        }
    }

    // Método para agregar un pedido manualmente
    public void agregarPedido() {
        if (isFull()) {
            System.out.println("La cola de preparación está llena.");
            return;
        }
        System.out.println("Ingresar nombre completo de Cliente:");
        String cliente = consola.nextLine();
        System.out.println("Ingrese monto total del pedido:");
        double costo = consola.nextDouble();
        consola.nextLine();
        System.out.println("Ingrese el tiempo de preparación:");
        float tiempo = consola.nextFloat();
        consola.nextLine();
        int id = rand.nextInt(900000) + 100000 + 1;
        Pedido nuevoPedido = new Pedido(cliente, costo, tiempo, id);
        enqueue(nuevoPedido);
    }

    // Método para contar el número de pedidos en la cola
    public int contarPedidos() {
        return size;
    }
}
