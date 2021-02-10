package objetos;

import java.util.Calendar;

public class Profesor {
	
	private float codigo;
	private String nombre;
	private String apellidos;
	private char sexo;
	private Calendar fechaNacimiento;
	private float centro;
	
	public Profesor(float codigo, String nombre, String apellidos, char sexo, Calendar fechaNacimiento, float centro) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.centro = centro;
	}
	public Profesor() {
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
	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public float getCentro() {
		return centro;
	}
	public void setCentro(float centro) {
		this.centro = centro;
	}
	
	
	
	

}
