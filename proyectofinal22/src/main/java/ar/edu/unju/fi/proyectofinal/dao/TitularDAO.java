package ar.edu.unju.fi.proyectofinal.dao;
//interface que nimplementa TitularDAOImpl
import java.util.List;

import ar.edu.unju.fi.proyectofinal.dominio.Titular;

public interface TitularDAO {
	
	List<Titular> getAll();
 
	void save(Titular titular);

	List<Titular> getByNombre(String nombre);

	Titular getBy(Integer idTitular);

	void update(Titular titularModel);
	
}
