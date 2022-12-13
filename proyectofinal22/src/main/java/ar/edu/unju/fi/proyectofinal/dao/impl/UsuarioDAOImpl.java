package ar.edu.unju.fi.proyectofinal.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ar.edu.unju.fi.proyectofinal.dao.UsuarioDAO;
import ar.edu.unju.fi.proyectofinal.dominio.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO{
	private EntityManager manager;
	
	public UsuarioDAOImpl(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public List<Usuario> getAll() {
		return manager.createQuery("from Usuario").getResultList();
	}

	@Override
	public void save(Usuario usuario) {
		manager.getTransaction().begin();
	    manager.persist(usuario);
	    manager.getTransaction().commit();			
	}

	@Override
	public Usuario getBy(String login, String password) {
		Query query = manager.createQuery("from Usuario u where u.login=:login and u.password=:password");
		query.setParameter("login", login);
		query.setParameter("password", password);
		try {
			return (Usuario) query.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}		
	}
}
