package municipales.vista;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class MenuEvento extends JPanel{
	public MenuEvento(JFrame marco) {
		setBackground(new Color(198, 219, 168));
		setLayout(null);
		
		JButton botonCrearEvento = new JButton("Añadir evento");
		botonCrearEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new SubirOModificarEvento(marco));
				marco.validate();
			}
		});
		botonCrearEvento.setBounds(306, 142, 117, 23);
		add(botonCrearEvento);
		
		JButton botonConsultarEvento = new JButton("Consultar evento");
		botonConsultarEvento.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				marco.setContentPane(new ConsultarEvento(marco));
				marco.validate();
				
			}
		});
		botonConsultarEvento.setBounds(298, 176, 136, 23);
		add(botonConsultarEvento);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new Principal());
				marco.validate();
				
			}
		});
		botonVolver.setBounds(24, 339, 89, 23);
		add(botonVolver);
	}

}
