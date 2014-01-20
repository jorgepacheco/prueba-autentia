package org.jpacheco.rest.spring.web;

import org.jpacheco.rest.spring.bean.Curso;
import org.jpacheco.rest.spring.bean.ResultQueryCurso;
import org.jpacheco.rest.spring.services.CursoServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping( value = "curso" )
public class CursoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CursoController.class);
    
	@Autowired
	private CursoServices service;

	
	   @RequestMapping( method = RequestMethod.GET)
	   @ResponseBody
	   public ResultQueryCurso getAll(@RequestParam("page") Integer page, @RequestParam("order") String order) {
		  LOGGER.debug(":::: Pagina:" + page); 
		  ResultQueryCurso resultQuery = service.getAllCoursesWithPagination(page,order);
	      return resultQuery;
	   }
	 
	   
	   @RequestMapping( method = RequestMethod.POST )
	   @ResponseStatus( HttpStatus.CREATED )
	   @ResponseBody
	   public Integer create(@RequestBody Curso entity, HttpServletRequest request){
	      return service.insert(entity, getDownloadPath(request));
	   }
   
	   private String getDownloadPath(HttpServletRequest request){		   
		   return request.getServletContext().getRealPath("/") + "download";
	   }
}
