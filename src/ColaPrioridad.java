import java.util.InputMismatchException;
import java.util.Scanner;


//Clase que representa a los clientes
class Cliente {
    String nombre;
    int nivelPrioridad; // 1: Alta, 2: Media, 3: Baja

    public Cliente(String nombre, int nivelPrioridad) {
        this.nombre = nombre;
        this.nivelPrioridad = nivelPrioridad;
    }

    @Override
    public String toString() {
        return nombre + " (Prioridad " + nivelPrioridad + ")";
    }
}

//Maneja una cola de clientes, donde se usan las operaciones para encolar y desencolar a los mismos
class Cola {
    private Cliente[] clientes;
    private int capacidad;
    private int frente;
    private int finalDeLaCola;
    private int tamaño;

    public Cola(int capacidad) {
        this.capacidad = capacidad;
        this.clientes = new Cliente[capacidad];
        this.frente = 0;
        this.finalDeLaCola = -1;
        this.tamaño = 0;
    }

    public void encolar(Cliente cliente) {
        if (tamaño == capacidad) {
            System.out.println("Cola llena. No se puede encolar al cliente.");
            return;
        }
        finalDeLaCola = (finalDeLaCola + 1) % capacidad;
        clientes[finalDeLaCola] = cliente;
        tamaño++;
    }

    public Cliente desencolar() {
        if (tamaño == 0) {
            System.out.println("Cola vacía. No se puede desencolar al cliente.");
            return null;
        }
        Cliente cliente = clientes[frente];
        frente = (frente + 1) % capacidad;
        tamaño--;
        return cliente;
    }


    //Verificamos si la cola esta vacia
    public boolean esVacia() {
        return tamaño == 0;
    }

    //Verificamos el tamaño de la cola
    public int tamaño() {
        return tamaño;
    }


    //Obtenemos el indice del Cliente
    public Cliente obtener(int index) {
        if (index >= 0 && index < tamaño) {
            return clientes[(frente + index) % capacidad];
        }
        return null;
    }


    //Mostramos la lista de los clientes
    public void mostrarCola() {
        for (int i = 0; i < tamaño; i++) {
            int index = (frente + i) % capacidad;
            System.out.println((i + 1) + ". " + clientes[index]);
        }
    }
}

//Esta clase se encarga de gestionar la cola de prioridad
class SistemaAtencionCliente {
    private Cola prioridadAlta;
    private Cola prioridadMedia;
    private Cola prioridadBaja;
    private int contadorAlta = 0;
    private int contadorMedia = 0;
    private int contadorBaja = 0;

    public SistemaAtencionCliente(int capacidad) {
        this.prioridadAlta = new Cola(capacidad);
        this.prioridadMedia = new Cola(capacidad);
        this.prioridadBaja = new Cola(capacidad);
    }


    //Añadimos los cllientes que van llegando segun su prioridad
    public void llegadaCliente(String nombre, int nivelPrioridad) {
        Cliente nuevoCliente = new Cliente(nombre, nivelPrioridad);
        switch (nivelPrioridad) {
            case 1 -> prioridadAlta.encolar(nuevoCliente);
            case 2 -> prioridadMedia.encolar(nuevoCliente);
            case 3 -> prioridadBaja.encolar(nuevoCliente);
            default -> System.out.println("Nivel de prioridad inválido");
        }
    }


    //Empezamos a atender a los clientes segun lo solicitado, usando contadores para cumplir con lo requerido
    public void atenderCliente() {
        if (contadorAlta < 3 && !prioridadAlta.esVacia()) {
            System.out.println("Atendiendo a " + prioridadAlta.desencolar());
            contadorAlta++;
        } else if (contadorMedia < 2 && !prioridadMedia.esVacia()) {
            System.out.println("Atendiendo a " + prioridadMedia.desencolar());
            contadorMedia++;
        } else if (contadorBaja < 1 && !prioridadBaja.esVacia()) {
            System.out.println("Atendiendo a " + prioridadBaja.desencolar());
            contadorBaja++;
        } else if (!prioridadAlta.esVacia()) {
            System.out.println("Atendiendo a " + prioridadAlta.desencolar());
            contadorAlta++;
        } else if (!prioridadMedia.esVacia()) {
            System.out.println("Atendiendo a " + prioridadMedia.desencolar());
            contadorMedia++;
        } else if (!prioridadBaja.esVacia()) {
            System.out.println("Atendiendo a " + prioridadBaja.desencolar());
            contadorBaja++;
        } else {
            System.out.println("No hay clientes por atender");
        }
        esperarEnter();
    }


    //Mostramos la lista de clientes por atender
    public void mostrarCola() {
        System.out.println("Cola de espera:");
        int index = 1;
        if (!prioridadAlta.esVacia()) {
            for (int i = 0; i < prioridadAlta.tamaño(); i++) {
                System.out.println(index + ". " + prioridadAlta.obtener(i));
                index++;
            }
        }
        if (!prioridadMedia.esVacia()) {
            for (int i = 0; i < prioridadMedia.tamaño(); i++) {
                System.out.println(index + ". " + prioridadMedia.obtener(i));
                index++;
            }
        }
        if (!prioridadBaja.esVacia()) {
            for (int i = 0; i < prioridadBaja.tamaño(); i++) {
                System.out.println(index + ". " + prioridadBaja.obtener(i));
                index++;
            }
        }
        esperarEnter();
    }


    //Creamos este metodo para mostrar en pantalla una pausa al usuario
    void esperarEnter() {
        System.out.println("Presione Enter para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Esperar que se presione Enter
        limpiarPantalla();
    }


    //Imprimimos varios saltos de linea para hacer un poco mas entendible lo que mostramos en pantalla
    private void limpiarPantalla() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}

//Clase principal que contiene la interfaz del usuario
public class ColaPrioridad {
    public static void main(String[] args) {
        SistemaAtencionCliente sistema = new SistemaAtencionCliente(10);
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        System.out.println("Bienvenido al Sistema de Atencion al Cliente");

        while (!salir) {
            System.out.println("_________________________________________________________________________________");
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Añadir nuevo cliente");
            System.out.println("2. Atender siguiente cliente");
            System.out.println("3. Mostrar cola de espera");
            System.out.println("4. Salir");
            System.out.println("_________________________________________________________________________________");

            int opcion = -1;
            while (opcion == -1) {
                System.out.print("Seleccione una opcion: ");
                try {
                    opcion = scanner.nextInt();
                    if (opcion < 1 || opcion > 4) {
                        System.out.println("Opción inválida. Por favor, intente de nuevo.");
                        opcion = -1;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Por favor, intente de nuevo.");
                    scanner.next();
                }
            }

            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    int nivelPrioridad = -1;
                    while (nivelPrioridad == -1) {
                        System.out.print("Ingrese el nivel de prioridad del cliente (1 es la mas alta): ");
                        try {
                            nivelPrioridad = scanner.nextInt();
                            if (nivelPrioridad < 1 || nivelPrioridad > 3) {
                                System.out.println("Nivel de prioridad inválido. Por favor, intente de nuevo.");
                                nivelPrioridad = -1;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada no válida. Por favor, intente de nuevo.");
                            scanner.next();
                        }
                    }
                    sistema.llegadaCliente(nombre, nivelPrioridad);
                    sistema.esperarEnter();
                }
                case 2 -> sistema.atenderCliente();
                case 3 -> sistema.mostrarCola();
                case 4 -> {
                    salir = true;
                    System.out.println("Saliendo del sistema. ¡Adios!");
                }
            }
        }
        scanner.close();
    }
}