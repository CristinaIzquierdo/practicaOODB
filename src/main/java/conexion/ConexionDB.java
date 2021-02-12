package conexion;


import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import objetos.Asignatura;
import objetos.Centro;
import objetos.Profesor;

public class ConexionDB {
	
	public static void main(String[]args) {
		
		ODB odb = ODBFactory.open("Escritorio\\ADPRUEBANEODATIS.DB");
		
		Centro centro = new Centro(1, "Itaca", 1, "Santa Isabel", "Zaragoza", "Zaragoza");
		Centro centro2 = new Centro(2, "losEnlaces", 2, "losEnlaces", "Zaragoza", "Zaragoza");
	
		
		Profesor profesor1 = new Profesor(1, "Dani", "Punas Lorenzo", 'm', "12-01-1997", 1);
		Profesor profesor2 = new Profesor(2, "Marcos", "Punas Lorenzo", 'm', "01-04-1987", 1);
		Profesor profesor3 = new Profesor(3, "Mario", "Mateo Salas", 'm', "21-12-2000", 2);
		Profesor profesor4 = new Profesor(4, "Sara", "Lopez Ortiz", 'f', "01-12-1994", 2);
		Profesor profesor5 = new Profesor(5, "Sara", "Lopez Ortiz", 'f', "08-08-1988", 1);
		Profesor profesor6 = new Profesor(6, "Maria", "Ortega Gallego", 'f', "01-07-1999", 2);
		
		
		Asignatura asignatura1 = new Asignatura(1, "AD");
		Asignatura asignatura2 = new Asignatura(2, "SGSE");
		Asignatura asignatura3 = new Asignatura(3, "EIE");
		Asignatura asignatura4 = new Asignatura(4, "ingles");
		Asignatura asignatura5 = new Asignatura(5, "PSP");
		Asignatura asignatura6 = new Asignatura(6, "programacion");
		Asignatura asignatura7 = new Asignatura(7, "DI");
		Asignatura asignatura8 = new Asignatura(8, "FOL");
		
		/*
        /*SE ALMACENANA LOS CENTROS*/
        odb.store(centro);
        odb.store(centro2);
        
        /*SE ALMACENANA LOS PROFESORES*/
        odb.store(profesor1);
        odb.store(profesor2);
        odb.store(profesor3);
        odb.store(profesor4);
        odb.store(profesor5);
        odb.store(profesor6);
        
        /*SE ALMACENANA LAS ASIGNATURAS*/
        odb.store(asignatura1);
        odb.store(asignatura2);
        odb.store(asignatura3);
        odb.store(asignatura4);
        odb.store(asignatura5);
        odb.store(asignatura6);
        odb.store(asignatura7);
        odb.store(asignatura8);

        

        /* LISTAR TODOS LOS PROFESORES
        Objects<Profesor> objects = odb.getObjects(Profesor.class);
        System.out.printf("%d Profesores:: %n", objects.size());
            
        while(objects.hasNext()) {
           Profesor p = objects.next();
           OID oid = odb.getObjectId(p);
           System.out.println("OID: " +oid.getObjectId()+ " => ");
           System.out.println(p);
        }
         LISTAR TODOS LOS PROFESORES*/
        
        
        /* LISTAR PROFESORES DE UN CENTRO*/
        IQuery iQuery = new CriteriaQuery(Profesor.class, Where.equal(Profesor.CENTRO, "losEnlaces"));
        iQuery.orderByAsc(Profesor.NOMBRE); //ordena ascendente por nombre
        
        Objects<Profesor> iterador = odb.getObjects(iQuery);
                   
        while(iterador.hasNext()) {
           Profesor p = iterador.next();
           OID oid = odb.getObjectId(p);
           System.out.println("OID: " +oid.getObjectId()+ " => ");
           System.out.println(p);
        }
        /* LISTAR PROFESORES DE UN CENTRO*/
        
                    
        odb.close();
            
        }
}

	



