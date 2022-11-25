package ar.edu.unju.fi.proyectofinal.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ar.edu.unju.fi.proyectofinal.presenter.TitularPresenter;
import ar.edu.unju.fi.proyectofinal.presenter.views.IViewTitular;
import javax.swing.JCheckBox;

public class AltaTitularFrame extends JDialog implements IViewTitular{

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private TitularPresenter titularPresenter;
	private JTextField textDni;
	private JTextField textEmail;
	private String estado = "DESABILITADO";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaTitularFrame frame = new AltaTitularFrame(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AltaTitularFrame(Integer idTitular) {
		
		titularPresenter = new TitularPresenter(this);
		
		setTitle("Alta Titular");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 398, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre*");
		lblNombre.setBounds(10, 8, 70, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(129, 5, 185, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion*");
		lblDireccion.setBounds(10, 36, 98, 14);
		contentPane.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(129, 33, 185, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);		
		
		buscarTitularBy(idTitular);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idTitular != null) {
					actualizarTitular(idTitular);
				}else {
					registrarTitular();	
				}				
			}
		});
		btnGuardar.setBounds(145, 201, 89, 23);
		contentPane.add(btnGuardar);
		
		textDni = new JTextField();
		textDni.setColumns(10);
		textDni.setBounds(129, 64, 185, 20);
		contentPane.add(textDni);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setBounds(10, 67, 98, 14);
		contentPane.add(lblDocumento);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(129, 95, 185, 20);
		contentPane.add(textEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 98, 98, 14);
		contentPane.add(lblEmail);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 141, 98, 14);
		contentPane.add(lblEstado);
		
		JCheckBox CheckBoxHabilitado = new JCheckBox("Habilitado");
		CheckBoxHabilitado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CheckBoxHabilitado.isSelected()) {
					estado="HABILITADO";	
				}
			}
		});
		CheckBoxHabilitado.setBounds(129, 137, 97, 23);
		contentPane.add(CheckBoxHabilitado);
	}

	private void buscarTitularBy(Integer idTitular) {
		if(idTitular != null) {
			titularPresenter.buscarBy(idTitular);	
		}		
	}
	
	private void actualizarTitular(Integer idTitular) {
		titularPresenter.actualizarTitular(idTitular, txtNombre.getText(), txtDireccion.getText(), textDni.getText(),textEmail.getText(),estado);
		this.dispose();		
	}
	private void registrarTitular() {
		titularPresenter.registrarTitular(txtNombre.getText(), txtDireccion.getText(), textDni.getText(),textEmail.getText(),estado);
		this.dispose();
	}

	@Override
	public void visualizarResultado(String mensajeResultado) {
		JOptionPane.showMessageDialog(this, mensajeResultado);		
	}
	@Override
	public void setInputsText(String nombre, String direccion) {
		this.txtNombre.setText(nombre);
		this.txtDireccion.setText(direccion);
	}
}
