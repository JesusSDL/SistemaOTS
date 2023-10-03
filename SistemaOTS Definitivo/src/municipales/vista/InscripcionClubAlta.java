package municipales.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import municipales.dao.*;
import municipales.modelo.*;

public class InscripcionClubAlta extends JPanel {
	JTable table = new JTable();
	private ArrayList<Club> losClubes;
	
	public InscripcionClubAlta() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("~Inscripciones a clubes~");
		lblNewLabel.setBackground(new Color(0, 191, 255));
		lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblNewLabel.setBounds(327, 30, 298, 46);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("\r\n");
		scrollPane.setBounds(37, 134, 326, 249);
		add(scrollPane);
		
		table = new JTable();
		DefaultTableModel dataModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Clubes disponibles:" });
		table.setModel(dataModel);
		scrollPane.setViewportView(table);
		
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
				/*ClubDAO cbDAO = new ClubDAO();
				ArrayList<Club> detallesClub = cbDAO.verDetalleClub(clubSeleccionado().getNombre());
				 Club cb = clubSeleccionado(); */
				 Club cb = clubSeleccionado(); 
				 JFrame marco = (JFrame)SwingUtilities.getWindowAncestor((JComponent) e.getSource());
						  marco.setContentPane(new ClubVerDetalle(cb)); 
						  marco.validate();
				 

			}
		});
		btnVerDetalle.setBounds(420, 153, 103, 23);
		add(btnVerDetalle);
		
		cargarTablaTodos(dataModel);
	}

	private void cargarTablaTodos(DefaultTableModel dataModel) {
		dataModel.setRowCount(0);
		ClubDAO cbDAO = new ClubDAO();
		losClubes = cbDAO.verSauron();

		for (Club cb : losClubes) {

			Object[] fila = new Object[] {cb.getNombre()};
			dataModel.addRow(fila);

		}
	}

	private Club clubSeleccionado() {
		int filaSeleccionada = table.getSelectedRow();
		return losClubes.get(filaSeleccionada);
	}
}
