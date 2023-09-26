package municipales.vista;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

public class Principal extends JPanel {

	public Principal() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JButton btnPropuesta = new JButton("Propuesta");
		btnPropuesta.setBackground(new Color(102, 153, 204));
		btnPropuesta.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPropuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new PropuestaPrincipal());
				marco.validate();
			}
		});
		btnPropuesta.setBounds(184, 123, 164, 23);
		add(btnPropuesta);
		
		JButton btnMaterial = new JButton("Material");
		btnMaterial.setBackground(new Color(102, 153, 204));
		btnMaterial.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new material());
				marco.validate();
			}
		});
		btnMaterial.setBounds(184, 178, 164, 23);
		add(btnMaterial);
		
		JButton btnJornada = new JButton("Jornada");
		btnJornada.setBackground(new Color(102, 153, 204));
		btnJornada.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnJornada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJornada.setBounds(184, 225, 164, 23);
		add(btnJornada);
		
		JLabel lblNewLabel = new JLabel("~DEMOCESI~");
		lblNewLabel.setBackground(new Color(0, 191, 255));
		lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblNewLabel.setBounds(184, 27, 164, 40);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Elija lo que quiere ver:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setBounds(57, 84, 154, 14);
		add(lblNewLabel_1);

	}
}
