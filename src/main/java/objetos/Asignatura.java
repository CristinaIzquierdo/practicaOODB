package objetos;

public class Asignatura {
	private float codigo;
	private String nombre;
	
	
	public Asignatura(float codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}


	public Asignatura() {
		super();
	}


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
	
	

}
