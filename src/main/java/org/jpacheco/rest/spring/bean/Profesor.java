package org.jpacheco.rest.spring.bean;

import java.io.Serializable;
import java.util.List;

public class Profesor implements Serializable {
	
	private long id;
	
	private String nombre;
	
	private String apellidos;
	
	private List<Curso> cursos;

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

}
