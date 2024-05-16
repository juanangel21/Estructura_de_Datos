import java.util.Scanner;

public class VectoresInicial5 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Leer el tamaño del vector T
        System.out.print("Introduzca el tamaño del vector T: ");
        int n = teclado.nextInt();

        // Leer los elementos del vector T
        int[] T = new int[n];
        System.out.println("Introduzca los elementos del vector T:");
        for (int i = 0; i < n; i++) {
            T[i] = teclado.nextInt();
        }

        // Leer el valor de k
        System.out.print("Introduzca el valor de k (índice de división): ");
        int k = teclado.nextInt();

        // Validar el valor de k
        if (k <= 0) {
            System.out.println("Error: El valor de k debe ser mayor a 0");
            return;
        }

        // Crear el nuevo vector
        int[] nuevoVector = new int[n];
        for (int i = 0; i < n; i++) {
            nuevoVector[i] = T[i] / k;
        }

        // Mostrar el nuevo vector
        System.out.println("Nuevo vector:");
        for (int elemento : nuevoVector) {
            System.out.print(elemento + " ");
        }
    }
}