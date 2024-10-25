import java.util.ArrayList;
public class ArrayList_A {
    public static void main(String[] args) {
        // Crear un ArrayList
        ArrayList<MyObject> arrayList = new ArrayList<>();

        // i. Agregar un objeto
        arrayList.add(new MyObject("mouse", 10500));
        arrayList.add(new MyObject("teclado", 15500));
        arrayList.add(new MyObject("auriculares", 9800));

        // ii. Imprimir la ArrayList completa
        System.out.println("ArrayList completa: " + arrayList);

        // iii. Imprimir un elemento específico
        System.out.println("Elemento en el índice 0: " + arrayList.get(0));

        // iv. Borrar un elemento
        arrayList.remove(1);
        System.out.println("ArrayList después de borrar el elemento en índice 1: " + arrayList);
    }
}

