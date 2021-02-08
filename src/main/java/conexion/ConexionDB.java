package conexion;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import objetos.Asignatura;
import objetos.Centro;
import objetos.Profesor;

public class ConexionDB {
	
	public static void main(String[]args) throws Exception{
	
	
		Centro centro = new Centro("123a", "Itaca", "José Luis", "Santa Isabel", "Zaragoza", "Zaragoza");
		Centro centro2 = new Centro("4568F", "losEnlaces", "Maria", "losEnlaces", "Zaragoza", "Zaragoza");
		
		Profesor profesor4 = new Profesor("89f", "Dani", "Punas Lorenzo", "masculino", "12122002", "Itaca");
		Profesor profesor5 = new Profesor("89f", "Marcos", "Punas Lorenzo", "masculino", "12122000", "Itaca");
		Profesor profesor2 = new Profesor("489d", "Mario", "Mateo Salas", "masculino", "08051995", "Itaca");
		Profesor profesor1 = new Profesor("9999f", "Sara", "Lopez Ortiz", "femenino", "12011981", "losEnlaces");
		Profesor profesor6 = new Profesor("12345d", "Sara", "Lopez Ortiz", "femenino", "12011983", "losEnlaces");
		Profesor profesor3 = new Profesor("4789g", "Maria", "Ortega Gallego", "femenino", "03121966", "losEnlaces");
		
		
		Asignatura asignatura1 = new Asignatura(1, "AD");
		Asignatura asignatura2 = new Asignatura(2, "SGSE");
		Asignatura asignatura3 = new Asignatura(3, "EIE");
		Asignatura asignatura4 = new Asignatura(4, "ingles");
		Asignatura asignatura5 = new Asignatura(5, "PSP");
		Asignatura asignatura6 = new Asignatura(6, "programacion");
		Asignatura asignatura7 = new Asignatura(7, "DI");
		Asignatura asignatura8 = new Asignatura(8, "FOL");
		

		
		ODB odb = null;
	

        try {
            // Open the database
            odb = ODBFactory.open("Escritorio\\EQUIPOS.DB");
            
            // Store the object
            odb.store(centro);
          
        } finally {
            if (odb != null) {
                // Close the database
                odb.close();
            }
        }
	}

	


}
