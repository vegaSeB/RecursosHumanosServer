package co.edu.unbosque.model;

import java.io.Serializable;

public class CandidatoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre, apellido, cargo;
	private long cedula;
	private int edad;
	
	public CandidatoDTO(String nombre, String apellido, String cargo, long cedula, int edad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cargo = cargo;
		this.cedula = cedula;
		this.edad = edad;
	}

	public CandidatoDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
