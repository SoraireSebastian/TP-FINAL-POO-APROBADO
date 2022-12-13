package ar.edu.unju.fi.proyectofinal.dao;

import java.util.List;

import ar.edu.unju.fi.proyectofinal.dominio.CuentaBancaria;

public interface CuentaBancariaDAO {

	List<CuentaBancaria> getAll();
	
	void save(CuentaBancaria cuenta);

	CuentaBancaria getBy(String numeroCuenta);
	 
	void depositar(CuentaBancaria cuentaImporte);
	
	public void extraer(CuentaBancaria cuentaExtraccion);
}  

