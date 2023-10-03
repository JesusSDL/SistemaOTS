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
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import municipales.dao.*;
import municipales.modelo.*;

public class ConsultarNoticia extends JPanel{
	DefaultTableModel data = new DefaultTableModel(new Object[][] {}, new String[] { "Titulo de noticia", "Contenido de noticia", "Fecha de publicación"});
	
	ArrayList<Noticia> Listado = new ArrayList<>();
	private JTable table;
	
	public ConsultarNoticia(JFrame marco) {
		setBackground(new Color(155, 238, 192));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 40, 557, 286);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(data);
		TraerListado(data);
		
		scrollPane.setViewportView(table);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new MenuNoticiasPanel(marco));
				marco.validate();
				
			}
		});
		botonVolver.setBounds(54, 337, 89, 23);
		add(botonVolver);
		
		JButton botonModificarOVer = new JButton("Ver o modificar");
		botonModificarOVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Noticia noticia = seleccionarNoticia();

				marco.setContentPane(new SubirOModificarNoticia(marco, noticia));
				marco.validate();

			}
		});
		botonModificarOVer.setBounds(486, 337, 125, 23);
		add(botonModificarOVer);
		
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 0 = si
				// 1 = no
				// 2 = cancelar
				int s = JOptionPane.showConfirmDialog(botonEliminar, "¿Está seguro de que desea eliminar?");
				if (s == 0) {
					EventoDAO ev = new EventoDAO();
					ev.Eliminar(seleccionarNoticia().getTituloNoticia());

				}
				TraerListado(data);

			}
		});
		botonEliminar.setBounds(277, 337, 89, 23);
		add(botonEliminar);
		
	}
	
	public void TraerListado(DefaultTableModel dataModel) {
		dataModel.setRowCount(0);
		
		NoticiaDAO noticias = new NoticiaDAO();

		Listado = noticias.traerTodas();

		for (Noticia n : Listado) {
			Object[] fila = new Object[] {n.getTituloNoticia(), n.getContenidoNoticia(), n.getFechaNoticia()};
			dataModel.addRow(fila);

		}

	}
	private Noticia seleccionarNoticia() {

		int filaSeleccionada = table.getSelectedRow();
		return Listado.get(filaSeleccionada);

	}
}
