package ar.edu.unju.fi.proyectofinal.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerContext {
	private EntityManagerFactory entityManagerFactory;
	private static ManagerContext instance = new ManagerContext();

	private ManagerContext() {
		entityManagerFactory = Persistence.createEntityManagerFactory("cuentasBancarias");
	}
    
	public static ManagerContext getInstance() {
        return instance;
    }

	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
    }

	public void closeEntityManager() {
		entityManagerFactory.close();
	}
	 
}
