import java.util.HashMap;
public class HashMap_C {
    public static void main(String[] args) {
        // Crear un HashMap
        HashMap<String, MyObject> hashMap = new HashMap<>();

        // i. Agregar un objeto
        hashMap.put("telefono1", new MyObject("Juan", 35156865));
        hashMap.put("telefono2", new MyObject("Pedro", 3515531));
        hashMap.put("telefono3", new MyObject("Carla", 35198674));
        // ii. Imprimir el HashMap completo
        System.out.println("HashMap completo: " + hashMap);

        // iii. Imprimir un elemento específico
        System.out.println("telefono1= " + hashMap.get("telefono1"));

        // iv. Borrar un elemento
        hashMap.remove("telefono1");
        System.out.println("HashMap después de borrar 'telefono1': " + hashMap);
    }
}
