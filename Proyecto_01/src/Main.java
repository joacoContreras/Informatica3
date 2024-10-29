import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean sistemaActivo = true;
        do {
            System.out.println("\nBienvenido al Proyecto 1");
            System.out.println("------------------------");
            System.out.println("0. Salir");
            System.out.println("1. Calcular Factorial");
            System.out.println("2. Calcular la suma de los primeros n enteros positivos");
            System.out.println("3. Calcular Potencia de un numero");
            System.out.println("4. Conteo Regresivo desde un numero n hasta 1");
            System.out.println("5. Calcular Producto de dos numeros enteros usando sumas sucesivas");
            System.out.println("6. Imprimir elementos de un arreglo en orden inverso");
            System.out.println("7. Devuelva el número de unos en la representación binaria de N.");
            System.out.println("Tu opcion: ");
            Scanner consola = new Scanner(System.in);
            int opcion = consola.nextInt();
            consola.nextLine();
            switch (opcion) {
                case 0:
                    sistemaActivo = false;
                    consola.close();
                break;

                case 1:
                    Factorial.imprimir(ingresarN());
                break;

                case 2:                    
                    SumaNumerosNaturales.suma(ingresarN());
                break;
                
                case 3:
                    System.out.println("...Primer input para n, segundo input para la potencia...");
                    PotenciaDeNumero.pow(ingresarN(),ingresarN());
                break;

                case 4:
                    ConteoRegresivo.conteo(ingresarN());
                break;
                
                case 5:
                    System.out.println("Ingrese dos numeros. Por ejemplo, 2 (primer numero) x 4 (segundo numero) = 2+2+2+2 = 8");
                    SumasSucesivas.main(ingresarN(), ingresarN());
                break;
                
                case 6:
                    System.out.println("Ingresar size del arreglo: ");
                    int size = ingresarN();
                    int[] array = new int[size];
                    System.out.println("Ingresa numeros enteros en el arreglo:");
                    for (int index = 0; index < size; index++) {
                        array[index] = ingresarN();
                    }
                    ImprimirInverso.main(array);

                break;

                case 7:
                    ContarUnosBinarios.main(ingresarN());
                break;
                
                default:
                        System.out.println("Error...");
                break;
            }
        } while (sistemaActivo);
        
    }

    private static int ingresarN() {
        System.out.print("Ingrese n: ");
        Scanner consola = new Scanner(System.in);
        int n = consola.nextInt();
        return n;
    }

}
