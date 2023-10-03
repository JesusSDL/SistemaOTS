package municipales.modelo;
import java.sql.Date;
import java.time.LocalDate;

public class Noticia {
	private String tituloNoticia;
	private String contenidoNoticia;
	private LocalDate fechaNoticia = LocalDate.now();
	public Noticia(String tituloNoticia, String contenidoNoticia, LocalDate fechaNoticia) {
		super();
		this.tituloNoticia = tituloNoticia;
		this.contenidoNoticia = contenidoNoticia;
		this.fechaNoticia = fechaNoticia;
	}
	public String getTituloNoticia() {
		return tituloNoticia;
	}
	public void setTituloNoticia(String tituloNoticia) {
		this.tituloNoticia = tituloNoticia;
	}
	public String getContenidoNoticia() {
		return contenidoNoticia;
	}
	public void setContenidoNoticia(String contenidoNoticia) {
		this.contenidoNoticia = contenidoNoticia;
	}
	public LocalDate getFechaNoticia() {
		return fechaNoticia;
	}
	public void setFechaNoticia(LocalDate fechaNoticia) {
		this.fechaNoticia = fechaNoticia;
	}
	
}
