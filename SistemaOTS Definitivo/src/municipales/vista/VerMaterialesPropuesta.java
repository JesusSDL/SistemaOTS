package municipales.vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import municipales.dao.MaterialesDAOC;
import municipales.dao.PropuestaDAO;
import municipales.modelo.Material;
import municipales.modelo.MaterialdePropuestas;
import municipales.modelo.Propuesta;

public class VerMaterialesPropuesta extends JPanel {
	JTable table = new JTable();
	private MaterialdePropuestas matPropuesta;
	private ArrayList<MaterialdePropuestas> matsDePropuestas;

	public VerMaterialesPropuesta() {
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("\r\n");
		scrollPane.setBounds(37, 134, 326, 249);
		add(scrollPane);
		// La tabla con los nombres de los atributos de propuesta
		table = new JTable();
		DefaultTableModel dataModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Títulos de los materiales de Propuestas" });
		table.setModel(dataModel);
		scrollPane.setViewportView(table);

		JButton btnVolver = new JButton("<--");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new VerMaterialesGeneral());
				marco.validate();
			}
		});
		btnVolver.setBounds(21, 27, 89, 23);
		add(btnVolver);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				MaterialdePropuestas m = matSeleccionado();
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) a.getSource());
				marco.setContentPane(new CrearMateriales(m));
				marco.validate();

			}
		});
		btnModificar.setBounds(420, 214, 107, 23);
		add(btnModificar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {

				MaterialdePropuestas matPropuesta = matSeleccionado();
				MaterialesDAOC mDAOC = new MaterialesDAOC();
				mDAOC.baja(matPropuesta.getTitulo());

			}
		});
		table.setModel(dataModel);
		btnEliminar.setBounds(420, 281, 107, 23);
		add(btnEliminar);

		JButton btnVerDetalle = new JButton("Ver Detalle");
		btnVerDetalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnVerDetalle.setBounds(420, 153, 107, 23);
		add(btnVerDetalle);

	}

	private MaterialdePropuestas matSeleccionado() {
		int filaSeleccionada = table.getSelectedRow();
		return matsDePropuestas.get(filaSeleccionada);
	}
}
