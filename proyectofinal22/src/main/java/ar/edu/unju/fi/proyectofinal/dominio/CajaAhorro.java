package ar.edu.unju.fi.proyectofinal.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CajaAhorro extends CuentaBancaria{
	private Double limiteExtraccion;

	@Column(name = "limite_extraccion")
	public Double getLimiteExtraccion() {
		return limiteExtraccion;
	}

	public void setLimiteExtraccion(Double limiteExtraccion) {
		this.limiteExtraccion = limiteExtraccion;
	}

	public CajaAhorro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CajaAhorro(String numeroCuenta, Titular titular, double saldo, Double limiteExtraccion) {
		super(numeroCuenta, titular, saldo);
		this.limiteExtraccion = limiteExtraccion;
	}
	
	
}
