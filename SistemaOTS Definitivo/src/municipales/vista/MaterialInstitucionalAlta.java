package municipales.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import municipales.dao.CategoriaDAO;
import municipales.dao.MaterialesDAOC;
import municipales.modelo.Categoria;
import municipales.modelo.MaterialInstitucional;
import municipales.modelo.Propuesta;

public class MaterialInstitucionalAlta extends JPanel {

	private JTextField txtTitulo;
	private JTextField txtDescripcion;
	private JTextField txtFuente;
	private JTextField txtEnlaceAlDoc;
	private MaterialInstitucional matInsti;
	private ArrayList<Categoria> categorias;
	JComboBox txtEsPrioritario = new JComboBox();
	JComboBox txtCat = new JComboBox();
	private JTextField txtNumeroMaterial;
	private JTextField txtProcedenciaV2;

	public MaterialInstitucionalAlta() {
		setLayout(null);

		txtProcedenciaV2 = new JTextField();
		txtProcedenciaV2.setBounds(124, 223, 86, 20);
		add(txtProcedenciaV2);
		txtProcedenciaV2.setColumns(10);
		JLabel lblNewLabel = new JLabel("Título:");
		lblNewLabel.setBounds(10, 38, 104, 17);
		add(lblNewLabel);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(124, 36, 86, 20);
		add(txtTitulo);
		txtTitulo.setColumns(10);

		JLabel lblCategora = new JLabel("Categoría:");
		lblCategora.setBounds(10, 68, 104, 17);
		add(lblCategora);

		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(124, 97, 86, 20);
		add(txtDescripcion);

		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setBounds(10, 99, 104, 17);
		add(lblDescripcin);

		txtFuente = new JTextField();
		txtFuente.setColumns(10);
		txtFuente.setBounds(124, 128, 86, 20);
		add(txtFuente);

		JLabel lblFuente = new JLabel("Fuente:");
		lblFuente.setBounds(10, 130, 104, 17);
		add(lblFuente);

		txtEnlaceAlDoc = new JTextField();
		txtEnlaceAlDoc.setColumns(10);
		txtEnlaceAlDoc.setBounds(124, 159, 86, 20);
		add(txtEnlaceAlDoc);

		JLabel lblEnlaceAlDocumento = new JLabel("Enlace al Documento:");
		lblEnlaceAlDocumento.setBounds(10, 161, 104, 17);
		add(lblEnlaceAlDocumento);

		JLabel lblPrioridad = new JLabel("Es prioritario?");
		lblPrioridad.setBounds(10, 192, 104, 17);
		add(lblPrioridad);
		txtEsPrioritario.setModel(new DefaultComboBoxModel(new String[] { "No", "Si" }));
		txtEsPrioritario.setBounds(124, 190, 86, 22);
		add(txtEsPrioritario);
		JLabel lblProcedencia = new JLabel("Procedencia:");
		lblProcedencia.setBounds(10, 222, 104, 17);
		add(lblProcedencia);

		CategoriaDAO cDAO = new CategoriaDAO();
		categorias = cDAO.verCats();

		txtCat.setBounds(124, 67, 86, 22);

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
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = txtTitulo.getText();
				String cat = txtCat.getSelectedItem().toString();
				String descripcion = txtDescripcion.getText();
				String fuente = txtFuente.getText();
				String enlaceAlDoc = txtEnlaceAlDoc.getText();

				String prioridad = txtEsPrioritario.getSelectedItem().toString();
		
				String procedencia = txtProcedenciaV2.getText();
				System.out.println(procedencia);
				MaterialesDAOC mDAOC = new MaterialesDAOC();

				if (esEdicion()) {
					// modifica
					int numMaterial = Integer.parseInt(txtNumeroMaterial.getText());
					MaterialInstitucional matInsti = new MaterialInstitucional(titulo, cat, descripcion, fuente,
							enlaceAlDoc, prioridad, procedencia);
					mDAOC.modificacionMatInsti(matInsti, numMaterial);
					JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
					marco.setContentPane(new VerMateriales());
					marco.validate();

				} else {
					// alta.
					System.out.println(procedencia);
					MaterialInstitucional matInsti = new MaterialInstitucional(titulo, cat, descripcion, fuente,
							enlaceAlDoc, prioridad, procedencia);
					mDAOC.altaMatInstitucional(matInsti);
					JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
					marco.setContentPane(new material());
					marco.validate();

				}

			}
		});
		btnGuardar.setBounds(351, 266, 89, 23);
		add(btnGuardar);

		txtNumeroMaterial = new JTextField();
		txtNumeroMaterial.setVisible(false);
		txtNumeroMaterial.setBounds(10, 267, 86, 20);
		add(txtNumeroMaterial);
		txtNumeroMaterial.setColumns(10);

	}

	public MaterialInstitucionalAlta(MaterialInstitucional matInsti) {
		// se auto ejecuta sin nada para que se arme la pantalla sin datos
		this();
		// los datos del objeto propuesta los coloca en la casilla correspondiente.

		txtTitulo.setText(matInsti.getTitulo());
		txtCat.setSelectedItem(matInsti.getCategoria());
		txtDescripcion.setText(matInsti.getDescripcion());
		txtFuente.setText(matInsti.getFuente());
		txtEnlaceAlDoc.setText(matInsti.getEnlaceAlDoc());
		txtEsPrioritario.setSelectedItem(matInsti.getEsPrioritario());
		txtProcedenciaV2.setText(matInsti.getProcedencia());
		txtNumeroMaterial.setText(matInsti.getId());
		this.matInsti = matInsti;

	}

	public boolean esEdicion() {
		return this.matInsti != null;

	}
}
