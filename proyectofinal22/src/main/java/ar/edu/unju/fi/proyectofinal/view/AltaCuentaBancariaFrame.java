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

public class AltaCuentaBancariaFrame extends JDialog implements IViewCuentaBancaria{
	private JPanel contentPane;
	private JTextField txtNumeroCuenta;
	private JTextField txtSaldo;
	private JComboBox<String> comboTipoCuenta;
	private JComboBox<Titular> comboTitulares;
	
	private CuentaBancariaPresenter cuentaBancariaPresenter;
	
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
		
		cuentaBancariaPresenter = new CuentaBancariaPresenter(this);
		
		setTitle("Alta Cuenta Bancaria");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 100, 393, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Tipo");
		lblNombre.setBounds(10, 8, 70, 14);
		contentPane.add(lblNombre);		
		comboTipoCuenta = new JComboBox<String>();
		comboTipoCuenta.setBounds(100, 8, 150, 17);
		comboTipoCuenta.addItem("CAJA-AHORRO");
		comboTipoCuenta.addItem("CUENTA-CORRIENTE");		
		contentPane.add(comboTipoCuenta);
		JLabel lblCliente = new JLabel("Titular");
		lblCliente.setBounds(10, 36, 98, 14);
		contentPane.add(lblCliente);
		comboTitulares = new JComboBox<Titular>();
		comboTitulares.setBounds(100,36, 150, 20);
		cuentaBancariaPresenter.cargarComboTitulares();
		contentPane.add(comboTitulares);
		JLabel lblNumeroCuenta = new JLabel("Numero");
		lblNumeroCuenta.setBounds(10, 64, 98, 14);
		contentPane.add(lblNumeroCuenta);		
		txtNumeroCuenta = new JTextField();
		txtNumeroCuenta.setBounds(100, 64, 104, 20);
		contentPane.add(txtNumeroCuenta);
		txtNumeroCuenta.setColumns(10);
		JLabel lblSaldo = new JLabel("Saldo");
		lblSaldo.setBounds(10, 88, 98, 14);
		contentPane.add(lblSaldo);		
		txtSaldo = new JTextField();
		txtSaldo.setBounds(100, 88, 104, 20);
		contentPane.add(txtSaldo);
		txtSaldo.setColumns(10);
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarCuentaBancaria();	
			}
		});
		btnGuardar.setBounds(135, 123, 119, 23);
		contentPane.add(btnGuardar);
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
