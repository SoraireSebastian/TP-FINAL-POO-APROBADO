package ar.edu.unju.fi.proyectofinal.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ar.edu.unju.fi.proyectofinal.dominio.Titular;
import ar.edu.unju.fi.proyectofinal.presenter.CuentaBancariaPresenter;
import ar.edu.unju.fi.proyectofinal.presenter.views.IViewCuentaBancaria;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class AltaCuentaBancariaFrame extends JDialog implements IViewCuentaBancaria{
	private JPanel contentPane;
	private JTextField txtNumeroCuenta;
	private JTextField txtSaldo;
	private JComboBox<String> comboTipoCuenta;
	private JComboBox<Titular> comboTitulares;
	
	private CuentaBancariaPresenter cuentaBancariaPresenter;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaCuentaBancariaFrame frame = new AltaCuentaBancariaFrame(null);
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
	public AltaCuentaBancariaFrame(Integer idCuenta) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ricky\\git\\TP-FINAL-POO-REGULAR\\proyectofinal22\\src\\main\\resources\\img\\user-icon (1).png"));
		
		cuentaBancariaPresenter = new CuentaBancariaPresenter(this);
		
		setTitle("Alta Cuenta Bancaria");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 100, 575, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Tipo*");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setForeground(new Color(0, 0, 0));
		lblNombre.setBounds(10, 159, 70, 14);
		contentPane.add(lblNombre);		
		comboTipoCuenta = new JComboBox<String>();
		comboTipoCuenta.setBounds(198, 159, 150, 26);
		comboTipoCuenta.addItem("CAJA-AHORRO");
		comboTipoCuenta.addItem("CUENTA-CORRIENTE");		
		contentPane.add(comboTipoCuenta);
		JLabel lblCliente = new JLabel("Titular*");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCliente.setForeground(new Color(0, 0, 0));
		lblCliente.setBounds(10, 196, 98, 17);
		contentPane.add(lblCliente);
		comboTitulares = new JComboBox<Titular>();
		comboTitulares.setBounds(198,196, 150, 20);
		cuentaBancariaPresenter.cargarComboTitulares();
		contentPane.add(comboTitulares);
		JLabel lblNumeroCuenta = new JLabel("Numero Cuenta*");
		lblNumeroCuenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroCuenta.setForeground(new Color(0, 0, 0));
		lblNumeroCuenta.setBounds(10, 227, 135, 17);
		contentPane.add(lblNumeroCuenta);		
		txtNumeroCuenta = new JTextField();
		txtNumeroCuenta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char num = e.getKeyChar();
				if(num<'0'||num>'9')e.consume();
			}
		});
		txtNumeroCuenta.setBounds(198, 227, 150, 20);
		contentPane.add(txtNumeroCuenta);
		txtNumeroCuenta.setColumns(10);
		JLabel lblSaldo = new JLabel("Saldo*");
		lblSaldo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSaldo.setForeground(new Color(0, 0, 0));
		lblSaldo.setBounds(10, 258, 104, 17);
		contentPane.add(lblSaldo);		
		txtSaldo = new JTextField();
		txtSaldo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char num = e.getKeyChar();
				if(num<'0'||num>'9')e.consume();
			}
		});
		txtSaldo.setBounds(198, 258, 150, 20);
		contentPane.add(txtSaldo);
		txtSaldo.setColumns(10);
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarCuentaBancaria();	
			}
		});
		btnGuardar.setBounds(216, 289, 119, 23);
		contentPane.add(btnGuardar);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ricky\\git\\TP-FINAL-POO-REGULAR\\proyectofinal22\\src\\main\\resources\\img\\icono-dollar.png"));
		lblNewLabel.setBounds(198, 11, 135, 118);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ricky\\git\\TP-FINAL-POO-REGULAR\\proyectofinal22\\src\\main\\resources\\img\\money-fondo.jpg"));
		lblNewLabel_1.setBounds(0, 0, 559, 323);
		contentPane.add(lblNewLabel_1);
	}

	@Override
	public JComboBox<Titular> getComboTitulares() {
		return comboTitulares;
	}

	private void registrarCuentaBancaria() {
		cuentaBancariaPresenter.registrarCuentaBancaria(comboTipoCuenta.getSelectedItem().toString(), comboTitulares.getSelectedItem(), txtNumeroCuenta.getText(), txtSaldo.getText());
		this.dispose();
	}
	
}
