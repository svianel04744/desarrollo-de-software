package main;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class App {
	private static Parqueadero parqueadero;
	private static Scanner scanner;
	
    private static void consultarEstadoParqueadero() {
    	System.out.println("\nVehículos Estacionados:");

        System.out.println(String.format("| %-15s | %-15s | %-10s | %-16s | %-30s |", 
                "Marca", "Modelo", "Placa", "Hora de Ingreso", "Detalles"));
        System.out.println("|-----------------|-----------------|------------|------------------|---------------------|");

        List<Vehiculo> vehiculos = parqueadero.consultarEstadoParqueadero();
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos estacionados.");
        } else {
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo);
            }
        }
    }
	
	private static void ingresarVehiculo() {
	    System.out.println("\nIngrese los datos del vehículo:");

	    System.out.print("Marca: ");
	    String marca = scanner.nextLine();

	    System.out.print("Modelo: ");
	    String modelo = scanner.nextLine();

	    System.out.print("Placa: ");
	    String placa = scanner.nextLine();

	    System.out.print("Tipo de vehículo (1. Automóvil, 2. Camión, 3. Motocicleta): ");
	    int tipoVehiculo = scanner.nextInt();
	    scanner.nextLine();

	    Vehiculo vehiculo = null;

	    switch (tipoVehiculo) {
	        case 1:
	            System.out.print("Tipo de Combustible (Gasolina, Diesel, etc.): ");
	            String tipoDeCombustible = scanner.nextLine();
	            vehiculo = new Automovil(LocalDateTime.now(), marca, modelo, placa, tipoDeCombustible);
	            break;
	        case 2:
	            System.out.print("Capacidad de Carga (en toneladas): ");
	            double capacidadCarga = scanner.nextDouble();
	            scanner.nextLine();
	            vehiculo = new Camion(LocalDateTime.now(), marca, modelo, placa, capacidadCarga);
	            break;
	        case 3:
	            System.out.print("Cilindraje (en cc): ");
	            int cilindraje = scanner.nextInt();
	            scanner.nextLine();
	            vehiculo = new Motocicleta(LocalDateTime.now(), marca, modelo, placa, cilindraje);
	            break;
	        default:
	            System.out.println("Tipo de vehículo no válido.");
	            return;
	    }

	    parqueadero.ingresarVehiculo(vehiculo);
	    System.out.println("Vehículo ingresado correctamente.");
	}
	
	private static void registrarSalidaVehiculo() {
	    System.out.print("\nIngrese la placa del vehículo que va a salir: ");
	    String placa = scanner.nextLine();

	    try {
	        double costo = parqueadero.registrarSalidaVehiculo(placa);

	        System.out.println("El costo de estacionamiento es: $" + costo);
	    } catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	}
	
	public static void main(String[] args) {
		parqueadero = new Parqueadero();
		scanner = new Scanner(System.in);
		
		int opcion;
		do {
            System.out.println("\n***** Menú Parqueadero *****");
            System.out.println("1. Ingresar Vehículo");
            System.out.println("2. Registrar Salida");
            System.out.println("3. Consultar estado del Parqueadero");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    ingresarVehiculo();
                    break;
                case 2:
                	registrarSalidaVehiculo();
                    break;
                case 3:
                	consultarEstadoParqueadero();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 0);
	}
}
