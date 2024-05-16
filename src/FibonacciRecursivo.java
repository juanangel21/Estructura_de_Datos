import java.util.Scanner;
import java.util.ArrayList;

public class FibonacciRecursivo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un valor para calcular su número de Fibonacci: ");
        int n = scanner.nextInt();
        ArrayList<Integer> sequence = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            sequence.add(fibonacci(i));
        }
        printFibonacciSequence(sequence);
        System.out.println("El " + n + "º número de Fibonacci es: " + fibonacci(n));
    }

    public static void printFibonacciSequence(ArrayList<Integer> sequence) {
        for (int i = 0; i < sequence.size(); i++) {
            System.out.print(sequence.get(i));
            if (i < sequence.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}