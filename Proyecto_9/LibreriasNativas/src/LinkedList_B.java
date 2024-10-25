import java.util.LinkedList;

public class LinkedList_B {
    public static void main(String[] args) {
        // Crear una LinkedList
        LinkedList<MyObject> linkedList = new LinkedList<>();

        // i. Agregar un objeto
        linkedList.add(new MyObject("las palmas", 251));
        linkedList.add(new MyObject("cerro de las rosas", 6500));
        linkedList.add(new MyObject("alberdi", 5300));

        // ii. Imprimir la LinkedList completa
        System.out.println("LinkedList completa: " + linkedList);

        // iii. Imprimir un elemento específico
        System.out.println("Elemento en el índice 0: " + linkedList.get(0));

        // iv. Borrar un elemento
        linkedList.remove(2);
        System.out.println("LinkedList después de borrar el elemento en índice 2: " + linkedList);
    }
}
