package main;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el Parqueadero
 */
public class Parqueadero {
	private List<Vehiculo> vehiculos;

	/**
	 * Metodo constructor del Parqueadero
	 */
	public Parqueadero() {
		this.vehiculos = new ArrayList<Vehiculo>();
		
		// Datos de prueba
		Automovil automovil_1 = new Automovil(LocalDateTime.now(), "Kia", "2022", "ABC123", "Gasolina");
		Camion camion_1 = new Camion(LocalDateTime.now(), "Volvo", "2020", "BCD234", 50);
		Motocicleta motocicleta_1 = new Motocicleta(LocalDateTime.now(), "Yamaha", "2015", "CD345E", 500);
		
		this.ingresarVehiculo(automovil_1);
		this.ingresarVehiculo(camion_1);
		this.ingresarVehiculo(motocicleta_1);
	}
	
	/**
	 * Registra el ingreso de un nuevo vehiculo
	 * 
	 * @param vehiculo El vehiculo a ingresar
	 */
	public void ingresarVehiculo(Vehiculo vehiculo) {
		this.vehiculos.add(vehiculo);
	}
	
	/**
	 * Registra la salida de un vehiculo, calcula y retorna el costo de la estancia del mismo 
	 * 
	 * @param placa La placa del vehiculo a procesar
	 * @return El costo de la estancia en el parqueadero
	 * 
	 * @throws Exception En caso de que el vehiculo con esa placa no se encuentre
	 */
	public double registrarSalidaVehiculo(String placa) throws Exception {
		Vehiculo vehiculo = this.obtenerVehiculoPorPlaca(placa);
		double fraccionVehiculo = this.obtenerValorFraccionDeVehiculo(vehiculo);
		
		double minutos = Duration.between(vehiculo.getHoraDeEntrada(), LocalDateTime.now()).toMinutes()+1;
		
		this.vehiculos.remove(vehiculo);
		
		return fraccionVehiculo*minutos;
	}

	/**
	 * @return Retorna la lista de vehiculos que estan actualmente en el parqueadero
	 */
	public List<Vehiculo> consultarEstadoParqueadero() {
		return this.vehiculos;
	}
	
	/**
	 * @param vehiculo El vehiculo a calcular
	 * 
	 * @return Retorna el costo de la fraccion de un vehiculo
	 */
	private double obtenerValorFraccionDeVehiculo(Vehiculo vehiculo) {
		if (vehiculo.getClass() == Motocicleta.class) {
			return 1000;
		} else if (vehiculo.getClass() == Automovil.class) {
			return 2000;
		}  else {
			return 3000;
		}
	}

	/**
	 * Busca un vehiculo en el parqueadero dada una placa
	 * 
	 * @param placa La placa del vehiculo a buscar
	 * @return El vehiculo
	 * 
	 * @throws Exception En caso de no ser encontrado
	 */
	private Vehiculo obtenerVehiculoPorPlaca(String placa) throws Exception {
		for (Vehiculo vehiculo : vehiculos) {
			if(vehiculo.getPlaca().equals(placa)) {
				return vehiculo;
			}
		}
		
		throw new Exception("Vehiculo no encontrado");
	}
}