package ar.edu.unju.fi.proyectofinal.dao;

import java.util.List;

import ar.edu.unju.fi.proyectofinal.dominio.Usuario;

public interface UsuarioDAO {

	List<Usuario> getAll();

	void save(Usuario usuario);

	Usuario getBy(String login, String password);

}
