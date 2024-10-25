import java.util.TreeMap;
public class TreeMap_D {
    public static void main(String[] args) {
        TreeMap<String, MyObject> treeMap = new TreeMap<>();
        treeMap.put("auto1", new MyObject("bora", 400000));
        treeMap.put("auto2", new MyObject("gol", 550000));
        treeMap.put("auto3", new MyObject("golf", 650000));
        System.out.println("TreeMap completo: " + treeMap);
        System.out.println("vehiculo 3 " + treeMap.get("auto3"));
        treeMap.remove("auto2");
        System.out.println("TreeMap después de borrar el vehiculo 2: " + treeMap);
    }
}
