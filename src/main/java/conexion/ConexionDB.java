package conexion;


import java.util.ArrayList;
import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import DAO.AsignaturaDAO;
import DAO.CentroDAO;
import DAO.ProfesorDAO;
import objetos.Asignatura;
import objetos.Centro;
import objetos.Profesor;
import utils.Leer;

public class ConexionDB {
	
	public static void main(String[]args) {
		
		ODB odb = ODBFactory.open("Escritorio\\ADPRUEBANEODATIS.DB"); //Se crea la base de datos
		
		ProfesorDAO profesorDAO = new ProfesorDAO();   
    	CentroDAO centroDAO = new CentroDAO();
    	AsignaturaDAO asignaturaDAO = new AsignaturaDAO();
    	
    	introducirDatos(odb, profesorDAO, asignaturaDAO, centroDAO);
		
		
    	//MENU
    	int opcion;
    	List<Profesor> profesores;
    	List<Asignatura> asignaturas;
    	
    	
    	do {
    		opcion = menu();
    		
    		switch(opcion) {
    		
    			case 1:  //Listar todos los centros
    				
    				List<Centro> centros = centroDAO.getAll(odb);
    				for (Centro centro: centros) {
    					System.out.println(centro);
    				}
    				
    				break;
    			
    			case 2: //Listar todos los profesores
    				
    				profesores = profesorDAO.getAll(odb);
    				for(Profesor profesor : profesores) {
    					System.out.println(profesor);
    				}
    				
    				break;
    				
    			case 3: //Listar los profesores de un centro cuya fecha de nacimiento sea anterior a 1993.
    				
//    				pDao.getAllBeforeDate(odb, "1993");
    				profesores = profesorDAO.getAll(odb);
    				for(Profesor profesor : profesores) {
    					String fecha = profesor.getFechaNacimiento();
    					int year = Integer.parseInt(fecha.substring(6, 10));
    					if(year < 1993) {
    						System.out.println(profesor);
    					}
    				}
    				
    				break;
    				
    			case 4: //Listar los profesores de sexo masculino que impartan la asignatura de Acceso a datos.
    				asignaturas = asignaturaDAO.getNombre(odb, "Acceso a datos");		//Meto en una lista las asignaturas que se llamen Acceso a datos.
    				for(Asignatura asignatura : asignaturas) {
    					profesores = asignatura.getListaProfesoresAsignatura();
    					for(Profesor p : profesores) {
    						if(p.getSexo().contentEquals("Hombre")) {
    							System.out.println(p.toString());				//Saco por pantalla los profesores hombres que imparten acceso a datos.
    						}
    					}
    				}				
    				break;
    				
    			case 5: //Comprobar que un profesor ya existe.				
    				System.out.println("Escribe el nombre del profesor.");
    				String nombre = Leer.pedirCadena();
    				System.out.println("Escribe su apellido.");
    				String apellido = Leer.pedirCadena();
    				
    				profesores = profesorDAO.getAllSameName(odb, nombre, apellido);
    				if(profesores.isEmpty()) {
    					System.out.println("El profesor no esta en la base de datos.");
    				}else {
    					for(Profesor prof : profesores) {
    						System.out.println(prof);
    					}
    				}
    				break;	
    				
    			case 6: //Eliminar un profesor.				
    				System.out.println("Escribe el código del profesor.");
    				int codigo = Leer.pedirEnteroValidar();
    				
    				profesorDAO.delete(odb, codigo);
    				break;
    				
    				
    			case 0: System.out.println("Has salido.");
    				odb.close();	//Cierro la base de datos.
    				break;
    			}
    			
    		
    	} while (opcion != 0);
    	
	}//FIN MAIN
    	
