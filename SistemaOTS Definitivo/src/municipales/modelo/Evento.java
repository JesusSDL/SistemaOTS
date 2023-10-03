package municipales.modelo;

import java.sql.Date;

public class Evento {
	private String nombreEvento;
	private Date fechaEvento;
	private int horaInicio;
	private int horaFin;
	private String motivoEvento;
	
	public Evento(String nombreEvento, Date fechaEvento, int horaInicio, int horaFin, String motivoEvento) {
		super();
		this.nombreEvento = nombreEvento;
		this.fechaEvento = fechaEvento;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.motivoEvento = motivoEvento;
	}
	public String getNombreEvento() {
		return nombreEvento;
	}
	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}
	public Date getFechaEvento() {
		return fechaEvento;
	}
	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}
	public int getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}
	public int getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(int horaFin) {
		this.horaFin = horaFin;
	}
	public String getMotivoEvento() {
		return motivoEvento;
	}
	public void setMotivoEvento(String motivoEvento) {
		this.motivoEvento = motivoEvento;
	}
	

}
