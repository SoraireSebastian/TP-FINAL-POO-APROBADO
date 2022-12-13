package ar.edu.unju.fi.proyectofinal.presenter;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import ar.edu.unju.fi.proyectofinal.dao.CuentaBancariaDAO;
import ar.edu.unju.fi.proyectofinal.dao.impl.CuentaBancariaDAOImpl;
import ar.edu.unju.fi.proyectofinal.dominio.CajaAhorro;
import ar.edu.unju.fi.proyectofinal.dominio.CuentaBancaria;
import ar.edu.unju.fi.proyectofinal.presenter.views.IViewCuentas;
import ar.edu.unju.fi.proyectofinal.util.ManagerContext;
import ar.edu.unju.fi.proyectofinal.view.ListadoCuentasFrame;

public class ListadoCuentasPresenter {
	private IViewCuentas ventanaCuentas;
	private CuentaBancariaDAO cuentaDAO;

	public ListadoCuentasPresenter(ListadoCuentasFrame listadoCuentasFrame) {
		this.ventanaCuentas =	listadoCuentasFrame;
	}
	
	public void visualizarCuentas() {
		cuentaDAO = new CuentaBancariaDAOImpl(ManagerContext.getInstance().getEntityManager());
		List<CuentaBancaria> listadoCuentas = cuentaDAO.getAll();
		DefaultTableModel model = (DefaultTableModel) ventanaCuentas.getTable().getModel();
		for(CuentaBancaria cuenta:listadoCuentas) {
			Object[] data = new Object[6];			
			data[0] = cuenta.getId();
			data[1] = cuenta.getTitular().getNombre();
			if (cuenta instanceof CajaAhorro) {
				data[2] = "CAJA AHORRO";				
			} else {
				data[2] = "CUENTA CORRIENTE";
			}
			data[3] = cuenta.getNumeroCuenta();
			data[4] = cuenta.getSaldo();
			data[5] = cuenta.getFecha();
			model.addRow(data);
		}
	}
	public void visualizarResultadoBusqueda(int numCuenta) {
		cuentaDAO = new CuentaBancariaDAOImpl(ManagerContext.getInstance().getEntityManager());
		List<CuentaBancaria> listadoCuentas = cuentaDAO.getAll();
		DefaultTableModel model = (DefaultTableModel) ventanaCuentas.getTable().getModel();
		int num;
		for(CuentaBancaria cuenta:listadoCuentas) {
			 num=Integer.parseInt(cuenta.getNumeroCuenta());
			if(num==numCuenta) {
				Object[] data = new Object[6];			
				data[0] = cuenta.getId();
				data[1] = cuenta.getTitular().getNombre();
				if (cuenta instanceof CajaAhorro) {
					data[2] = "CAJA AHORRO";				
				} else {
					data[2] = "CUENTA CORRIENTE";
				}
				data[3] = cuenta.getNumeroCuenta();
				data[4] = cuenta.getSaldo();
				data[5] = cuenta.getFecha();
				model.addRow(data);
			}
		}
	}
	
	
	
	
	
}

	