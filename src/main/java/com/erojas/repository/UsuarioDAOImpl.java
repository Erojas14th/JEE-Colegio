package com.erojas.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.erojas.model.Alumno;
import com.erojas.model.Usuario;

@Stateless
public class UsuarioDAOImpl implements UsuarioDAO{

	
	@PersistenceContext(unitName="ColegioPU")
	private EntityManager em;
	
	@Override
	public void registrar(Usuario t) throws Exception {
		em.persist(t);
		
	}

	@Override
	public void modificar(Usuario t) throws Exception {
		em.merge(t);
		
	}

	@Override
	public List<Usuario> listar() throws Exception {
		List<Usuario> lista =new ArrayList<>();
		Query q = em.createQuery("from usuario");
		lista=q.getResultList();
		return lista;
	}

	@Override
	public Usuario listarPorId(Usuario t) throws Exception {
		Usuario usu = new Usuario();
		usu=em.find(Usuario.class, t.getId());
		return usu;
	}

	@Override
	public void eliminar(Usuario t) throws Exception {
		em.remove(t);
		
	}

	@Override
	public Usuario getUsuarioByAlumnoId(Integer idAlumno) throws Exception {
		Usuario usu = new Usuario();
		String query =" select new com.erojas.model.Usuario(u.id, u.nombre , u.clave , u.tipo , u.estado) "
				+ " from usuario u where u.persona.id= ?1";
		Query  q = em.createQuery(query);
		q.setParameter(1,idAlumno);
		usu= (Usuario)q.getSingleResult();
		return usu;
	}

	@Override
	public Integer getUsuarioByNombreAndClave(String nombre, String clave) throws Exception {
		Integer idUsuario =-1;
		String query = "select u.id from usuario u where u.nombre= ?1 and u.clave=?2";
		try {
			Query q = em.createQuery(query);
			q.setParameter(1, nombre);
			q.setParameter(2, clave);
			idUsuario = (Integer)q.getSingleResult();
			if(idUsuario==null) {
				idUsuario=0;
			}
		}catch(Exception e) {}
		return idUsuario;
	}

}
