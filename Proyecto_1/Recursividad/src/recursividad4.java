
public class recursividad4 {
   
public static String invertir(String cadena) {
 
    if (cadena.isEmpty()) {
        return cadena;
    }

    return invertir(cadena.substring(1)) + cadena.charAt(0);
}

public static void main(String[] args) {
    String cadena = "Holacomoestas";
    String invertida = invertir(cadena);
    System.out.println("La cadena invertida es: "+invertida);  
}
}


