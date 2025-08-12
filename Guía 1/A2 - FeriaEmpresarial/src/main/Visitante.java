package main;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un Visitante
 */
public class Visitante {
	private List<Reseña> reseñas;
	private String correo;
	private String identificacion;
	private String nombre;
	
	/**
	 * Metodo constructor de la clase Visitante
	 * 
	 * @param correo El Correo del visitante
	 * @param identificacion La Identificación del visitante
	 * @param nombre El Nombre del visitante
	 */
	public Visitante(String correo, String identificacion, String nombre) {
		this.reseñas = new ArrayList<Reseña>();
		this.correo = correo;
		this.identificacion = identificacion;
		this.nombre = nombre;
	}
	
	/**
	 * Agrega una reseña a la lista de reseñas del visitante
	 * 
	 * @param reseña
	 */
	public void agregarReseña(Reseña reseña) {
		this.reseñas.add(reseña);
	}

	/**
	 * @return Retorna el correo del visitante
	 */
	public String getCorreo() {
		return correo;
	}

	
	/**
	 * Actualiza el correo del visitante
	 * 
	 * @param correo El nuevo correo
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return Retorna la identificación del visitante
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * Actualiza la identificación del visitante
	 * 
	 * @param identificacion La nueva identificación
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @return Retorna el nombre del visitante
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Actualiza el nombre del visitante
	 * 
	 * @param nombre El nuevo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Genera un reporte en forma de filas (Fila de una tabla) con datos del visitante y sus reseñas
	 * 
	 * @return El reporte generado
	 */
	public String generarReporteDeVisitas() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String reporteDeVisitas = "";
		
		for (Reseña reseña : reseñas) {
			Stand stand = reseña.getStand();
			
			reporteDeVisitas += String.format("| %-20s | %-20s | %-10s | %-20s | %-15s | %-30s |",
	                nombre, reseña.getFecha().format(formatter), stand.getNumero(), stand.getEmpresa().getNombre(), reseña.getCalificacion() + " / 5", reseña.getComentario()) + "\n";
		}
		
		return reporteDeVisitas;
	}
	
	/**
	 * Cambia la representación textual (String) de la clase Visitante, usada para las tablas/reportes
	 */
	@Override
	public String toString() {
        return String.format("| %-20s | %-15s | %-25s |",
                nombre, identificacion, correo);
	}
}