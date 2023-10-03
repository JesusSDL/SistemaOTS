package municipales.vista;

import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import municipales.dao.*;
import municipales.modelo.*;

public class QuejaSubir extends JPanel {
	private JTextField txtDescripcion;
	private JTextField txtNombreApellido;
	private JTextField txtAñoDivision;

	
	public QuejaSubir() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Formulario de Quejas");
		lblNewLabel.setBounds(427, 21, 137, 33);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descripición de la queja:");
		lblNewLabel_1.setBounds(126, 174, 153, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ingrese su nombre y apellido:");
		lblNewLabel_2.setBounds(126, 272, 172, 20);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ingrese su Año y División:");
		lblNewLabel_3.setBounds(126, 327, 192, 14);
		add(lblNewLabel_3);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(328, 144, 311, 75);
		add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		txtNombreApellido = new JTextField();
		txtNombreApellido.setColumns(10);
		txtNombreApellido.setBounds(328, 272, 236, 20);
		add(txtNombreApellido);
		
		txtAñoDivision = new JTextField();
		txtAñoDivision.setColumns(10);
		txtAñoDivision.setBounds(328, 324, 86, 20);
		add(txtAñoDivision);
		JButton btnVolver = new JButton("<--");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new Principal());
				marco.validate();
			}
		});
		btnVolver.setBounds(21, 27, 89, 23);
		add(btnVolver);
		
		JButton btnEnviar = new JButton("Enviar Formulario");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				QuejaDAO qDAO = new QuejaDAO();
				
				String descripcion =  txtDescripcion.getText();
				String nombreApellido = txtNombreApellido.getText();
				String añoDivision = txtAñoDivision.getText();
				
				Queja qj = new Queja( descripcion, nombreApellido, añoDivision);
				
				qDAO.alta(qj);

				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				marco.setContentPane(new CargaExitosa());
				marco.validate();
				
			}
		});
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEnviar.setBounds(454, 382, 185, 23);
		add(btnEnviar);

	}

}
