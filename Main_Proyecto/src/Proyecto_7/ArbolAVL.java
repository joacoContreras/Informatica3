package Proyecto_7;
public class ArbolAVL {
    private NodoAVL raiz;

    
    private int altura(NodoAVL nodo) {
        if (nodo==null){
            return 0;
        }else{
            return nodo.altura;
        }
    }
    private int balance(NodoAVL nodo) {
        if(nodo==null){
            return 0;
        } else {
            return altura(nodo.izq)-altura(nodo.der);
        }
    }

    // Rotación derecha
    private NodoAVL rotDer(NodoAVL y) {
        NodoAVL x = y.izq;
        y.izq = x.der;
        x.der = y;

        // Actualizar alturas
        y.altura=Math.max(altura(y.izq),altura(y.der))+1;
        x.altura=Math.max(altura(x.izq),altura(x.der))+1;

        return x;
    }

    // Rotación izquierda
    private NodoAVL rotIzq(NodoAVL x) {
        NodoAVL y=x.der;
        x.der=y.izq;
        y.izq=x;

        // Actualizar alturas
        x.altura=Math.max(altura(x.izq), altura(x.der))+1;
        y.altura=Math.max(altura(y.izq), altura(y.der))+1;

        return y;
    }

    // Rotación doble izquierda-derecha
    private NodoAVL rotIzqDer(NodoAVL nodo) {
        nodo.izq=rotIzq(nodo.izq);
        return rotDer(nodo);
    }

    // Rotación doble derecha-izquierda
    private NodoAVL rotDerIzq(NodoAVL nodo) {
        nodo.der=rotDer(nodo.der);
        return rotIzq(nodo);
    }

    // Método de inserción
    public NodoAVL insertar(NodoAVL nodo, int valor) {
        if (nodo==null) {
            return new NodoAVL(valor);
        }

        if (valor<nodo.valor) {
            nodo.izq=insertar(nodo.izq,valor);
        } else if(valor>nodo.valor){
            nodo.der=insertar(nodo.der, valor);
        } else{
            return nodo;
        }

        // Actualizar la altura del nodo actual
        nodo.altura=Math.max(altura(nodo.izq),altura(nodo.der))+1;

        // Obtener el balance del nodo
        int balance=balance(nodo);

        // Verificar si el nodo se desbalanceó y realizar rotaciones
        // Caso Izquierda Izquierda
        if(balance>1&&valor<nodo.izq.valor){
            return rotDer(nodo);
        }

        // Caso Derecha Derecha
        if(balance<-1&&valor>nodo.der.valor) {
            return rotIzq(nodo);
        }

        // Caso Izquierda Derecha
        if (balance>1&&valor>nodo.izq.valor) {
            nodo.izq=rotIzq(nodo.izq);
            return rotDer(nodo);
        }

        // Caso Derecha Izquierda
        if(balance<-1&&valor<nodo.der.valor){
            nodo.der=rotDer(nodo.der);
            return rotIzq(nodo);
        }

        return nodo;
    }

    // Método para eliminar un nodo
    public NodoAVL eliminar(NodoAVL nodo,int valor) {
        if(nodo==null) {
            return nodo;
        }

        if(valor<nodo.valor){
            nodo.izq = eliminar(nodo.izq, valor);
        } else if(valor>nodo.valor){
            nodo.der=eliminar(nodo.der,valor);
        } else{
           
            if(nodo.izq==null||nodo.der==null){
                NodoAVL temp=(nodo.izq!=null)?nodo.izq:nodo.der;

                if(temp==null){ // No tiene hijos
                    nodo = null;
                } else { // Un hijo
                    nodo=temp;
                }
            } else {
                // Nodo con dos hijos, obtener el sucesor
                NodoAVL temp = obtenerMinimoValor(nodo.der);
                nodo.valor=temp.valor;
                nodo.der=eliminar(nodo.der, temp.valor);
            }
        }
        if (nodo==null) {
            return nodo;
        }

        // Actualizar la altura
        nodo.altura=Math.max(altura(nodo.izq),altura(nodo.der))+1;

        // Obtener el balance del nodo
        int balance=balance(nodo);

        // Verificar si el nodo se desbalanceó y realizar rotaciones
        // Caso Izquierda Izquierda
        if (balance>1&&balance(nodo.izq)>= 0){
            return rotDer(nodo);
        }

        // Caso Izquierda Derecha
        if (balance>1&&balance(nodo.izq)<0){
            nodo.izq=rotIzq(nodo.izq);
            return rotDer(nodo);
        }

        // Caso Derecha Derecha
        if(balance<-1&&balance(nodo.der)<= 0){
            return rotIzq(nodo);
        }

        // Caso Derecha Izquierda
        if(balance<-1&&balance(nodo.der)>0){
            nodo.der=rotDer(nodo.der);
            return rotIzq(nodo);
        }

        return nodo;
    }

    // Método para obtener el valor mínimo de un subárbol
    private NodoAVL obtenerMinimoValor(NodoAVL nodo) {
        NodoAVL actual=nodo;
        while (actual.izq!=null) {
            actual=actual.izq;
        }
        return actual;
    }

    // Método para insertar un valor en el árbol
    public void insertar(int valor) {
        raiz=insertar(raiz, valor);
    }

     //eliminar un valor del árbol
    public void eliminar(int valor){
        raiz=eliminar(raiz,valor);
    }

    // Método para imprimir el árbol
    private void imprimirArbol(NodoAVL nodo, String prefijo, boolean esIzquierdo) {
        if (nodo != null) {
            System.out.println(prefijo + (esIzquierdo ? "+-- " : "\\-- ") + nodo.valor);
            imprimirArbol(nodo.izq, prefijo + (esIzquierdo ? "|   " : "    "), true);
            imprimirArbol(nodo.der, prefijo + (esIzquierdo ? "|   " : "    "), false);
        }
    }

    // Método público para imprimir el árbol a partir de la raíz
    public void imprimirArbol() {
        imprimirArbol(raiz, "", false);
    }
}
