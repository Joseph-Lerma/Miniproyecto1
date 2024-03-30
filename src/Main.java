import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
private static List<Cliente> clientes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Insertar cliente");;
            System.out.println("2. Eliminar cliente");
            System.out.println("3. Actualizar dinero ahorrado");
            System.out.println("4. Buscar cliente por nombre y ver su ahorro");
            System.out.println("5. Listar todos los clientes");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    insertarCliente();
                    break;
                case 2:
                    eliminarCliente();
                    break;
                case 3:
                    actualizarAhorroCliente();
                case 4:
                    buscarClientePorNombre();
                    break;
                case 5:
                    listarClientes();
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        scanner.close();
    }

    private static void insertarCliente() {
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la cédula del cliente:");
        String cedula = scanner.nextLine();
        int opcion;
        String nivelingresos = ""; // Declarar la variable fuera del switch

        do {
            System.out.println("Seleccione el nivel de ingresos del cliente:");
            System.out.println("1. Bajo");
            System.out.println("2. Medio");
            System.out.println("3. Alto");
            opcion = scanner.nextInt();
        
            // Limpiar el buffer del scanner
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    nivelingresos = "Bajo";
                    System.out.println("El cliente tiene ingresos bajos.");
                    break;
                case 2:
                    nivelingresos = "Medio";
                    System.out.println("El cliente tiene ingresos medios.");
                    break;
                case 3:
                    nivelingresos = "Alto";
                    System.out.println("El cliente tiene ingresos altos.");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida (1, 2 o 3).");
                    break;
            }
        } while (nivelingresos.isEmpty()); // Continuar el bucle si el nivel de ingresos no ha sido asignado

       
        scanner.nextLine(); // Limpiar el buffer del scanner
        System.out.println("Ingrese la fecha de creación del cliente:");
        String fechacreacion = scanner.nextLine();
        
        double ahorro =0;
        while(ahorro <=0){//ingresar un valor de ahorro mayor que cero
            System.out.println("Ingrese la cantidad de dinero ahorrado:");
            ahorro  = scanner.nextDouble();
            if(ahorro<=0){
                    System.out.println("ingrese un valor correcto, mayor o igual que 0$");
            }
        }

        Cliente cliente = new Cliente(nombre, cedula, ahorro ,nivelingresos ,fechacreacion);
        clientes.add(cliente);
        System.out.println("Cliente insertado correctamente.");
    }

    private static void actualizarAhorroCliente() {
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();
        Cliente clienteEncontrado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre)) {
                clienteEncontrado = cliente;
                break;
            }
        }
        if (clienteEncontrado != null) {
            System.out.println("Ingrese la cantidad de dinero ahorrado:");
            double ahorro = scanner.nextDouble();
            clienteEncontrado.setAhorro(ahorro);
            System.out.println("Ahorro actualizado correctamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static void eliminarCliente() {
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();
        Cliente clienteEncontrado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre)) {
                clienteEncontrado = cliente;
                break;
            }
        }
        if (clienteEncontrado != null) {
            clientes.remove(clienteEncontrado);
            System.out.println("Cliente eliminado correctamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static void buscarClientePorNombre() {
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();
        Cliente clienteEncontrado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre)) {
                clienteEncontrado = cliente;
                break;
            }
        }
        if (clienteEncontrado != null) {
            System.out.println("Nombre: " + clienteEncontrado.getNombre());
            System.out.println("Ahorro: " + clienteEncontrado.getAhorro());
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("Lista de clientes:");
            for (Cliente cliente : clientes) {
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Cédula: " + cliente.getCedula());
                System.out.println("Nivel de Ingresos: " + cliente.getNivelingresos());
                System.out.println("Ahorro: " + cliente.getAhorro());
                // Aquí podrías mostrar más información del cliente si lo deseas
            }
        }
    }
}
