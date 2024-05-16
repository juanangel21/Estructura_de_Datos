import java.util.Random;

public class VectoresInicial4 {

    public static void main(String[] args) {
        Random random = new Random(); // Generador de números aleatorios
        int[] notas = new int[20]; // Vector para almacenar las notas de los alumnos
        int sumaNotas = 0; // Variable para almacenar la suma de las notas
        double promedio; // Variable para almacenar el promedio de las notas
        int alumnosInferiores = 0; // Contador de alumnos con nota inferior al promedio

        // Generar 20 notas aleatorias entre 0 y 100
        for (int i = 0; i < notas.length; i++) {
            notas[i] = random.nextInt(101); // Generar un número entre 0 y 100 (inclusive)
        }

        // Calcular la suma de las notas
        for (int nota : notas) {
            sumaNotas += nota;
        }

        // Calcular el promedio de las notas
        promedio = (double) sumaNotas / notas.length;

        // Contar alumnos con nota inferior al promedio
        for (int nota : notas) {
            if (nota < promedio) {
                alumnosInferiores++;
            }
        }

        // Mostrar los resultados
        System.out.println("Notas de los alumnos:");
        for (int nota : notas) {
            System.out.print(nota + " ");
        }

        System.out.println("\nPromedio: " + promedio);
        System.out.println("Cantidad de alumnos con nota inferior al promedio: " + alumnosInferiores);
    }
}