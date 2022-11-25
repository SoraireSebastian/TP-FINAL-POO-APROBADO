package ar.edu.unju.fi.proyectofinal.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Titular {
	private Integer id;
	private String nombre;
	private String direccion;
	private String dni;
	private String email;
	private String estado;
	
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable= false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "direccion")
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	//////////////////////////////////////////////////////
	@Column(name = "documento")
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	///////////////////////////////////////////////////
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	/////////////////////////////////////////////////
	@Column(name = "estado")
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
	public Titular(String nombre, String direccion,String dni,String email,String estado) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni=dni;
		this.email=email;
		this.estado=estado;	
	}
	
	//////////////////////////////////////////////////////////////////
	public Titular() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	
}
