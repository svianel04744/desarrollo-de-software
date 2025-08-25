package main.modelo;

public class CalculadoraImpuestos {

	/**
	 * 
	 */
	public CalculadoraImpuestos() {
	}
	
	public double calcularImpuesto(Vehiculo vehiculo) {
		int año = vehiculo.getAño();
		double avaluo = vehiculo.getAvaluo();
		int cilindraje = vehiculo.getCilindraje();
		Combustible combustible = vehiculo.getCombustible();
		TipoVehiculo tipo = vehiculo.getTipo();
				
		double impuestoBase = avaluo * 0.01;
		
		// Ajuste por cilindraje
		if (cilindraje > 3000) {
		    impuestoBase *= 1.2; // +20%
		} else if (cilindraje > 2000) {
		    impuestoBase *= 1.1; // +10%
		} else if (cilindraje < 1200) {
		    impuestoBase *= 0.9; // -10%
		}

		// Descuento por tipo de combustible
		switch (combustible) {
		    case ELECTRICO:
		        impuestoBase *= 0.5; // 50% de descuento
		        break;
		    case HIBRIDO:
		        impuestoBase *= 0.75; // 25% de descuento
		        break;
		    case GASOLINA:
		        break;
		}

		// Ajuste por tipo de vehículo
		if (tipo == TipoVehiculo.PUBLICO) {
		    impuestoBase *= 0.9; // 10% de descuento para transporte público
		}

		// Penalización por antigüedad (vehículos más viejos pagan más)
		int antiguedad = 2025 - año;
		if (antiguedad > 20) {
		    impuestoBase *= 1.15; // +15%
		} else if (antiguedad > 10) {
		    impuestoBase *= 1.1;  // +10%
		} else if (antiguedad < 3) {
		    impuestoBase *= 0.95; // -5%
		}

		// Impuesto mínimo
		if (impuestoBase < 50000) {
		    impuestoBase = 50000; // mínimo base
		}
		
		return impuestoBase;
	}
}
