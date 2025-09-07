package main.mvc;

import main.controlador.CentralPacientesControlador;
import main.modelo.CentralPacientes;
import main.vista.CentralPacientesView;

public class Main {
	public static void main(String[] args) {
		CentralPacientes model = new CentralPacientes();
		CentralPacientesView view = new CentralPacientesView();
		CentralPacientesControlador controlador = new CentralPacientesControlador(model, view);
		
		view.setVisible(true);
	}
}
