import java.util.Scanner;
import java.util.ArrayList;

public class VectoresAvanzado11 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Leer el valor de N
        System.out.print("Introduzca el valor máximo de números (N): ");
        int N = teclado.nextInt();

        // Leer los números
        ArrayList<Integer> numeros = new ArrayList<>();
        System.out.println("Introduzca los números (uno por línea):");
        for (int i = 0; i < N; i++) {
            int numero = teclado.nextInt();
            if (numero > 0) {
                numeros.add(numero);
            } else {
                System.out.println("Error: El número debe ser positivo.");
                i--; // Volver a leer el número
            }
        }

        // Encontrar las secuencias de pares más largas
        ArrayList<ArrayList<Integer>> secuenciasPares = encontrarSecuenciasPares(numeros);

        // Ordenar las secuencias por suma decreciente
        ordenarSecuencias(secuenciasPares);

        // Mostrar las secuencias de pares más largas
        System.out.println("\nSecuencias de pares más largas con mayor suma:");
        for (ArrayList<Integer> secuencia : secuenciasPares) {
            mostrarSecuencia(secuencia);
        }
    }

    private static ArrayList<ArrayList<Integer>> encontrarSecuenciasPares(ArrayList<Integer> numeros) {
        ArrayList<ArrayList<Integer>> secuencias = new ArrayList<>();
        ArrayList<Integer> secuenciaActual = new ArrayList<>();

        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) % 2 == 0) {
                secuenciaActual.add(numeros.get(i));

                if (i == numeros.size() - 1 || numeros.get(i + 1) % 2 != 0) {
                    // Se ha encontrado una secuencia de pares
                    ArrayList<Integer> nuevaSecuencia = new ArrayList<>(secuenciaActual);
                    secuencias.add(nuevaSecuencia);
                    secuenciaActual.clear();
                }
            }
        }

        return secuencias;
    }

    private static void ordenarSecuencias(ArrayList<ArrayList<Integer>> secuencias) {
        secuencias.sort((s1, s2) -> {
            int suma1 = 0;
            int suma2 = 0;

            for (int numero : s1) {
                suma1 += numero;
            }

            for (int numero : s2) {
                suma2 += numero;
            }

            return Integer.compare(suma2, suma1);
        });
    }

    private static void mostrarSecuencia(ArrayList<Integer> secuencia) {
        System.out.print("[");
        for (int i = 0; i < secuencia.size(); i++) {
            System.out.print(secuencia.get(i));
            if (i < secuencia.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");

        int suma = 0;
        for (int numero : secuencia) {
            suma += numero;
        }
        System.out.println(" (" + suma + ")");
    }
}