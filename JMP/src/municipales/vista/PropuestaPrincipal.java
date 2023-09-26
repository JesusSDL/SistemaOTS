package municipales.vista;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

public class PropuestaPrincipal extends JPanel {
	public PropuestaPrincipal() {
		setBackground(Color.WHITE);
		setLayout(null);

		JButton btnCrear = new JButton("Crear Propuesta");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new PropuestaAlta());
				marco.validate();
			}
		});
		btnCrear.setBounds(166, 91, 167, 23);
		add(btnCrear);

		JButton btnVer = new JButton("Ver propuestas");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new PropuestaVer());
				marco.validate();
			}
		});
		btnVer.setBounds(166, 150, 167, 23);
		add(btnVer);

		JButton btnVolver = new JButton("<--");
		btnVolver.setBackground(new Color(204, 255, 255));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new Principal());
				marco.validate();
			}
		});
		btnVolver.setFont(new Font("Sylfaen", Font.BOLD, 14));
		btnVolver.setBounds(10, 11, 89, 23);
		add(btnVolver);
		
		JLabel lblNewLabel = new JLabel("Propuestas ");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 17));
		lblNewLabel.setBounds(198, 47, 122, 23);
		add(lblNewLabel);

	}
}
