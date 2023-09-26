package municipales.modelo;

import java.time.LocalDate;
import java.util.*;

public class Propuesta {

	private int id;
	private String origen;
	private String titulo;
	private String cat;
	private String descripcion;
	private String autor;
	private LocalDate fecha;
	private String estado = "Pendiente";
	private String motivo;
	private String textoLusqtoff;
	private ArrayList<MaterialInstitucional> materialAsignado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
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

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public ArrayList<MaterialInstitucional> getMaterialAsignado() {
		return materialAsignado;
	}

	public void setMaterialAsignado(ArrayList<MaterialInstitucional> materialAsignado) {
		this.materialAsignado = materialAsignado;
	}

	public String getTextoLusqtoff() {
		return textoLusqtoff;
	}

	public void setTextoLusqtoff(String textoLusqtoff) {
		this.textoLusqtoff = textoLusqtoff;
	}

	public Propuesta(String origen, String titulo, String cat, String descripcion, String autor, LocalDate fecha,
			String textoLusqtoff) {
		super();
		this.origen = origen;
		this.titulo = titulo;
		this.cat = cat;
		this.descripcion = descripcion;
		this.autor = autor;
		this.fecha = fecha;
		this.textoLusqtoff = textoLusqtoff;
	}

	public Propuesta(int id, String origen, String titulo, String cat, String descripcion, String autor,
			LocalDate fecha, String estado, String motivo) {
		// No sé pero nos sirve para actualizar
		this.id = id;
		this.origen = origen;
		this.titulo = titulo;
		this.cat = cat;
		this.descripcion = descripcion;
		this.autor = autor;
		this.fecha = fecha;
		this.estado = estado;
		this.motivo = motivo;

	}

	public Propuesta(String titulo) {
		// Para borrar
		this.titulo = titulo;
	}

	public Propuesta(String origen, String titulo, String cat, String descripcion, String autor, LocalDate fecha,
			String estado, String motivo) {
		// Para actualizar (?
		this.origen = origen;
		this.titulo = titulo;
		this.cat = cat;
		this.descripcion = descripcion;
		this.autor = autor;
		this.fecha = fecha;
		this.estado = estado;
		this.motivo = motivo;

	}

	public Propuesta(String origen, String titulo, String cat, String descripcion, String autor, LocalDate fecha,
			String estado, String motivo, String textoLusqtoff) {
		// Para actualizar (?
		this.origen = origen;
		this.titulo = titulo;
		this.cat = cat;
		this.descripcion = descripcion;
		this.autor = autor;
		this.fecha = fecha;
		this.estado = estado;
		this.motivo = motivo;
		this.textoLusqtoff = textoLusqtoff;

	}

	public Propuesta(ArrayList<MaterialInstitucional> materialAsignado) {

		this.materialAsignado = materialAsignado;
	}

	public Propuesta(int id2, String origen2, String titulo2, String cat2, String descripcion2, String autor2,
			LocalDate fecha2, String estado2, String motivo2, String textoLusqtoff2) {
		this.id = id2;
		this.origen = origen2;
		this.titulo = titulo2;
		this.cat = cat2;
		this.descripcion = descripcion2;
		this.autor = autor2;
		this.fecha = fecha2;
		this.estado = estado2;
		this.motivo = motivo2;
		this.textoLusqtoff = textoLusqtoff2;

	}

}
