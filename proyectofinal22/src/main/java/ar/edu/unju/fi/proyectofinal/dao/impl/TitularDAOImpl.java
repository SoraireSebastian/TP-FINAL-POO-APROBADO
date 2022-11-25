package ar.edu.unju.fi.proyectofinal.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.fi.proyectofinal.dao.TitularDAO;
import ar.edu.unju.fi.proyectofinal.dominio.Titular;

public class TitularDAOImpl implements TitularDAO {
	
	private EntityManager manager;
	
	public TitularDAOImpl(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public List<Titular> getAll() {
		return manager.createQuery("from Titular").getResultList();
	}
	
	@Override
	public void save(Titular titular) {
        manager.getTransaction().begin();
        manager.persist(titular);
        manager.getTransaction().commit();		
	}

	@Override
	public List<Titular> getByNombre(String nombre) {//JPA SE ENCARGA DE CONVERTIR TODO EL REGISTRO DE LA BASE DE DATOS A UNA LISTA DE TITULARES
		Query query =  manager.createQuery("from Titular t where t.nombre like concat('%', :nombre, '%')");
		query.setParameter("nombre", nombre);
		return query.getResultList();	
	}

	@Override
	public Titular getBy(Integer idTitular) {
		Query query =  manager.createQuery("from Titular t where t.id=:idTitular");
		query.setParameter("idTitular", idTitular);
		return (Titular) query.getSingleResult();
	}

	@Override
	public void update(Titular titular) {
        manager.getTransaction().begin();//defino transaccion ,begin inicio la transcaccion
        manager.merge(titular);//Guarda un titular en la base de datos
        manager.getTransaction().commit();			
	}
}
