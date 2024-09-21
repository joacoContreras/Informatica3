public class ArbolBinario {
    Nodo raiz;

    // Constructor
    public ArbolBinario() {
        raiz = null;
    }

    // Metodo para insertar un nuevo nodo en el arbol
    public void agregar(int valor) {
        raiz = agregarRecursivo(raiz, valor);
    }

    private Nodo agregarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }

        if (valor < actual.valor) {
            actual.izquierdo = agregarRecursivo(actual.izquierdo, valor);
        } 
        else if(valor > actual.valor) {
            actual.derecho = agregarRecursivo(actual.derecho, valor);
        }

        return actual;
    }
    public void buscar(int valor) {
        boolean esta = buscarRecursivo(raiz, valor);
        if (esta == false) {
            System.out.println("No se encontro el valor ingresado");
        } 
        else {
            eliminar(raiz, valor);
        } 
    }

    // Metodo recursivo para buscar un valor
    private boolean buscarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return false;
        }

        if (valor == actual.valor) {
            return true;
        }

        return valor < actual.valor
            ? buscarRecursivo(actual.izquierdo, valor) // Es verdadero?  
            : buscarRecursivo(actual.derecho, valor); // Si lo de arriba es falso, procede
    }

    // Método para eliminar un nodo
    private Nodo eliminar(Nodo nodo, int valor) {
        // Caso base: si el árbol está vacío
        if (nodo == null) {
            return nodo;
        }

        // Recursivamente buscar el nodo a eliminar
        if (valor < nodo.valor) {
            nodo.izquierdo = eliminar(nodo.izquierdo, valor);
        } 
        else if (valor > nodo.valor) {
            nodo.derecho = eliminar(nodo.derecho, valor);
        } 
        else {
            // Nodo encontrado
            // Caso 1: Nodo con solo un hijo o sin hijo
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            } 
            else if (nodo.derecho == null) {
                return nodo.izquierdo;
            }

            // Caso 2: Nodo con dos hijos
            // Obtener el sucesor inorden (mínimo en el subárbol derecho)
            nodo.valor = encontrarMinimo(nodo.derecho);

            // Eliminar el sucesor inorden
            nodo.derecho = eliminar(nodo.derecho, nodo.valor);
        }
        return nodo;
    }

    // Método para encontrar el valor mínimo en un subárbol
    private int encontrarMinimo(Nodo nodo) {
        int min = nodo.valor;
        while (nodo.izquierdo != null) {
            min = nodo.izquierdo.valor;
            nodo = nodo.izquierdo;
        }
        return min;
    }

    // Recorrido InOrden(izq, raiz, der)
    public void InOrden() {
        inOrdenRecursivo(raiz);
    }

    private void inOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            inOrdenRecursivo(nodo.izquierdo);
            System.out.println(nodo.valor + " ");
            inOrdenRecursivo(nodo.derecho);
        }
    }

    // Recorrido PreOrden (raiz, izq, der)
    public void PreOrden() {
        preOrdenRecursivo(raiz);
    }
    
    private void preOrdenRecursivo(Nodo nodo) {
        if (nodo!=null) {
            System.out.println(nodo.valor + " ");
            preOrdenRecursivo(nodo.izquierdo);
            preOrdenRecursivo(nodo.derecho);
        }
    }

    // Recorrido PostOrden (izq, der, raiz)
    public void PostOrden() {
        PostOrdenRecursivo(raiz);
    }

    private void PostOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            PostOrdenRecursivo(nodo.izquierdo);
            PostOrdenRecursivo(nodo.derecho);
            System.out.println(nodo.valor + " ");
        }
    }

    public int depth() {
        return depthRecursivo(raiz);
    }
    
    private int depthRecursivo(Nodo actual) {
        if (actual == null) {
            return 0;  // Si no hay nodo, la profundidad es 0
        } else {
            // Calcula la profundidad de los subárboles izquierdo y derecho
            int profundidadIzquierda = depthRecursivo(actual.izquierdo);
            int profundidadDerecha = depthRecursivo(actual.derecho);
    
            // Devuelve la mayor profundidad + 1 (para el nodo actual)
            return Math.max(profundidadIzquierda, profundidadDerecha) + 1; // Devuelve el valor maximo entre dos numeros + 1
        }
    }

    public void impArbol() {
        imprimirArbol(raiz, "");
    }
    private void imprimirArbol(Nodo nodo, String prefijo) {
        if (nodo != null) {
            System.out.println(prefijo + nodo.valor);
            if (nodo.izquierdo != null || nodo.derecho != null) {
                if (nodo.derecho != null) {
                    imprimirArbol(nodo.derecho, prefijo + "  ┌─ ");
                }
                if (nodo.izquierdo != null) {
                    imprimirArbol(nodo.izquierdo, prefijo + "  └─ ");
                }
            }
        }
    }
    
}