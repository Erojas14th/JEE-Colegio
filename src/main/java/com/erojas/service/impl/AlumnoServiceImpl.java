package com.erojas.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.erojas.model.Alumno;
import com.erojas.repository.AlumnoDAO;
import com.erojas.service.AlumnoService;

@Named
@RequestScoped
public class AlumnoServiceImpl implements AlumnoService{

	@EJB
	private AlumnoDAO dao;
	
	@Override
	public void registrar(Alumno t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(Alumno t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<Alumno> listar() throws Exception {
		
		return dao.listar();
	}

	@Override
	public Alumno listarPorId(Alumno t) throws Exception {
		
		return dao.listarPorId(t);
	}

	@Override
	public void eliminar(Alumno t) throws Exception {
		dao.eliminar(t);
		
	}

}
