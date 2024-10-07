public class ArbolAVL {
    private NodoAVL raiz;

    // Obtener la altura de un nodo
    private int altura(NodoAVL nodo) {
        return nodo == null ? 0 : nodo.altura;
    }

    // Obtener el factor de equilibrio de un nodo
    private int obtenerBalance(NodoAVL nodo) {
        return nodo == null ? 0 : altura(nodo.izquierda) - altura(nodo.derecha);
    }

    // Rotación derecha
    private NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.izquierda;
        NodoAVL T2 = x.derecha;

        // Realizar la rotación
        x.derecha = y;
        y.izquierda = T2;

        // Actualizar alturas
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;
        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;

        return x;
    }

    // Rotación izquierda
    private NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.derecha;
        NodoAVL T2 = y.izquierda;

        // Realizar la rotación
        y.izquierda = x;
        x.derecha = T2;

        // Actualizar alturas
        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;

        return y;
    }
    
    // Rotación doble izquierda-derecha
private NodoAVL rotacionIzquierdaDerecha(NodoAVL nodo) {
    // Primero, rotación izquierda en el hijo izquierdo
    nodo.izquierda = rotacionIzquierda(nodo.izquierda);
    // Luego, rotación derecha en el nodo
    return rotacionDerecha(nodo);
}

    
 // Rotación doble derecha-izquierda
private NodoAVL rotacionDerechaIzquierda(NodoAVL nodo) {
    // Primero, rotación derecha en el hijo derecho
    nodo.derecha = rotacionDerecha(nodo.derecha);
    // Luego, rotación izquierda en el nodo
    return rotacionIzquierda(nodo);
}
    // Método de inserción
    public NodoAVL insertar(NodoAVL nodo, int valor) {
        // Realizar inserción estándar en árbol binario de búsqueda
        if (nodo == null) {
            return new NodoAVL(valor);
        }

        if (valor < nodo.valor) {
            nodo.izquierda = insertar(nodo.izquierda, valor);
        } else if (valor > nodo.valor) {
            nodo.derecha = insertar(nodo.derecha, valor);
        } else {
            return nodo; // Valores duplicados no permitidos
        }

        // Actualizar la altura del nodo actual
        nodo.altura = Math.max(altura(nodo.izquierda), altura(nodo.derecha)) + 1;

        // Obtener el factor de equilibrio
        int balance = obtenerBalance(nodo);

        // Verificar si el nodo se desbalanceó y realizar rotaciones
        // Caso Izquierda Izquierda
        if (balance > 1 && valor < nodo.izquierda.valor) {
            return rotacionDerecha(nodo);
        }

        // Caso Derecha Derecha
        if (balance < -1 && valor > nodo.derecha.valor) {
            return rotacionIzquierda(nodo);
        }

        // Caso Izquierda Derecha
        if (balance > 1 && valor > nodo.izquierda.valor) {
            nodo.izquierda = rotacionIzquierda(nodo.izquierda);
            return rotacionDerecha(nodo);
        }

        // Caso Derecha Izquierda
        if (balance < -1 && valor < nodo.derecha.valor) {
            nodo.derecha = rotacionDerecha(nodo.derecha);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    // Método para eliminar un nodo
    public NodoAVL eliminar(NodoAVL nodo, int valor) {
        // Realizar eliminación estándar en árbol binario de búsqueda
        if (nodo == null) {
            return nodo;
        }

        if (valor < nodo.valor) {
            nodo.izquierda = eliminar(nodo.izquierda, valor);
        } else if (valor > nodo.valor) {
            nodo.derecha = eliminar(nodo.derecha, valor);
        } else {
            // Nodo con un solo hijo o sin hijos
            if ((nodo.izquierda == null) || (nodo.derecha == null)) {
                NodoAVL temp = (nodo.izquierda != null) ? nodo.izquierda : nodo.derecha;

                if (temp == null) { // No tiene hijos
                    nodo = null;
                } else { // Un hijo
                    nodo = temp;
                }
            } else {
                // Nodo con dos hijos, obtener el sucesor
                NodoAVL temp = obtenerMinimoValor(nodo.derecha);

                // Copiar el valor del sucesor
                nodo.valor = temp.valor;

                // Eliminar el sucesor
                nodo.derecha = eliminar(nodo.derecha, temp.valor);
            }
        }

        // Si el nodo es null, retornar
        if (nodo == null) {
            return nodo;
        }

        // Actualizar la altura
        nodo.altura = Math.max(altura(nodo.izquierda), altura(nodo.derecha)) + 1;

        // Obtener el factor de equilibrio
        int balance = obtenerBalance(nodo);

        // Verificar si el nodo se desbalanceó y realizar rotaciones
        // Caso Izquierda Izquierda
        if (balance > 1 && obtenerBalance(nodo.izquierda) >= 0) {
            return rotacionDerecha(nodo);
        }

        // Caso Izquierda Derecha
        if (balance > 1 && obtenerBalance(nodo.izquierda) < 0) {
            nodo.izquierda = rotacionIzquierda(nodo.izquierda);
            return rotacionDerecha(nodo);
        }

        // Caso Derecha Derecha
        if (balance < -1 && obtenerBalance(nodo.derecha) <= 0) {
            return rotacionIzquierda(nodo);
        }

        // Caso Derecha Izquierda
        if (balance < -1 && obtenerBalance(nodo.derecha) > 0) {
            nodo.derecha = rotacionDerecha(nodo.derecha);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    // Método para obtener el valor mínimo de un subárbol
    private NodoAVL obtenerMinimoValor(NodoAVL nodo) {
        NodoAVL actual = nodo;

        while (actual.izquierda != null) {
            actual = actual.izquierda;
        }

        return actual;
    }

    // Método para insertar un valor en el árbol
    public void insertar(int valor) {
        raiz = insertar(raiz, valor);
    }

    // Método para eliminar un valor del árbol
    public void eliminar(int valor) {
        raiz = eliminar(raiz, valor);
    }

 private void imprimirArbol(NodoAVL nodo, String prefijo, boolean esIzquierdo) {
    if (nodo != null) {
        System.out.println(prefijo + (esIzquierdo ? "+-- " : "\\-- ") + nodo.valor);
        imprimirArbol(nodo.izquierda, prefijo + (esIzquierdo ? "|   " : "    "), true);
        imprimirArbol(nodo.derecha, prefijo + (esIzquierdo ? "|   " : "    "), false);
    }
}

    // Método público para imprimir el árbol a partir de la raíz
    public void imprimirArbol() {
        imprimirArbol(raiz, "", false);
    }
}