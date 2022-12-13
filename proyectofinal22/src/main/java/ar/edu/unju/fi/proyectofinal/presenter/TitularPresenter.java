package ar.edu.unju.fi.proyectofinal.presenter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	// Metodo para registrar Titular y guardarlo en la base de datos
	public void registrarTitular(String nombre, String direccion,String dni,String email,String estado) {
		
		titularModel = new Titular(nombre, direccion,dni,email,estado);
		titularDAO.save(titularModel);		
		
		// Método el cual al registrarse un titular muestra los datos cargados
		formularioAltaTitular.visualizarResultado("El siguiente titular ha sido registrado: \n"+
												   "Nombre: "+titularModel.getNombre()+"\n"+
												   "Dirección: "+titularModel.getDireccion()+"\n"+
												   "Documento: "+titularModel.getDocumento()+"\n"+
												   "Email: "+titularModel.getEmail()+"\n"+
												   "Estado: "+titularModel.getEstado());
		
	}

	public void buscarBy(Integer idTitular) {
		Titular titular = titularDAO.getBy(idTitular);
		formularioAltaTitular.setInputsText(titular.getNombre(), titular.getDireccion(),titular.getDocumento(),titular.getEmail(),titular.getEstado());		
	}

	public void actualizarTitular(Integer idTitular, String nombre, String direccion,String dni,String email,String estado) {
		titularModel = new Titular(nombre, direccion,dni,email,estado);
		titularModel.setId(idTitular);
		titularDAO.update(titularModel);
	}
	public boolean ValidarEmail(String email) {
        // Patron para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        return mather.find();
    }
	
	
}
