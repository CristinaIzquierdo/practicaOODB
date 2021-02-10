package objetos;

public class Centro {
	
	private float codigo;
	private String nombre;
	private float director;
	private String direccion;
	private String localidad;
	private String provincia;
	
	
	public Centro(float codigo, String nombre, float director, String direccion, String localidad, String provincia) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.director = director;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
	}


	public Centro() {
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


	public float getDirector() {
		return director;
	}


	public void setDirector(float director) {
		this.director = director;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	
	
	
	
	

}
