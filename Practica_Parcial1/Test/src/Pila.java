public class Pila {
    private int[] stack;
    private int top;
    private int capacity;

    public Pila(int size) {
        stack = new int[size];
        top = -1;
        capacity = size;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("La pila esta llena.");
            return;
        }
        else {
            stack[++top] = value;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("La pila esta vacia");
            return -1;
        }
        return stack[top--];
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("La pila esta vacia");
            return -1;
        }
        else {
            return stack[top];
        }
    }

    public void imprimirPila() {
        if (isEmpty()) {
            System.out.println("La pila esta vacia.");
            return;
        }
        System.out.println("Elementos de la pila:");
        for (int i = 0; i <= top; i++) {
            System.out.println(stack[i] +" ");
        }
        System.out.println();
    }
}
