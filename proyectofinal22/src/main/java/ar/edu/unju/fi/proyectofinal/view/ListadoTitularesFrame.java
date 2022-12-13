package ar.edu.unju.fi.proyectofinal.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import ar.edu.unju.fi.proyectofinal.presenter.ListadoTitularesPresenter;
import ar.edu.unju.fi.proyectofinal.presenter.views.IViewTitulares;

public class ListadoTitularesFrame extends JFrame implements IViewTitulares {

	private JPanel contentPane;
	private ListadoTitularesPresenter presenter;
	private JTable table;

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoTitularesFrame frame = new ListadoTitularesFrame();
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
	public ListadoTitularesFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"src/main/resources/img/user-icon (1).png"));
		setTitle("Listado de Titulares");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 824, 459);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextField txtNombre = new JTextField();
		txtNombre.setBounds(10, 5, 104, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTableModelFor(table);
				presenter.buscarTitularesBy(txtNombre.getText());
			}
		});
		btnBuscar.setBounds(130, 5, 112, 23);
		contentPane.add(btnBuscar);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaTitularFrame altaTitularFrame = new AltaTitularFrame(null);
				altaTitularFrame.setModal(true);
				altaTitularFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				altaTitularFrame.setVisible(true);
				setTableModelFor(table);
				visualizarListadoTitulares();
			}
		});
		btnAgregar.setBounds(276, 4, 112, 23);
		contentPane.add(btnAgregar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();// GUARDA EN LA VARIABLE ROW LA FILA SELECCIONADA CON EL MOUSE;
				if (row != -1) {
					Integer idTitular = (Integer) table.getModel().getValueAt(row, 0);

					AltaTitularFrame altaTitularFrame = new AltaTitularFrame(idTitular);
					altaTitularFrame.setModal(true);
					altaTitularFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					altaTitularFrame.setVisible(true);
					setTableModelFor(table);
					visualizarListadoTitulares();
				} else {
					JOptionPane.showMessageDialog(null, "No Selecciono Ningun Titular");
				}

			}
		});
		btnEditar.setBounds(419, 4, 112, 23);
		contentPane.add(btnEditar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 36, 767, 373);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setRowSelectionAllowed(true);
		setTableModelFor(table);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(
				"src/main/resources/img/money-fondo.jpg"));
		lblNewLabel.setBounds(0, 0, 808, 420);
		contentPane.add(lblNewLabel);
		presenter = new ListadoTitularesPresenter(this);

		visualizarListadoTitulares();
	}

	private void setTableModelFor(JTable table) {
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "NOMBRE", "DIRECCION", "DOCUMENTO", "ESTADO" }) {
			boolean[] columnEditables = new boolean[] { false, true, true, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(96);
		table.getColumnModel().getColumn(2).setPreferredWidth(187);
		table.getColumnModel().getColumn(3).setPreferredWidth(52);
		table.getColumnModel().getColumn(4).setPreferredWidth(134);
	}

	@Override
	public void visualizarListadoTitulares() {
		presenter.visualizarTitulares();

	}
}
