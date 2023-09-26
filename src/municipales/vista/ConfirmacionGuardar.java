package municipales.vista;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfirmacionGuardar extends JPanel {

	/**
	 * Create the panel.
	 */
	public ConfirmacionGuardar() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("No se guardaran los datos.");
		lblNewLabel.setBounds(132, 53, 203, 31);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Desea continuar: ");
		lblNewLabel_1.setBounds(67, 95, 136, 14);
		add(lblNewLabel_1);
		
		JButton btnSI = new JButton("SI ");
		btnSI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new PropuestaPrincipal());
				marco.validate();
			}
		});
		btnSI.setBounds(124, 185, 89, 23);
		add(btnSI);
		
		JButton btnNO = new JButton("NO");
		btnNO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new PropuestaAlta());
				marco.validate();
			}
		});
		btnNO.setBounds(300, 185, 89, 23);
		add(btnNO);

	}
}
