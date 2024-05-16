import java.util.Random;

public class VectoresInicial3 {

    public static void main(String[] args) {
        Random random = new Random(); // Generador de números aleatorios
        int[] numeros = new int[20]; // Vector para almacenar los números aleatorios
        int suma = 0; // Variable para almacenar la suma de los números
        double media; // Variable para almacenar la media de los números

        // Generar 20 números aleatorios entre 0 y 100
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(101); // Generar un número entre 0 y 100 (inclusive)
        }

        // Calcular la suma de los números
        for (int numero : numeros) {
            suma += numero;
        }

        // Calcular la media de los números
        media = (double) suma / numeros.length;

        // Mostrar los resultados
        System.out.println("Números aleatorios:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }

        System.out.println("\nSuma: " + suma);
        System.out.println("Media: " + media);
    }
}