package municipales.vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import municipales.dao.MaterialesDAOC;
import municipales.dao.PropuestaDAO;
import municipales.modelo.Material;
import municipales.modelo.MaterialInstitucional;
import municipales.modelo.MaterialdePropuestas;
import municipales.modelo.Propuesta;

public class VerMateriales extends JPanel {
	JTable table = new JTable();
	private MaterialInstitucional matInstitucional;
	private ArrayList<MaterialInstitucional> matsInstitucionales;

	public VerMateriales() {
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("\r\n");
		scrollPane.setBounds(37, 134, 326, 249);
		add(scrollPane);
		// La tabla con los nombres de los atributos de propuesta
		table = new JTable();
		DefaultTableModel dataModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Títulos de los materiales Institucionales" });
		cargarTablaMatsInstitucionales(dataModel);
		table.setModel(dataModel);
		scrollPane.setViewportView(table);

		JButton btnVolver = new JButton("<--");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new material());
				marco.validate();
			}
		});
		btnVolver.setBounds(21, 27, 89, 23);
		add(btnVolver);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				MaterialInstitucional m = matSeleccionado();
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) a.getSource());
				marco.setContentPane(new MaterialInstitucionalAlta(m));
				marco.validate();

			}
		});
		btnModificar.setBounds(420, 214, 107, 23);
		add(btnModificar);
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				MaterialInstitucional matInsti = matSeleccionado();
				MaterialesDAOC mDAOC = new MaterialesDAOC();
				mDAOC.baja(matInsti.getTitulo());
				cargarTablaMatsInstitucionales(dataModel);

			}
		});
		btnEliminar.setBounds(420, 281, 107, 23);
		add(btnEliminar);

		JButton btnVerDetalle = new JButton("Ver Detalle");
		btnVerDetalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaterialInstitucional m = matSeleccionado();
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new MaterialInstiVerDetalle(m));
				marco.validate();

			}
		});
		btnVerDetalle.setBounds(420, 153, 107, 23);
		add(btnVerDetalle);

		cargarTablaMatsInstitucionales(dataModel);

	}

	// hecho
	private void cargarTablaMatsInstitucionales(DefaultTableModel dataModel) {
		dataModel.setRowCount(0);
		MaterialesDAOC mDAOC = new MaterialesDAOC();
		matsInstitucionales = mDAOC.verMatsInstitucionales();
		for (MaterialInstitucional mat : matsInstitucionales) {

			// poner todos los atributos para que los traiga ordenados por la tabla con la
			// consulta flitrada para encontrar los pendientes

			Object[] fila = new Object[] { mat.getTitulo() };
			dataModel.addRow(fila);
		}
	}

	private MaterialInstitucional matSeleccionado() {
		int filaSeleccionada = table.getSelectedRow();
		return matsInstitucionales.get(filaSeleccionada);
	}
}
