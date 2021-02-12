package DAO;

import java.util.ArrayList;

import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

import objetos.Asignatura;

public class AsignaturaDAO {

	private ODB odb;

	public AsignaturaDAO(ODB odb) {
		this.odb = odb;
	}
	
	public List<Asignatura> getAllAsignaturas(){
		List<Asignatura> asignaturas = new ArrayList<Asignatura>();
		
		Objects<Asignatura> iterador = odb.getObjects(Asignatura.class);
		System.out.printf("%dAsignaturas: %n", +iterador.size());
		
		while(iterador.hasNext()) {
			Asignatura asignatura = iterador.next();
			asignaturas.add(asignatura);
		}
		
		return asignaturas;		
	}
	
}
