package org.jpacheco.rest.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jpacheco.rest.spring.bean.Profesor;

public interface ProfesorMapper {
	
	public Profesor getAutorWithTutoriales(@Param("id_profesor") int id);
	
	public List<Profesor> getAll();
	
}
