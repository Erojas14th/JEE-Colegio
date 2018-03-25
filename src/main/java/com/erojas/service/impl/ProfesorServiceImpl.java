package com.erojas.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.erojas.model.Profesor;
import com.erojas.service.ProfesorService;

@Named
@RequestScoped
public class ProfesorServiceImpl implements ProfesorService{

	@EJB
	private ProfesorService dao;
	
	@Override
	public void registrar(Profesor t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(Profesor t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<Profesor> listar() throws Exception {
		return dao.listar();
	}

	@Override
	public Profesor listarPorId(Profesor t) throws Exception {
		return dao.listarPorId(t);
	}

	@Override
	public void eliminar(Profesor t) throws Exception {
		dao.eliminar(t);
		
	}

}
