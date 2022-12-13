package ar.edu.unju.fi.proyectofinal.presenter;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import ar.edu.unju.fi.proyectofinal.dao.CuentaBancariaDAO;
import ar.edu.unju.fi.proyectofinal.dao.TitularDAO;
import ar.edu.unju.fi.proyectofinal.dao.impl.CuentaBancariaDAOImpl;
import ar.edu.unju.fi.proyectofinal.dao.impl.TitularDAOImpl;
import ar.edu.unju.fi.proyectofinal.dominio.CajaAhorro;
import ar.edu.unju.fi.proyectofinal.dominio.CuentaBancaria;
import ar.edu.unju.fi.proyectofinal.dominio.CuentaCorriente;
import ar.edu.unju.fi.proyectofinal.dominio.Titular;
import ar.edu.unju.fi.proyectofinal.presenter.views.IViewCuentaBancaria;
import ar.edu.unju.fi.proyectofinal.util.ManagerContext;

public class CuentaBancariaPresenter {
	private IViewCuentaBancaria formularioAltaCuenta;
	private CuentaBancariaDAO cuentaBancariaDAO;
	private CuentaBancaria cuentaBancaria;
	private TitularDAO titularDAO;;
	
	public CuentaBancariaPresenter(IViewCuentaBancaria formularioAltaCuenta) {
		this.formularioAltaCuenta = formularioAltaCuenta;
		this.cuentaBancariaDAO = new CuentaBancariaDAOImpl(ManagerContext.getInstance().getEntityManager());
		this.titularDAO = new TitularDAOImpl(ManagerContext.getInstance().getEntityManager());
	}
	
	public void registrarCuentaCorriente(Integer idTitular, String numeroCuenta, Double importeComision, double saldo) {
		Titular titular = titularDAO.getBy(idTitular);
		cuentaBancaria = new CuentaCorriente(numeroCuenta, titular, importeComision, saldo);
		cuentaBancariaDAO.save(cuentaBancaria);
	}

	public void cargarComboTitulares() {
		DefaultComboBoxModel myModel = new DefaultComboBoxModel();
		List<Titular> titulares = titularDAO.getAll();
		for (Titular titular : titulares) {
			myModel.addElement(titular);
		}
		formularioAltaCuenta.getComboTitulares().setModel(myModel);
	}

	public void registrarCuentaBancaria(String tipoCuenta, Object selectedItem, String numeroCuenta, String saldo) {
		CuentaBancaria cuentaBancaria;
		if (tipoCuenta.equals("CAJA-AHORRO")) {
			cuentaBancaria  = new CajaAhorro(numeroCuenta, (Titular) selectedItem, Double.parseDouble(saldo), null);
			cuentaBancariaDAO.save(cuentaBancaria);
		}else {
			cuentaBancaria  = new CuentaCorriente(numeroCuenta, (Titular) selectedItem, null, Double.parseDouble(saldo));
			cuentaBancariaDAO.save(cuentaBancaria);
		}
		
	}
	
	
}

	