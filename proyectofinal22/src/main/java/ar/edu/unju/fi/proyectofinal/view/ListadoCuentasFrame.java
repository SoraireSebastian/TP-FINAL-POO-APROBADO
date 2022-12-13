package ar.edu.unju.fi.proyectofinal.view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ar.edu.unju.fi.proyectofinal.presenter.ListadoCuentasPresenter;
import ar.edu.unju.fi.proyectofinal.presenter.views.IViewCuentas;

public class ListadoCuentasFrame extends JFrame implements IViewCuentas {
	private JPanel contentPane;
	private ListadoCuentasPresenter presenter;
	private JTable table;
	private JTextField textBusqueda;

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoCuentasFrame frame = new ListadoCuentasFrame();
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
	public ListadoCuentasFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ricky\\Downloads\\user-icon (1).png"));
		setTitle("Listado de Cuentas Bancarias");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 931, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Listado de Cuentas Bancarias");
		lblTitulo.setBounds(10, 11, 153, 14);
		contentPane.add(lblTitulo);

		JButton btnAgregar = new JButton("Agregar Cuenta");
		btnAgregar.setBounds(173, 11, 138, 23);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaCuentaBancariaFrame altaCuentaFrame = new AltaCuentaBancariaFrame(null);
				altaCuentaFrame.setModal(true);
				altaCuentaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				altaCuentaFrame.setVisible(true);
				setTableModelFor(table);
				visualizarListadoCuentas();
			}
		});
		contentPane.add(btnAgregar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 905, 350);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setRowSelectionAllowed(true);
		setTableModelFor(table);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("New label");
		scrollPane.setColumnHeaderView(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		scrollPane.setColumnHeaderView(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		scrollPane.setColumnHeaderView(lblNewLabel_2);

		JButton btnExtraccionDeposito = new JButton("Extraccion/Deposito");
		btnExtraccionDeposito.setBounds(321, 11, 129, 23);
		btnExtraccionDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer row = table.getSelectedRow();
				// GestionarSaldoFrame frame = new GestionarSaldoFrame();
				// frame.setVisible(true);
				if (row != -1) {
					Integer idTitular = (Integer) table.getModel().getValueAt(row, 0);
					GestionarSaldoFrame frame = new GestionarSaldoFrame(row);
					frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "No Selecciono Ninguna Cuenta");
					// JOptionPane.showMessageDialog(null,row);
				}
			}
		});
		contentPane.add(btnExtraccionDeposito);

		textBusqueda = new JTextField();
		textBusqueda.setBounds(473, 12, 118, 20);
		textBusqueda.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char num = e.getKeyChar();
				if (num < '0' || num > '9')
					e.consume();
			}
		});
		contentPane.add(textBusqueda);
		textBusqueda.setColumns(10);

		JButton btnSearch = new JButton("Buscar N° Cuenta");
		btnSearch.setBounds(601, 11, 153, 23);
		btnSearch.addActionListener(new ActionListener() {
			///////////////////////////////////////////////////////
			public void actionPerformed(ActionEvent e) {
				setTableModelFor(table);
				visualizarResultadoBusqueda();
				////////////////////////////////////////////////////////
			}

		});
		contentPane.add(btnSearch);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(779, 11, 98, 23);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/////////////////////////////////////////////////////////////////////
				setTableModelFor(table); // Actualiza la tabla
				visualizarListadoCuentas();
				//////////////////////////////////////////////////////////////////////
			}
		});
		contentPane.add(btnActualizar);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(
				"src/main/resources/img/money-fondo.jpg"));
		lblNewLabel_3.setBounds(0, 0, 915, 400);
		contentPane.add(lblNewLabel_3);
		presenter = new ListadoCuentasPresenter(this);
		visualizarListadoCuentas();
	}

	private void setTableModelFor(JTable table) {
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Titular", "Tipo Cuenta", "Numero Cuenta", "Saldo", "Fecha" }) {
			boolean[] columnEditables = new boolean[] { true, true, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(194);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
	}

	@Override
	public void visualizarListadoCuentas() {
		// TODO Auto-generated method stub
		presenter.visualizarCuentas();
	}

	@Override
	public void visualizarResultadoBusqueda() {
		int numCuenta = Integer.parseInt(textBusqueda.getText()); // convierte lo que recibe txfield a entero
		// String numCuenta = textBusqueda.getText();
		presenter.visualizarResultadoBusqueda(numCuenta);
	}
}
