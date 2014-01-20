package org.jpacheco.rest.spring.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jpacheco.rest.spring.bean.Curso;
import org.jpacheco.rest.spring.services.CursoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
@RequestMapping("download")
public class FileDownloadController {
     
    /**
     * Size of a byte buffer to read/write file
     */
    private static final int BUFFER_SIZE = 4096;
             
    
	@Autowired
	private CursoServices service;
	
	
	   @RequestMapping(method = RequestMethod.GET)
	    public void doDownload( @RequestParam("id") int id, HttpServletRequest request,
	            HttpServletResponse response) throws IOException {
	 
	        // get absolute path of the application
	        ServletContext context = request.getServletContext();
	        
	        Curso curso = service.getCursoById(id);
	        byte[] downloadFile = curso.getFile();
	        
	        ByteArrayInputStream inputStream = new ByteArrayInputStream(downloadFile);
	         
	        // get MIME type of the file
	        String mimeType = context.getMimeType(curso.getFileName());
	        if (mimeType == null) {
	            // set to binary type if MIME mapping not found
	            mimeType = "application/octet-stream";
	        }
	        System.out.println("MIME type: " + mimeType);
	 
	        // set content attributes for the response
	        response.setContentType(mimeType);
	        response.setContentLength((int) downloadFile.length);
	 
	        // set headers for the response
	        String headerKey = "Content-Disposition";
	        String headerValue = String.format("attachment; filename=\"%s\"",
	        		curso.getFileName());
	        response.setHeader(headerKey, headerValue);
	 
	        // get output stream of the response
	        OutputStream outStream = response.getOutputStream();
	 
	        byte[] buffer = new byte[BUFFER_SIZE];
	        int bytesRead = -1;
	 
	        // write bytes read from the input stream into the output stream
	        while ((bytesRead = inputStream.read(buffer)) != -1) {
	            outStream.write(buffer, 0, bytesRead);
	        }
	 
	        inputStream.close();
	        outStream.close();
	 
	    }	

}