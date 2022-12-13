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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ricky\\git\\TP-FINAL-POO-REGULAR\\proyectofinal22\\src\\main\\resources\\img\\user-icon (1).png"));
		
		titularPresenter = new TitularPresenter(this);
		
		setTitle("Alta Titular");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 532, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre*");
		lblNombre.setBounds(24, 205, 70, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(159, 202, 185, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion*");
		lblDireccion.setBounds(24, 236, 98, 14);
		contentPane.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(159, 233, 185, 20);
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
		btnGuardar.setBounds(199, 352, 89, 23);
		contentPane.add(btnGuardar);
		
		textDni = new JTextField();
		textDni.addKeyListener(new KeyAdapter() {
			@Override
			/***
			 * METODO SOLO PERMITE INGRESAR NUMEROS EN EL CAMPO DNI;
			 */
			public void keyTyped(KeyEvent e) {
				char num = e.getKeyChar();
				if(num<'0'||num>'9')e.consume();
			}
		});
		textDni.setColumns(10);
		textDni.setBounds(159, 264, 185, 20);
		contentPane.add(textDni);
		
		JLabel lblDocumento = new JLabel("Documento*");
		lblDocumento.setBounds(24, 267, 98, 14);
		contentPane.add(lblDocumento);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(159, 295, 185, 20);
		contentPane.add(textEmail);
		
		JLabel lblEmail = new JLabel("Email*");
		lblEmail.setBounds(24, 298, 98, 14);
		contentPane.add(lblEmail);
		
		JLabel lblEstado = new JLabel("Estado*");
		lblEstado.setBounds(24, 326, 125, 14);
		contentPane.add(lblEstado);
		
		JCheckBox CheckBoxHabilitado = new JCheckBox("Habilitado");
		CheckBoxHabilitado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CheckBoxHabilitado.isSelected()) {
					estado="HABILITADO";	
				}
			}
		});
		CheckBoxHabilitado.setBounds(199, 322, 97, 23);
		contentPane.add(CheckBoxHabilitado);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ricky\\git\\TP-FINAL-POO-REGULAR\\proyectofinal22\\src\\main\\resources\\img\\conversation-icon.png"));
		lblNewLabel.setBounds(178, 11, 133, 180);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ricky\\git\\TP-FINAL-POO-REGULAR\\proyectofinal22\\src\\main\\resources\\img\\money-fondo.jpg"));
		lblNewLabel_1.setBounds(0, 0, 516, 386);
		contentPane.add(lblNewLabel_1);
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
