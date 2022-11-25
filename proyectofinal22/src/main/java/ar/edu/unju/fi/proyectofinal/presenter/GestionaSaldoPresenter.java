package ar.edu.unju.fi.proyectofinal.presenter;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import ar.edu.unju.fi.proyectofinal.dao.CuentaBancariaDAO;
import ar.edu.unju.fi.proyectofinal.dao.impl.CuentaBancariaDAOImpl;
import ar.edu.unju.fi.proyectofinal.dominio.CajaAhorro;
import ar.edu.unju.fi.proyectofinal.dominio.CuentaBancaria;
import ar.edu.unju.fi.proyectofinal.presenter.views.IViewGestionarSaldo;
import ar.edu.unju.fi.proyectofinal.util.ManagerContext;

public class GestionaSaldoPresenter {
	private IViewGestionarSaldo iviewSaldo;
	private CuentaBancaria cuantaDominio; 
	private CuentaBancariaDAO cuentaDAO;
	
	public GestionaSaldoPresenter(IViewGestionarSaldo Saldo) {
		this.iviewSaldo = Saldo;
		this.cuentaDAO= new CuentaBancariaDAOImpl(ManagerContext.getInstance().getEntityManager());
	}
	
	public void depositarSaldo(double monto,Integer idCuenta) {
		List<CuentaBancaria> listadoCuentas = cuentaDAO.getAll();
					double sum = listadoCuentas.get(idCuenta).getSaldo()+monto;
					listadoCuentas.get(idCuenta).setSaldo(sum);
					cuentaDAO.save(listadoCuentas.get(idCuenta));	
	}
	
	
	public void extraerSaldo(double monto,Integer idCuenta) {
		int posicion=idCuenta;
		List<CuentaBancaria> listadoCuentas = cuentaDAO.getAll();
		double sum = listadoCuentas.get(idCuenta).getSaldo()-monto;
		listadoCuentas.get(idCuenta).setSaldo(sum);
		cuentaDAO.save(listadoCuentas.get(idCuenta));
	}
	
	
	
}
