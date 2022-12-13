package ar.edu.unju.fi.proyectofinal.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.fi.proyectofinal.dao.CuentaBancariaDAO;
import ar.edu.unju.fi.proyectofinal.dominio.CuentaBancaria;

public class CuentaBancariaDAOImpl implements CuentaBancariaDAO{
	private EntityManager manager;
	
	public CuentaBancariaDAOImpl(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public List<CuentaBancaria> getAll() {
		return manager.createQuery("from CuentaBancaria").getResultList();		
	}

	@Override
	public void save(CuentaBancaria cuenta) {
		manager.getTransaction().begin();
        manager.persist(cuenta);
        manager.getTransaction().commit();
	}

	@Override
	public CuentaBancaria getBy(String numeroCuenta) {
		Query query = manager.createQuery("from CuentaBancaria c where c.numeroCuenta = :numeroCuenta");
		query.setParameter("numeroCuenta", numeroCuenta);
		return (CuentaBancaria) query.getSingleResult();
	}

	@Override
	public void depositar(CuentaBancaria cuentaImporte) {
		manager.getTransaction().begin();
        manager.merge(cuentaImporte);
        manager.getTransaction().commit();
		
	}

	@Override
	public void extraer(CuentaBancaria cuentaExtraccion) {
		manager.getTransaction().begin();
        manager.merge(cuentaExtraccion);
        manager.getTransaction().commit();
	}



	
	
}
