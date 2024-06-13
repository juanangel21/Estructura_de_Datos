import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class FusionarListasOrdenadas {

    public static void main(String[] args) {

        // Elegimos la longitud de nuestras listas introducidos por teclado
        Scanner sc = new Scanner(System.in);

        System.out.println("Tamaño de la primera lista = ");
        int n1 = sc.nextInt();

        System.out.println("Tamaño de la segunda lista= ");
        int n2 = sc.nextInt();


        // Generamos las listas segun la longitud con valores aleatorios

        List<Integer> lista1 = generarListaAleatoria(n1, 10);
        List<Integer> lista2 = generarListaAleatoria(n2, 10);

        // Mostrar las listas antes de ordenarlas
        System.out.println("Lista 1: " + lista1);
        System.out.println("Lista 2: " + lista2);

        // Ordenar las listas
        Collections.sort(lista1);
        Collections.sort(lista2);

        // Mostrar las listas después de ordenarlas
        System.out.println("Lista 1 ordenada: " + lista1);
        System.out.println("Lista 2 ordenada: " + lista2);

        // Fusionar las listas
        List<Integer> mergedList = mergeSortedListas(lista1, lista2);

        // Mostrar la lista fusionada
        System.out.println("Lista Fusionada: " + mergedList);

        sc.close();
    }

    // Aca generamos los valores aleatorios a las listas
    public static List<Integer> generarListaAleatoria(int t, int l) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < t; i++) {
            list.add(random.nextInt(l));
        }

        return list;
    }

    public static List<Integer> mergeSortedListas(List<Integer> lista1, List<Integer> lista2) {
        List<Integer> mergedLista = new ArrayList<>();
        int i = 0, j = 0;

        while (i < lista1.size() && j < lista2.size()) {
            if (lista1.get(i) <= lista2.get(j)) {
                mergedLista.add(lista1.get(i));
                i++;
            } else {
                mergedLista.add(lista2.get(j));
                j++;
            }
        }

        while (i < lista1.size()) {
            mergedLista.add(lista1.get(i));
            i++;
        }

        while (j < lista2.size()) {
            mergedLista.add(lista2.get(j));
            j++;
        }

        return mergedLista;
    }
}