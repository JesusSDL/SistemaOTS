package municipales.modelo;

public class MaterialInstitucional extends Material {

	private String procedencia;

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public MaterialInstitucional(String titulo, String categoria, String descripcion, String fuente, String enlaceAlDoc,
			String esPrioritario, String procedencia, String id) {
		super(titulo, categoria, descripcion, fuente, enlaceAlDoc, esPrioritario, id);
		this.procedencia = procedencia;
	}

	public MaterialInstitucional(String titulo, String categoria, String descripcion, String fuente, String enlaceAlDoc,
			String esPrioritario, String procedencia) {
		super(titulo, categoria, descripcion, fuente, enlaceAlDoc, esPrioritario);
		this.procedencia = procedencia;
	}

	public MaterialInstitucional(String titulo) {
		// para borrar
		super(titulo);
	}

}
