package ar.edu.unju.fi.proyectofinal.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import ar.edu.unju.fi.proyectofinal.dominio.CuentaBancaria;
import ar.edu.unju.fi.proyectofinal.presenter.GestionaSaldoPresenter;
import ar.edu.unju.fi.proyectofinal.presenter.TitularPresenter;
import ar.edu.unju.fi.proyectofinal.presenter.views.IViewGestionarSaldo;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class GestionarSaldoFrame extends JFrame implements IViewGestionarSaldo {

	private JPanel contentPane;
	private JTextField n1;
	private GestionaSaldoPresenter presenter;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionarSaldoFrame frame = new GestionarSaldoFrame(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	//CONTRUCTOR
	////////////////////////////////////
	/**
	 * Create the frame.
	 */
	public GestionarSaldoFrame(Integer idCuenta) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/img/user-icon (1).png"));
		
		presenter = new GestionaSaldoPresenter(this);
		setTitle("Gestionar Saldo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 602, 360);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccionar Opcion");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(227, 121, 142, 23);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Depositar", "Extraer"}));
		comboBox.setBounds(217, 162, 152, 29);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("    Ingrese Monto");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(229, 202, 140, 23);
		contentPane.add(lblNewLabel_1);
		
		n1 = new JTextField();
		n1.setBounds(217, 236, 152, 23);
		contentPane.add(n1);
		n1.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			//////////////////////////////////////////////////////
			public void actionPerformed(ActionEvent e) {
				//metodo para realizar el deposito o extraccion
				 String opcion = comboBox.getSelectedItem().toString();
				double num;
				if(opcion.equalsIgnoreCase("Depositar")){
					//num=Double.parseDouble(n1.getText()); //Transforma  lo ingresado en la casila n1 a double y lo almacena en la variable num
					//resultado.setText(String.valueOf(num));
					deposito(idCuenta);
					
				}
				if(opcion.equalsIgnoreCase("Extraer")){
					//num=Double.parseDouble(n1.getText()); //Transforma  lo ingresado en la casila n1 a double y lo almacena en la variable num
					//resultado.setText(String.valueOf(num));
					extraccion(idCuenta);
					
					
				}
				
				//dispose();//cierra la ventana actual metodo heredado del JFrame	
				
				
			}
		});
		btnNewButton.setBounds(242, 288, 97, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("src/main/resources/img/get-money-icon.png"));
		lblNewLabel_2.setBounds(217, 11, 140, 99);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("src/main/resources/img/abstract-grunge-decorative-relief-navy-blue-stucco-wall-texture-wide-angle-rough-colored-background.jpg"));
		lblNewLabel_3.setBounds(0, 0, 585, 322);
		contentPane.add(lblNewLabel_3);
		
	}

	@Override
	public void deposito(Integer idCuenta) {
	double num=Double.parseDouble(n1.getText());
		presenter.depositarSaldo(num,idCuenta);
		
	}

	
	@Override
	public void extraccion(Integer idCuenta) {
		double num=Double.parseDouble(n1.getText());
		presenter.extraerSaldo(num,idCuenta);
		
	}
}
