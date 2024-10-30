package Proyecto_4;
import java.util.Scanner;
public class Main4 {
    public static void main(String[] args) {
        boolean sistemaActivo = true;
        do {
            System.out.println("\nBienvenido al Proyecto 4");
            System.out.println("------------------------");
            System.out.println("0. Salir");
            System.out.println("1. Implementacion de Pila con Lista");
            System.out.println("2. Pila de Palabras");
            System.out.println("3. Verificación de Paréntesis");
            System.out.println("4. Conversión de Decimal a Binario");
            System.out.println("5. Implementacion de una Cola con Lista");
            System.out.println("6. Cola de Numeros");
            System.out.println("7. Ordenamiento de Cola");
            System.out.println("8. Verificación de Palíndromos con cola");
            System.out.println("Tu opcion: ");
            Scanner consola = new Scanner(System.in);
            int opcion = consola.nextInt();
            consola.nextLine();
            switch (opcion) {
                case 0:
                    sistemaActivo = false;
                break;

                case 1:
                    PIL_Pila<Integer> pila = new PIL_Pila<>();
                    boolean pilaOn = true;
                    do {
                        System.out.println("\nPila con Lista");
                        System.out.println("...............");
                        System.out.println("0. Salir");
                        System.out.println("1. Push");
                        System.out.println("2. Pop");
                        System.out.println("3. Top");
                        System.out.print("Tu opcion: ");
                        int opcion1 = consola.nextInt();
                        consola.nextLine();
                        switch (opcion1) {
                            case 0:
                                pilaOn = false;
                                break;
                            case 1:
                                    pila.push(IngresarN());
                                break;
                            case 2:
                                    System.out.println("Elemento eliminado (pop): " + pila.pop());
                                break;
                            case 3:
                                    System.out.println("Elemento en la cima (top): " + pila.top());
                                break;
                            default:
                                    System.out.println("Error....");
                                break;
                        }
                    } while (pilaOn);
                break;

                case 2:
                    PIL_MainPilasPalabras.main();                  
                break;
                
                case 3:
                    PIL_VerificacionParentesis.main();
                break;
                case 4:
                    PIL_DecimalABinario.main();
                break;

                case 5:
                    ColaLista cola = new ColaLista();
                    boolean colaOn = true;
                    do {
                        System.out.println("\nCola con Lista");
                        System.out.println("...............");
                        System.out.println("0. Salir");
                        System.out.println("1. Enqueue");
                        System.out.println("2. Dequeue");
                        System.out.println("3. Top");
                        System.out.print("Tu opcion: ");
                        int opcion1 = consola.nextInt();
                        consola.nextLine();
                        switch (opcion1) {
                            case 0:
                                colaOn = false;
                                break;
                            case 1:
                                cola.enqueue(IngresarN());
                                break;
                            case 2:
                                cola.dequeue();
                                break;
                            case 3:
                                System.out.println("Elemento en el frente: " + cola.top());
                                break;
                            default:
                                System.out.println("Error....");
                                break;
                        }
                    } while (colaOn);
                break;
                case 6:
                    ColaLista cola2 = new ColaLista();
                    boolean colaOn2 = true;
                    do {
                        System.out.println("\nCola de Numeros");
                        System.out.println("...............");
                        System.out.println("0. Salir");
                        System.out.println("1. Enqueue");
                        System.out.println("2. Dequeue y sumar todos los elementos");
                        System.out.print("Tu opcion: ");
                        int opcion2 = consola.nextInt();
                        consola.nextLine();
                        switch (opcion2) {
                            case 0:
                                colaOn2 = false;
                                break;
                            case 1:
                                cola2.enqueue(IngresarN());
                                break;
                            case 2:
                                cola2.dequeueSum();
                                break;
                            default:
                                System.out.println("Error....");
                                break;
                        }
                    } while (colaOn2);
                break;

                case 7:
                    OrdenamientoConCola.OrdenamientoCC();
                break;
                case 8:
                    System.out.println("Ingresar una frase o palabra: ");
                    String texto = consola.nextLine();
                    if (COL_VerificacionPalindromos.esPalindromo(texto)) {
                        System.out.println("La frase es un palíndromo.");
                    } else {
                        System.out.println("La frase no es un palíndromo.");
                    }
                    break;
                default:
                        System.out.println("Error...");
                break;
            }
        } while (sistemaActivo);
        
    }

    public static int IngresarN(){
        Scanner consola = new Scanner(System.in);
        System.out.println("Ingresar numero entero: ");
        int n = consola.nextInt();
        consola.nextLine();
        return n;
    }
}
