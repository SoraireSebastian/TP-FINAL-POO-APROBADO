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
	/////////////////////////////////
	
	
	/**
	 * Create the frame.
	 */
	public GestionarSaldoFrame(Integer idCuenta) {
		
		presenter = new GestionaSaldoPresenter(this);
		setTitle("Gestionar Saldo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccionar Opcion");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(141, 11, 140, 23);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Depositar", "Extraer"}));
		comboBox.setBounds(129, 45, 152, 23);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("    Ingrese Monto");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(141, 95, 140, 23);
		contentPane.add(lblNewLabel_1);
		
		n1 = new JTextField();
		n1.setBounds(141, 129, 140, 23);
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
				
			}
		});
		btnNewButton.setBounds(164, 184, 89, 23);
		contentPane.add(btnNewButton);
		
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
