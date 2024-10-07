public class Main {  // Punto 2
    
    
      public static void main(String[] args) {
        ArbolAVL arbol = new ArbolAVL();
        
        arbol.insertar(10);
        arbol.insertar(100);
        arbol.insertar(20);
        arbol.insertar(80);
        arbol.insertar(40);
        arbol.insertar(70);

        System.out.println("Arbol AVL en orden:");
        arbol.imprimirArbol();

       
    }
}
    

