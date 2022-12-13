package ar.edu.unju.fi.proyectofinal.dominio;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class CuentaBancaria {
	private Integer id;
	private String numeroCuenta;
	private Titular titular;
	private LocalDate fecha = LocalDate.now();
	private double saldo = 0d;
		
	public CuentaBancaria() {
	}
	
	public CuentaBancaria(String numeroCuenta, Titular titular, double saldo) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable= false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "numero_cuenta")
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "titular_id", nullable = false)
	public Titular getTitular() {
		return titular;
	}

	public void setTitular(Titular titular) {
		this.titular = titular;
	}
	
	@Column(name = "saldo")
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	@Column(name = "fecha")
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [id= " + id + ", numeroCuenta= " + numeroCuenta + ", titular= " + titular + ", fecha= "
				+ fecha + ", saldo= " + saldo + "]";
	}
	
}
