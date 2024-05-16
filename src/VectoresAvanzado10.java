import java.util.Scanner;

public class VectoresAvanzado10 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double montoTotalApostado = 0;
        double montoTotalGanado = 0;

        System.out.println("Bienvenido al juego de la lotería");

        while (true) {
            System.out.println("\nIngrese 10 números de dos dígitos separados por espacios:");
            String numerosIngresados = teclado.nextLine();
            String[] numerosArray = numerosIngresados.split(" ");

            if (numerosArray.length != 10) {
                System.out.println("Debe ingresar exactamente 10 números.");
                continue;
            }

            int numerosCorrectos = 0;
            for (String numero : numerosArray) {
                if (numero.matches("\\d{2}")) {
                    numerosCorrectos++;
                }
            }

            if (numerosCorrectos != 10) {
                System.out.println("Los números ingresados no son válidos. Intente nuevamente.");
                continue;
            }

            double montoApostado;
            try {
                System.out.println("Ingrese el monto a apostar:");
                montoApostado = Double.parseDouble(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Monto inválido. Intente nuevamente.");
                continue;
            }

            int numerosAcertados = 0;
            for (int i = 0; i < 10; i++) {
                int numeroAleatorio = (int) (Math.random() * 90 + 10);
                if (numerosArray[i].equals(String.valueOf(numeroAleatorio))) {
                    numerosAcertados++;
                }
            }

            double ganancia = 0;
            if (numerosAcertados == 10) {
                ganancia = montoApostado * 50;
            } else if (numerosAcertados == 5) {
                ganancia = montoApostado * 25;
            } else if (numerosAcertados == 4) {
                ganancia = montoApostado * 15;
            }

            double impuesto = ganancia * 0.10;
            double montoCobrar = ganancia - impuesto;

            montoTotalApostado += montoApostado;
            montoTotalGanado += montoCobrar;

            System.out.println("\nNúmeros acertados: " + numerosAcertados);
            System.out.println("Monto ganado: Gs." + ganancia);
            System.out.println("Impuesto (10%): Gs." + impuesto);
            System.out.println("Monto a cobrar: Gs" + montoCobrar);

            System.out.println("\n¿Desea realizar otra jugada? (S/N)");
            String respuesta = teclado.nextLine().toUpperCase();
            if (!respuesta.equals("S")) {
                break;
            }
        }

        System.out.println("\nMonto total apostado: Gs." + montoTotalApostado);
        System.out.println("Monto total ganado: Gs." + montoTotalGanado);
        System.out.println("Ganancia o pérdida: Gs." + (montoTotalGanado - montoTotalApostado));
        System.out.println("\n¡Gracias por jugar!");
    }
}
