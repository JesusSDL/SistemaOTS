package municipales.vista;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PropuestaAltaExitosa extends JPanel {
	public PropuestaAltaExitosa() {
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

		JLabel lblNewLabel = new JLabel("¡Los datos se guardaron con éxito!\r\n");
		lblNewLabel.setBounds(10, 42, 440, 34);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Estado: Pendiente de Aprobación.");
		lblNewLabel_1.setBounds(10, 84, 196, 14);
		add(lblNewLabel_1);
	}
}
