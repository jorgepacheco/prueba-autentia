package org.jpacheco.rest.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.jpacheco.rest.spring.bean.Curso;

public interface CursosMapper {
	
	public List<Curso> getAll();
	
	public List<Curso> getActiveCourses(@Param("activo") Boolean activo);
	
	public List<Curso> getActiveCoursesPag(@Param("activo") Boolean activo, @Param("order") String order, RowBounds rb);
	
	public int insert(Curso curso);
	
	public int getCountActiveCourses(@Param("activo") Boolean activo);
	
	public Curso getCursoById(@Param("id") int id);

	
}
 