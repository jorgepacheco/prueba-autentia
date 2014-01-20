package com.autentia.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.jpacheco.rest.spring.bean.Curso;
import org.jpacheco.rest.spring.bean.Profesor;
import org.jpacheco.rest.spring.mapper.CursosMapper;
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
public class CursosMapperTest {
	
	@Resource
	private CursosMapper cursosMapper;
	

	@Test
	public void test_count_active_courses() {
		int numberCourses = cursosMapper.getCountActiveCourses(Boolean.TRUE);
		assertTrue(numberCourses > 0);
	}

	@Test
	public void test_all_courses() {
		List<Curso> all = cursosMapper.getAll();
		assertNotNull(all);
	}
	
	@Test
	public void test_active_courses() {
		List<Curso> all = cursosMapper.getActiveCourses(Boolean.TRUE);
		assertNotNull(all);
	}
	
	@Test
	public void test_non_active_courses() {
		List<Curso> all = cursosMapper.getActiveCourses(Boolean.FALSE);
		assertNotNull(all);
	}
	
	@Test
	public void test_active_courses_pag() {
		List<Curso> all = cursosMapper.getActiveCoursesPag(Boolean.TRUE,"desc", new RowBounds(0, 5));
		assertNotNull(all);
	}
	
	@Test
	public void test_curso_by_id() {
		Curso curso = cursosMapper.getCursoById(1);
		assertNotNull(curso);
	}
	
	
	@Test
	public void test_insert() {
		Curso curso = new Curso();
		curso.setActivo(true);
		curso.setHoras(2);
		curso.setNivel("kaka");
		curso.setTitulo("Titulin");
		Profesor profesor =new Profesor();
		profesor.setId(4);
		curso.setProfesor(profesor );
		int insert = cursosMapper.insert(curso );
		assertTrue(insert == 1);
	}
	

}
