package Proyecto_9;

import java.util.Scanner;
public class MainHeap {
    public static void main(String[] args) {
        MonticuloMax heapmx = new MonticuloMax();
        MonticuloMin heapmn = new MonticuloMin();
        boolean sistemaActivo = true;
        for (int i = 10; i < 40; i++) {
            heapmx.insertar(i);
            heapmn.insertar(i);
        }
        heapmn.insertar(5);
        heapmn.insertar(3);

        do {
            System.out.println("\nSistema HEAP");
            System.out.println("-------------");
            System.out.println("0. Salir");
            System.out.println("1. Imprimir Heap max");
            System.out.println("2. Imprimir Heap min");
            System.out.println("3. Ingresar valor a Heap Max");
            System.out.println("4. Ingresar valor a Heap Min");
            System.out.println("5. Extraer valor de Heap Max (Mayor prioridad)");
            System.out.println("6. Extraer valor de Heap Min (Mayor prioridad)");
            
            System.out.println("Tu opcion: ");
            Scanner input = new Scanner(System.in);
            int opcion = input.nextInt();
            input.nextLine();
            switch (opcion) {
                case 0:
                    sistemaActivo = false;
                    break;
                case 1:
                    heapmx.mostrarMonticulo();
                    break;
                
                case 2:
                    heapmn.mostrarMonticulo();
                    break;
                case 3:
                    System.out.print("Ingresar valor entero al monticulo Max: ");
                    int num = input.nextInt();
                    input.nextLine();
                    heapmx.insertar(num);
                    System.out.println("Heap actualizado: ");
                    heapmx.mostrarMonticulo();
                    break;
                case 4: 
                    System.out.print("Ingresar valor entero al monticulo Min: ");
                    int num1 = input.nextInt();
                    input.nextLine();
                    heapmx.insertar(num1);
                    System.out.println("Heap actualizado: ");
                    heapmn.mostrarMonticulo();
                    break;
                case 5:
                    heapmx.eliminarMax();
                    System.out.println("Heap actualizado: ");
                    heapmx.mostrarMonticulo();
                    break;
                case 6:
                    heapmn.eliminarMin();
                    System.out.println("Heap actualizado: ");
                    heapmn.mostrarMonticulo();
                    
                default:
                    System.out.println("Error...");
                    break;
            }

        } while (sistemaActivo == true);
    }
}
