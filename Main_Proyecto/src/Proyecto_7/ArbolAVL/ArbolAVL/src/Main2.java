public class Main2 {  //Punto 3
    
        
      public static void main(String[] args) {
        ArbolAVL arbol = new ArbolAVL();
        
        arbol.insertar(5);
        arbol.insertar(10);
        arbol.insertar(20);
        arbol.insertar(30);
        arbol.insertar(40);
        arbol.insertar(50);
        arbol.insertar(60);
       
        System.out.println("Arbol AVL en orden:");
        arbol.imprimirArbol();
        
 
    }
    
}