	//METODOS
		public static int menu() {
			
				System.out.println("Elige una de las siguientes opciones, para salir pulse 0.");
				System.out.println("1- Listar todos los centros.");
				System.out.println("2- Listar todos los profesores.");
				System.out.println("3- Listar los profesores de un centro cuya fecha de nacimiento sea anterior a 1993.");
				System.out.println("4- Listar los profesores de sexo masculino que impartan la asignatura de Acceso a datos.");
				System.out.println("5- Comprobar que un profesor ya existe.");
				System.out.println("6- Eliminar un profesor.");
				int opcion = Leer.pedirEnteroValidar();		
			
			return opcion;
		}
		
    	
		public static void introducirDatos(ODB odb, ProfesorDAO pDao, AsignaturaDAO aDao, CentroDAO cDao) {
			//Creo 6 profesores, 3 centros y 8 asignaturas
			
			Profesor profesor1 = new Profesor(1, "Dani", "Punas Lorenzo", "Hombre", "12-01-1997", 1);
			Profesor profesor2 = new Profesor(2, "Marcos", "Punas Lorenzo", "Hombre", "01-04-1987", 1);
			Profesor profesor3 = new Profesor(3, "Mario", "Mateo Salas", "Hombre", "21-12-2000", 2);
			Profesor profesor4 = new Profesor(4, "Sara", "Lopez Ortiz", "Mujer", "01-12-1994", 2);
			Profesor profesor5 = new Profesor(5, "Sara", "Lopez Ortiz", "Mujer", "08-08-1988", 1);
			Profesor profesor6 = new Profesor(6, "Maria", "Ortega Gallego", "Mujer", "01-07-1999", 2);
			
			
			List<Profesor> listaProfesores1 = new ArrayList();
	    	listaProfesores1.add(profesor1);
	    	listaProfesores1.add(profesor4);
	    
	    	
	    	List<Profesor> listaProfesores2 = new ArrayList();
	    	listaProfesores2.add(profesor2);
	    	listaProfesores2.add(profesor6);
	    	
	    	
	    	List<Profesor> listaProfesores3 = new ArrayList();
	    	listaProfesores3.add(profesor3);
	    	listaProfesores3.add(profesor5);
	    	
	    	
	    	
	    	
	    	
	    	Centro centro1 = new Centro(1, "Itaca", 1, "Santa Isabel", "Zaragoza", "Zaragoza");
	    	
	    	centro1.listaProfesores(listaProfesores1);
	    	profesor1.setCentroProfesor(centro1);
	    	profesor3.setCentroProfesor(centro1);
	    	profesor6.setCentroProfesor(centro1);
	    	
	    	
	    	
	    	
	    	
	    	Centro centro2 = new Centro(2, "losEnlaces", 2, "losEnlaces", "Zaragoza", "Zaragoza");
	    	
	    	centro2.listaProfesores(listaProfesores2);
	    	profesor4.setCentroProfesor(centro2);
	    	profesor5.setCentroProfesor(centro2);
	    	profesor6.setCentroProfesor(centro2);
	    	
	    	
	    	Centro centro3 = new Centro(3, "CristoRey", 3, "CristoRey", "Zaragoza", "Zaragoza");
	    	
	    	centro3.listaProfesores(listaProfesores3);
	    	profesor1.setCentroProfesor(centro3);
	    	profesor2.setCentroProfesor(centro3);
	    
		
	    	List<Profesor> profesoresAD = new ArrayList();
	    	profesoresAD.add(profesor1);
	    	profesoresAD.add(profesor2);
	    	
	    	List<Profesor> profesoresSGSE = new ArrayList();
	    	profesoresAD.add(profesor3);
	    	profesoresAD.add(profesor4);
	    	
	    	List<Profesor> profesoresEIE = new ArrayList();
	    	profesoresAD.add(profesor5);
	    	profesoresAD.add(profesor6);
	    	
	    	List<Profesor> profesoresIngles = new ArrayList();
	    	profesoresAD.add(profesor1);
	    	profesoresAD.add(profesor2);
	    	
	    	List<Profesor> profesoresPSP = new ArrayList();
	    	profesoresAD.add(profesor5);
	    	profesoresAD.add(profesor6);
	    	
	    	List<Profesor> profesoresProgramacion = new ArrayList();
	      	profesoresAD.add(profesor3);
	    	profesoresAD.add(profesor4);
	    	
	    	List<Profesor> profesoresDI = new ArrayList();
	    	profesoresAD.add(profesor1);
	    	profesoresAD.add(profesor3);
	    	
	    	List<Profesor> profesoresFOL = new ArrayList();
	    	profesoresAD.add(profesor5);
	    	profesoresAD.add(profesor4);
	    	
	    		    	
			Asignatura asignatura1 = new Asignatura(1, "AD");
			asignatura1.setListaProfesoresAsignatura(profesoresAD);
			
			Asignatura asignatura2 = new Asignatura(2, "SGSE");
			asignatura2.setListaProfesoresAsignatura(profesoresSGSE);
			
			Asignatura asignatura3 = new Asignatura(3, "EIE");
			asignatura3.setListaProfesoresAsignatura(profesoresEIE);
			
			Asignatura asignatura4 = new Asignatura(4, "ingles");
			asignatura4.setListaProfesoresAsignatura(profesoresIngles);
			
			Asignatura asignatura5 = new Asignatura(5, "PSP");
			asignatura5.setListaProfesoresAsignatura(profesoresPSP);
			
			Asignatura asignatura6 = new Asignatura(6, "programacion");
			asignatura6.setListaProfesoresAsignatura(profesoresProgramacion);
			
			Asignatura asignatura7 = new Asignatura(7, "DI");
			asignatura7.setListaProfesoresAsignatura(profesoresDI);
			
			Asignatura asignatura8 = new Asignatura(8, "FOL");
			asignatura8.setListaProfesoresAsignatura(profesoresFOL);
		
			
	        /*SE ALMACENANA LOS CENTROS*/
			pDao.save(profesor1, odb);
			pDao.save(profesor2, odb);
			pDao.save(profesor3, odb);
			pDao.save(profesor4, odb);
			pDao.save(profesor5, odb);
			pDao.save(profesor6, odb);
			
	        cDao.save(centro1, odb);
	        cDao.save(centro2, odb);
	        cDao.save(centro3, odb);
	        
	        aDao.save(asignatura1, odb);
	        aDao.save(asignatura2, odb);
	        aDao.save(asignatura3, odb);
	        aDao.save(asignatura4, odb);
	        aDao.save(asignatura5, odb);
	        aDao.save(asignatura6, odb);
	        aDao.save(asignatura7, odb);
	        aDao.save(asignatura8, odb);
  
       
            
        }
}

	



