package main.mvc;

import main.modelo.CalculadoraImpuestos;
import main.controlador.CalculadoraImpuestosControlador;
import main.vista.CalculadoraImpuestosView;

public class Main {
	public static void main(String[] args) {
		CalculadoraImpuestos model = new CalculadoraImpuestos();
		CalculadoraImpuestosView view = new CalculadoraImpuestosView();
		CalculadoraImpuestosControlador controlador = new CalculadoraImpuestosControlador(model, view);
		
		view.setVisible(true);
	}
}
