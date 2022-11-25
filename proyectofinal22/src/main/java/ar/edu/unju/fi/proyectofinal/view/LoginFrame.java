package ar.edu.unju.fi.proyectofinal.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ar.edu.unju.fi.proyectofinal.presenter.LoginPresenter;
import ar.edu.unju.fi.proyectofinal.presenter.views.IViewlogin;

public class LoginFrame extends JFrame implements IViewlogin{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtPassword;
	
	private LoginPresenter loginPresenter;

	private boolean loggedIn = false;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public LoginFrame() {
		
		loginPresenter = new LoginPresenter(this);
		
		setTitle("Login Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 353, 156);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Usuario");
		lblNombre.setBounds(10, 8, 70, 14);
		contentPane.add(lblNombre);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(129, 5, 104, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 36, 98, 14);
		contentPane.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(129, 33, 104, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Ingresar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				loginPresenter.validar(txtUsuario.getText(), txtPassword.getText());				
				
				VentanaPrincipal frame = new VentanaPrincipal();
				frame.setVisible(true);
			}
		});
		btnLogin.setBounds(115, 83, 100, 23);
		contentPane.add(btnLogin);
	}
	
//	private void login() {
//		loggedIn =  loginPresenter.validar(txtUsuario.getText(), txtPassword.getText());
//		if (loggedIn) {
//			this.setVisible(false);
//			ListadoTitularesFrame  titulares = new ListadoTitularesFrame();
//			titulares.setVisible(true);	
//		}else {
//			JOptionPane.showMessageDialog(null, "Los Datos de Acceso son Incorrectos");
//		}
//	}
	
	@Override
	public void visualizarResultado(String resultado) {
		JOptionPane.showMessageDialog(this, resultado);
		txtUsuario.setText(null);
		txtPassword.setText(null);
	}
	
	@Override
	public void visualizarMain() {
		this.setVisible(false);
		ListadoTitularesFrame  titulares = new ListadoTitularesFrame();
		titulares.setVisible(false);
	}
}
