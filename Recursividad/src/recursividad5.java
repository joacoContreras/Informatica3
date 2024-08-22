
import java.util.Scanner;

public class recursividad5 {
      public static  int funcion(int numero, int p){
       if(p==0){
           return 1;
       }else{
           return numero*funcion(numero,(p-1));
       }
   } 
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        int valor=scanner.nextInt();
        System.out.println("Ingrese la potencia: ");
        int p=scanner.nextInt();
        int c=funcion(valor,p);
        System.out.println("El factorial es: "+c);
    }
}
