import java.util.Scanner;

public class VectoresInicial2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10]; // Declaramos un array de tamaño 10

        // Leer 10 números del usuario y almacenarlos en el array
        System.out.println("Introduce 10 números:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        // Mostrar el valor de cada índice
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("[" + i + "] = " + numeros[i]);
        }
    }
}