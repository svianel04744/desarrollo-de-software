package main;

import java.time.LocalDateTime;

/**
 * Clase que representa un vehiculo
 */
public class Vehiculo {
	private LocalDateTime horaDeEntrada;
	private String marca;
	private String modelo;
	private String placa;
	
	/**
	 * Metodo constructor de un Vehiculo
	 * 
	 * @param horaDeEntrada La hora de entrada del Vehiculo
	 * @param marca La marca del vehiculo
	 * @param modelo El modelo del vehiculo
	 * @param placa La placa del vehiculo
	 */
	public Vehiculo(LocalDateTime horaDeEntrada, String marca, String modelo, String placa) {
		this.horaDeEntrada = horaDeEntrada;
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
	}

	/**
	 * @return Retorna la hora de entrada del vehiculo
	 */
	public LocalDateTime getHoraDeEntrada() {
		return horaDeEntrada;
	}

	/**
	 * Actualiza la hora de entrada del vehiculo
	 * 
	 * @param horaDeEntrada La nueva hora de entrada
	 */
	public void setHoraDeEntrada(LocalDateTime horaDeEntrada) {
		this.horaDeEntrada = horaDeEntrada;
	}

	/**
	 * @return Retorna la marca del vehiculo
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Actualiza la marca del vehiculo
	 * 
	 * @param marca La nueva marca 
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return Retorna el modelo del vehiculo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Actualiza el modelo del vehiculo
	 * 
	 * @param modelo El nuevo modelo 
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return Retorna la placa del vehiculo
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * Actualiza la placa del vehiculo
	 * 
	 * @param placa La nueva placa 
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}
}