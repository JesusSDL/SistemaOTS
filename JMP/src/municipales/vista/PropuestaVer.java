package municipales.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.ReadOnlyFileSystemException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import municipales.dao.PropuestaDAO;
import municipales.modelo.Propuesta;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PropuestaVer extends JPanel {
	JTable table = new JTable();
	private ArrayList<Propuesta> propuestas;

	public PropuestaVer() {

		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("\r\n");
		scrollPane.setBounds(37, 134, 326, 249);
		add(scrollPane);
		// La tabla con los nombres de los atributos de propuesta
		table = new JTable();
		DefaultTableModel dataModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Títulos de las Propuestas" });
		table.setModel(dataModel);
		scrollPane.setViewportView(table);

		// lleva consigo los datos del registro seleccionado al panel de alta y en las
		// casillas los rellena con los datos correspondientes
		// modificás el que querés y le das a cargar y lo actualiza
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				Propuesta p = propuestaSeleccionada();
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) a.getSource());
				marco.setContentPane(new PropuestaAlta(p));
				marco.validate();

			}
		});
		btnModificar.setBounds(420, 214, 103, 23);
		add(btnModificar);
		// Elminia el registro de una aunque estaría bueno que te de una confirmación
		// Por las dudas
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {

				Propuesta p = propuestaSeleccionada();
				PropuestaDAO pDAO = new PropuestaDAO();
				pDAO.baja(p.getTitulo());
				cargarTablaTodos(dataModel);
			}
		});
		btnEliminar.setBounds(420, 281, 103, 23);
		add(btnEliminar);

		JButton btnVolver = new JButton("<--");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new PropuestaPrincipal());
				marco.validate();
			}
		});
		btnVolver.setBounds(21, 27, 89, 23);
		add(btnVolver);

		JLabel lblNewLabel = new JLabel("Buscar Propuestas : ");
		lblNewLabel.setBounds(37, 77, 125, 23);
		add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Todas", "Pendientes", "Aprobadas", "Rechazadas" }));
		comboBox.setBounds(157, 77, 96, 22);
		add(comboBox);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String elegir = comboBox.getSelectedItem().toString();
				switch (elegir) {

				case "Todas":

					cargarTablaTodos(dataModel);
					break;
				case "Pendientes":

					cargarTablaPendientes(dataModel);

					break;

				case "Aprobadas":
					cargarTablaAceptadas(dataModel);
					break;

				case "Rechazadas":
					cargarTablaRechazadas(dataModel);
					break;
				}

			}
		});
		btnBuscar.setBounds(281, 77, 89, 23);
		add(btnBuscar);

		JButton btnVerDetalle = new JButton("Ver Detalle");
		btnVerDetalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Propuesta p = propuestaSeleccionada();
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new PropuestaVerDetalle(p));
				marco.validate();

			}
		});
		btnVerDetalle.setBounds(420, 153, 103, 23);
		add(btnVerDetalle);

		cargarTablaTodos(dataModel);

	}

	// Acá se complica la cosa pero básicamente va cargando los registros de la bd
	// en la tabla
	private void cargarTablaTodos(DefaultTableModel dataModel) {
		dataModel.setRowCount(0);
		PropuestaDAO pDAO = new PropuestaDAO();
		propuestas = pDAO.verSauron();

		for (Propuesta p : propuestas) {

			// poner todos los atributos para que los traiga ordenados por la tabla

			Object[] fila = new Object[] { p.getTitulo() };
			dataModel.addRow(fila);

		}
	}

	// hecho
	private void cargarTablaPendientes(DefaultTableModel dataModel) {
		dataModel.setRowCount(0);
		PropuestaDAO pDAO = new PropuestaDAO();
		propuestas = pDAO.verPendientes();

		for (Propuesta p : propuestas) {

			// poner todos los atributos para que los traiga ordenados por la tabla con la
			// consulta flitrada para encontrar los pendientes

			Object[] fila = new Object[] { p.getTitulo() };
			dataModel.addRow(fila);

		}
	}

	private void cargarTablaAceptadas(DefaultTableModel dataModel) {
		dataModel.setRowCount(0);
		PropuestaDAO pDAO = new PropuestaDAO();
		propuestas = pDAO.verAprobadas();

		for (Propuesta p : propuestas) {

			// poner todos los atributos para que los traiga ordenados por la tabla con la
			// consulta flitrada para encontrar los pendientes

			Object[] fila = new Object[] { p.getTitulo() };
			dataModel.addRow(fila);

		}
	}

	private void cargarTablaRechazadas(DefaultTableModel dataModel) {
		dataModel.setRowCount(0);
		PropuestaDAO pDAO = new PropuestaDAO();
		propuestas = pDAO.verRechazadas();

		for (Propuesta p : propuestas) {

			// poner todos los atributos para que los traiga ordenados por la tabla con la
			// consulta flitrada para encontrar los pendientes

			Object[] fila = new Object[] { p.getTitulo() };
			dataModel.addRow(fila);

		}
	}

	private Propuesta propuestaSeleccionada() {
		int filaSeleccionada = table.getSelectedRow();
		return propuestas.get(filaSeleccionada);
	}
}
