package municipales.modelo;

import java.util.ArrayList;

public class MaterialdePropuestas extends Material {

	private ArrayList<Propuesta> propuestasAsoc;

	public ArrayList<Propuesta> getPropuestasAsoc() {
		return propuestasAsoc;
	}

	public void setPropuestasAsoc(ArrayList<Propuesta> propuestasAsoc) {
		this.propuestasAsoc = propuestasAsoc;
	}

	public MaterialdePropuestas(String titulo, String categoria, String descripcion, String fuente, String enlaceAlDoc,
			String esPrioritario, String id, ArrayList<Propuesta> propuestasAsoc) {
		super(titulo, categoria, descripcion, fuente, enlaceAlDoc, esPrioritario, id);
		this.propuestasAsoc = propuestasAsoc;
	}

	public MaterialdePropuestas(String titulo) {
		super(titulo);

	}

}
