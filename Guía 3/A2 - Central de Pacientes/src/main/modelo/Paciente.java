package main.modelo;

public class Paciente {
	private String clinica;
	private int edad;
	private String id;
	private String nombre;
	
	/**
	 * @param clinica
	 * @param edad
	 * @param id
	 * @param nombre
	 */
	public Paciente(String clinica, int edad, String id, String nombre) {
		this.clinica = clinica;
		this.edad = edad;
		this.id = id;
		this.nombre = nombre;
	}

	public String getClinica() {
		return clinica;
	}

	public void setClinica(String clinica) {
		this.clinica = clinica;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
