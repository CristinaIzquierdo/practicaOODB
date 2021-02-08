package conexion;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import objetos.Centro;

public class ConexionDB {
	
	public static void main(String[]args) throws Exception{
	
	
		Centro centro = new Centro("123a", "Itaca", "José Luis", "Santa Isabel", "Zaragoza", "Zaragoza");
		Centro centro2 = new Centro("4568F", "losEnlaces", "Maria", "losEnlaces", "Zaragoza", "Zaragoza");
		
		
		
		ODB odb = null;
	

        try {
            // Open the database
            odb = ODBFactory.open("Escritorio\\EQUIPOS.DB");
         
            // Store the object
            odb.store(centro);
            System.out.println("Correcto");
        } finally {
            if (odb != null) {
                // Close the database
                odb.close();
            }
        }
	}

	


}
