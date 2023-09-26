package municipales.vista;

import java.time.*;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import municipales.modelo.*;
import municipales.dao.*;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;

public class PropuestaAlta extends JPanel {
	private JTextField txtTitulo;
	private JTextField txtDescripcion;
	private JTextField txtAutor;
	LocalDate fecha = LocalDate.now();
	private Propuesta propuesta;
	private JComboBox txtOrigen = new JComboBox();
	private ArrayList<Categoria> categorias;
	private JComboBox txtCat = new JComboBox();
	private JTextField txtNumeroPropuesta;
	private JTextField txtTextoLusqtoff;

	public PropuestaAlta() {
		setLayout(null);
		setLayout(null);

		txtTextoLusqtoff = new JTextField();
		txtTextoLusqtoff.setColumns(10);
		txtTextoLusqtoff.setBounds(200, 210, 86, 20);
		add(txtTextoLusqtoff);

		txtOrigen.setModel(new DefaultComboBoxModel(new String[] { "Docente", "Estudiante" }));
		txtOrigen.setBounds(200, 62, 86, 17);
		add(txtOrigen);
		JLabel origenPropuesta = new JLabel("Origen:");
		origenPropuesta.setBounds(109, 63, 61, 14);
		add(origenPropuesta);

		JLabel lblNewLabel_1 = new JLabel("Título:");
		lblNewLabel_1.setBounds(109, 100, 61, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Categoría:");
		lblNewLabel_2.setBounds(109, 125, 74, 17);
		add(lblNewLabel_2);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(200, 92, 86, 20);
		add(txtTitulo);
		txtTitulo.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Autor:");
		lblNewLabel_2_1.setBounds(109, 185, 74, 14);
		add(lblNewLabel_2_1);

		JLabel lblNewLabel_3 = new JLabel("Descripción:");
		lblNewLabel_3.setBounds(109, 154, 74, 14);
		add(lblNewLabel_3);

		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(200, 151, 86, 20);
		add(txtDescripcion);

		txtAutor = new JTextField();
		txtAutor.setColumns(10);
		txtAutor.setBounds(200, 182, 86, 20);
		add(txtAutor);

		JLabel lblNewLabel = new JLabel("Propuesta");
		lblNewLabel.setBounds(394, 11, 86, 14);
		add(lblNewLabel);

		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String origen = (String) txtOrigen.getSelectedItem();
				String titulo = txtTitulo.getText();
				String cat = txtCat.getSelectedItem().toString();
				String descripcion = txtDescripcion.getText();
				String autor = txtAutor.getText();
				String textoLusqtoff = txtTextoLusqtoff.getText();

				PropuestaDAO pDAO = new PropuestaDAO();
				if (esEdicion()) {
					// modifica
					int numeroPropuesta = Integer.parseInt(txtNumeroPropuesta.getText());
					Propuesta propuesta = new Propuesta(origen, titulo, cat, descripcion, autor, fecha, textoLusqtoff);
					pDAO.modificacion(propuesta, numeroPropuesta);
				} else {
					// Es un alta.
					Propuesta propuesta = new Propuesta(origen, titulo, cat, descripcion, autor, fecha, textoLusqtoff);

					pDAO.alta(propuesta);
				}
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new PropuestaAltaExitosa());
				marco.validate();

			}
		});
		btnCargar.setBounds(351, 266, 89, 23);
		add(btnCargar);

		JButton btnVolver = new JButton("<--");
		btnVolver.setBackground(new Color(204, 255, 255));
		btnVolver.setForeground(new Color(0, 0, 0));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new ConfirmacionGuardar());
				marco.validate();
			}
		});
		btnVolver.setFont(new Font("Sylfaen", Font.BOLD, 16));
		btnVolver.setBounds(10, 11, 61, 23);
		add(btnVolver);

		txtNumeroPropuesta = new JTextField();
		txtNumeroPropuesta.setVisible(false);
		txtNumeroPropuesta.setBounds(30, 328, 86, 20);
		add(txtNumeroPropuesta);
		txtNumeroPropuesta.setColumns(10);

		// Logramos hacer el jcombobox con las categorías existentes pero x algún motivo
		// se pasa el id de eclipse (@1237745) etc
		CategoriaDAO cDAO = new CategoriaDAO();
		categorias = cDAO.verCats();

		for (Categoria categoria : categorias) {
			String nomCat = categoria.getNomCategoria();
			Categoria cat = new Categoria(nomCat);
			txtCat.addItem(nomCat);

		}

		txtCat.setBounds(200, 125, 86, 17);
		add(txtCat);

		JLabel lblNewLabel_2_1_1 = new JLabel("Texto Lüsqtoff");
		lblNewLabel_2_1_1.setBounds(109, 213, 74, 14);
		add(lblNewLabel_2_1_1);

	}

	private void add(LocalDate fecha2) {
		// TODO Auto-generated method stub

	}

	public PropuestaAlta(Propuesta p) {
		// se auto ejecuta sin nada para que se arme la pantalla sin datos
		this();
		// los datos del objeto propuesta los coloca en la casilla correspondiente.

		txtOrigen.setSelectedItem(p.getOrigen());
		txtTitulo.setText(p.getTitulo());
		CategoriaDAO cDao = new CategoriaDAO();
		int idCategoria = cDao.verCatsconF(p.getCat());
		txtCat.setSelectedItem(idCategoria);
		txtDescripcion.setText(p.getDescripcion());
		txtAutor.setText(p.getAutor());
		LocalDate fecha = LocalDate.now();
		txtTextoLusqtoff.setText(p.getTextoLusqtoff());
		txtNumeroPropuesta.setText("" + p.getId());

		this.propuesta = p;

	}

	public boolean esEdicion() {
		return this.propuesta != null;

	}
}
