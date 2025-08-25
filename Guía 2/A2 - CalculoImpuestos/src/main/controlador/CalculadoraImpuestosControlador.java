package main.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.modelo.CalculadoraImpuestos;
import main.modelo.Combustible;
import main.modelo.TipoVehiculo;
import main.modelo.Vehiculo;
import main.vista.CalculadoraImpuestosView;

public class CalculadoraImpuestosControlador implements ActionListener {
	private CalculadoraImpuestos model;
	private CalculadoraImpuestosView view;
	
	/**
	 * @param model
	 * @param view
	 */
	public CalculadoraImpuestosControlador(CalculadoraImpuestos model, CalculadoraImpuestosView view) {
		this.model = model;
		this.view = view;
		
		this.view.setCalcularImpuestoListener(this);
	}
	
	public void calcularImpuestoListener() {
		int año = view.getAño();
		double avaluo = view.getAvaluo();
		int cilindraje = view.getCilindraje();
		Combustible combustible = view.getTipoCombustible();
		String marca = view.getMarca();
		String modelo = view.getModelo();
		TipoVehiculo tipoVehiculo = view.getTipoVehiculo();
		
		Vehiculo vehiculo = new Vehiculo(año, avaluo, cilindraje, combustible, marca, modelo, tipoVehiculo);
		double valorImpuesto = model.calcularImpuesto(vehiculo);
		
		view.setValorImpuesto(valorImpuesto);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "CalcularImpuesto") {
			calcularImpuestoListener();
		}
	}
}
