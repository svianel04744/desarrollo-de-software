package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa un Camion
 */
public class Camion extends Vehiculo {
	private double capacidadCarga;

	/**
	 * Metodo constructor de la clase Camion
	 * 
	 * @param horaDeEntrada La hora de entrada del Camion
	 * @param marca La marca del Camion
	 * @param modelo El modelo del Camion
	 * @param placa La placa del Camion
	 * @param capacidadCarga La capacidad de carga del camion
	 */
	public Camion(LocalDateTime horaDeEntrada, String marca, String modelo, String placa, double capacidadCarga) {
		super(horaDeEntrada, marca, modelo, placa);
		this.capacidadCarga = capacidadCarga;
	}

	/**
	 * @return Retorna la capacidad de carga del camion
	 */
	public double getCapacidadCarga() {
		return capacidadCarga;
	}

	/**
	 * Actualiza la capacidad de carga del camion
	 * 
	 * @param capacidadCarga La nueva capacidad de carga
	 */
	public void setCapacidadCarga(double capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}
	
	/**
	 * Cambia la representación textual (String) de la clase Camion, usada para las tablas
	 */
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
        return String.format("| %-15s | %-15s | %-10s | %-16s | %-30.2f Toneladas |", 
                getMarca(), getModelo(), getPlaca(), getHoraDeEntrada().format(formatter), capacidadCarga);
	}
}