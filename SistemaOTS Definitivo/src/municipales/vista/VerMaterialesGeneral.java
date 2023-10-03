package municipales.vista;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class VerMaterialesGeneral extends JPanel {

	public VerMaterialesGeneral() {
		setLayout(null);

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
		JButton btnVerMatsPropuestas = new JButton("Ver materiales de propuestas");
		btnVerMatsPropuestas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new VerMaterialesPropuesta());
				marco.validate();
			}
		});
		btnVerMatsPropuestas.setBounds(123, 89, 173, 23);
		add(btnVerMatsPropuestas);

		JButton btnVerMatsInstis = new JButton("Ver Materiales institucionales");
		btnVerMatsInstis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new VerMateriales());
				marco.validate();
			}
		});
		btnVerMatsInstis.setBounds(123, 123, 173, 23);
		add(btnVerMatsInstis);

	}
}
