package Proyecto_8;

import java.util.Scanner;

// Clase Nodo del Árbol Rojinegro
class Nodo {
    int dato;
    Nodo izquierdo, derecho, padre;
    boolean esRojo; // true para rojo, false para negro

    public Nodo(int dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
        this.padre = null;
        this.esRojo = true; // Por defecto, los nodos se insertan como rojos
    }
}

// Clase Árbol Rojinegro
public class ArbolRojinegro13 {
    private Nodo raiz;

    // Constructor del árbol
    public ArbolRojinegro13() {
        raiz = null;
    }
    // Método para verificar si el árbol cumple con las propiedades rojinegras
public boolean verificarPropiedadesRojinegras() {
    if (raiz == null) {
        return true; // Un árbol vacío es válido
    }
    // La raíz debe ser negra
    if (raiz.esRojo) {
        return false;
    }
    // Verifica propiedades del árbol rojinegro
    return verificarPropiedades(raiz) && verificarAlturaNegra(raiz) != -1;
}

// Verifica que los hijos de nodos rojos sean negros
private boolean verificarPropiedades(Nodo nodo) {
    if (nodo == null) {
        return true;
    }

    // Si el nodo es rojo, sus hijos deben ser negros
    if (nodo.esRojo) {
        if ((nodo.izquierdo != null && nodo.izquierdo.esRojo) || (nodo.derecho != null && nodo.derecho.esRojo)) {
            return false;
        }
    }

    // Verifica recursivamente para los subárboles izquierdo y derecho
    return verificarPropiedades(nodo.izquierdo) && verificarPropiedades(nodo.derecho);
}

// Verifica que todos los caminos hasta las hojas tengan la misma cantidad de nodos negros
private int verificarAlturaNegra(Nodo nodo) {
    if (nodo == null) {
        return 0; // Altura negra de un nodo nulo es 0
    }

    int alturaIzquierda = verificarAlturaNegra(nodo.izquierdo);
    int alturaDerecha = verificarAlturaNegra(nodo.derecho);

    // Si alguna de las sub-alturas es -1, significa que hay un error en la altura negra
    if (alturaIzquierda == -1 || alturaDerecha == -1 || alturaIzquierda != alturaDerecha) {
        return -1;
    }

    // Si el nodo es negro, incrementa la altura negra en 1
    return alturaIzquierda + (nodo.esRojo ? 0 : 1);
    }


    // Rotación hacia la izquierda
    private void rotarIzquierda(Nodo nodo) {
        Nodo derecho = nodo.derecho;
        nodo.derecho = derecho.izquierdo;
        if (derecho.izquierdo != null) {
            derecho.izquierdo.padre = nodo;
        }
        derecho.padre = nodo.padre;
        if (nodo.padre == null) {
            raiz = derecho;
        } else if (nodo == nodo.padre.izquierdo) {
            nodo.padre.izquierdo = derecho;
        } else {
            nodo.padre.derecho = derecho;
        }
        derecho.izquierdo = nodo;
        nodo.padre = derecho;
    }

    // Rotación hacia la derecha
    private void rotarDerecha(Nodo nodo) {
        Nodo izquierdo = nodo.izquierdo;
        nodo.izquierdo = izquierdo.derecho;
        if (izquierdo.derecho != null) {
            izquierdo.derecho.padre = nodo;
        }
        izquierdo.padre = nodo.padre;
        if (nodo.padre == null) {
            raiz = izquierdo;
        } else if (nodo == nodo.padre.derecho) {
            nodo.padre.derecho = izquierdo;
        } else {
            nodo.padre.izquierdo = izquierdo;
        }
        izquierdo.derecho = nodo;
        nodo.padre = izquierdo;
    }

