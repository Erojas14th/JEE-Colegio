package com.erojas.controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;
import javax.inject.Named;


import com.erojas.model.Usuario;
import com.erojas.service.UsuarioService;

@Named
@RequestScoped
public class UsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private UsuarioService us;
	@Inject
	private Usuario usuario;

	private List<Usuario> listaUsuarios;

	@PostConstruct
	public void init() {
		listaUsuarios = new ArrayList<>();
		this.listar();
	}

	// METHOS
	public void listar() {
		try {
			listaUsuarios = us.listar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String ingresar() {
		String direccion = "";
		try {
			Integer codigo = us.getUsuarioByNombreAndClave(usuario.getNombre(), usuario.getClave());
			if (codigo>0 && codigo!=null) {
				Usuario obj = new Usuario();
				obj.setId(codigo);
				obj = us.listarPorId(obj);

				switch (obj.getTipo()) {
				case "ROLE_ADMIN":
					direccion = "/admin/indexAdmin";
					break;
				case "ROLE_USER":
					direccion = "/user/indexUser";
					break;
				case "ROLE_XYZ":
					direccion = "error";
					break;
				}

			} else {
				direccion="login";
			}

		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return direccion;
	}


	
	
	// GETTERS AND SETTERS
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
