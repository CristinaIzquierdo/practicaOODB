package conexion;

import java.util.Calendar;

import java.util.GregorianCalendar;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import objetos.Asignatura;
import objetos.Centro;
import objetos.Profesor;

public class ConexionDB {
	
	public static void main(String[]args) throws Exception{
		
		Centro centro = new Centro(1, "Itaca", 1, "Santa Isabel", "Zaragoza", "Zaragoza");
		Centro centro2 = new Centro(2, "losEnlaces", 2, "losEnlaces", "Zaragoza", "Zaragoza");
		
		Profesor profesor4 = new Profesor(1, "Dani", "Punas Lorenzo", 'm', 'fecha' 1);
		Profesor profesor5 = new Profesor(2, "Marcos", "Punas Lorenzo", 'm', 1999-04-04, 1);
		Profesor profesor2 = new Profesor(3, "Mario", "Mateo Salas", 'm', 1999-04-04, 2);
		Profesor profesor1 = new Profesor(4, "Sara", "Lopez Ortiz", 'f', 1999-04-04, 2);
		Profesor profesor6 = new Profesor(5, "Sara", "Lopez Ortiz", 'f', 1999-04-04, 1);
		Profesor profesor3 = new Profesor(6, "Maria", "Ortega Gallego", 'f', 1999-04-04, 2);
		
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
