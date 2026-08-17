import java.time.Year;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehiculo> inventario = new ArrayList<>();
        boolean salir = false;

        while (!salir) {
            System.out.println(" INVENTARIO - CONCESIONARIO AUTOMOTION S.A.S ");
            System.out.println("1- Agregar un nuevo vehiculo");
            System.out.println("2- Listar inventario completo");
            System.out.println("3- Ver valor total del inventario");
            System.out.println("4- Buscar vehiculo por placa");
            System.out.println("0- Salir");

            imprimirPrompt("Seleccione una opcion: ");
            int opcion = leerEntero(scanner);

            switch (opcion) {
                case 1 -> registrarVehiculo(scanner, inventario);
                case 2 -> {
                    System.out.println("\n LISTADO DEL INVENTARIO ");
                    listarInventario(inventario);
                }
                case 3 -> {
                    System.out.println("\n VALOR TOTAL DEL INVENTARIO ");
                    double total = calcularValorTotalInventario(inventario);
                    System.out.printf("El valor total del inventario es: $%,.2f COP%n", total);
                }
                case 4 -> {
                    System.out.println("\n BUSQUEDA POR PLACA ");
                    imprimirPrompt("Ingrese la placa a buscar: ");
                    String placaBusqueda = scanner.nextLine().trim();
                    Vehiculo v = buscarPorPlaca(inventario, placaBusqueda);
                    if (v != null) {
                        System.out.println("\nVehiculo encontrado:");
                        System.out.println(v.mostrarFicha());
                        System.out.printf("Precio final: $%,.2f COP%n", v.calcularPrecioFinal());
                    } else {
                        System.out.println("No se encontro ningun vehiculo con la placa: " + placaBusqueda);
                    }
                }
                case 0 -> {
                    salir = true;
                    System.out.println("\nGracias por utilizar el sistema de AutoMotion S.A.S.");
                }
                default -> System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }

        scanner.close();
    }
    public static void agregarVehiculo(ArrayList<Vehiculo> inventario, Vehiculo v) {
        if (v != null) {
            inventario.add(v);
            System.out.println("Vehiculo registrado exitosamente en el inventario.");
        }
    }

    public static void listarInventario(ArrayList<Vehiculo> inventario) {
        if (inventario.isEmpty()) {
            System.out.println("El inventario se encuentra vacio.");
            return;
        }
        for (Vehiculo v : inventario) {
            System.out.println(v.mostrarFicha());
            System.out.printf("Precio final: $%,.2f COP%n", v.calcularPrecioFinal());
        }
    }

    public static double calcularValorTotalInventario(ArrayList<Vehiculo> inventario) {
        double total = 0.0;
        for (Vehiculo v : inventario) {
            total += v.calcularPrecioFinal();
        }
        return total;
    }

    public static Vehiculo buscarPorPlaca(ArrayList<Vehiculo> inventario, String placa) {
        if (placa == null || placa.trim().isEmpty()) {
            return null;
        }
        for (Vehiculo v : inventario) {
            if (v.getPlaca().equalsIgnoreCase(placa.trim())) {
                return v;
            }
        }
        return null;
    }
    public static void registrarVehiculo(Scanner scanner, ArrayList<Vehiculo> inventario) {
        System.out.println("\n--- REGISTRAR UN VEHICULO ---");
        System.out.println("1- Automovil");
        System.out.println("2- Motocicleta");
        System.out.println("3- Camion de Carga");

        imprimirPrompt("Seleccione el tipo de vehiculo: ");
        int tipo = leerEntero(scanner);

        if (tipo < 1 || tipo > 3) {
            System.out.println("ERROR: TIPO DE VEHICULO NO VALIDO");
            return;
        }

        imprimirPrompt("Ingrese la placa: ");
        String placa = scanner.nextLine().trim();

        if (buscarPorPlaca(inventario, placa) != null) {
            System.out.println("ERROR: LA PLACA YA SE ENCUENTRA REGISTRADA");
            return;
        }

        imprimirPrompt("Ingrese la marca: ");
        String marca = scanner.nextLine().trim();

        imprimirPrompt("Ingrese el modelo: ");
        String modelo = scanner.nextLine().trim();

        imprimirPrompt("Ingrese el ano (1990 - " + Year.now().getValue() + "): ");
        int anio = leerEntero(scanner);

        imprimirPrompt("Ingrese el precio base: $");
        double precioBase = leerDouble(scanner);

        switch (tipo) {
            case 1 -> {
                imprimirPrompt("Ingrese el numero de puertas (2-5): ");
                int puertas = leerEntero(scanner);

                imprimirPrompt("Ingrese el tipo de combustible (Gasolina, Diesel, Electrico): ");
                String combustible = scanner.nextLine().trim();

                Automovil auto = new Automovil(placa, marca, modelo, anio, precioBase, puertas, combustible);
                agregarVehiculo(inventario, auto);
            }
            case 2 -> {
                imprimirPrompt("Ingrese cilindraje en c.c: ");
                int cilindraje = leerEntero(scanner);

                Motocicleta moto = new Motocicleta(placa, marca, modelo, anio, precioBase, cilindraje);
                agregarVehiculo(inventario, moto);
            }
            case 3 -> {
                imprimirPrompt("Ingrese la capacidad de toneladas: ");
                double toneladas = leerDouble(scanner);

                Camioncarga camion = new Camioncarga(placa, marca, modelo, anio, precioBase, toneladas);
                agregarVehiculo(inventario, camion);
            }
        }
    }

    private static void imprimirPrompt(String mensaje) {
        System.out.print(mensaje);
        System.out.flush();
    }

    private static int leerEntero(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            return -1;
        }
    }

    private static double leerDouble(Scanner scanner) {
        try {
            return Double.parseDouble(scanner.nextLine().trim());
        } catch (Exception e) {
            return -1.0;
        }
    }
}