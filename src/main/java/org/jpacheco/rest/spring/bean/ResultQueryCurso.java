package org.jpacheco.rest.spring.bean;

import java.util.List;

public class ResultQueryCurso {
	
	private List<Curso> cursos;
	
	private Pagination pagination;

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public ResultQueryCurso() {
		super();
	}

	public ResultQueryCurso(List<Curso> cursos, Pagination pagination) {
		super();
		this.cursos = cursos;
		this.pagination = pagination;
	}
	

}
