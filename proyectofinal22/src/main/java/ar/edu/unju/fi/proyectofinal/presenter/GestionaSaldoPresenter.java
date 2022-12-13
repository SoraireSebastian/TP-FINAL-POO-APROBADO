package ar.edu.unju.fi.proyectofinal.presenter;

import java.util.List;

import javax.swing.JOptionPane;
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
		if (listadoCuentas.get(idCuenta) instanceof CajaAhorro) {
			double sum = listadoCuentas.get(idCuenta).getSaldo()+monto;
			listadoCuentas.get(idCuenta).setSaldo(sum);
			cuentaDAO.save(listadoCuentas.get(idCuenta));
			JOptionPane.showMessageDialog(null, "Operación Correcta");
		}
		else {
			double sum,cuenta;
			cuenta = (monto*10)/100;
			sum = listadoCuentas.get(idCuenta).getSaldo()+monto-cuenta;
			listadoCuentas.get(idCuenta).setSaldo(sum);
			cuentaDAO.save(listadoCuentas.get(idCuenta));
			JOptionPane.showMessageDialog(null, "Se realizó un 10% de comision por el depósito");
		}
	}
	
	
	public void extraerSaldo(double monto,Integer idCuenta){
		List<CuentaBancaria> listadoCuentas = cuentaDAO.getAll();
		if (listadoCuentas.get(idCuenta) instanceof CajaAhorro) {
			if((monto <= listadoCuentas.get(idCuenta).getSaldo())&&(monto <= 500)) {
				double sum = listadoCuentas.get(idCuenta).getSaldo()-monto;
				listadoCuentas.get(idCuenta).setSaldo(sum);
				cuentaDAO.save(listadoCuentas.get(idCuenta));
				JOptionPane.showMessageDialog(null, "Operación Exitosa");
			}
			else {
				JOptionPane.showMessageDialog(null, "Solo se permite extraer hasta $500");
			}
			
		}
		else {
			if((monto <= listadoCuentas.get(idCuenta).getSaldo())) {
				double sum = listadoCuentas.get(idCuenta).getSaldo()-monto;
				listadoCuentas.get(idCuenta).setSaldo(sum);
				cuentaDAO.save(listadoCuentas.get(idCuenta));
				JOptionPane.showMessageDialog(null, "Operación Exitosa");
			}else {
				JOptionPane.showMessageDialog(null, "No posee suficiente saldo");
			}
			
		}
	
	
	}
	
}
