package com.erojas.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.erojas.model.Usuario;
import com.erojas.repository.UsuarioDAO;
import com.erojas.service.UsuarioService;

@Named
@RequestScoped
public class UsuarioServiceImpl implements UsuarioService{

	@EJB
	private UsuarioDAO dao;
	
	@Override
	public void registrar(Usuario t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(Usuario t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<Usuario> listar() throws Exception {
		
		return dao.listar();
	}

	@Override
	public Usuario listarPorId(Usuario t) throws Exception {
		
		return dao.listarPorId(t);
	}

	@Override
	public void eliminar(Usuario t) throws Exception {
		dao.eliminar(t);
		
	}

	@Override
	public Usuario getUsuarioByAlumnoId(Integer idAlumno) throws Exception {
		
		return dao.getUsuarioByAlumnoId(idAlumno);
	}

	@Override
	public Integer getUsuarioByNombreAndClave(String nombre, String clave) throws Exception {
		// TODO Auto-generated method stub
		return dao.getUsuarioByNombreAndClave(nombre, clave);
	}

}
