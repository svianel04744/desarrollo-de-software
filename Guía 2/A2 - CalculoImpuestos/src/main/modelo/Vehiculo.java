package main.modelo;

public class Vehiculo {
	private int año;
	private double avaluo;
	private int cilindraje;
	private Combustible combustible;
	private String marca;
	private String modelo;
	private TipoVehiculo tipo;
	
	/**
	 * @param año
	 * @param avaluo
	 * @param cilindraje
	 * @param combustible
	 * @param marca
	 * @param modelo
	 * @param tipo
	 */
	public Vehiculo(int año, double avaluo, int cilindraje, Combustible combustible, String marca, String modelo, TipoVehiculo tipo) {
		this.año = año;
		this.avaluo = avaluo;
		this.combustible = combustible;
		this.cilindraje = cilindraje;
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public double getAvaluo() {
		return avaluo;
	}

	public void setAvaluo(double avaluo) {
		this.avaluo = avaluo;
	}

	public Combustible getCombustible() {
		return combustible;
	}

	public void setCombustible(Combustible combustible) {
		this.combustible = combustible;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public TipoVehiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVehiculo tipo) {
		this.tipo = tipo;
	}
}
