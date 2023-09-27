package municipales.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import municipales.dao.*;
import municipales.modelo.Reunion;

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

public class ReunionVer extends JPanel {
	JTable table = new JTable();
	private ArrayList<Reunion> lasReuniones;

	public ReunionVer() {
		setLayout(null);
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("\r\n");
		scrollPane.setBounds(37, 134, 326, 249);
		add(scrollPane);
		
		table = new JTable();
		DefaultTableModel dataModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Tema tratado de la reunión" });
		table.setModel(dataModel);
		scrollPane.setViewportView(table);

	
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				Reunion r = reunionSeleccionada();
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) a.getSource());
				marco.setContentPane(new ReunionAlta(r));
				marco.validate();

			}
		});
		btnModificar.setBounds(420, 214, 103, 23);
		add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {

				Reunion r = reunionSeleccionada();
				ReunionDAO rDAO = new ReunionDAO();
				rDAO.baja(r);
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
				marco.setContentPane(new Principal());
				marco.validate();
			}
		});
		btnVolver.setBounds(21, 27, 89, 23);
		add(btnVolver);

		JButton btnVerDetalle = new JButton("Ver Detalle");
		btnVerDetalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Reunion r = reunionSeleccionada(); JFrame marco = (JFrame)
				  SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				  marco.setContentPane(new ReunionVerDetalle(r)); marco.validate();
				 

			}
		});
		btnVerDetalle.setBounds(420, 153, 103, 23);
		add(btnVerDetalle);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new ReunionAlta());
				marco.validate();
				
			}
		});
		btnAgregar.setBounds(420, 338, 103, 23);
		add(btnAgregar);

		cargarTablaTodos(dataModel);

	}

	// llama a sauron
	private void cargarTablaTodos(DefaultTableModel dataModel) {
		dataModel.setRowCount(0);
		ReunionDAO rDAO = new ReunionDAO();
		lasReuniones = rDAO.verSauron();

		for (Reunion r : lasReuniones) {

			Object[] fila = new Object[] { r.getTemaTratado() };
			dataModel.addRow(fila);

		}
	}

	private Reunion reunionSeleccionada() {
		int filaSeleccionada = table.getSelectedRow();
		return lasReuniones.get(filaSeleccionada);
	}
}
