package com.autentia.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.jpacheco.rest.spring.bean.Profesor;
import org.jpacheco.rest.spring.mapper.ProfesorMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:/persistenceContext.xml" })  
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class ProfesoresMapperTest {
	
	
	@Resource
	private ProfesorMapper profesorMapper;
	
	@Test
	public void test_find_profesor_by_id_with_courses() {
		Profesor list = profesorMapper.getAutorWithTutoriales(4);
		assertNotNull(list);
	}

	@Test
	public void test_all_profesors() {
		List<Profesor> all = profesorMapper.getAll();
		assertNotNull(all);
	}
	

	

}
