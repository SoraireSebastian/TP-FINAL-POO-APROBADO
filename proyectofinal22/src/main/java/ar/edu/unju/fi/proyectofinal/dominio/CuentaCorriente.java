package ar.edu.unju.fi.proyectofinal.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CuentaCorriente extends CuentaBancaria{
	private Double importeComision;

	@Column(name = "importe_comision")
	public Double getImporteComision() {
		return importeComision;
	}
	public void setImporteComision(Double importeComision) {
		this.importeComision = importeComision;
	}
	
	public CuentaCorriente() {
		
	}
	
	public CuentaCorriente(String numeroCuenta, Titular titular, Double importeComision, double saldo) {
		super(numeroCuenta, titular, saldo);
		this.importeComision = importeComision;
	}
}
