package com.erojas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.erojas.model.Profesor;
import com.erojas.service.ProfesorService;

@Named
@RequestScoped
public class ProfesorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private ProfesorService ps;
	@Inject
	private Profesor profesor;

	private List<Profesor> listaProfesor;

	@PostConstruct
	public void init() {
		listaProfesor = new ArrayList<>();
	}

	// Methods
	
	public void listar() {
		try {
			listaProfesor=ps.listar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Getters and setters
	public ProfesorService getPs() {
		return ps;
	}

	public void setPs(ProfesorService ps) {
		this.ps = ps;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public List<Profesor> getListaProfesor() {
		return listaProfesor;
	}

	public void setListaProfesor(List<Profesor> listaProfesor) {
		this.listaProfesor = listaProfesor;
	}

}
