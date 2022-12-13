package ar.edu.unju.fi.proyectofinal.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void visualizarGestionTitulares() {
		ListadoTitularesFrame frame = new ListadoTitularesFrame();
		frame.setVisible(true);	
	}
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ricky\\Downloads\\user-icon (1).png"));
		setTitle("Banco Macro S.A.");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 569, 354);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(255, 255, 255));
		setJMenuBar(menuBar);
		
		JMenu menuVentanaPrincipal = new JMenu("Funcionalidades");
		menuBar.add(menuVentanaPrincipal);
		
		JMenuItem menuTitulares = new JMenuItem("Gestionar Titulares");
		menuTitulares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visualizarGestionTitulares();
			}
		});
		menuVentanaPrincipal.add(menuTitulares);
		
		JMenuItem menuCuentasBancarias = new JMenuItem("Gestionar Cuentas Bancarias");
		menuCuentasBancarias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoCuentasFrame frame = new ListadoCuentasFrame();
				frame.setVisible(true);
			}
		});
		menuVentanaPrincipal.add(menuCuentasBancarias);
		
		JMenuItem menuSalir = new JMenuItem("Salir");
		menuSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		menuVentanaPrincipal.add(menuSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("src/main/resources/img/fondo dollar.jpg"));
		lblNewLabel.setBounds(0, 0, 548, 293);
		contentPane.add(lblNewLabel);
	}
}
