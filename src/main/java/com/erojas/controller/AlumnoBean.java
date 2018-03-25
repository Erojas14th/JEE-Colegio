package com.erojas.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

import com.erojas.model.Alumno;
import com.erojas.service.AlumnoService;

@Named
@RequestScoped
public class AlumnoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private AlumnoService as;
	@Inject
	private Alumno alumno;
	private List<Alumno> listaAlumnos;
	private Date fechaSeleccionada;
	private UploadedFile foto;

	@PostConstruct
	public void init() {
		listaAlumnos = new ArrayList<>();
		this.cargarLista();
	}

	// Methods
	public void cargarLista() {
		try {
			this.listaAlumnos = as.listar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void guardar() {

		try {

			if (foto != null) {
				alumno.setFoto(foto.getContents());
			}

			if (fechaSeleccionada != null) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(fechaSeleccionada);
				LocalDate local = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
				alumno.setFechaNacimiento(local);
			}

			if (alumno.getId() == null) {
				as.registrar(this.alumno);
			} else {

				as.modificar(this.alumno);
			}

			this.cargarLista();
		} catch (Exception e) {

		}
	}

	public void limpiar() {
		this.alumno.setId(null);
		this.alumno.setApellidos(null);
		this.alumno.setDireccion(null);
		this.alumno.setEmail(null);
		this.alumno.setNombre(null);
		this.alumno.setSexo(null);
		this.alumno.setFechaNacimiento(null);
		this.alumno.setFoto(null);
		foto = null;
		fechaSeleccionada = null;

	}

	public void seleccionar(Alumno per) throws Exception {
		alumno = as.listarPorId(per);
		Calendar cal = Calendar.getInstance();
		cal.set(alumno.getFechaNacimiento().getYear(), alumno.getFechaNacimiento().getMonthValue(),
				alumno.getFechaNacimiento().getDayOfMonth());
		this.fechaSeleccionada = cal.getTime();

	}
	
	public void eliminar(Alumno alu) {
		try {
			as.eliminar(alu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Getters and setters

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public List<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(List<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}

	public Date getFechaSeleccionada() {
		return fechaSeleccionada;
	}

	public void setFechaSeleccionada(Date fechaSeleccionada) {
		this.fechaSeleccionada = fechaSeleccionada;
	}

	public UploadedFile getFoto() {
		return foto;
	}

	public void setFoto(UploadedFile foto) {
		this.foto = foto;
	}

}
