package ar.edu.unju.fi.proyectofinal.view;

import java.awt.EventQueue;
import java.awt.Image;
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
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ricky\\Downloads\\user-icon (1).png"));
		
		loginPresenter = new LoginPresenter(this);
		
		setTitle("Login Sistema");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 527, 346);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("USUARIO:");
		lblNombre.setForeground(new Color(0, 0, 0));
		lblNombre.setBounds(40, 205, 70, 14);
		contentPane.add(lblNombre);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(160, 202, 161, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setBounds(40, 245, 110, 14);
		contentPane.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(160, 242, 161, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Ingresar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				loggedIn =  loginPresenter.validar(txtUsuario.getText(), txtPassword.getText());
				//loginPresenter.validar(txtUsuario.getText(), txtPassword.getText());				
				if (loggedIn) {
					ListadoTitularesFrame  titulares = new ListadoTitularesFrame();
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
					
					
					//titulares.setVisible(true);	
				}else {
					JOptionPane.showMessageDialog(null, "Los Datos de Acceso son Incorrectos");
				}
				
				//VentanaPrincipal frame = new VentanaPrincipal();
				//frame.setVisible(true);
			}
		});
		
		btnLogin.setBounds(194, 273, 100, 23);
		contentPane.add(btnLogin);
		/////////////////////////////////////////////////
		
		
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/img/owl-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(171, 11, 138, 176);
		contentPane.add(lblNewLabel);
		
		/////////////////////////////////////////////
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