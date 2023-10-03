package municipales.vista;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MaterialElegir extends JPanel {

	public MaterialElegir() {
		setLayout(null);

		JButton btnVolver = new JButton("<--");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new material());
				marco.validate();
			}
		});
		btnVolver.setBounds(10, 11, 89, 23);
		add(btnVolver);
		JButton btnMatInsti = new JButton("Material Institucional");
		btnMatInsti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new MaterialInstitucionalAlta());
				marco.validate();
			}
		});
		btnMatInsti.setBounds(154, 53, 155, 23);
		add(btnMatInsti);

		JButton btnMatPropuesta = new JButton("Material de propuesta");
		btnMatPropuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new MaterialPropuesta());
				marco.validate();
			}
		});
		btnMatPropuesta.setBounds(154, 116, 155, 23);
		add(btnMatPropuesta);

	}
}
