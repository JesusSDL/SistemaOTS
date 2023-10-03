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

public class MenuNoticiasPanel extends JPanel{
	public MenuNoticiasPanel(JFrame marco) {
		setBackground(new Color(155, 238, 192));
		setLayout(null);
		
		JButton botonAgregar = new JButton("Agregar noticia");
		botonAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marco.setContentPane(new SubirOModificarNoticia(marco));
				marco.validate();
			}
		});
		botonAgregar.setBounds(290, 142, 121, 23);
		add(botonAgregar);
		
		JButton botonConsultar = new JButton("Consultar noticias");
		botonConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marco.setContentPane(new ConsultarNoticia(marco));
				marco.validate();
			}
		});
		botonConsultar.setBounds(290, 176, 121, 23);
		add(botonConsultar);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new Principal());
				marco.validate();
			}
		});
		botonVolver.setBounds(60, 343, 89, 23);
		add(botonVolver);
	}

}
