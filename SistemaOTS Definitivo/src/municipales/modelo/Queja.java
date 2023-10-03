package municipales.modelo;

public class Queja {
	private int idQueja;
	private String descripcion;
	private String nombreApellido;
	private String cursoDivision;

	public int getIdQueja() {
		return idQueja;
	}

	public void setIdQueja(int idQueja) {
		this.idQueja = idQueja;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getCursoDivision() {
		return cursoDivision;
	}

	public void setCursoDivision(String cursoDivision) {
		this.cursoDivision = cursoDivision;
	}

	public Queja(int idQueja, String descripcion, String nombreApellido, String cursoDivision) {
		super();
		this.idQueja = idQueja;
		this.descripcion = descripcion;
		this.nombreApellido = nombreApellido;
		this.cursoDivision = cursoDivision;
	}

	public Queja(String descripcion, String nombreApellido, String cursoDivision) {
		super();
		this.descripcion = descripcion;
		this.nombreApellido = nombreApellido;
		this.cursoDivision = cursoDivision;
	}

	public Queja(int idQueja) {
		super();
		this.idQueja = idQueja;

	}

}
