package com.erojas.service;

import com.erojas.model.Usuario;

public interface UsuarioService extends Service<Usuario> {
	Usuario getUsuarioByAlumnoId(Integer idAlumno) throws Exception;
	Integer  getUsuarioByNombreAndClave(String nombre, String clave) throws Exception;
}
