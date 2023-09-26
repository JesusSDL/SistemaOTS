package municipales.vista;

import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import municipales.dao.CategoriaDAO;
import municipales.modelo.Categoria;
import municipales.modelo.MaterialInstitucional;
import javax.swing.JComboBox;

public class MaterialInstiVerDetalle extends JPanel {
	private JTextField txtTitulo;
	private JTextField txtDescripcion;
	private JTextField txtFuente;
	private JTextField txtEnlaceAlDoc;
	private JTextField txtProcedencia;
	private JTextField txtNumeroMaterial;
	JComboBox txtEsPrioritario = new JComboBox();
	JComboBox txtCat = new JComboBox();
	private ArrayList<Categoria> categorias;
	private MaterialInstitucional matInsti;

	public MaterialInstiVerDetalle() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Título:");
		lblNewLabel.setBounds(10, 49, 113, 14);
		add(lblNewLabel);

		txtTitulo = new JTextField();
		txtTitulo.setEditable(false);
		txtTitulo.setBounds(133, 46, 86, 20);
		add(txtTitulo);
		txtTitulo.setColumns(10);

		JLabel lblCategora = new JLabel("Categoría:");
		lblCategora.setBounds(10, 77, 113, 14);
		add(lblCategora);

		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setBounds(10, 105, 113, 14);
		add(lblDescripcin);

		txtDescripcion = new JTextField();
		txtDescripcion.setEditable(false);
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(133, 102, 86, 20);
		add(txtDescripcion);

		JLabel lblFuente = new JLabel("Fuente:");
		lblFuente.setBounds(10, 133, 113, 14);
		add(lblFuente);

		txtFuente = new JTextField();
		txtFuente.setEditable(false);
		txtFuente.setColumns(10);
		txtFuente.setBounds(133, 130, 86, 20);
		add(txtFuente);

		JLabel lblEnlaceAlDoc = new JLabel("Enlace al Doc:");
		lblEnlaceAlDoc.setBounds(10, 161, 113, 14);
		add(lblEnlaceAlDoc);

		txtEnlaceAlDoc = new JTextField();
		txtEnlaceAlDoc.setEditable(false);
		txtEnlaceAlDoc.setColumns(10);
		txtEnlaceAlDoc.setBounds(133, 158, 86, 20);
		add(txtEnlaceAlDoc);

		JLabel lblEsPrioritario = new JLabel("Es prioritario?");
		lblEsPrioritario.setBounds(10, 189, 113, 14);
		add(lblEsPrioritario);

		JLabel lblProcedencia = new JLabel("Procedencia:");
		lblProcedencia.setBounds(10, 217, 113, 14);
		add(lblProcedencia);

		txtProcedencia = new JTextField();
		txtProcedencia.setEditable(false);
		txtProcedencia.setColumns(10);
		txtProcedencia.setBounds(133, 214, 86, 20);
		add(txtProcedencia);
		txtEsPrioritario.setEditable(true);
		txtEsPrioritario.setEnabled(false);

		txtEsPrioritario.setModel(new DefaultComboBoxModel(new String[] { "No", "Si" }));
		txtEsPrioritario.setBounds(133, 185, 86, 22);
		add(txtEsPrioritario);

		CategoriaDAO cDAO = new CategoriaDAO();
		categorias = cDAO.verCats();
		txtCat.setEnabled(false);
		txtCat.setEditable(true);

		txtCat.setBounds(133, 73, 86, 22);

		for (Categoria categoria : categorias) {
			String nomCat = categoria.getNomCategoria();
			txtCat.addItem(nomCat);
		}

		add(txtCat);

		JButton btnVolver = new JButton("<--");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new material());
				marco.validate();
			}
		});
		btnVolver.setBounds(10, 11, 89, 23);
		add(btnVolver);

		txtNumeroMaterial = new JTextField();
		txtNumeroMaterial.setVisible(false);
		txtNumeroMaterial.setBounds(10, 267, 86, 20);
		add(txtNumeroMaterial);
		txtNumeroMaterial.setColumns(10);

	}

	public MaterialInstiVerDetalle(MaterialInstitucional matInsti) {
		// se auto ejecuta sin nada para que se arme la pantalla sin datos
		this();
		// los datos del objeto propuesta los coloca en la casilla correspondiente.

		txtTitulo.setText(matInsti.getTitulo());
		txtCat.setSelectedItem(matInsti.getCategoria());
		txtDescripcion.setText(matInsti.getDescripcion());
		txtFuente.setText(matInsti.getFuente());
		txtEnlaceAlDoc.setText(matInsti.getEnlaceAlDoc());
		txtEsPrioritario.setSelectedItem(matInsti.getEsPrioritario());
		txtProcedencia.setText(matInsti.getProcedencia());
		txtNumeroMaterial.setText(matInsti.getId());
		this.matInsti = matInsti;

	}
}
