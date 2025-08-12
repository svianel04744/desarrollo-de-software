package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa una Motocicleta
 */
public class Motocicleta extends Vehiculo {
	private int cilindraje;

	/**
	 * Metodo constructor de la clase Motocicleta
	 * 
	 * @param horaDeEntrada La hora de entrada de la Motocicleta
	 * @param marca La marca de la Motocicleta
	 * @param modelo El modelo de la Motocicleta
	 * @param placa La placa de la Motocicleta
	 * @param cilindraje El cilindraje de la Motocicleta
	 */
	public Motocicleta(LocalDateTime horaDeEntrada, String marca, String modelo, String placa, int cilindraje) {
		super(horaDeEntrada, marca, modelo, placa);
		this.cilindraje = cilindraje;
	}

	/**
	 * @return Retorna el cilindraje de la motocicleta
	 */
	public int getCilindraje() {
		return cilindraje;
	}

	/**
	 * Actualiza el cilindraje de la motocicleta
	 * 
	 * @param cilindraje El nuevo cilindraje
	 */
	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}
	
	/**
	 * Cambia la representación textual (String) de la clase Motocicleta, usada para las tablas
	 */
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
        return String.format("| %-15s | %-15s | %-10s | %-16s | %-30d CC |", 
                getMarca(), getModelo(), getPlaca(), getHoraDeEntrada().format(formatter), cilindraje);
	}
}