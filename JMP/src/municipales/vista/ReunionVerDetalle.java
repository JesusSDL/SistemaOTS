package municipales.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import municipales.modelo.Reunion;
import javax.swing.JLabel;

public class ReunionVerDetalle extends JPanel {

	private JTextField txtTema;
	private JTextField txtDetalle;
	private JTextField txtResumen;
	private JTextField txtFecha;
	private JTextField txtId;
	private Reunion reunion;
	public ReunionVerDetalle() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tema tratado:");
		lblNewLabel.setBounds(63, 85, 169, 27);
		add(lblNewLabel);
		
		txtTema = new JTextField();
		txtTema.setEditable(false);
		txtTema.setBounds(242, 78, 238, 40);
		add(txtTema);
		txtTema.setColumns(10);
		
		JLabel lblDetalle = new JLabel("Detalle:");
		lblDetalle.setBounds(62, 136, 169, 27);
		add(lblDetalle);
		
		txtDetalle = new JTextField();
		txtDetalle.setEditable(false);
		txtDetalle.setColumns(10);
		txtDetalle.setBounds(242, 129, 238, 40);
		add(txtDetalle);
		
		JLabel lblResumen = new JLabel("resumen");
		lblResumen.setBounds(62, 196, 169, 27);
		add(lblResumen);
		
		JLabel lblltimaModificacin = new JLabel("Última modificación:");
		lblltimaModificacin.setBounds(62, 253, 169, 27);
		add(lblltimaModificacin);
		
		txtResumen = new JTextField();
		txtResumen.setEditable(false);
		txtResumen.setColumns(10);
		txtResumen.setBounds(242, 189, 238, 40);
		add(txtResumen);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(242, 246, 238, 40);
		add(txtFecha);
		
		
		JButton btnVolver = new JButton("<--");
		btnVolver.setBackground(new Color(204, 255, 255));
		btnVolver.setForeground(new Color(0, 0, 0));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new Principal());
				marco.validate();
			}
		});
		btnVolver.setFont(new Font("Sylfaen", Font.BOLD, 16));
		btnVolver.setBounds(47, 8, 97, 31);
		add(btnVolver);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setVisible(false);
		txtId.setBounds(520, 21, 22, 20);
		add(txtId);
		
	}

	public ReunionVerDetalle(Reunion r) {
		this();
		txtTema.setText(r.getTemaTratado());
		txtDetalle.setText(r.getDetalleAsamblea());
		txtResumen.setText(r.getResumenAsamblea());
		txtFecha.setText("" + r.getFechaAsamblea());

		txtId.setText("" + r.getId());

		this.reunion = r;
		
		
	}

}
