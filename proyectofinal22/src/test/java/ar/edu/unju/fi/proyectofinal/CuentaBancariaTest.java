package ar.edu.unju.fi.proyectofinal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import ar.edu.unju.fi.proyectofinal.dao.CuentaBancariaDAO;
import ar.edu.unju.fi.proyectofinal.dao.TitularDAO;
import ar.edu.unju.fi.proyectofinal.dao.impl.CuentaBancariaDAOImpl;
import ar.edu.unju.fi.proyectofinal.dao.impl.TitularDAOImpl;
import ar.edu.unju.fi.proyectofinal.dominio.CajaAhorro;
import ar.edu.unju.fi.proyectofinal.dominio.CuentaBancaria;
import ar.edu.unju.fi.proyectofinal.dominio.CuentaCorriente;
import ar.edu.unju.fi.proyectofinal.dominio.Titular;
import ar.edu.unju.fi.proyectofinal.util.ManagerContext;
import ar.edu.unju.fi.proyectofinal.view.ListadoCuentasFrame;

@DisplayName("Pruebas unitarias cuentas bancarias JPA")
@TestMethodOrder(OrderAnnotation.class)
public class CuentaBancariaTest {

	ManagerContext context;
	EntityManager entityManager; 
	CuentaBancariaDAO cuentaBancariaDAO;
	TitularDAO titularDAO;
	Titular titular1;
	Titular titular2;
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Configurando en SetUp...");
		context = ManagerContext.getInstance();
	    entityManager = context.getEntityManager();
	    cuentaBancariaDAO = new CuentaBancariaDAOImpl(entityManager);
	    titularDAO = new TitularDAOImpl(entityManager);
		titular1 = new Titular("Juan Perez", "Los molinos 345","11111","juan@11.com","HABILITADO");
		titular2 = new Titular("Mariana Mamani", "Los andes 43","22222","MARIA@11.com","HABILITADO");		
	}
	
	@Test
	@DisplayName("Prueba Agregar cuenta Caja Ahorro")
	@Order(1)
	void altaCajaAhorroTest() {		
		titularDAO.save(titular1);
		CuentaBancaria cuenta = new CajaAhorro("100", titular1, 10, 100d);
		cuentaBancariaDAO.save(cuenta);
		List<CuentaBancaria> cuentas = cuentaBancariaDAO.getAll();
		assertEquals(1, cuentas.size());
	} 

	@Test
	@DisplayName("Prueba Agregar cuenta Corriente")
	@Order(2)
	void altaCuentaCorrienteTest() {		
		titularDAO.save(titular2);
		CuentaBancaria cuenta = new CuentaCorriente("101", titular2, 12d, 100d);
		cuentaBancariaDAO.save(cuenta);
		List<CuentaBancaria> cuentas = cuentaBancariaDAO.getAll();
		assertEquals(2, cuentas.size());
	}
	
	@Test
	@DisplayName("Prueba Buscar cuenta bancaria")
	@Order(3)
	void buscarCuentaTest() { 
		String numeroCuenta = "101";
		CuentaBancaria cuenta = cuentaBancariaDAO.getBy(numeroCuenta);
		assertEquals("Mariana Mamani", cuenta.getTitular().getNombre());
		
	}
	
	
	@Test
	@DisplayName("Prueba realizar deposito")
	@Order(4)
	void realizarDeposito() {
		System.out.println("Comienza...");
		
		String numCuenta = "101";
		Double importeDeposito = 50d;
		CuentaBancaria cuenta = cuentaBancariaDAO.getBy(numCuenta);
		cuenta.setSaldo(cuenta.getSaldo() + importeDeposito);
		cuentaBancariaDAO.depositar(cuenta);
		assertEquals(150d,cuenta.getSaldo());
	}
	
	
	@Test
	@DisplayName("Prueba realizar extraccion")
	@Order(5)
	void realizarExtraccion() {
		String numeroCuenta = "101";
		CuentaBancaria cuenta = cuentaBancariaDAO.getBy(numeroCuenta);
		float importeExtraccion = 500;
		cuenta.setSaldo(cuenta.getSaldo() - importeExtraccion);
		cuentaBancariaDAO.extraer(cuenta);
		assertEquals(-350.0,cuenta.getSaldo());
						
	}
	
	
}
