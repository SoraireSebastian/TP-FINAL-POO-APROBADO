package ar.edu.unju.fi.proyectofinal.presenter.views;

import javax.swing.JTable;

public interface IViewCuentas {
	void visualizarListadoCuentas();
	JTable getTable();
	void setTable(JTable table);
	void visualizarResultadoBusqueda();
}
