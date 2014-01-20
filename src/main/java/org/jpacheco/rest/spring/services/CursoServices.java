package org.jpacheco.rest.spring.services;

import java.util.List;

import org.jpacheco.rest.spring.bean.Curso;
import org.jpacheco.rest.spring.bean.ResultQueryCurso;

public interface CursoServices {

	public List<Curso> getAllCourses();
	
	public int insert(Curso curso, String path);
	
	public ResultQueryCurso getAllCoursesWithPagination(int page, String order);
	
	public Curso getCursoById(int id);
	
	
}
