package municipales.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;


import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import municipales.modelo.*;
import municipales.dao.*;
import javax.swing.JTextField;

public class ClubVerDetalle extends JPanel {

	private Club club;
//	JTable table = new JTable();
	private ArrayList<Club> losClubes;
	private JTextField txtActividad;
	private JTextField txtFechaNacimiento;
	private JTextField txtId;
	private JTextField txtDescripcionActividad;
	private JTextField txtNombre;

	public ClubVerDetalle() {
		setLayout(null);
		JLabel lblNewLabel = new JLabel("~Detalle del club~");
		lblNewLabel.setBackground(new Color(0, 191, 255));
		lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblNewLabel.setBounds(327, 30, 298, 46);
		add(lblNewLabel);
		
		txtDescripcionActividad = new JTextField();
		txtDescripcionActividad.setEditable(false);
		txtDescripcionActividad.setColumns(10);
		txtDescripcionActividad.setBounds(252, 228, 218, 66);
		add(txtDescripcionActividad);
		
		txtNombre = new JTextField();
		txtNombre.setVisible(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(241, 158, 142, 28);
		add(txtNombre);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ingrese Fecha de Nacimiento (AAAA-MM-DD)");
		lblNewLabel_2_1.setVisible(false);
		lblNewLabel_2_1.setBounds(21, 228, 260, 37);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ingrese Nombre apellido:");
		lblNewLabel_1_1.setVisible(false);
		lblNewLabel_1_1.setBounds(56, 173, 156, 14);
		add(lblNewLabel_1_1);

		/*
		 * JScrollPane scrollPane = new JScrollPane();
		 * scrollPane.setToolTipText("\r\n"); scrollPane.setBounds(37, 134, 326, 249);
		 * add(scrollPane);
		 * 
		 * table = new JTable(); DefaultTableModel dataModel = new DefaultTableModel(new
		 * Object[][] {}, new String[] { "Actividdades y descripción:" });
		 * table.setModel(dataModel); scrollPane.setViewportView(table);
		 */

		JButton btnVolver = new JButton("<--");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new InscripcionClubAlta());
				marco.validate();
			}
		});
		btnVolver.setBounds(21, 27, 89, 23);
		add(btnVolver);

		JLabel lblNewLabel_1 = new JLabel("Actividad:");
		lblNewLabel_1.setBounds(86, 148, 156, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Descripción de la actividad");
		lblNewLabel_2.setBounds(86, 251, 156, 14);
		add(lblNewLabel_2);

		txtActividad = new JTextField();
		txtActividad.setEditable(false);
		txtActividad.setBounds(252, 124, 218, 62);
		add(txtActividad);
		txtActividad.setColumns(10);

		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setVisible(false);
		txtFechaNacimiento.setBounds(291, 235, 156, 23);
		add(txtFechaNacimiento);
		txtFechaNacimiento.setColumns(10);

		JButton btnInscribirseConfirmar = new JButton("Inscribirse");
		btnInscribirseConfirmar.setForeground(Color.BLACK);
		btnInscribirseConfirmar.setVisible(false);
		btnInscribirseConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ICEDao estudianteDAO = new ICEDao();
				String nombreApellido = txtNombre.getText();
				String fechaNac = txtFechaNacimiento.getText();
				
			 ICE estudiante = new ICE(nombreApellido, fechaNac);
			 estudianteDAO.altaEstudiante(estudiante);
			/* no se llegó a hacer en la tabla relacional la relación
			 * ClubDAO cbDAO = new ClubDAO();
			 cbDAO.verIdClub();
			 estudianteDAO.altaEstudianteRelacional(, );*/
				
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new Principal());
				marco.validate();
			}
		});
		btnInscribirseConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInscribirseConfirmar.setBackground(new Color(0, 128, 0));
		btnInscribirseConfirmar.setBounds(86, 338, 164, 23);
		add(btnInscribirseConfirmar);

		JButton btnElegirClub = new JButton("Elegir Club");
		btnElegirClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnInscribirseConfirmar.setVisible(true);
				btnElegirClub.setVisible(false);
				txtActividad.setVisible(false);
				txtDescripcionActividad.setVisible(false);
				txtFechaNacimiento.setVisible(true);
				txtNombre.setVisible(true);
				lblNewLabel_2_1.setVisible(true);
				lblNewLabel_1_1.setVisible(true);
				lblNewLabel_1.setVisible(false);
				lblNewLabel_2.setVisible(false);
				

			}
		});
		btnElegirClub.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnElegirClub.setBackground(new Color(102, 153, 204));
		btnElegirClub.setBounds(306, 338, 164, 23);
		add(btnElegirClub);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setVisible(false);
		txtId.setBounds(326, 197, 86, 20);
		add(txtId);
		txtId.setColumns(10);


		// ClubVerDetalle(dataModel);
	}

	public ClubVerDetalle(Club cb) {
		this();

		txtActividad.setText(cb.getActividades());
		txtDescripcionActividad.setText(cb.getDescripcionActividades());
		txtId.setText("" + cb.getIdClub());
		this.club = cb;

	}

	/*
	 * public ClubVerDetalle(ArrayList<Club> actividadClubsito, DefaultTableModel
	 * dataModel2) { for (Club cb : actividadClubsito) { Object[] fila = new
	 * Object[] { cb.getActividades(), cb.getDescripcionActividades()};
	 * dataModel2.addRow(fila); }
	 * 
	 * }
	 * 
	 * Referencia para que no explotemos todo private void
	 * cargarTablaTodos(DefaultTableModel dataModel) { dataModel.setRowCount(0);
	 * ClubDAO cbDAO = new ClubDAO(); losClubes = cbDAO.verSauron();
	 * 
	 * for (Club cb : losClubes) {
	 * 
	 * Object[] fila = new Object[] { cb.getActividades(),
	 * cb.getDescripcionActividades()}; dataModel.addRow(fila);
	 * 
	 * } }
	 */

}
