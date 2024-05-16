import java.util.Scanner;

public class FibonacciIterativo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un valor para calcular su número de Fibonacci: ");
        int n = scanner.nextInt();
        System.out.println("\nEl " + n + "º número de Fibonacci es: " + fibonacci(n));
    }

    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int a = 0;
        int b = 1;
        int fib = 1;
        System.out.print(a + ", " + b);

        for (int i = 2; i <= n; i++) {
            fib = a + b;
            System.out.print(", " + fib);
            a = b;
            b = fib;
        }

        return fib;
    }
}
