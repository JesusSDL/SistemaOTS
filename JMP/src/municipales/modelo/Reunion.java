package municipales.modelo;

import java.time.LocalDate;

public class Reunion {
	private int id;
	private String temaTratado;
	private String detalleAsamblea;
	private String resumenAsamblea;
	private LocalDate fechaAsamblea;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTemaTratado() {
		return temaTratado;
	}

	public void setTemaTratado(String temaTratado) {
		this.temaTratado = temaTratado;
	}

	public String getDetalleAsamblea() {
		return detalleAsamblea;
	}

	public void setDetalleAsamblea(String detalleAsamblea) {
		this.detalleAsamblea = detalleAsamblea;
	}

	public String getResumenAsamblea() {
		return resumenAsamblea;
	}

	public void setResumenAsamblea(String resumenAsamblea) {
		this.resumenAsamblea = resumenAsamblea;
	}

	public LocalDate getFechaAsamblea() {
		return fechaAsamblea;
	}

	public void setFechaAsamblea(LocalDate fechaAsamblea) {
		this.fechaAsamblea = fechaAsamblea;
	}

	public Reunion(int id, String temaTratado, String detalleAsamblea, String resumenAsamblea,
			LocalDate fechaAsamblea) {
		super();
		this.id = id;
		this.temaTratado = temaTratado;
		this.detalleAsamblea = detalleAsamblea;
		this.resumenAsamblea = resumenAsamblea;
		this.fechaAsamblea = fechaAsamblea;
	}

	public Reunion(int id) {
		this.id = id;
	}

	public Reunion(String tema, String detalle, String resumen, LocalDate fecha) {
		this.temaTratado = tema;
		this.detalleAsamblea = detalle;
		this.resumenAsamblea = resumen;
		this.fechaAsamblea = fecha;
	}
}
