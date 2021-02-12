package DAO;

import java.util.ArrayList;
import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

import objetos.Profesor;

public class ProfesorDAO {
	
	private ODB odb;

	public ProfesorDAO(ODB odb) {
		this.odb = odb;
	}
	
	public List<Profesor> getAllProfesores(){
		List<Profesor> profesores = new ArrayList<Profesor>();
		
		Objects<Profesor> iterador = odb.getObjects(Profesor.class);
		System.out.printf("%dProfesores: %n", +iterador.size());
		
		while(iterador.hasNext()) {
			Profesor profesor = iterador.next();
			profesores.add(profesor);
		}
		
		return profesores;		
	}

}
