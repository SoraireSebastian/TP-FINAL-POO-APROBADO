package ar.edu.unju.fi.proyectofinal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ar.edu.unju.fi.proyectofinal.dao.TitularDAO;
import ar.edu.unju.fi.proyectofinal.dao.impl.TitularDAOImpl;
import ar.edu.unju.fi.proyectofinal.dominio.Titular;
import ar.edu.unju.fi.proyectofinal.util.ManagerContext;

@DisplayName("Pruebas unitarias titulares JPA")
public class TitularJPATest {
	ManagerContext context;
	EntityManager entityManager; 
	TitularDAO titularDAO;
	Titular titular1;
	Titular titular2;
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Configurando en SetUp...");
		context = ManagerContext.getInstance();
	    entityManager = context.getEntityManager();
		titularDAO = new TitularDAOImpl(entityManager);
		titular1 = new Titular("Juan Perez", "Los molinos 345","33333","juan@13.com","HABILITADO");
		titular2 = new Titular("Mariana Mamani", "Los andes 43","44444","MARIA@13.com","HABILITADO");		
	}
	
	@Test
	@DisplayName("Prueba Agregar Titular")
	void altaTitularTest() {
		List<Titular> titulares = titularDAO.getAll();
		int size = titulares.size();
		titularDAO.save(titular1);
		titularDAO.save(titular2);
		titulares = titularDAO.getAll();		
		for (Titular titular : titulares) {
			System.out.println("nomnre -->" + titular.getNombre());
		}
		size += 2;
		assertEquals(size, titulares.size());
	}
	
	@Test
	@DisplayName("Prueba buscar Titular")
	void buscarTitularTest() {
		String nombre = "Juan";
		List<Titular> titulares = titularDAO.getByNombre(nombre);		
		assertTrue(titulares.size() > 0);		
	}
	
	
}
