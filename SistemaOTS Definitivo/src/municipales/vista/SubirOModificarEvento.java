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
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import municipales.dao.*;
import municipales.modelo.*;

public class SubirOModificarEvento extends JPanel {
	private JTextField cuadroNombreEvento;
	private JTextField cuadroHoraInicio;
	private JTextField cuadroHoraFin;
	private JTextField cuadroFecha;
	private JTextField cuadroMotivoEvento;
	private Evento evento;

	/**
	 * @wbp.parser.constructor
	 */

	public SubirOModificarEvento(JFrame marco) {
		setBackground(new Color(198, 219, 168));
		setLayout(null);

		cuadroNombreEvento = new JTextField();
		cuadroNombreEvento.setBounds(229, 98, 286, 20);
		add(cuadroNombreEvento);
		cuadroNombreEvento.setColumns(10);

		JLabel lblNewJgoodiesTitle = new JLabel("Nombre del evento:");
		lblNewJgoodiesTitle.setBounds(123, 101, 96, 14);
		add(lblNewJgoodiesTitle);

		cuadroHoraInicio = new JTextField();
		cuadroHoraInicio.setBounds(229, 166, 46, 20);
		add(cuadroHoraInicio);
		cuadroHoraInicio.setColumns(10);

		JLabel lblNewJgoodiesTitle_1 = new JLabel ("Horario:");
		lblNewJgoodiesTitle_1.setBounds(123, 169, 88, 14);
		add(lblNewJgoodiesTitle_1);

		cuadroHoraFin = new JTextField();
		cuadroHoraFin.setBounds(336, 166, 46, 20);
		add(cuadroHoraFin);
		cuadroHoraFin.setColumns(10);

		JLabel lblNewJgoodiesTitle_2 = new JLabel("a");
		lblNewJgoodiesTitle_2.setBounds(306, 169, 20, 14);
		add(lblNewJgoodiesTitle_2);

		JLabel lblNewJgoodiesTitle_3 = new JLabel("hs");
		lblNewJgoodiesTitle_3.setBounds(276, 169, 20, 14);
		add(lblNewJgoodiesTitle_3);

		JLabel lblNewJgoodiesTitle_4 = new JLabel("hs");
		lblNewJgoodiesTitle_4.setBounds(387, 169, 20, 14);
		add(lblNewJgoodiesTitle_4);

		cuadroFecha = new JTextField();
		cuadroFecha.setBounds(229, 129, 165, 20);
		add(cuadroFecha);
		cuadroFecha.setColumns(10);

		JLabel lblNewJgoodiesTitle_5 = new JLabel("Fecha:");
		lblNewJgoodiesTitle_5.setBounds(123, 132, 88, 14);
		add(lblNewJgoodiesTitle_5);

		cuadroMotivoEvento = new JTextField();
		cuadroMotivoEvento.setBounds(229, 207, 286, 77);
		add(cuadroMotivoEvento);
		cuadroMotivoEvento.setColumns(10);

		JLabel lblNewJgoodiesTitle_6 = new JLabel("Motivo de evento:");
		lblNewJgoodiesTitle_6.setBounds(123, 207, 88, 14);
		add(lblNewJgoodiesTitle_6);

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marco.setContentPane(new MenuEvento(marco));
				marco.validate();
			}
		});
		botonCancelar.setBounds(123, 331, 89, 23);
		add(botonCancelar);

		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fechaTexto = cuadroFecha.getText();
				SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

				EventoDAO evDao = new EventoDAO();

				if (esEdicion()) {
					try {
						java.util.Date fechaUtil = formatoFecha.parse(fechaTexto);
						java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());

						Evento eve = new Evento(cuadroNombreEvento.getText(), fechaSQL,
								Integer.parseInt(cuadroHoraInicio.getText()), Integer.parseInt(cuadroHoraFin.getText()),
								cuadroMotivoEvento.getText());

						evDao.Modificar(evento.getNombreEvento(), eve);
					} catch (ParseException ex) {
						ex.printStackTrace();
					}

				} else {
					try {
						// Intenta parsear el texto a un objeto Date
						java.util.Date fechaUtil = formatoFecha.parse(fechaTexto);
						java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());

						Evento ev = new Evento(cuadroNombreEvento.getText(), fechaSQL,
								Integer.parseInt(cuadroHoraInicio.getText()), Integer.parseInt(cuadroHoraFin.getText()),
								cuadroMotivoEvento.getText());
						evDao.agregar(ev);

						marco.setContentPane(new MenuEvento(marco));
						marco.validate();
					} catch (ParseException ex) {
						ex.printStackTrace();
					}
				}

				marco.setContentPane(new MenuEvento(marco));
				marco.validate();

			}
		});
		botonGuardar.setBounds(426, 331, 89, 23);
		add(botonGuardar);
	}

	public SubirOModificarEvento(JFrame marco, Evento e) {

		this(marco);
		cuadroNombreEvento.setText(e.getNombreEvento());
		cuadroFecha.setText(e.getFechaEvento().toString());
		cuadroHoraInicio.setText(String.valueOf(e.getHoraInicio()));
		cuadroHoraFin.setText(String.valueOf(e.getHoraFin()));
		cuadroMotivoEvento.setText(e.getMotivoEvento());
		this.evento = e;
		cuadroNombreEvento.setVisible(true);
		cuadroFecha.setVisible(true);
		cuadroHoraInicio.setVisible(true);
		cuadroHoraFin.setVisible(true);
		cuadroMotivoEvento.setVisible(true);
	}

	public boolean esEdicion() {
		return this.evento != null;
	}

}
