import java.util.ArrayList;


public class Main {
    
    static ArrayList<Pedido> pedidos = new ArrayList<>();
    

    public static void main(String[] args) {
        pedidos.add(new Pedido("Juan Carlos", 455.56, 30, 455900));
    }
}
