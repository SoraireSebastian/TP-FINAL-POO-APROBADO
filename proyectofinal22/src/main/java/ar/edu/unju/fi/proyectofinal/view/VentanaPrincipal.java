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
		setTitle("Banco Macro S.A.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
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
				
			}
		});
		menuVentanaPrincipal.add(menuSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
