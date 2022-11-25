package ar.edu.unju.fi.proyectofinal.presenter;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import ar.edu.unju.fi.proyectofinal.dao.TitularDAO;
import ar.edu.unju.fi.proyectofinal.dao.impl.CuentaBancariaDAOImpl;
import ar.edu.unju.fi.proyectofinal.dao.impl.TitularDAOImpl;
import ar.edu.unju.fi.proyectofinal.dominio.Titular;
import ar.edu.unju.fi.proyectofinal.presenter.views.IViewTitulares;
import ar.edu.unju.fi.proyectofinal.util.ManagerContext;

public class ListadoTitularesPresenter {
	private IViewTitulares ventanaTitulares;
	private TitularDAO titularDAO;

	public ListadoTitularesPresenter(IViewTitulares ventanaTitulares) {
		this.ventanaTitulares = ventanaTitulares;		
	}
	
	public void visualizarTitulares() {
		titularDAO = new TitularDAOImpl(ManagerContext.getInstance().getEntityManager());
		List<Titular> listadoTitulares = titularDAO.getAll();
		cargarModelFor(listadoTitulares);		
	}

	public void buscarTitularesBy(String nombre) {	
		titularDAO = new TitularDAOImpl(ManagerContext.getInstance().getEntityManager());
		List<Titular> listadoTitulares = titularDAO.getByNombre(nombre);
		cargarModelFor(listadoTitulares);
	}
	
	private void cargarModelFor(List<Titular> listadoTitulares) {
		DefaultTableModel model = (DefaultTableModel)ventanaTitulares.getTable().getModel();
		for(Titular t:listadoTitulares) {
			Object[] data = new Object[3];
			data[0]=t.getId();
			data[1]=t.getNombre();
			data[2]=t.getDireccion();
			model.addRow(data);
		}
	}
}
