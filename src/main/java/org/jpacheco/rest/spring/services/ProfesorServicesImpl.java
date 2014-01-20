package org.jpacheco.rest.spring.services;

import java.util.List;

import org.jpacheco.rest.spring.bean.Profesor;
import org.jpacheco.rest.spring.mapper.ProfesorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfesorServicesImpl implements ProfesorServices {

	@Autowired
	private ProfesorMapper profesorMapper;
	
	@Override
	public List<Profesor> getAllProfesors() {
		
		List<Profesor> lstProfesor = profesorMapper.getAll();
		return lstProfesor;
	}

}
