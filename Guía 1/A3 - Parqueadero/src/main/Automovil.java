package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa un Automovil
 */
public class Automovil extends Vehiculo {
	private String tipoCombustible;
	
	/**
	 * Metodo constructor de la clase Automovil
	 * 
	 * @param horaDeEntrada La hora de entrada del Automovil
	 * @param marca La marca del Automovil
	 * @param modelo El modelo del Automovil
	 * @param placa La placa del Automovil
	 * @param tipoCombustible El tipon de combustible del Automovil
	 */
	public Automovil(LocalDateTime horaDeEntrada, String marca, String modelo, String placa, String tipoCombustible) {
		super(horaDeEntrada, marca, modelo, placa);
		this.tipoCombustible = tipoCombustible;
	}

	/**
	 * @return Retorna el tipo de combustible del Automovil
	 */
	public String getTipoCombustible() {
		return tipoCombustible;
	}
	
	/**
	 * Actualiza el tipo de combustible del Automovil
	 * 
	 * @param tipoCombustible El nuevo tipo de combustible
	 */
	public void setTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}
	
	/**
	 * Cambia la representación textual (String) de la clase Automovil, usada para las tablas
	 */
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
        return String.format("| %-15s | %-15s | %-10s | %-16s | %-30s |",
                getMarca(), getModelo(), getPlaca(), getHoraDeEntrada().format(formatter), getTipoCombustible());
	}
}