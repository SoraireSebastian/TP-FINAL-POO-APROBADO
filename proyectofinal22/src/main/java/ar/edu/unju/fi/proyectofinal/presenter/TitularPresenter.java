package ar.edu.unju.fi.proyectofinal.presenter;

import ar.edu.unju.fi.proyectofinal.dao.TitularDAO;
import ar.edu.unju.fi.proyectofinal.dao.impl.TitularDAOImpl;
import ar.edu.unju.fi.proyectofinal.dominio.Titular;
import ar.edu.unju.fi.proyectofinal.presenter.views.IViewTitular;
import ar.edu.unju.fi.proyectofinal.util.ManagerContext;

public class TitularPresenter {
	private IViewTitular formularioAltaTitular;
	private TitularDAO titularDAO;
	private Titular titularModel;
	
	public TitularPresenter(IViewTitular formularioAltaTitular) {
		this.formularioAltaTitular = formularioAltaTitular;
		this.titularDAO = new TitularDAOImpl(ManagerContext.getInstance().getEntityManager());
	}
	
	public void registrarTitular(String nombre, String direccion,String dni,String email,String estado) {
		
		titularModel = new Titular(nombre, direccion,dni,email,estado);
		titularDAO.save(titularModel);		
		
		
		formularioAltaTitular.visualizarResultado("El siguiente titular ha sido registrado: \n"+
												   "Nombre: "+titularModel.getNombre()+"\n"+
												   "Dirección: "+titularModel.getDireccion()+"\n"+
												   "Documento: "+titularModel.getDni()+"\n"+
												   "Email: "+titularModel.getEmail()+"\n"+
												   "Estado: "+titularModel.getEstado());
		
	}

	public void buscarBy(Integer idTitular) {
		Titular titular = titularDAO.getBy(idTitular);
		formularioAltaTitular.setInputsText(titular.getNombre(), titular.getDireccion());		
	}

	public void actualizarTitular(Integer idTitular, String nombre, String direccion,String dni,String email,String estado) {
		titularModel = new Titular(nombre, direccion,dni,email,estado);
		titularModel.setId(idTitular);
		titularDAO.update(titularModel);
	}
}
