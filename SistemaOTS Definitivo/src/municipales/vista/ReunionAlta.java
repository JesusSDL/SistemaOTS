package municipales.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import municipales.dao.*;
import municipales.modelo.Propuesta;
import municipales.modelo.Reunion;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ReunionAlta extends JPanel {
	LocalDate fecha = LocalDate.now();
	private Reunion reunion;
	private JTextField txtTema;
	private JTextField txtDetalle;
	private JTextField txtResumen;
	private JTextField txtId;
	public ReunionAlta() {

		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String tema =  txtTema.getText();
				String detalle = txtDetalle.getText();
				String resumen = txtResumen.getText();

				ReunionDAO rDAO = new ReunionDAO();
				if (esEdicion()) {
					// modifica
					int numeroReunion = Integer.parseInt(txtId.getText());
					Reunion reu = new Reunion(tema, detalle, resumen, fecha);
					rDAO.modificacion(reu, numeroReunion);
				} else {
					// Es un alta.
					Reunion reu = new Reunion(tema, detalle, resumen, fecha);

					rDAO.alta(reu);
				}
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new CargaExitosa());
				marco.validate();

			}
		});
		setLayout(null);
		btnCargar.setBounds(142, 238, 114, 23);
		add(btnCargar);

		JButton btnVolver = new JButton("<--");
		btnVolver.setBackground(new Color(204, 255, 255));
		btnVolver.setForeground(new Color(0, 0, 0));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new ReunionVer());
				marco.validate();
			}
		});
		btnVolver.setFont(new Font("Sylfaen", Font.BOLD, 16));
		btnVolver.setBounds(47, 8, 97, 31);
		add(btnVolver);
		
		txtTema = new JTextField();
		txtTema.setBounds(228, 89, 86, 20);
		add(txtTema);
		txtTema.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tema tratado:");
		lblNewLabel.setBounds(56, 92, 151, 14);
		add(lblNewLabel);
		
		JLabel lblDetalles = new JLabel("Detalles:");
		lblDetalles.setBounds(56, 139, 151, 14);
		add(lblDetalles);
		
		txtDetalle = new JTextField();
		txtDetalle.setColumns(10);
		txtDetalle.setBounds(228, 136, 86, 20);
		add(txtDetalle);
		
		JLabel resumen = new JLabel("Resumen:");
		resumen.setBounds(56, 180, 151, 14);
		add(resumen);
		
		txtResumen = new JTextField();
		txtResumen.setColumns(10);
		txtResumen.setBounds(228, 177, 86, 20);
		add(txtResumen);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setVisible(false);
		txtId.setBounds(43, 361, 86, 20);
		add(txtId);
		txtId.setColumns(10);
	}

	public ReunionAlta(Reunion r) {
		// se auto ejecuta sin nada para que se arme la pantalla sin datos
		this();
		// los datos del objeto propuesta los coloca en la casilla correspondiente.

		txtTema.setText(r.getTemaTratado());
		txtDetalle.setText(r.getDetalleAsamblea());
		txtResumen.setText(r.getResumenAsamblea());
		LocalDate fecha = LocalDate.now();

		txtId.setText("" + r.getId());

		this.reunion = r;

	}

	public boolean esEdicion() {
		return this.reunion != null;

	}
}
