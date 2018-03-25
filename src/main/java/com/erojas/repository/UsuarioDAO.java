package com.erojas.repository;

import javax.ejb.Local;

import com.erojas.model.Usuario;

@Local
public interface UsuarioDAO extends DAO<Usuario>{

	
	Usuario getUsuarioByAlumnoId(Integer idAlumno) throws Exception;
	Integer  getUsuarioByNombreAndClave(String nombre, String clave) throws Exception;
}
