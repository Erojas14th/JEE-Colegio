package com.erojas.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.erojas.model.Alumno;

@Stateless
public class AlumnoDAOImpl implements AlumnoDAO {

	@PersistenceContext(unitName="ColegioPU")
	private EntityManager em;
	
	@Override
	public void registrar(Alumno t) throws Exception {
		em.persist(t);
		
	}

	@Override
	public void modificar(Alumno t) throws Exception {
				if(t.getFoto() != null && t.getFoto().length > 0){
			Query query = em.createQuery("UPDATE persona SET foto = ?1 WHERE id = ?2");
			query.setParameter(1, t.getFoto());
			query.setParameter(2, t.getId());
			query.executeUpdate();
		}
		em.merge(t);
	}

	@Override
	public List<Alumno> listar() throws Exception {
		List<Alumno> lista =new ArrayList<>();
		Query q = em.createQuery("from alumno");
		lista=q.getResultList();
		return lista;
	}

	@Override
	public Alumno listarPorId(Alumno t) throws Exception {
		Alumno al = new Alumno();
		al = em.find(Alumno.class, t.getId());
		return al;
	}

	@Override
	public void eliminar(Alumno t) throws Exception {
		em.remove(t);
		
	}

}
