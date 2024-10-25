public class RN_sinEliminar {

    private class Nodo {
        int dato;
        Nodo izquierdo, derecho, padre;
        boolean esRojo;

        Nodo(int dato) {
            this.dato = dato;
            izquierdo = derecho = padre = null;
            esRojo = true; // Por defecto, el nuevo nodo es rojo
        }
    }

    private Nodo raiz;

    public RN_sinEliminar() {
        raiz = null;
    }

    public void insertar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        raiz = insertarNodo(raiz, nuevoNodo);
        repararInsercion(nuevoNodo);
    }

    private Nodo insertarNodo(Nodo raiz, Nodo nuevoNodo) {
        if (raiz == null) {
            return nuevoNodo;
        }
        if (nuevoNodo.dato < raiz.dato) {
            raiz.izquierdo = insertarNodo(raiz.izquierdo, nuevoNodo);
            raiz.izquierdo.padre = raiz;
        } else if (nuevoNodo.dato > raiz.dato) {
            raiz.derecho = insertarNodo(raiz.derecho, nuevoNodo);
            raiz.derecho.padre = raiz;
        }
        return raiz;
    }

    private void repararInsercion(Nodo nodo) {
        while (nodo != raiz && nodo.padre.esRojo) {
            if (nodo.padre == nodo.padre.padre.izquierdo) {
                Nodo tio = nodo.padre.padre.derecho;
                if (tio != null && tio.esRojo) {
                    nodo.padre.esRojo = false;
                    tio.esRojo = false;
                    nodo.padre.padre.esRojo = true;
                    nodo = nodo.padre.padre;
                } else {
                    if (nodo == nodo.padre.derecho) {
                        nodo = nodo.padre;
                        rotarIzquierda(nodo);
                    }
                    nodo.padre.esRojo = false;
                    nodo.padre.padre.esRojo = true;
                    rotarDerecha(nodo.padre.padre);
                }
            } else {
                Nodo tio = nodo.padre.padre.izquierdo;
                if (tio != null && tio.esRojo) {
                    nodo.padre.esRojo = false;
                    tio.esRojo = false;
                    nodo.padre.padre.esRojo = true;
                    nodo = nodo.padre.padre;
                } else {
                    if (nodo == nodo.padre.izquierdo) {
                        nodo = nodo.padre;
                        rotarDerecha(nodo);
                    }
                    nodo.padre.esRojo = false;
                    nodo.padre.padre.esRojo = true;
                    rotarIzquierda(nodo.padre.padre);
                }
            }
        }
        raiz.esRojo = false;
    }

    private void reemplazarNodo(Nodo antiguo, Nodo nuevoNodo) {
        if (antiguo.padre == null) {
            raiz = nuevoNodo;
        } else if (antiguo == antiguo.padre.izquierdo) {
            antiguo.padre.izquierdo = nuevoNodo;
        } else {
            antiguo.padre.derecho = nuevoNodo;
        }
        if (nuevoNodo != null) {
            nuevoNodo.padre = antiguo.padre;
        }
    }

    public void eliminar(int dato) {
        Nodo nodo = buscar(raiz, dato);
        if (nodo == null) {
            System.out.println("El dato no está presente en el árbol.");
            return;
        }
        Nodo nodoOriginal = nodo;
        boolean nodoOriginalColor = nodo.esRojo;
        Nodo nodoDeReemplazo;

        if (nodo.izquierdo == null) {
            nodoDeReemplazo = nodo.derecho;
            reemplazarNodo(nodo, nodo.derecho);
        } else if (nodo.derecho == null) {
            nodoDeReemplazo = nodo.izquierdo;
            reemplazarNodo(nodo, nodo.izquierdo);
        } else {
            Nodo sucesor = encontrarMinimo(nodo.derecho);
            nodoOriginalColor = sucesor.esRojo;
            nodoDeReemplazo = sucesor.derecho;
            if (sucesor.padre != nodo) {
                reemplazarNodo(sucesor, sucesor.derecho);
                sucesor.derecho = nodo.derecho;
                sucesor.derecho.padre = sucesor;
            }
            reemplazarNodo(nodo, sucesor);
            sucesor.izquierdo = nodo.izquierdo;
            sucesor.izquierdo.padre = sucesor;
            sucesor.esRojo = nodo.esRojo;
        }

        if (!nodoOriginalColor && nodoDeReemplazo != null) {
            repararEliminacion(nodoDeReemplazo);
        }
    }

    private Nodo buscar(Nodo nodo, int dato) {
        if (nodo == null || nodo.dato == dato) {
            return nodo;
        }
        if (dato < nodo.dato) {
            return buscar(nodo.izquierdo, dato);
        } else {
            return buscar(nodo.derecho, dato);
        }
    }

    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }

    private void repararEliminacion(Nodo nodo) {
        while (nodo != raiz && (nodo == null || !nodo.esRojo)) {
            if (nodo == nodo.padre.izquierdo) {
                Nodo hermano = nodo.padre.derecho;
                if (hermano != null && hermano.esRojo) {
                    hermano.esRojo = false;
                    nodo.padre.esRojo = true;
                    rotarIzquierda(nodo.padre);
                    hermano = nodo.padre.derecho;
                }
                if ((hermano.izquierdo == null || !hermano.izquierdo.esRojo) &&
                        (hermano.derecho == null || !hermano.derecho.esRojo)) {
                    if (hermano != null) hermano.esRojo = true;
                    nodo = nodo.padre;
                } else {
                    if (hermano.derecho == null || !hermano.derecho.esRojo) {
                        if (hermano.izquierdo != null) hermano.izquierdo.esRojo = false;
                        hermano.esRojo = true;
                        rotarDerecha(hermano);
                        hermano = nodo.padre.derecho;
                    }
                    if (hermano != null) hermano.esRojo = nodo.padre.esRojo;
                    nodo.padre.esRojo = false;
                    if (hermano != null && hermano.derecho != null) hermano.derecho.esRojo = false;
                    rotarIzquierda(nodo.padre);
                    nodo = raiz;
                }
            } else {
                Nodo hermano = nodo.padre.izquierdo;
                if (hermano != null && hermano.esRojo) {
                    hermano.esRojo = false;
                    nodo.padre.esRojo = true;
                    rotarDerecha(nodo.padre);
                    hermano = nodo.padre.izquierdo;
                }
                if ((hermano.derecho == null || !hermano.derecho.esRojo) &&
                        (hermano.izquierdo == null || !hermano.izquierdo.esRojo)) {
                    if (hermano != null) hermano.esRojo = true;
                    nodo = nodo.padre;
                } else {
                    if (hermano.izquierdo == null || !hermano.izquierdo.esRojo) {
                        if (hermano.derecho != null) hermano.derecho.esRojo = false;
                        hermano.esRojo = true;
                        rotarIzquierda(hermano);
                        hermano = nodo.padre.izquierdo;
                    }
                    if (hermano != null) hermano.esRojo = nodo.padre.esRojo;
                    nodo.padre.esRojo = false;
                    if (hermano != null && hermano.izquierdo != null) hermano.izquierdo.esRojo = false;
                    rotarDerecha(nodo.padre);
                    nodo = raiz;
                }
            }
        }
        if (nodo != null) nodo.esRojo = false;
    }

    private void rotarIzquierda(Nodo nodo) {
        Nodo derecho = nodo.derecho;
        nodo.derecho = derecho.izquierdo;
        if (derecho.izquierdo != null) derecho.izquierdo.padre = nodo;
        derecho.padre = nodo.padre;
        if (nodo.padre == null) raiz = derecho;
        else if (nodo == nodo.padre.izquierdo) nodo.padre.izquierdo = derecho;
        else nodo.padre.derecho = derecho;
        derecho.izquierdo = nodo;
        nodo.padre = derecho;
    }

    private void rotarDerecha(Nodo nodo) {
        Nodo izquierdo = nodo.izquierdo;
        nodo.izquierdo = izquierdo.derecho;
        if (izquierdo.derecho != null) izquierdo.derecho.padre = nodo;
        izquierdo.padre = nodo.padre;
        if (nodo.padre == null) raiz = izquierdo;
        else if (nodo == nodo.padre.derecho) nodo.padre.derecho = izquierdo;
        else nodo.padre.izquierdo = izquierdo;
        izquierdo.derecho = nodo;
        nodo.padre = izquierdo;
    }

    public void imprimirArbol() {
        imprimirInOrden(raiz);
        System.out.println();
    }

    private void imprimirInOrden(Nodo nodo) {
        if (nodo != null) {
            imprimirInOrden(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            imprimirInOrden(nodo.derecho);
        }
    }

    public static void main(String[] args) {
        RN_sinEliminar arbol = new RN_sinEliminar();
        arbol.insertar(20);
        arbol.insertar(15);
        arbol.insertar(25);
        arbol.insertar(10);
        arbol.insertar(5);
        arbol.insertar(1);
        System.out.println("Árbol en orden:");
        arbol.imprimirArbol();
        arbol.eliminar(10);
        System.out.println("Árbol después de eliminar 10:");
        arbol.imprimirArbol();
    }
}
