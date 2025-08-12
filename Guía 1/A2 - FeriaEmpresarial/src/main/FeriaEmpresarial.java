package main;

import java.util.*;

/**
 * Clase que representa la Feria Empresarial
 */
public class FeriaEmpresarial {
	private List<Empresa> empresas;
	private List<Stand> stands;
	private List<Visitante> visitantes;

	/**
	 * Metodo constructor de la clase Feria Empresarial
	 * 
	 * Contiene la creación de algunos datos de prueba para ser visualizados al inicio de la aplicación
	 */
	public FeriaEmpresarial() {
		this.empresas = new ArrayList<Empresa>();
		this.stands = new ArrayList<Stand>();
		this.visitantes = new ArrayList<Visitante>();
		
		// Datos de prueba
		Empresa empresaA = new Empresa("ventas@microsoft.com", "123", "Microsoft", "TECNOLOGIA");
		Empresa empresaB = new Empresa("ventas@apple.com", "234", "Apple", "TECNOLOGIA");
		
		Stand standA = new Stand(1, "Pabellon A", TamañoStand.GRANDE);
		Stand standB = new Stand(2, "Pabellon A", TamañoStand.MEDIANO);
		Stand standC = new Stand(3, "Pabellon A", TamañoStand.PEQUEÑO);

		Visitante visitanteA = new Visitante("visitante_a@gmail.com", "001", "Visitante A");
		Visitante visitanteB = new Visitante("visitante_b@gmail.com", "002", "Visitante B");
		Visitante visitanteC = new Visitante("visitante_c@gmail.com", "003", "Visitante C");
		
		standB.setEmpresa(empresaA);
		
		Reseña r = standB.agregarReseña(4, "Estaba lindo", visitanteC);
		
		visitanteC.agregarReseña(r);
		
		empresas.add(empresaA);
		empresas.add(empresaB);
		
		visitantes.add(visitanteA);
		visitantes.add(visitanteB);
		visitantes.add(visitanteC);
		
		stands.add(standA);
		stands.add(standB);
		stands.add(standC);
	}
	
	/**
	 * Asigna una Empresa a un Stand
	 * 
	 * @param nitEmpresa El NIT de la empresa a asignar
	 * @param numeroStand El numero del Stand
	 * 
	 * @throws Exception Retorna un error en casi de que la Empresa o el Stand no se encuentren
	 */
	public void asignarEmpresaAStand(String nitEmpresa, int numeroStand) throws Exception {
		Empresa empresa = null;		
		for (Empresa e : empresas) {
			if (e.getNit().equals(nitEmpresa)) {
				empresa = e;
			}
		}
		
		if(empresa == null) {
			throw new Exception("Empresa no encontrada");
		}
		
		Stand stand = null;		
		for (Stand s : stands) {
			if(s.getNumero() == numeroStand) {
				stand = s;
			}
		}
		
		if(stand == null) {
			throw new Exception("Stand no encontrado");
		}
		
		empresa.setStand(stand);
		stand.setEmpresa(empresa);
	}
	
	/**
	 * Crea una reseña para un STand
	 * 
	 * @param calificacion La calificación (1 a 5) de la reseña dada por el Visitante
	 * @param comentario El comentario de la reseña dado por el Visitante
	 * @param identificacionVisitante La identificación del visitante que escribio la reseña
	 * @param numeroStand EL numero del Stand el cual se esta reseñando
	 * 
	 * @throws Exception Retorna un error si no se cumple:
	 * 	- La calificación no esta entre 1 y 5
	 *  - El Visitante no se encuentra
	 *  - El Stand no existe
	 *  - El Stand no tiene ninguna Empresa asignada 
	 */
	public void calificarStand(int calificacion, String comentario, String identificacionVisitante, int numeroStand) throws Exception {
		if(calificacion < 0 || calificacion > 5) {
			throw new Exception("La calificación debe ser entre 1 y 5");
		}
		
		Visitante visitante = null;
		for (Visitante v: visitantes) {
			if (v.getIdentificacion().equals(identificacionVisitante)) {
				visitante = v;
			}
		}
		
		if (visitante == null) {
			throw new Exception("El visitante no existe");
		}
		
		boolean encontrado = false;
		for (Stand stand : stands) {
			if(stand.getNumero() == numeroStand) {
				if(stand.getEmpresa() == null) {
					throw new Exception("El stand esta vacio");
				}
				
				Reseña reseña = stand.agregarReseña(calificacion, comentario, visitante);
				visitante.agregarReseña(reseña);
				encontrado = true;
			}
		}
		
		if(!encontrado) {
			throw new Exception("El stand no existe");
		}
	}
	
