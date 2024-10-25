
public class MyObject {
    private String name;
    private int value;

    public MyObject(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Clave { nombre = '" + name + "', contraseña = " + value + " }";
    }
}
