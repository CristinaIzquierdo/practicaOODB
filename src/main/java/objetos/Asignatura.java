package objetos;

import java.util.List;

public class Asignatura {
	
	public static final String CODIGO = "codigo";
	public static final String NOMBRE = "nombre";
	
	private float codigo;
	private String nombre;
//	private List<String> materia; 
	
	
	
	public Asignatura() {
	}
	
	public Asignatura(float codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
/*
  	public Asignatura(float codigo, String nombre, List<String>materia) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.materia = materia;
	}
 */

	public float getCodigo() {
		return codigo;
	}


	public void setCodigo(float codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Asignatura{" +
				"codigo='" + codigo + '\'' +
				", nombre=" + nombre + '\'' +
			//	", materia=" + materia + 
				'}';
	}
	
	
	
	

}
