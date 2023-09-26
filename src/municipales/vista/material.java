package municipales.vista;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class material extends JPanel {

	
	public material() {
		setLayout(null);

		JButton btnNewButton = new JButton("<--");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new Principal());
				marco.validate();
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Materiales ");
		lblNewLabel.setBounds(184, 45, 82, 14);
		add(lblNewLabel);

		JButton btnNewButton_1 = new JButton("Crear Material");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new MaterialElegir());
				marco.validate();
			}
		});
		btnNewButton_1.setBounds(166, 70, 123, 23);
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Ver Materiales ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new VerMaterialesGeneral());
				marco.validate();
			}
		});
		btnNewButton_2.setBounds(166, 119, 123, 23);
		add(btnNewButton_2);

	}
}
