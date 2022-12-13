package ar.edu.unju.fi.proyectofinal.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ar.edu.unju.fi.proyectofinal.presenter.TitularPresenter;
import ar.edu.unju.fi.proyectofinal.presenter.views.IViewTitular;
import javax.swing.ImageIcon;

public class AltaTitularFrame extends JDialog implements IViewTitular{

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtDocumento;
	private JTextField txtEmail;
	private TitularPresenter titularPresenter;
	private JLabel lblEstado;
	private JLabel lblNombre1;
	private JLabel lblDireccion1;
	private JLabel lblDocumento1;
	private JLabel lblEmail1;
	private JButton btnGuardar;
	private JComboBox<String> comboEstado;

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
		setBounds(100, 100, 914, 414);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// JLABEL DE NOMBRE PARA DAR DE ALTA UN TITULAR
		JLabel lblNombre = new JLabel("Nombre y Apellido");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(10, 81, 133, 20);
	
		contentPane.add(lblNombre);
		//----------------------------------------
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNombre.setBounds(153, 81, 232, 23);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean espacio = key == 32;

				if (!(minusculas || mayusculas || espacio)) {
					e.consume();
				}

				if (txtNombre.getText().length() >= 35) {
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				validacionesFrm();
			}
		});
		

		// JLABEL DE DIRECCIÓN PARA DAR DE ALTA UN TITULAR
		JLabel lblDireccion = new JLabel("Dirección");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDireccion.setBounds(10, 114, 133, 17);
		contentPane.add(lblDireccion);

		// MÉTODO PARA DEFINIR CANTIDAD DE 35 CARACTERES A TEXTO DIRECCIÓN
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtDireccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtDireccion.getText().length() >= 40) {
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				validacionesFrm();
			}
		});
		txtDireccion.setBounds(153, 112, 232, 23);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);

		// -------JLABEL DOCUMENTO-----------------
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDocumento.setBounds(10, 147, 133, 17);
		contentPane.add(lblDocumento);
		txtDocumento = new JTextField();
		txtDocumento.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtDocumento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				boolean numeros = key >= 48 && key <= 57;

				// CONDICIONAL QUE PERMITE SOLO INGRESAR NÚMEROS
				if (!numeros) {
					e.consume();
				}
				// CONDICIONAL QUE SOLO PERMITE UN MÁXIMO DE 8 DÍGITOS EN EL CAMPO
				if (txtDocumento.getText().length() >= 8) {
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				validacionesFrm();
			}
		});
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(153, 145, 232, 23);
		contentPane.add(txtDocumento);

		// -------JLABEL EMAIL---------------------
		JLabel lblEmail = new JLabel("Correo Electrónico");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(10, 181, 133, 17);
		contentPane.add(lblEmail);
		txtEmail = new JTextField();
		txtEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (titularPresenter.ValidarEmail(txtEmail.getText())) {
					lblEmail1.setText(" ");
				} else {
					lblEmail1.setText("Por favor, escriba un correo válido");
				}
			}
		});
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validacionesFrm();
			}
		});
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(153, 179, 232, 23);
		contentPane.add(txtEmail);

		// -----------JLABEL ESTADO------------------

		lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEstado.setBounds(10, 217, 133, 17);
		contentPane.add(lblEstado);

		//// ------------JBUTTON MÉTODO GUARDAR---------------------
		btnGuardar = new JButton("Registrar");
		btnGuardar.setEnabled(false);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (idTitular != null) {
					actualizarTitular(idTitular);
				} else {
					registrarTitular();
				}
			}
		});

		// ---------MÉTODO GUARDAR-----------------
		btnGuardar.setBounds(153, 272, 232, 46);
		contentPane.add(btnGuardar);

		JLabel lblFormularioDeRegistro = new JLabel("Formulario de Registro Titular");
		lblFormularioDeRegistro.setForeground(Color.DARK_GRAY);
		lblFormularioDeRegistro.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFormularioDeRegistro.setBounds(11, 11, 298, 35);
		contentPane.add(lblFormularioDeRegistro);
		lblNombre1 = new JLabel("");
		lblNombre1.setForeground(Color.RED);
		lblNombre1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNombre1.setBounds(395, 81, 397, 20);
		contentPane.add(lblNombre1);

		lblDireccion1 = new JLabel("");
		lblDireccion1.setForeground(Color.RED);
		lblDireccion1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDireccion1.setBounds(395, 117, 397, 20);
		contentPane.add(lblDireccion1);

		lblDocumento1 = new JLabel("");
		lblDocumento1.setForeground(Color.RED);
		lblDocumento1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDocumento1.setBounds(395, 150, 397, 20);
		contentPane.add(lblDocumento1);

		lblEmail1 = new JLabel("");
		lblEmail1.setForeground(Color.RED);
		lblEmail1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblEmail1.setBounds(395, 184, 397, 20);
		contentPane.add(lblEmail1);
		// ------------------------------------

		comboEstado = new JComboBox<String>();
		comboEstado.setBounds(153, 213, 232, 22);
		comboEstado.addItem("Habilitado");
		comboEstado.addItem("Deshabilitado");
		contentPane.add(comboEstado);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/img/money-fondo.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 898, 375);
		contentPane.add(lblNewLabel);

		// ------------COMBO BOX DE FORMULARIO ALTA TITULAR ----------------------

		// ---------MÉTODO BUSCAR------------------
		buscarTitularBy(idTitular);

	}

	// ---------------SECTOR MÉTODOS--------------------------
	private void buscarTitularBy(Integer idTitular) {
		if (idTitular != null) {
			titularPresenter.buscarBy(idTitular);
		}
	}

	private void actualizarTitular(Integer idTitular) {
		titularPresenter.actualizarTitular(idTitular, txtNombre.getText(), txtDireccion.getText(),
				txtDocumento.getText(), txtEmail.getText(), comboEstado.getSelectedItem().toString());
		this.dispose();
		btnGuardar.setEnabled(true);
	}

	private void registrarTitular() {
		titularPresenter.registrarTitular(txtNombre.getText(), txtDireccion.getText(), txtDocumento.getText(),
				txtEmail.getText(), comboEstado.getSelectedItem().toString());
		this.dispose();
	}

	private void validacionesFrm() {
		// CONDICIONAL INPUT NOMBRE
		if (txtNombre.getText().isEmpty()) {
			lblNombre1.setText("*Campo Requerido");
		} else if (txtNombre.getText().length() < 8 || txtNombre.getText().length() > 30) {
			lblNombre1.setText("El nombre debe tener entre 8-30 caracteres");
		} else {
			lblNombre1.setText("CORRECTO");
		}
		// CONDICIONAL INPUT DIRECCIÓN
		if (txtDireccion.getText().isEmpty()) {
			lblDireccion1.setText("*Campo Requerido");
		} else if (txtDireccion.getText().length() < 15 || txtDireccion.getText().length() > 35 ) {
			lblDireccion1.setText("La dirección debe tener entre 15-35 caracteres");
		} else {
			lblDireccion1.setText("CORRECTO");
		}
		// CONDICIONAL INPUT DOCUMENTO
		if (txtDocumento.getText().isEmpty()) {
			lblDocumento1.setText("*Campo Requerido");
		} else if (txtDocumento.getText().length() < 8) {
			lblDocumento1.setText("El dni debe tener 8 dígitos");
		} else {
			lblDocumento1.setText("CORRECTO");
		}

		// CONDICIONAL INPUT CORREO
		if (txtEmail.getText().isEmpty()) {
			lblEmail1.setText("*Campo Requerido");
		} else if (txtEmail.getText().length() < 12 || txtEmail.getText().length() > 30) {
			lblEmail1.setText("El correo debe tener entre 12-30 caracteres");
		} else if (!titularPresenter.ValidarEmail(txtEmail.getText().trim())) {
			lblEmail1.setText("Por favor, escriba un correo válido");
		} else {
			lblEmail1.setText("CORRECTO");
		}

		// CONDICIONAL PARA APAGAR O PRENDER BOTÓN DE GUARDAR REGISTRO
		if (txtNombre.getText().length() >= 8 && txtNombre.getText().length() <= 30 ) {
			if (txtDireccion.getText().length() >= 15 && txtDireccion.getText().length() <=35) {
				if (txtDocumento.getText().length() >= 8) {
					if (txtEmail.getText().length() >= 12 && txtEmail.getText().length() <= 30
							&& titularPresenter.ValidarEmail(txtEmail.getText())) {
						btnGuardar.setEnabled(true);
					} else {
						btnGuardar.setEnabled(false);
					}
				} else {
					btnGuardar.setEnabled(false);
				}
			} else {
				btnGuardar.setEnabled(false);
			}
		} else {
			btnGuardar.setEnabled(false);
		}
	}

	// ---------MÉTODO ------------------
	@Override
	public void visualizarResultado(String mensajeResultado) {
		JOptionPane.showMessageDialog(this, mensajeResultado);
	}

	@Override
	public void setInputsText(String nombre, String direccion, String documento, String email, String estado) {
		this.txtNombre.setText(nombre);
		this.txtDireccion.setText(direccion);
		this.txtDocumento.setText(documento);
		this.txtEmail.setText(email);
	}
}