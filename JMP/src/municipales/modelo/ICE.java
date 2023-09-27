package municipales.modelo;

import java.time.LocalDate;
import java.util.*;

public class ICE {
	private int id;
	private String nombreApe;
	private String rol;
	private Date fechaNacimiento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreApe() {
		return nombreApe;
	}

	public void setNombreApe(String nombreApe) {
		this.nombreApe = nombreApe;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public ICE(int id, String nombreApe, String rol, Date fechaNacimiento) {
		super();
		this.id = id;
		this.nombreApe = nombreApe;
		this.rol = rol;
		this.fechaNacimiento = fechaNacimiento;
	}
	public ICE(String nombreApe) {
		//p borrar
		this.nombreApe = nombreApe;
	}
}
