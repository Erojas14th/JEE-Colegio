package com.erojas.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erojas.model.Alumno;
import com.erojas.service.AlumnoService;

@WebServlet("/imagen/*")
public class ImageServlet extends HttpServlet  {

	private static final long serialVersionUID = 1L;
	@Inject
	private AlumnoService as ;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getPathInfo().substring(1));
	    Alumno al = new Alumno();
	    al.setId(id);
	    try {
	    	al = as.listarPorId(al);
	    	resp.setContentType(getServletContext().getMimeType(al.getNombre()));
	    	resp.setContentLength(al.getFoto().length);
	    	resp.getOutputStream().write(al.getFoto());
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
}
