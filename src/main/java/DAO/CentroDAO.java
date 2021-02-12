package DAO;

import java.util.ArrayList;
import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

import objetos.Centro;

public class CentroDAO {

	private ODB odb;

	public CentroDAO(ODB odb) {
		this.odb = odb;
	}
	
	public List<Centro> getAllCentros(){
		List<Centro> centros = new ArrayList<Centro>();
		
		Objects<Centro> iterador = odb.getObjects(Centro.class);
		System.out.printf("%dCentros: %n", +iterador.size());
		
		while(iterador.hasNext()) {
			Centro centro = iterador.next();
			centros.add(centro);
		}
		
		return centros;		
	}
	
}