	/**
	 * Crea un nuevo Stand
	 * 
	 * @param numero El numero unico del Stand
	 * @param tamañoUsuario El tamaño del Stand
	 * @param ubicacion La ubicación del Stand
	 * 
	 * @throws Exception Retorna un error si no se cumple:
	 *  - El tamaño del Stand no es valido (PEQUEÑO, MEDIANO o GRANDE)
	 *  - El numero del Stand ya esta siendo utilizado
	 */
	public void crearStand(int numero, String tamañoUsuario, String ubicacion) throws Exception{
        try {
        	TamañoStand tamaño = TamañoStand.valueOf(tamañoUsuario);
        	
			for (Stand stand : stands) {
				if(stand.getNumero() == numero) {
					throw new Exception("Numero de stand ya utilizado");
				}
			}
			
			Stand nuevo = new Stand(numero, ubicacion, tamaño);
			this.stands.add(nuevo);
		} catch (IllegalArgumentException e) {
			throw new Exception("El tamaño del stand no es valido");
		}
	}
	
	/**
	 * Actualiza la información de una empresa
	 * 
	 * @param nit El nit de la empresa que se quiere actualizar
	 * @param nuevoCorreo El nuevo correo
	 * @param nuevoNombre El nuevo nombre
	 * @param nuevoSector El nuevo sector
	 * 
	 * @throws Exception Retorna un error si la empresa con ese NIT no existe
	 */
	public void editarEmpresa(String nit, String nuevoCorreo, String nuevoNombre, String nuevoSector) throws Exception {
        for (Empresa empresa : empresas) {
			if(empresa.getNit().equals(nit)) {
				empresa.setCorreo(nuevoCorreo);
				empresa.setNombre(nuevoNombre);
				empresa.setSector(nuevoSector);
					
				return;
			}
		}
        	
        throw new Exception("Empresa no econtrada");
	}
	
	/**
	 * Actualiza la información de un visitante
	 * 
	 * @param identificacion La identificación del visitante que se quiere actualizar
	 * @param nuevoCorreo El nuevo correo
	 * @param nuevoNombre El nuevo nombre
	 * 
	 * @throws Exception Retorna un error en caso de que el visitante con esa identificación no exista
	 */
	public void editarVisitante(String identificacion, String nuevoCorreo, String nuevoNombre) throws Exception {
        for (Visitante visitante: visitantes) {
			if(visitante.getIdentificacion().equals(identificacion)) {
				visitante.setCorreo(nuevoCorreo);
				visitante.setNombre(nuevoNombre);
					
				return;
			}
		}
        	
        throw new Exception("Visitante no econtrado");
	}
	
	/**
	 * Elimina una empresa
	 * 
	 * @param nit El NIT de la empresa
	 * 
	 * @throws Exception En caso de que no se encuentre la empresa con ese NIT
	 */
	public void eliminarEmpresa(String nit) throws Exception {
		for (Empresa empresa : empresas) {
			if (empresa.getNit().equals(nit)) {
				this.empresas.remove(empresa);
				return;
			}
		}
		
		throw new Exception("Empresa no encontrada");
	}
	
	/**
	 * Elimina un Stand
	 * 
	 * @param numero El numero unico del Stand a eliminar
	 * 
	 * @throws Exception En caso de que no exista el Stand con ese numero
	 */
	public void eliminarStand(int numero) throws Exception {
		for (Stand stand: stands) {
			if (stand.getNumero() == numero) {
				this.stands.remove(stand);
				return;
			}
		}
		
		throw new Exception("Stand no encontrada");
	}
	
	/**
	 * Elimna un visitante
	 * 
	 * @param identificacion La identificación del visitante a eliminar
	 * 
	 * @throws Exception En caso de que no se encuentre un visitante con esa identificaión
	 */
	public void eliminarVisitante(String identificacion) throws Exception {
		for (Visitante visitante: visitantes) {
			if (visitante.getIdentificacion().equals(identificacion)) {
				this.visitantes.remove(visitante);
			}
		}
		
		throw new Exception("Visitante no encontrado");
	}
	
	/**
	 * @return Retorna la lista de empresas registradas
	 */
	public List<Empresa> getEmpresas() {
		return this.empresas;
	}
	
	/**
	 * @return Retorna la lista de Stands en la feria
	 */
	public List<Stand> getStands() {
		return this.stands;
	}
	
	/**
	 * @return Retorna la lista de visistantes registrados
	 */
	public List<Visitante> getVisitantes() {
		return this.visitantes;
	}
	
	/**
	 * Registra una nueva empresa en la feria
	 *  
	 * @param nombre El nombre de la empresa
	 * @param nit El NIT de la empresa 
	 * @param sector El sector de la empresa
	 * @param correo El correo de la empresa
	 */
	public void registrarEmpresa(String correo, String nit, String nombre, String sector) {
       Empresa nueva = new Empresa(correo, nit, nombre, sector);
       this.empresas.add(nueva);
	}
	
	/**
	 * Registra un nuevo visitante en la feria
	 * 
	 * @param correo El Correo del visitante
	 * @param identificacion La Identificación del visitante
	 * @param nombre El Nombre del visitante
	 */
	public void registrarVisitante(String correo, String identificacion, String nombre) {
		Visitante nuevo = new Visitante(correo, identificacion, nombre);
		this.visitantes.add(nuevo);
	}
}