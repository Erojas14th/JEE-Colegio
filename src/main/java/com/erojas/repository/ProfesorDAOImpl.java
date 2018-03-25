package com.erojas.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.erojas.model.Alumno;
import com.erojas.model.Profesor;

@Stateless
public class ProfesorDAOImpl implements ProfesorDAO{

	@PersistenceContext(unitName="ColegioPU")
	private EntityManager em;
	
	@Override
	public void registrar(Profesor t) throws Exception {
		em.persist(t);
		
	}

	@Override
	public void modificar(Profesor t) throws Exception {
		if(t.getFoto() != null && t.getFoto().length > 0){
			Query query = em.createQuery("UPDATE profesor SET foto = ?1 WHERE id = ?2");
			query.setParameter(1, t.getFoto());
			query.setParameter(2, t.getId());
			query.executeUpdate();
		}
		em.merge(t);
		
	}

	@Override
	public List<Profesor> listar() throws Exception {
		List<Profesor> lista =new ArrayList<>();
		Query q = em.createQuery("from profesor");
		lista=q.getResultList();
		return lista;
	}

	@Override
	public Profesor listarPorId(Profesor t) throws Exception {
		Profesor al = new Profesor();
		al = em.find(Profesor.class, t.getId());
		return al;
	}

	@Override
	public void eliminar(Profesor t) throws Exception {
		em.remove(t);
		
	}

}
