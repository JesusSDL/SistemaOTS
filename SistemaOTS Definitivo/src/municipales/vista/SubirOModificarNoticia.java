package municipales.vista;
import javax.swing.JFrame;

import java.time.LocalDate;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import municipales.dao.*;
import municipales.modelo.*;



public class SubirOModificarNoticia extends JPanel{
	private JTextField cuadroTitulo;
	private JTextField cuadroContenido;
	private Noticia noticia;
	LocalDate fecha = LocalDate.now();
	
	/**
	 * @wbp.parser.constructor
	 */
	
	public SubirOModificarNoticia(JFrame marco) {
		setBackground(new Color(155, 238, 192));
		setLayout(null);
		
		cuadroTitulo = new JTextField();
		cuadroTitulo.setBounds(259, 86, 341, 20);
		add(cuadroTitulo);
		cuadroTitulo.setColumns(10);
		
		cuadroContenido = new JTextField();
		cuadroContenido.setBounds(259, 117, 341, 194);
		add(cuadroContenido);
		cuadroContenido.setColumns(10);
		
		JLabel textoTitulo = new JLabel("Titulo de la Noticia:");
		textoTitulo.setBounds(161, 89, 100, 14);
		add(textoTitulo);
		
		JLabel lblNewJgoodiesTitle = new JLabel("Contenido:");
		lblNewJgoodiesTitle.setBounds(161, 117, 88, 14);
		add(lblNewJgoodiesTitle);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marco.setContentPane(new MenuNoticiasPanel(marco));
				marco.validate();
			}
		});
		botonVolver.setBounds(161, 354, 89, 23);
		add(botonVolver);
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NoticiaDAO notDao = new NoticiaDAO();
				

				if (esEdicion()) {
						Noticia not = new Noticia(cuadroTitulo.getText(), cuadroContenido.getText(),fecha);

						notDao.modificar(noticia.getTituloNoticia(), not);
				} else {
						Noticia nt = new Noticia(cuadroContenido.getText(),cuadroContenido.getText(),fecha);
						notDao.agregar(nt);

						marco.setContentPane(new MenuNoticiasPanel(marco));
						marco.validate();
					}
				marco.setContentPane(new MenuNoticiasPanel(marco));
				marco.validate();
			}
		});
		botonGuardar.setBounds(511, 354, 89, 23);
		add(botonGuardar);
		
		
	}
	public SubirOModificarNoticia(JFrame marco, Noticia n) {

		this(marco);
		cuadroTitulo.setText(n.getTituloNoticia());
		cuadroContenido.setText(n.getContenidoNoticia());
		this.noticia = n;
		cuadroTitulo.setVisible(true);
		cuadroContenido.setVisible(true);
	}

	public boolean esEdicion() {
		return this.noticia != null;
	}
}
