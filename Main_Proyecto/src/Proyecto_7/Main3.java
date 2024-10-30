package Proyecto_7;

public class Main3 {
    
    public static void ejecutar() {
        ArbolAVL arbol = new ArbolAVL();

        // Insertar los nodos del árbol según los valores dados
        arbol.insertar(4);
        arbol.insertar(2);
        arbol.insertar(30);
        arbol.insertar(1);
        arbol.insertar(10);
        arbol.insertar(50);
        arbol.insertar(5);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);

        System.out.println("Árbol AVL después de insertar todos los nodos:");
        arbol.imprimirArbol();

        // Eliminar el nodo 1
        arbol.eliminar(1);
        System.out.println("Árbol AVL después de eliminar el nodo 1:");
        arbol.imprimirArbol();

        // Eliminar el nodo 30
        arbol.eliminar(30);
        System.out.println("Árbol AVL después de eliminar el nodo 30:");
        arbol.imprimirArbol();
    }
}
