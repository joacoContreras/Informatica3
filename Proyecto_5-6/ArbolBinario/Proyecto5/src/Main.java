import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArbolBinario arbol = new ArbolBinario();
        Scanner consola = new Scanner(System.in);
        boolean sistemaActivo = true;

        do {
            System.out.println("\nBienvenido al sistema Arbol-Binario");
            System.out.println("--------------------------------------");
            System.out.println("0- Salir");
            System.out.println("1- Agregar Nodo");
            System.out.println("2- Recorrido InOrden");
            System.out.println("3- Recorrido PreOrden");
            System.out.println("4- Recorrido PostOrden");
            System.out.println("5- Dtree");
            System.out.println("6- Buscar Nodo raiz");
            System.out.println("7- Calcular profundidad");
            System.out.println("8- Imprimir arbol");
            System.out.println("Ingrese opcion: ");
            int opcion = consola.nextInt();
            consola.nextLine();
            switch (opcion) {
                case 0:
                    sistemaActivo = false;
                    break;
                case 1:
                    System.out.println("Ingrese un valor entero para agregar al arbol: ");
                    int nuevoNodo = consola.nextInt();
                    consola.nextLine();
                    arbol.agregar(nuevoNodo);
                    break;
                case 2:
                    System.out.println("inOrdenRecursivo");
                    arbol.InOrden();
                    break;
                case 3:
                    System.out.println("preOrdenRecursivo");
                    arbol.PreOrden();
                    break;
                case 4:
                    System.out.println("PostOrdenRecursivo:");
                    arbol.PostOrden();
                    break;
                case 5:
                    System.out.println("Ingresa valor del nodo a eliminar:");
                    int target = consola.nextInt();
                    consola.nextLine();
                    arbol.buscar(target);
                    break;
                case 6:
                    System.out.println("El valor de la raiz del arbol es: " + arbol.raiz.valor);
                    break;
                case 7:
                    int depth = arbol.depth();
                    System.out.println("El arbol posee " + depth + " niveles");
                default:
                case 8:
                System.out.println("Arbol Binario: ");
                    arbol.impArbol();
                    break;
            }
            
        } while (sistemaActivo == true);
        
    }
}
