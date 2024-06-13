import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class HistorialNavegador {

    private LinkedList<String> historial;
    private ListIterator<String> iterator;
    private String currentPage;

    public HistorialNavegador(String homepage) {
        historial = new LinkedList<>();
        historial.add(homepage);
        iterator = historial.listIterator();
        iterator.next();  // Move iterator to the first element
        currentPage = homepage;
    }

    public void visit(String url) {
        // Remove all elements after the current page
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        historial.add(url);
        iterator = historial.listIterator(historial.size());
        currentPage = url;
    }

    public String back(int steps) {
        while (steps > 0 && iterator.hasPrevious()) {
            iterator.previous();
            steps--;
        }
        if (iterator.hasPrevious()) {
            currentPage = iterator.previous();
            iterator.next();  // Correct the position
        } else {
            currentPage = historial.getFirst();
        }
        return currentPage;
    }

    public String forward(int steps) {
        while (steps > 0 && iterator.hasNext()) {
            currentPage = iterator.next();
            steps--;
        }
        return currentPage;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la página de inicio: ");
        String homepage = sc.nextLine();

        HistorialNavegador historialNavegador = new HistorialNavegador(homepage);

        while (true) {
            System.out.println("\nAcciones:");
            System.out.println("1. Visitar una nueva URL");
            System.out.println("2. Retroceder en el historial");
            System.out.println("3. Avanzar en el historial");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce la nueva URL: ");
                    String url = sc.nextLine();
                    historialNavegador.visit(url);
                    System.out.println("Página actual: " + historialNavegador.currentPage + ".com");
                    break;
                case 2:
                    System.out.print("Introduce el número de pasos hacia atrás: ");
                    int stepsBack = sc.nextInt();
                    sc.nextLine();
                    String backPage = historialNavegador.back(stepsBack);
                    System.out.println("Página actual después de retroceder: " + backPage + ".com");
                    break;
                case 3:
                    System.out.print("Introduce el número de pasos hacia adelante: ");
                    int stepsForward = sc.nextInt();
                    sc.nextLine();
                    String forwardPage = historialNavegador.forward(stepsForward);
                    System.out.println("Página actual después de avanzar: " + forwardPage + ".com");
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción no válida, por favor intenta de nuevo.");
            }
        }
    }
}
