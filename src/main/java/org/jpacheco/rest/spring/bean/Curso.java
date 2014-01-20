package org.jpacheco.rest.spring.bean;

import java.io.Serializable;

public class Curso implements Serializable {
	
	
	private int id;
	
	private String titulo;
	
	private int horas;
	
	private String nivel;
	
	private Profesor profesor;
	
	private String fileUpload;
	
	private String fileName;
	
	private byte[] file;
	
	public byte[] getFile() {
		return file;
	}


	public void setFile(byte[] file) {
		this.file = file;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getFileUpload() {
		return fileUpload;
	}


	public void setFileUpload(String fileUpload) {
		this.fileUpload = fileUpload;
	}


	public Profesor getProfesor() {
		return profesor;
	}


	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}




	private Boolean activo;


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public int getHoras() {
		return horas;
	}


	public void setHoras(int horas) {
		this.horas = horas;
	}


	public String getNivel() {
		return nivel;
	}


	public void setNivel(String nivel) {
		this.nivel = nivel;
	}


	public Boolean getActivo() {
		return activo;
	}


	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	
	

}
