package main;

/**
 * Clase que representa una Empresa
 */
public class Empresa {
	private String correo;
	private String nit;
	private String nombre;
	private String sector;
	private Stand stand;
	
	/**
	 * Metodo constructor de la clase Empresa
	 * 
	 * @param nombre El nombre de la empresa
	 * @param nit El NIT de la empresa 
	 * @param sector El sector de la empresa
	 * @param correo El correo de la empresa
	 */
	public Empresa(String correo, String nit, String nombre, String sector) {
		this.correo = correo;
		this.nit = nit;
		this.nombre = nombre;
		this.sector = sector;
		this.stand = null;
	}

	/**
	 * @return Retorna el correo de la empresa
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Actualiza el correo de la empresa
	 * 
	 * @param correo El nuevo correo
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return Retorna el NIT (Numero que identifica a una empresa) 
	 */
	public String getNit() {
		return nit;
	}

	/**
	 * Actualiza el NIT de la empresa
	 * 
	 * @param nit El nuevo NIT
	 */
	public void setNit(String nit) {
		this.nit = nit;
	}
	
	/**
	 * @return Retorna el nombre de la empresa
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Actualiza el nombre de la empresa
	 * 
	 * @param nombre El nuevo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return Retorna el sector de la empresa
	 */
	public String getSector() {
		return sector;
	}

	/**
	 * Actualiza el sector de la empresa
	 * 
	 * @param sector El nuevo sector
	 */
	public void setSector(String sector) {
		this.sector = sector;
	}

	/**
	 * @return Retorna el Stand asignado a la empresa
	 */
	public Stand getStand() {
		return stand;
	}

	/**
	 * Actualiza el Stand asignado a la empresa
	 * 
	 * @param stand El nuevo Stand
	 */
	public void setStand(Stand stand) {
		this.stand = stand;
	}
	
	/**
	 * Genera un reporte en forma de filas (Fila de una tabla) con los datos de la empresa y el stand asignado
	 * 
	 * @return El reporte generado
	 */
	public String generarReporteEmpresasYStands() {
		String stand = "No asignado";
		if(getStand() != null) {
			stand = String.format("%s", getStand().getNumero());
		}
		
        return String.format("| %-20s | %-15s | %-15s |",
                getNombre(), getSector(), stand);
	}
	
	/**
	 * Cambia la representación textual (String) de la clase Empresa, usada para las tablas/reportes
	 */
	@Override
	public String toString() {
		String stand = "No asignado";
		if(getStand() != null) {
			stand = String.format("%s", getStand().getNumero());
		}
		
        return String.format("| %-20s | %-15s | %-15s | %-20s | %-15s |",
                getNombre(), getSector(), getNit(), getCorreo(), stand);
	}
}