    // Método para insertar un nodo en el árbol
    public void insertar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (raiz == null) {
            nuevo.esRojo = false; // La raíz siempre debe ser negra
            raiz = nuevo;
        } else {
            Nodo temp = raiz;
            Nodo padre = null;
            while (temp != null) {
                padre = temp;
                if (dato < temp.dato) {
                    temp = temp.izquierdo;
                } else {
                    temp = temp.derecho;
                }
            }
            nuevo.padre = padre;
            if (dato < padre.dato) {
                padre.izquierdo = nuevo;
            } else {
                padre.derecho = nuevo;
            }
            arreglarInsercion(nuevo);
        }
    }

    // Método para arreglar las propiedades rojinegras después de insertar un nodo
    private void arreglarInsercion(Nodo nodo) {
        while (nodo != raiz && nodo.padre.esRojo) {
            Nodo abuelo = nodo.padre.padre;
            if (nodo.padre == abuelo.izquierdo) {
                Nodo tio = abuelo.derecho;
                if (tio != null && tio.esRojo) {
                    nodo.padre.esRojo = false;
                    tio.esRojo = false;
                    abuelo.esRojo = true;
                    nodo = abuelo;
                } else {
                    if (nodo == nodo.padre.derecho) {
                        nodo = nodo.padre;
                        rotarIzquierda(nodo);
                    }
                    nodo.padre.esRojo = false;
                    abuelo.esRojo = true;
                    rotarDerecha(abuelo);
                }
            } else {
                Nodo tio = abuelo.izquierdo;
                if (tio != null && tio.esRojo) {
                    nodo.padre.esRojo = false;
                    tio.esRojo = false;
                    abuelo.esRojo = true;
                    nodo = abuelo;
                } else {
                    if (nodo == nodo.padre.izquierdo) {
                        nodo = nodo.padre;
                        rotarDerecha(nodo);
                    }
                    nodo.padre.esRojo = false;
                    abuelo.esRojo = true;
                    rotarIzquierda(abuelo);
                }
            }
        }
        raiz.esRojo = false; // La raíz siempre debe ser negra
    }
     // Método modificado para mostrar el árbol con etiquetas de subárboles
    public void mostrar(Nodo nodo, String indentacion, boolean esDerecho, boolean esRaiz) {
    if (nodo != null) {
        if (esRaiz) {
            System.out.println(nodo.dato + (nodo.esRojo ? " (Rojo)" : " (Negro) [Raíz]"));
        } else if (esDerecho) {
            System.out.println(indentacion + "+-- " + nodo.dato + (nodo.esRojo ? " (Rojo)" : " (Negro)") + " [Subárbol Derecho]");
        } else {
            System.out.println(indentacion + "+-- " + nodo.dato + (nodo.esRojo ? " (Rojo)" : " (Negro)") + " [Subárbol Izquierdo]");
        }
        mostrar(nodo.izquierdo, indentacion + (esDerecho ? "    " : "|   "), false, false);
        mostrar(nodo.derecho, indentacion + (esDerecho ? "    " : "|   "), true, false);
    }
    }
     // Método para obtener la raíz del árbol
    public Nodo getRaiz() {
        return raiz;
    }
     // Método para calcular la mayor altura negra del árbol
    public int calcularAlturaNegra() {
        return calcularAlturaNegra(raiz);
    }

    // Método privado recursivo para calcular la altura negra
    private int calcularAlturaNegra(Nodo nodo) {
        if (nodo == null) {
            return 0; // Si el nodo es nulo, la altura negra es 0
        }

        // Calculamos la altura negra de los subárboles izquierdo y derecho
        int alturaIzquierda = calcularAlturaNegra(nodo.izquierdo);
        int alturaDerecha = calcularAlturaNegra(nodo.derecho);

        // Tomamos el mayor valor entre las alturas de los subárboles
        int alturaMaxima = Math.max(alturaIzquierda, alturaDerecha);

        // Si el nodo actual es negro, sumamos 1 a la altura
        if (!nodo.esRojo) {
            alturaMaxima++;
        }

        return alturaMaxima;
    }

    


    // Método principal
    public static void main(String[] args) {
        ArbolRojinegro13 arbol = new ArbolRojinegro13();
        Scanner scanner= new Scanner(System.in);
        System.out.println("ingrese la cantidad de nodos:");
        int cantidad= scanner.nextInt();
        // Insertar valores
        for(int i=0;i<cantidad;i++){
        System.out.println("ingrese valor del nodo:");
        int insertar= scanner.nextInt();
        arbol.insertar(insertar);
        System.out.println("-------------------------------------------------");
        System.out.println("Árbol en forma de árbol (estructura jerárquica): ");
        arbol.mostrar(arbol.getRaiz(), "", true, true);
    }
        int alturaNegra = arbol.calcularAlturaNegra();
        System.out.println("La mayor altura negra del árbol es: " + alturaNegra);
        if (arbol.verificarPropiedadesRojinegras()) {
            System.out.println("El árbol cumple con todas las propiedades de un árbol rojinegro.");
         } else {
            System.out.println("El árbol NO cumple con las propiedades de un árbol rojinegro.");
        }

        
    }
}