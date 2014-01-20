package org.jpacheco.rest.spring.services;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.jpacheco.rest.spring.bean.Curso;
import org.jpacheco.rest.spring.bean.Pagination;
import org.jpacheco.rest.spring.bean.ResultQueryCurso;
import org.jpacheco.rest.spring.mapper.CursosMapper;
import org.jpacheco.rest.spring.util.FileHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CursoServicesImpl implements CursoServices {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CursoServicesImpl.class);
	@Autowired
	private CursosMapper cursosMapper;

	@Override
	public List<Curso> getAllCourses() {
		List<Curso> lstCursos = cursosMapper.getAll();
		return lstCursos;
	}

	@Override
	@Transactional
	public int insert(Curso curso, String path) {
		LOGGER.debug("::: Extraemos el byte[] del fileString");
		trataFichero(curso, path);
		return cursosMapper.insert(curso);
	}

	private void trataFichero(Curso curso, String path) {
		if(curso.getFileUpload() != null){
			byte[] fileByte = FileHelper.extractBytesFromStringBase64(curso.getFileUpload());
			curso.setFile(fileByte);
			//LOGGER.debug("::: Copiamos el Fichero :::");
			//FileHelper.copyBytesToFile(fileByte, path, curso.getFileName());
		}
	}

	@Override
	public ResultQueryCurso getAllCoursesWithPagination(int page, String order) {
		
		Pagination pagination = getPagination(page,order);
		RowBounds rb = new RowBounds(pagination.getOffset(), pagination.getPage());
		LOGGER.debug("::: Listado Paginado: Empieza en el registro:" + rb.getOffset() + " Numero de Regristros:" + rb.getLimit());
		List<Curso> lstCursos = cursosMapper.getActiveCoursesPag(Boolean.TRUE, order, rb);
		return new ResultQueryCurso(lstCursos, pagination);
	}
	
	private Pagination getPagination(int page, String order){
		Pagination pagination = new Pagination();
		pagination.setNumberPage(page);
		pagination.setTotal(cursosMapper.getCountActiveCourses(Boolean.TRUE));
		pagination.setOrder(order);
		return pagination;
		
	}

	@Override
	public Curso getCursoById(int id) {
		return cursosMapper.getCursoById(id);
	}

}
