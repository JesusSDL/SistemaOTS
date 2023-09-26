package municipales.modelo;

public class Material {

	private String titulo;
	private String categoria;
	private String descripcion;
	private String fuente;
	private String enlaceAlDoc;
	private String esPrioritario;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFuente() {
		return fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public String getEnlaceAlDoc() {
		return enlaceAlDoc;
	}

	public void setEnlaceAlDoc(String enlaceAlDoc) {
		this.enlaceAlDoc = enlaceAlDoc;
	}

	public String getEsPrioritario() {
		return esPrioritario;
	}

	public void setEsPrioritario(String esPrioritario) {
		this.esPrioritario = esPrioritario;
	}

	public Material(String titulo, String categoria, String descripcion, String fuente, String enlaceAlDoc,
			String esPrioritario, String id) {
		super();
		this.titulo = titulo;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.fuente = fuente;
		this.enlaceAlDoc = enlaceAlDoc;
		this.esPrioritario = esPrioritario;
		this.id = id;
	}

	public Material(String titulo, String categoria, String descripcion, String fuente, String enlaceAlDoc,
			String esPrioritario) {
		super();
		this.titulo = titulo;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.fuente = fuente;
		this.enlaceAlDoc = enlaceAlDoc;
		this.esPrioritario = esPrioritario;
	}

	public Material(String titulo) {
		this.titulo = titulo;
	}

}
