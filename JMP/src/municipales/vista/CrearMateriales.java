package municipales.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import municipales.dao.CategoriaDAO;
import municipales.dao.MaterialesDAOC;
import municipales.dao.PropuestaDAO;
import municipales.modelo.Categoria;
import municipales.modelo.Material;
import municipales.modelo.MaterialInstitucional;
import municipales.modelo.MaterialdePropuestas;
import municipales.modelo.Propuesta;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class CrearMateriales extends JPanel {
	private JTextField txtTitulo;
	private JTextField txtDescripcion;
	private JTextField txtFuente;
	private JTextField txtEnlace;
	private JTextField txtProcedencia;
	JComboBox txtEsPrioritario = new JComboBox();
	JComboBox txtCat = new JComboBox();
	private ArrayList<Categoria> categorias;
	private ArrayList<Propuesta> propuestas;
	
	JList JListPropuestasAsoc = new JList();
	DefaultListModel<String> propuestasAsocDefaultList = new DefaultListModel<String>();
	
	
	private MaterialInstitucional matInsti;
	private MaterialdePropuestas matPropuestas;

	/**
	 * Create the panel.
	 */
	public CrearMateriales() {
		setLayout(null);

		JButton btnConfirmar = new JButton("Confirmar");
		JScrollPane scrollPane = new JScrollPane();

		JLabel lblNewLabel_6 = new JLabel("Asocie las propuestas");
		JLabel lblNewLabel = new JLabel("Título:");
		lblNewLabel.setBounds(26, 47, 46, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Categoría:");
		lblNewLabel_1.setBounds(26, 84, 70, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Descripcion:");
		lblNewLabel_2.setBounds(26, 116, 70, 14);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Fuente:");
		lblNewLabel_3.setBounds(26, 155, 46, 14);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Enlace:");
		lblNewLabel_4.setBounds(26, 200, 46, 14);
		add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Es Prioritario?");
		lblNewLabel_5.setBounds(26, 239, 97, 14);
		add(lblNewLabel_5);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(106, 44, 86, 20);
		add(txtTitulo);
		txtTitulo.setColumns(10);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(106, 113, 86, 20);
		add(txtDescripcion);
		txtDescripcion.setColumns(10);

		txtFuente = new JTextField();
		txtFuente.setBounds(106, 152, 86, 20);
		add(txtFuente);
		txtFuente.setColumns(10);

		txtEnlace = new JTextField();
		txtEnlace.setBounds(106, 197, 86, 20);
		add(txtEnlace);
		txtEnlace.setColumns(10);

		txtProcedencia = new JTextField();
		txtProcedencia.setBounds(106, 264, 86, 20);
		add(txtProcedencia);
		txtProcedencia.setColumns(10);

		CategoriaDAO cDAO = new CategoriaDAO();
		categorias = cDAO.verCats();

		txtCat.setBounds(106, 80, 86, 22);

		for (Categoria categoria : categorias) {
			String nomCat = categoria.getNomCategoria();
			txtCat.addItem(nomCat);
		}

		add(txtCat);

		JButton btnVolver = new JButton("<--");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new material());
				marco.validate();
			}
		});
		btnVolver.setBounds(10, 11, 89, 23);
		add(btnVolver);

		JButton btnGuardar1 = new JButton("Guardar");
		btnGuardar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (esMatInsti() == 0) {
					txtProcedencia.setEditable(false);
					scrollPane.setVisible(true);
					btnGuardar1.setVisible(false);
					btnConfirmar.setVisible(true);
					btnVolver.setVisible(false);
					txtEsPrioritario.setEnabled(false);
					JListPropuestasAsoc.setVisible(true);
					String titulo = txtTitulo.getText();
					String cat = txtCat.getSelectedItem().toString();
					String descripcion = txtDescripcion.getText();
					String fuente = txtFuente.getText();
					String enlaceDoc = txtEnlace.getText();
					String esPrioritario = txtEsPrioritario.getSelectedItem().toString();
					//ArrayList<Propuesta> propuestasAsoc = JListPropuestasAsoc.getselec;

				} else if (esMatInsti() != 0) {
					String titulo = txtTitulo.getText();
					String cat = txtCat.getSelectedItem().toString();
					String descripcion = txtDescripcion.getText();
					String fuente = txtFuente.getText();
					String enlaceDoc = txtEnlace.getText();
					String esPrioritario = txtEsPrioritario.getSelectedItem().toString();
					String procedencia = txtProcedencia.getText();

					MaterialInstitucional matInsti = new MaterialInstitucional(titulo, cat, descripcion, fuente,
							enlaceDoc, esPrioritario, procedencia);
					MaterialesDAOC mDAOC = new MaterialesDAOC();
					mDAOC.altaMatInstitucional(matInsti);
					JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
					marco.setContentPane(new material());
					marco.validate();

				}

			}
		});
		btnGuardar1.setBounds(319, 253, 89, 23);
		add(btnGuardar1);

		scrollPane.setVisible(false);
		scrollPane.setBounds(297, 94, 131, 135);
		add(scrollPane);

		PropuestaDAO pDAO = new PropuestaDAO();
		propuestas = pDAO.verMatsConPropuesta();

		JListPropuestasAsoc.setVisible(false);
		scrollPane.setViewportView(JListPropuestasAsoc);

		for (Propuesta propuestas : propuestas) {

			String tituloPropuestaAsoc = propuestas.getTitulo();
			propuestasAsocDefaultList.addElement(tituloPropuestaAsoc);

		}
		JListPropuestasAsoc.setModel(propuestasAsocDefaultList);

		lblNewLabel_6.setVisible(false);
		lblNewLabel_6.setBounds(299, 48, 129, 20);
		add(lblNewLabel_6);

		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirmar.setVisible(false);
		btnConfirmar.setBounds(319, 253, 89, 23);
		add(btnConfirmar);

		JLabel lblNewLabel_5_1 = new JLabel("Procedencia:");
		lblNewLabel_5_1.setBounds(26, 266, 97, 10);
		add(lblNewLabel_5_1);

		JLabel lblNewLabel_7 = new JLabel("Material");
		lblNewLabel_7.setBounds(574, 15, 46, 14);
		add(lblNewLabel_7);

		txtEsPrioritario.setModel(new DefaultComboBoxModel(new String[] { "No", "Si" }));
		txtEsPrioritario.setBounds(106, 235, 86, 22);
		add(txtEsPrioritario);

	}

	public int esMatInsti() {
		return txtProcedencia.getSelectionStart();
	}

	public CrearMateriales(Material mat) {
		this();

		txtTitulo.setText(mat.getTitulo());
		txtCat.setSelectedItem(mat.getCategoria());
		txtDescripcion.setText(mat.getDescripcion());
		txtFuente.setText(mat.getFuente());
		txtEnlace.setText(mat.getEnlaceAlDoc());
		txtEsPrioritario.setSelectedItem(mat.getEsPrioritario());
	//	txtProcedencia.setText(mat.getProcedencia());

	}

	

	

}
