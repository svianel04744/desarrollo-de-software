package main;

import java.util.Scanner;

public class App {
	private static FeriaEmpresarial feriaEmpresarial;
    private static Scanner scanner;
    
    public static void menuPrincipal() {
        System.out.println("\nBienvenido a la Feria Empresarial");
        System.out.println("1. Empresas");
        System.out.println("2. Stands");
        System.out.println("3. Visitantes");
        System.out.println("4. Reportes");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    public static void menuEmpresas() {
        while (true) {
            System.out.println("\nMenú Empresas:");
            System.out.println("1. Listar");
            System.out.println("2. Registrar");
            System.out.println("3. Editar");
            System.out.println("4. Eliminar");
            System.out.println("0. Menú Principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    listarEmpresas();
                    break;
                case 2:
                    registrarEmpresa();
                    break;
                case 3:
                    editarEmpresa();
                    break;
                case 4:
                    eliminarEmpresa();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
    
    public static void editarEmpresa() {
        System.out.print("NIT de la empresa a editar: ");
        String nit = scanner.nextLine();
        
        System.out.print("Nuevo nombre de la empresa: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Nuevo sector de la empresa: ");
        String sector = scanner.nextLine();
        
        System.out.print("Nuevo correo de la empresa: ");
        String correo = scanner.nextLine();
        
        try {
        	feriaEmpresarial.editarEmpresa(nit, correo, nombre, sector);
		} catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
		}
    }
    
    public static void eliminarEmpresa() {
        System.out.print("NIT de la empresa a eliminar: ");
        String nit = scanner.nextLine();
        
        try {
        	feriaEmpresarial.eliminarEmpresa(nit);
		} catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
		}
    }

    public static void listarEmpresas() {
        System.out.println("Empresas registradas");
        System.out.println(String.format("| %-20s | %-15s | %-15s | %-20s | %-15s |",
        		"Nombre", "Sector", "NIT", "Correo", "Stand"));
        System.out.println("|----------------------|-----------------|-----------------|----------------------|-----------------|");
        		
    	for (Empresa empresa : feriaEmpresarial.getEmpresas()) {
            System.out.println(empresa.toString());			
		}
    }
    
    public static void registrarEmpresa() {
        System.out.print("Nombre de la empresa: ");
        String nombre = scanner.nextLine();
        
        System.out.print("NIT de la empresa: ");
        String nit = scanner.nextLine();
        
        System.out.print("Sector de la empresa: ");
        String sector = scanner.nextLine();
        
        System.out.print("Correo electrónico de la empresa: ");
        String correo = scanner.nextLine();
        
        try {
            feriaEmpresarial.registrarEmpresa(correo, nit, nombre, sector);
		} catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
		}
    }
	
    public static void menuReportes() {
        while (true) {
            System.out.println("\nMenú Reportes:");
            System.out.println("1. Listar empresas y sus stands");
            System.out.println("2. Listar visitantes y stands visitados");
            System.out.println("0. Menú Principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                	generarReporteEmpresasYStands();
                    break;
                case 2:
                	generarReporteVisitantesYStands();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
    
    public static void generarReporteEmpresasYStands() {
        System.out.println("Reporte de Empresas y Stands");
        System.out.println(String.format("| %-20s | %-15s | %-15s |",
        		"Nombre", "Sector", "Stand"));
        System.out.println("|----------------------|-----------------|-----------------|");
        		
    	for (Empresa empresa : feriaEmpresarial.getEmpresas()) {
            System.out.println(empresa.generarReporteEmpresasYStands());			
		}
    }
    
    public static void generarReporteVisitantesYStands() {
        System.out.println("Reporte de Visitantes y los Stands que han visitado");
        System.out.println(String.format("| %-20s | %-20s | %-10s | %-20s | %-15s | %-30s |",
        		"Nombre", "Fecha", "# Stand", "Empresa", "Calificación", "Comentario"));
        System.out.println("|----------------------|----------------------|------------|----------------------|-----------------|--------------------------------|");
        		
    	for (Visitante visitante: feriaEmpresarial.getVisitantes()) {
            System.out.print(visitante.generarReporteDeVisitas());			
		}
    }    

    public static void menuStands() {
        while (true) {
            System.out.println("\nMenú Visitantes:");
            System.out.println("1. Listar");
            System.out.println("2. Crear");
            System.out.println("3. Eliminar");
            System.out.println("4. Asignar empresa");
            System.out.println("5. Calificar");
            System.out.println("0. Menú Principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    listarStands();
                    break;
                case 2:
                    crearStand();
                    break;
                case 3:
                    eliminarStand();
                    break;
                case 4:
                    asignarEmpresaAStand();
                    break;
                case 5:
                    calificarStand();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static void asignarEmpresaAStand() {
        System.out.print("NIT de la empresa: ");
        String nitEmpresa = scanner.nextLine();

        System.out.print("Numero del stand: ");
        int numeroStand = scanner.nextInt();
	    scanner.nextLine();
        
        try {
            feriaEmpresarial.asignarEmpresaAStand(nitEmpresa, numeroStand);
		} catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
		}
    }

    public static void calificarStand() {
        System.out.print("Identificación del visitante: ");
        String identificacionVisitante = scanner.nextLine();

        System.out.print("Numero del stand: ");
        int numeroStand = scanner.nextInt();
	    scanner.nextLine();

        System.out.print("Calificación: ");
        int calificacion = scanner.nextInt();
	    scanner.nextLine();
        
        System.out.print("Comentario: ");
        String comentario = scanner.nextLine();
        
        try {
            feriaEmpresarial.calificarStand(calificacion, comentario, identificacionVisitante, numeroStand);
		} catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
		}
    }
    
    public static void crearStand() {
        System.out.print("Numero del stand: ");
        int numero = scanner.nextInt();
	    scanner.nextLine();
        
        System.out.print("Tamaño del stand (Debe ser uno de los siguientes: PEQUEÑO, MEDIANO o GRANDE): ");
        String tamaño = scanner.nextLine();
        
        System.out.print("Ubicación del stand: ");
        String ubicacion = scanner.nextLine();
        
        try {
            feriaEmpresarial.crearStand(numero, tamaño, ubicacion);
		} catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
		}
    }
    
    public static void eliminarStand() {
        System.out.print("Numero del stand a eliminar: ");
        int numero = scanner.nextInt();
	    scanner.nextLine();
        
        try {
        	feriaEmpresarial.eliminarStand(numero);
		} catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
		}
    }
    
    public static void listarStands() {
        System.out.println("Stands");
        System.out.println(String.format("| %-15s | %-15s | %-15s | %-20s |",
        		"Numero", "Ubicación", "Tamaño", "Empresa"));
        System.out.println("|-----------------|-----------------|-----------------|----------------------|");
        		
    	for (Stand stand: feriaEmpresarial.getStands()) {
            System.out.println(stand.toString());			
		}
    }
    
    public static void menuVisitantes() {
        while (true) {
            System.out.println("\nMenú Visitantes:");
            System.out.println("1. Listar");
            System.out.println("2. Registrar");
            System.out.println("3. Editar");
            System.out.println("4. Eliminar");
            System.out.println("0. Menú Principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    listarVisitantes();
                    break;
                case 2:
                    registrarVisitante();
                    break;
                case 3:
                    editarVisitante();
                    break;
                case 4:
                    eliminarVisitante();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
    
    public static void editarVisitante() {
        System.out.print("Identificación del visitante a editar: ");
        String identificacion = scanner.nextLine();
        
        System.out.print("Nuevo nombre del visitante: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Nuevo correo del visitante: ");
        String correo = scanner.nextLine();
        
        try {
        	feriaEmpresarial.editarVisitante(identificacion, correo, nombre);
		} catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
		}
    }
    
    public static void eliminarVisitante() {
        System.out.print("Identificación del visitante a eliminar: ");
        String identificacion = scanner.nextLine();
        
        try {
        	feriaEmpresarial.eliminarVisitante(identificacion);
		} catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
		}
    }

    public static void listarVisitantes() {
        System.out.println("Visitantes registrados");
        System.out.println(String.format("| %-20s | %-15s | %-25s |",
        		"Nombre", "Identificación", "Correo"));
        System.out.println("|----------------------|-----------------|---------------------------|");
        		
    	for (Visitante visitante : feriaEmpresarial.getVisitantes()) {
            System.out.println(visitante.toString());			
		}
    }
    
    public static void registrarVisitante() {
        System.out.print("Nombre del visitante: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Identificación del visitante: ");
        String identificacion = scanner.nextLine();
        
        System.out.print("Correo electrónico del visitante: ");
        String correo = scanner.nextLine();
        
        try {
            feriaEmpresarial.registrarVisitante(correo, identificacion, nombre);
		} catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
		}
    }
    
	public static void main(String[] args) {
		feriaEmpresarial = new FeriaEmpresarial();
		scanner = new Scanner(System.in);
		
        while (true) {
        	menuPrincipal();
        	
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
	            case 1:
	                menuEmpresas();
	                break;
	            case 2:
	                menuStands();
	                break;
	            case 3:
	                menuVisitantes();
	                break;
	            case 4:
	                menuReportes();
	                break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }
    }
}
