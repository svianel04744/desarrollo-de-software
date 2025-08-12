package main;

import java.time.LocalDateTime;

/**
 * Clase que representa una Reseña realizada por un Visitante a un Stand
 */
public class Reseña {
	private int calificacion;
	private String comentario;
	private LocalDateTime fecha;
	private Stand stand;
	private Visitante visitante;
	
	/**
	 * Metodo constructor de la clase Reseña
	 * 
	 * @param calificacion La calificación dada por el Visitante
	 * @param comentario El comentario escrito por el Visitante
	 * @param fecha La fecha de la reseña
	 * @param stand El Stand al cual se le realizo la reseña
	 * @param visitante El Visitante que hizo la Reseña
	 */
	public Reseña(int calificacion, String comentario, LocalDateTime fecha, Stand stand, Visitante visitante) {
		this.calificacion = calificacion;
		this.comentario = comentario;
		this.fecha = fecha;
		this.stand = stand;
		this.visitante = visitante;
	}

	/**
	 * @return Retorna la calificación de la Reseña
	 */
	public int getCalificacion() {
		return calificacion;
	}

	/**
	 * @return Retorna el comentario de la reseña
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * @return Retorna la fecha de la reseña 
	 */
	public LocalDateTime getFecha() {
		return fecha;
	}

	/**
	 * @return Retorna el Stand de la reseña
	 */
	public Stand getStand() {
		return stand;
	}

	/**
	 * @return Retorna el Visitante que realizo la Reseña
	 */
	public Visitante getVisitante() {
		return visitante;
	}
}