package municipales.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import municipales.dao.MaterialesDAOC;
import municipales.dao.PropuestaDAO;
import municipales.modelo.Material;
import municipales.modelo.MaterialInstitucional;
import municipales.modelo.Propuesta;

import javax.swing.JRadioButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class PropuestaVerDetalle extends JPanel {
	private JTextField txtOrigen;
	private JTextField txtTitulo;
	private JTextField txtCat;
	private JTextField txtDescripcion;
	private JTextField txtAutor;
	private JTextField txtFecha;
	private JTextField txtEstado;
	private JTextField txtMotivoRechazo;
	JScrollPane scrollPane = new JScrollPane();
	JList JListAsignarMateriales = new JList();
	DefaultListModel<String> matsAsociar = new DefaultListModel<String>();
	private ArrayList<Material> materiales;
	ArrayList<String> materialAsignado;
	private Propuesta propuesta;
	private JTextField txtNumeroPropuesta;
	

	public PropuestaVerDetalle() {
		setLayout(null);
		JButton btnConfirmarAprobacion = new JButton("Confirmar");
		btnConfirmarAprobacion.setVisible(false);
		JListAsignarMateriales.setVisible(false);
		scrollPane.setVisible(false);

		scrollPane.setBounds(475, 245, 182, 123);
		add(scrollPane);
		scrollPane.setRowHeaderView(JListAsignarMateriales);

		MaterialesDAOC mDAOC = new MaterialesDAOC();
		materiales = mDAOC.verSauron();

		for (Material material : materiales) {
			String titulo = material.getTitulo();
			matsAsociar.addElement(titulo);
		}

		JListAsignarMateriales.setModel(matsAsociar);

		JLabel lblNewLabel = new JLabel("Origen:");
		lblNewLabel.setBounds(10, 73, 118, 14);
		add(lblNewLabel);

		txtOrigen = new JTextField();
		txtOrigen.setEditable(false);
		txtOrigen.setBounds(138, 70, 86, 20);
		add(txtOrigen);
		txtOrigen.setColumns(10);
		JLabel lblMateriales = new JLabel("Materiales: ");
		lblMateriales.setBounds(364, 233, 74, 14);
		add(lblMateriales);
		lblMateriales.setVisible(false);

		txtTitulo = new JTextField();
		txtTitulo.setEditable(false);
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(138, 129, 86, 20);
		add(txtTitulo);

		JLabel lblNewLabelsdf = new JLabel("Título: ");
		lblNewLabelsdf.setBounds(10, 132, 118, 14);
		add(lblNewLabelsdf);

		txtCat = new JTextField();
		txtCat.setEditable(false);
		txtCat.setColumns(10);
		txtCat.setBounds(138, 190, 86, 17);
		add(txtCat);

		JLabel lblCategora = new JLabel("Categoría:");
		lblCategora.setBounds(10, 192, 118, 14);
		add(lblCategora);

		txtDescripcion = new JTextField();
		txtDescripcion.setEditable(false);
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(138, 245, 201, 116);
		add(txtDescripcion);

		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setBounds(10, 252, 118, 14);
		add(lblDescripcin);

		txtAutor = new JTextField();
		txtAutor.setEditable(false);
		txtAutor.setColumns(10);
		txtAutor.setBounds(492, 70, 86, 20);
		add(txtAutor);

		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(364, 73, 118, 14);
		add(lblAutor);

		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(492, 129, 86, 20);
		add(txtFecha);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(364, 132, 118, 14);
		add(lblFecha);

		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		txtEstado.setBounds(492, 189, 86, 20);
		add(txtEstado);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(364, 192, 118, 14);
		add(lblEstado);

		JButton btnVolver = new JButton("<--");
		JButton btnConfirmarRechazo = new JButton("Confirmar");
		JButton btnRechazar = new JButton("Rechazar");
		JButton btnAprobar = new JButton("Aprobar");

		// btn confirmar Rechazo
		btnConfirmarRechazo.setVisible(false);
		btnConfirmarRechazo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEstado.setText("Rechazada");
				txtMotivoRechazo.setEditable(false);
				btnVolver.setVisible(true);
				btnConfirmarRechazo.setVisible(false);
				btnAprobar.setVisible(true);

				String origenRechazo = txtOrigen.getText();
				String tituloRechazo = txtTitulo.getText();
				String catRechazo = txtCat.getText();
				String descripcionRechazo = txtDescripcion.getText();
				String autorRechazo = txtAutor.getText();
				LocalDate fechaRechazo = LocalDate.now();
				String estadoRechazo = txtEstado.getText();
				String motivoRechazo = txtMotivoRechazo.getText();
				
				int numeroPropuesta = Integer.parseInt(txtNumeroPropuesta.getText());

				PropuestaDAO pDAO = new PropuestaDAO();
				Propuesta propuestaRechazada = new Propuesta(origenRechazo, tituloRechazo, catRechazo,
						descripcionRechazo, autorRechazo, fechaRechazo, estadoRechazo, motivoRechazo);
				pDAO.modificacion(propuestaRechazada, numeroPropuesta);
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new PropuestaVer());
				marco.validate();

			}
		});
		btnConfirmarRechazo.setBounds(530, 415, 127, 20);
		add(btnConfirmarRechazo);

		// btn volver
		btnVolver.setEnabled(true);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new PropuestaVer());
				marco.validate();
			}
		});
		btnVolver.setFont(new Font("Sylfaen", Font.BOLD, 14));
		btnVolver.setBounds(10, 11, 89, 23);
		add(btnVolver);
		JLabel lblMotivoRechazo = new JLabel("Motivo Rechazo:");
		lblMotivoRechazo.setBounds(364, 252, 118, 14);
		add(lblMotivoRechazo);

		// btn semi-aprobar
		btnAprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMateriales.setVisible(true);
				lblMotivoRechazo.setVisible(false);
				txtEstado.setText("Aprobada");
				txtMotivoRechazo.setText("");
				btnVolver.setVisible(true);
				txtMotivoRechazo.setVisible(false);
				scrollPane.setVisible(true);
				JListAsignarMateriales.setVisible(true);
				add(scrollPane);
				btnAprobar.setVisible(false);
				btnConfirmarAprobacion.setVisible(true);

			}

		});
		btnAprobar.setBounds(530, 415, 127, 20);
		add(btnAprobar);

		// btnRechazar
		btnRechazar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMotivoRechazo.setEditable(true);
				btnVolver.setVisible(false);
				btnConfirmarRechazo.setVisible(true);
				btnAprobar.setVisible(false);

			}
		});
		btnRechazar.setBounds(393, 416, 127, 20);
		add(btnRechazar);

		txtMotivoRechazo = new JTextField();
		txtMotivoRechazo.setEditable(false);
		txtMotivoRechazo.setColumns(10);
		txtMotivoRechazo.setBounds(492, 249, 201, 112);
		add(txtMotivoRechazo);

		txtNumeroPropuesta = new JTextField();
		txtNumeroPropuesta.setVisible(false);
		txtNumeroPropuesta.setBounds(347, 21, 86, 20);
		add(txtNumeroPropuesta);
		txtNumeroPropuesta.setColumns(10);

		btnConfirmarAprobacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PropuestaDAO pDAO = new PropuestaDAO();
				String origenAprobada = txtOrigen.getText();
				String tituloAprobada = txtTitulo.getText();
				String catAprobada = txtCat.getText();
				String descripcionAprobada = txtDescripcion.getText();
				String autorAprobada = txtAutor.getText();
				LocalDate fechaAprobada = LocalDate.now();
				String estadoAprobada = txtEstado.getText();
				String motivoAprobada = txtMotivoRechazo.getText();

				int numeroPropuesta = Integer.parseInt(txtNumeroPropuesta.getText());

				MaterialesDAOC mDAOC = new MaterialesDAOC();

				materialAsignado = (ArrayList<String>) JListAsignarMateriales.getSelectedValuesList();
				mDAOC.asignarMatsPropuestas(materialAsignado, tituloAprobada);

				Propuesta propuestaAprobada = new Propuesta(origenAprobada, tituloAprobada, catAprobada,
						descripcionAprobada, autorAprobada, fechaAprobada, estadoAprobada, motivoAprobada);
				pDAO.modificacion(propuestaAprobada, numeroPropuesta);

				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new PropuestaVer());
				marco.validate();

			}
		});
		btnConfirmarAprobacion.setBounds(530, 414, 127, 23);
		add(btnConfirmarAprobacion);

		

		// JListPropuestasAsoc.setModel(propuestasAsocDefaultList);

	}

	public PropuestaVerDetalle(Propuesta p) {
		// se auto ejecuta sin nada para que se arme la pantalla sin datos
		this();
		// acá hacemos que traiga los datos del verSauron y muy importante, la casilla
		// está desactivada para que modifiquen
		txtOrigen.setText(p.getOrigen());
		txtTitulo.setText(p.getTitulo());
		txtCat.setText("" + p.getCat());
		txtDescripcion.setText(p.getDescripcion());
		txtAutor.setText(p.getAutor());
		txtFecha.setText("" + p.getFecha());
		txtEstado.setText(p.getEstado());
		txtMotivoRechazo.setText(p.getMotivo());

		txtNumeroPropuesta.setText("" + p.getId());

		this.propuesta = p;

	}
}
