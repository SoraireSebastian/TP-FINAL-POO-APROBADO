package ar.edu.unju.fi.proyectofinal.presenter;

import java.util.List;

import ar.edu.unju.fi.proyectofinal.dao.UsuarioDAO;
import ar.edu.unju.fi.proyectofinal.dao.impl.UsuarioDAOImpl;
import ar.edu.unju.fi.proyectofinal.dominio.CuentaBancaria;
import ar.edu.unju.fi.proyectofinal.dominio.Usuario;
import ar.edu.unju.fi.proyectofinal.presenter.views.IViewlogin;
import ar.edu.unju.fi.proyectofinal.util.ManagerContext;

public class LoginPresenter {
	private IViewlogin formularioLogin;
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;
	
	public LoginPresenter(IViewlogin formularioLogin) {
		this.formularioLogin = formularioLogin;
		this.usuarioDAO = new UsuarioDAOImpl(ManagerContext.getInstance().getEntityManager());
	}
		
	//public void validar(String login, String password) {
		//FIXME Comparar datos de acceso con el modelo
		//Agregar en el dominio  la clase Usuario y mapearla: id, usuario, password
		//Agregar el Dao correspondiente para la entidad Usuario
		//Implementar en el Dao de usuario el metodo para validar un usuario por usuario y password
		//Desde aqui se llama al DAO de usuario  para validar usuario y password
		
		//Usuario usuario = usuarioDAO.getBy(login,password);
		//if (usuario != null) {
			//formularioLogin.visualizarMain();
		//} else {
		//	formularioLogin.visualizarResultado("El usuario o constraseña es incorrrecta");
		//}
	//}
	public boolean validar(String usuario, String password) {
		List<Usuario> listadoUsuario = usuarioDAO.getAll();
		boolean band=false;
		for(int i=0;i<listadoUsuario.size();i++) {
			if (usuario.equals(listadoUsuario.get(i).getLogin()) && password.equals(listadoUsuario.get(i).getPassword())) {
				band=true;	
				}
			}
			return band;
		}
		//if (usuario.equals("admin") && password.equals("admin")) {
			//return true;	
		//}else {
			//return false;
			//}
		//}
}
