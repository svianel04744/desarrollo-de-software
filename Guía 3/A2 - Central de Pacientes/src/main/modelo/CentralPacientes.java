package main.modelo;

public class CentralPacientes {
	private ListaEnlazadaSimple<Paciente> pacientes;

	/**
	 * 
	 */
	public CentralPacientes() {
		this.pacientes = new ListaEnlazadaSimple<Paciente>();
	}
	
	public void agregarPaciente(Paciente paciente) throws Exception {
		try {
			buscarPaciente(paciente.getId());
		} catch (Exception e) {
			pacientes.add(paciente);
			return;
		}
		
		throw new Exception("Ya existe un paciente con esa identificación");
	}
	
	public Paciente buscarPaciente(String identificacion) throws Exception{
		for (int i = 0; i < pacientes.size(); i++) {
			if(pacientes.get(i).getId().equals(identificacion)) {
				return pacientes.get(i);
			}
		}
		
		throw new Exception("El paciente no existe");
	}
	
	public void eliminarPaciente(String identificacion) throws Exception {
		for (int i = 0; i < pacientes.size(); i++) {
			if(pacientes.get(i).getId().equals(identificacion)) {
				pacientes.remove(i);
				return;
			}
		}
		
		throw new Exception("El paciente no existe");
	}

	public ListaEnlazadaSimple<Paciente> getPacientes() {
		return pacientes;
	}
}
