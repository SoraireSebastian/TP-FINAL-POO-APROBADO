package ar.edu.unju.fi.proyectofinal.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ar.edu.unju.fi.proyectofinal.presenter.ListadoCuentasPresenter;
import ar.edu.unju.fi.proyectofinal.presenter.views.IViewCuentas;
import javax.swing.JTextField;

public class ListadoCuentasFrame extends JFrame implements IViewCuentas{
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
		setTitle("Listado de Cuentas Bancarias");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 806, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Listado de Cuentas Bancarias");
		lblTitulo.setBounds(10, 11, 153, 14);
		contentPane.add(lblTitulo);
		
		JButton btnAgregar = new JButton("Agregar Cuenta");
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
		btnAgregar.setBounds(173, 11, 109, 23);
		contentPane.add(btnAgregar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 770, 350);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setRowSelectionAllowed(true);
		setTableModelFor(table);
		scrollPane.setViewportView(table);
		
		JButton btnExtraccionDeposito = new JButton("Extraccion/Deposito");
		btnExtraccionDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer row = table.getSelectedRow();
				//GestionarSaldoFrame frame = new GestionarSaldoFrame();
				//frame.setVisible(true);
				if (row != -1) {
					Integer idTitular =  (Integer) table.getModel().getValueAt(row, 0);
					GestionarSaldoFrame frame = new GestionarSaldoFrame(row);
					frame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "No Selecciono Ninguna Cuenta");		
				//	JOptionPane.showMessageDialog(null,row);
				}
			}
		});
		btnExtraccionDeposito.setBounds(305, 11, 129, 23);
		contentPane.add(btnExtraccionDeposito);
		
		textBusqueda = new JTextField();
		textBusqueda.setBounds(473, 12, 118, 20);
		contentPane.add(textBusqueda);
		textBusqueda.setColumns(10);
		
		JButton btnSearch = new JButton("Buscar");
		btnSearch.addActionListener(new ActionListener() {
			///////////////////////////////////////////////////////
			public void actionPerformed(ActionEvent e) {
				setTableModelFor(table);
				visualizarResultadoBusqueda();
			////////////////////////////////////////////////////////	
			}
			
			
		});
		btnSearch.setBounds(601, 11, 82, 23);
		contentPane.add(btnSearch);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/////////////////////////////////////////////////////////////////////
				setTableModelFor(table); 
				visualizarListadoCuentas();
				//////////////////////////////////////////////////////////////////////
			}
		});
		btnActualizar.setBounds(698, 11, 82, 23);
		contentPane.add(btnActualizar);
		presenter = new ListadoCuentasPresenter(this);
	    visualizarListadoCuentas();
	}
	
	private void setTableModelFor(JTable table) {
		table.setModel(new DefaultTableModel(
			new Object[][] {
				},
				new String[] {
					"Id", "Titular", "Tipo", "Numero", "Saldo"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					true, true, false
				};
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
		int numCuenta=Integer.parseInt(textBusqueda.getText()); //convierte lo que recibe txfield a entero
		//String numCuenta = textBusqueda.getText();
		presenter.visualizarResultadoBusqueda(numCuenta);
	}
}
