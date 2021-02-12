package objetos;

import java.util.Calendar;
import java.util.List;

public class Profesor {
	
	public static String CODIGO = "codigo"; 
	public static String NOMBRE = "nombre"; 
	public static String APELLIDOS = "apellidos"; 
	public static String SEXO = "sexo"; 
	public static String FECHANACIMIENTO = "fechaNacimiento"; 
	public static String CENTRO = "centro"; 
	
	private float codigo;
	private String nombre;
	private String apellidos;
	private char sexo;
	private String fechaNacimiento;
	private float centro;
	public List<Asignatura> asignatura;
	
	
	public Profesor() {
	}
	
	
	public Profesor(float codigo, String nombre, String apellidos, char sexo, String fechaNacimiento, float centro) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.centro = centro;
	}
	
	
	public Profesor(float codigo, String nombre, String apellidos, char sexo, String fechaNacimiento, float centro, List<Asignatura> asignatura) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.centro = centro;
		this.asignatura = asignatura;
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
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public float getCentro() {
		return centro;
	}
	public void setCentro(float centro) {
		this.centro = centro;
	}


	@Override
	public String toString() {
		return "Profesor{"+
				"codigo='" + codigo + '\'' +
				", nombre=" + nombre + '\'' +
				", apellidos=" + apellidos + '\'' +
				", sexo=" + sexo + '\'' +
				", fechaNacimiento=" + fechaNacimiento + '\'' +
				", centro=" + centro + '\'' +
				", asignatura=" + asignatura + 
				'}';
	}
	
	
	
	
	
	
	

}
