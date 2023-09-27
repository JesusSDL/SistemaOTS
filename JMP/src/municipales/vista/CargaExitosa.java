package municipales.vista;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;


public class CargaExitosa extends JPanel {

	
	public CargaExitosa() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Los datos se cargaron con éxito.");
		lblNewLabel.setBounds(61, 60, 238, 58);
		add(lblNewLabel);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new Principal());
				marco.validate();
			}
		});
		btnVolver.setBounds(138, 157, 171, 23);
		add(btnVolver);

	}

}
