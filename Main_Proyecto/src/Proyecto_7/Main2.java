package Proyecto_7;

import java.util.Scanner;

public class Main2 {  // Punto 3
    
    public static void ejecutar() {
        ArbolAVL arbol = new ArbolAVL();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese la cantidad de elementos que desea insertar en el árbol AVL:");
        int cantidad = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese los elementos del árbol AVL:");
        for (int i = 0; i < cantidad; i++) {
            int elemento = scanner.nextInt();
            scanner.nextLine();
            arbol.insertar(elemento);
        }
        
        System.out.println("Arbol AVL en orden:");
        arbol.imprimirArbol();
        
    }
}
