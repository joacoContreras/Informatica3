
import java.util.Scanner;

public class recursividad1 {
   public static  int funcion(int numero){
       if(numero<=1){
           return 1;
       }else{
           return numero*funcion(numero-1);
       }
   } 
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        int valor=scanner.nextInt();
        int c=funcion(valor);
        System.out.println("El factorial es: "+c);
    }
}