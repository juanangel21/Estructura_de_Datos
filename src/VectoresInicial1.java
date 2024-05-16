import java.util.Scanner;

public class VectoresInicial1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10]; // Declaramos un array de tamaño 10

        // Leer 10 números del usuario y almacenarlos en el array
        System.out.println("Introduce 10 números:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        // Mostrar los números en orden inverso
        System.out.println("Los números en orden inverso son:");
        for (int i = 9; i >= 0; i--) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();
    }
}