package municipales.vista;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PropuestaBajaExitosa extends JPanel {
	public PropuestaBajaExitosa() {
		setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new Principal());
				marco.validate();
			}
		});
		btnVolver.setBounds(351, 266, 89, 23);
		add(btnVolver);
		
		JLabel lblNewLabel = new JLabel("Eliminación de Registro Exitosa");
		lblNewLabel.setBounds(10, 73, 205, 30);
		add(lblNewLabel);
	}
}
