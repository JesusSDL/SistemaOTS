package municipales.modelo;

public class Club {
	private int idClub;
	private String nombre;
	private String profesor;
	private String actividades;
	private String descripcionActividades;

	public int getIdClub() {
		return idClub;
	}

	public void setIdClub(int idClub) {
		this.idClub = idClub;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public String getActividades() {
		return actividades;
	}

	public void setActividades(String actividades) {
		this.actividades = actividades;
	}

	public String getDescripcionActividades() {
		return descripcionActividades;
	}

	public void setDescripcionActividades(String descripcionActividades) {
		this.descripcionActividades = descripcionActividades;
	}

	public Club(int idClub, String nombre, String profesor, String actividades, String descripcionActividades) {
		super();
		this.idClub = idClub;
		this.nombre = nombre;
		this.profesor = profesor;
		this.actividades = actividades;
		this.descripcionActividades = descripcionActividades;
	}

	public Club(String nombre, String profesor, String actividades, String descripcionActividades) {
		super();
		this.nombre = nombre;
		this.profesor = profesor;
		this.actividades = actividades;
		this.descripcionActividades = descripcionActividades;
	}

	public Club(int id) {
		super();
		this.idClub = id;
	}

	public Club(String nombreClub) {
		this.nombre = nombreClub;
	}

	public Club(String actividades2, String descripcionActividades2) {
		this.actividades = actividades2;
		this.descripcionActividades = descripcionActividades2;
	}

}
