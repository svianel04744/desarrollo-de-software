package main;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Clase que representa un Stand
 */
public class Stand {
	private Empresa empresa;
	private int numero;
	private List<Reseña> reseñas;
	private TamañoStand tamaño;
	private String ubicacion;
	
	/**
	 * MEtodo constructor de la clase Stand
	 * 
	 * @param numero El numero unico del Stand
	 * @param ubicacion La ubicación del Stand
	 * @param tamaño El tamaño del Stand
	 */
	public Stand(int numero, String ubicacion, TamañoStand tamaño) {
		this.numero = numero;
		this.reseñas = new ArrayList<Reseña>();
		this.tamaño = tamaño;
		this.ubicacion = ubicacion;
	}

	/**
	 * @return Retorna la empresa asignada al Stand
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * Actualiza la empresa del Stand
	 * 
	 * @param empresa La nueva empresa
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return Retorna el numero unico del Stand
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @return Retorna la ubicación del Stand
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * @return Retorna la lista de reseñas realizadas al Stand
	 */
	public List<Reseña> getReseñas() {
		return reseñas;
	}
	
	/**
	 * Agrega una nueva reseña a la lista de reseñas del Stand
	 * 
	 * @param calificacion La calificación del Visitante
	 * @param comentario El comentario del Visitante
	 * @param visitante El Visitante que realizo la reseña
	 * @return La reseña creada
	 */
	public Reseña agregarReseña(int calificacion, String comentario, Visitante visitante) {
		Reseña reseña = new Reseña(calificacion, comentario, LocalDateTime.now(), this, visitante);
		this.reseñas.add(reseña);
		
		return reseña;
	}

	/**
	 * @return Retorna el tamaño del Stand
	 */
	public TamañoStand getTamaño() {
		return tamaño;
	}
	
	/**
	 * Cambia la representación textual (String) de la clase Stand, usada para las tablas/reportes
	 */
	@Override
	public String toString() {
		String empresa = "No asignada";
		if(getEmpresa() != null) {
			empresa = String.format("%s", getEmpresa().getNombre());
		}
		
        return String.format("| %-15s | %-15s | %-15s | %-20s |",
                numero, ubicacion, tamaño, empresa);
	}
	
}