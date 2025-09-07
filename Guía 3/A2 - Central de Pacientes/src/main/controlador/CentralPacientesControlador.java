package main.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.modelo.CentralPacientes;
import main.modelo.ListaEnlazadaSimple;
import main.modelo.Paciente;
import main.vista.CentralPacientesView;

public class CentralPacientesControlador implements ActionListener {
	private CentralPacientes model;
	private CentralPacientesView view;
	
	/**
	 * @param model
	 * @param view
	 */
	public CentralPacientesControlador(CentralPacientes model, CentralPacientesView view) {
		this.model = model;
		this.view = view;
		
		view.setAgregarPacienteListener(this);
		view.setBuscarPacienteListener(this);
		view.setEliminarPacienteListener(this);
		
		view.actualizarTabla(model.getPacientes());
	}
	
	public void agregarPaciente() {
		try {
			String clinica = view.getNuevoPacienteClinica();
			String edad = view.getNuevoPacienteEdad();
			String identificacion = view.getNuevoPacienteIdentificacion();
			String nombre = view.getNuevoPacienteNombre();
			
			if (identificacion.equals("")) {
				view.setErrorMessage("Por favor ingrese una identificación");
				return;
			} else if (nombre.equals("")) {
				view.setErrorMessage("Por favor ingrese un nombre");
				return;
			} else if (edad.equals("")) {
				view.setErrorMessage("Por favor ingrese una edad");
				return;
			} else if (clinica.equals("")) {
				view.setErrorMessage("Por favor ingrese una clinica");
				return;
			}
			
			int edadNumero = Integer.parseInt(edad);			
			if (edadNumero < 0) {
				view.setErrorMessage("Por favor ingrese una edad valida");
				return;				
			} 
			
			model.agregarPaciente(new Paciente(clinica, edadNumero, identificacion, nombre));
			view.actualizarTabla(model.getPacientes());
		} catch(NumberFormatException e) {
			view.setErrorMessage("La edad no es un numero valido");
		} catch (Exception e) {
			view.setErrorMessage(e.getMessage());
		}
	}
	
	public void buscarPaciente() {
		try {
			String identificacion = view.getBuscarPacienteIdentificacion();
			
			if (identificacion.equals("")) {
				view.actualizarTabla(model.getPacientes());
			} else {
				Paciente p = model.buscarPaciente(identificacion);
				ListaEnlazadaSimple<Paciente> listaNueva = new ListaEnlazadaSimple<Paciente>();
				listaNueva.add(p);
				
				view.actualizarTabla(listaNueva);
			}
		} catch (Exception e) {
			view.setErrorMessage(e.getMessage());
		}
	}
	
	public void eliminarPaciente() {
		try {
			String identificacion = view.getEliminarPacienteIdentificacion();
			
			model.eliminarPaciente(identificacion);
			view.actualizarTabla(model.getPacientes());
		} catch (Exception e) {
			view.setErrorMessage(e.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "AGREGAR") {
			view.setErrorMessage("");
			agregarPaciente();
		} else if(e.getActionCommand() == "BUSCAR") {
			view.setErrorMessage("");
			buscarPaciente();
		} else if(e.getActionCommand() == "ELIMINAR") {
			view.setErrorMessage("");
			eliminarPaciente();
		} 
	}
}
