package DAO;

import java.util.ArrayList;

import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import objetos.Asignatura;

public class AsignaturaDAO implements IDAO<Asignatura>{

	//private ODB odb;
	
	@Override
	public Asignatura get(String id) {
		return null;
	}
	
	
	public List<Asignatura> getNombre(ODB odb, String nombre) {
		
		List<Asignatura> asignatura = new ArrayList();
		IQuery query = new CriteriaQuery(Asignatura.class, Where.equal("nombre", nombre));
		Objects<Asignatura> objectsAsignaturas = odb.getObjects(query);
		
		while(objectsAsignaturas.hasNext()) {
			asignatura.add(objectsAsignaturas.next());
		}
		return asignatura;
		
	}

	

	@Override
	public List<Asignatura> getAll(ODB odb) {
		
		List<Asignatura> asignaturas = new ArrayList();
		IQuery query = new CriteriaQuery(Asignatura.class);
		Objects<Asignatura> objectsAsignaturas = odb.getObjects(query);
		
		while (objectsAsignaturas.hasNext()) {
			asignaturas.add(objectsAsignaturas.next());
		}
		return asignaturas;
	}
	
	

	@Override
	public void save(Asignatura asignatura, ODB odb) {
		odb.store(asignatura);
		
	}

	@Override
	public void update(Asignatura t, String nombreDocumento) {}

	@Override
	public void delete(ODB odb, int codigo) {}
	
}
