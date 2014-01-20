package org.jpacheco.rest.spring.web;

import java.util.List;

import org.jpacheco.rest.spring.bean.Profesor;
import org.jpacheco.rest.spring.services.ProfesorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "profesor")
public class ProfesorController {

	@Autowired
	private ProfesorServices service;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Profesor> getAll() {
		return service.getAllProfesors();
	}
}
