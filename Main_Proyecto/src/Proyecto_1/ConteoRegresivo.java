package Proyecto_1;

public class ConteoRegresivo {
    public static void conteo(int n) {
        System.out.print("n = " + n + ": ");
        recursiva(n);
        System.out.println("\n");
    }

    private static void recursiva(int n){
        if (n > 0) {
            n -= 1;
            System.out.print(n +", ");
            recursiva(n);
        }
    }
}
