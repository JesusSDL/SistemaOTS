package municipales.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import municipales.modelo.*;


public class EventoDAO extends Conexion{
	
	public boolean agregar(Evento e) {
		int filasAfectadas = 0;
		Connection c = null;
		try {
			c = conectar();
			String Sql = "INSERT INTO `mydb2`.`evento`(`titulo_Evento`,`fecha_Evento`,`hora_inicio`,`hora_Fin`,`motivo_Evento`)VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pst = c.prepareStatement(Sql);

			pst.setString(1, e.getNombreEvento());
			pst.setDate(2, new java.sql.Date(e.getFechaEvento().getTime()));
			pst.setInt(3, e.getHoraInicio());
			pst.setInt(4, e.getHoraFin());
			pst.setString(5, e.getMotivoEvento());
			pst.executeUpdate();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (c != null) {
					c.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return filasAfectadas != 0;
	}
	
	public boolean Eliminar(String eventoName) {
		int filasAfectadas = 0;
		Connection c = null;
		try {
			c = conectar();
			String sql = "DELETE FROM `mydb2`.`evento` WHERE titulo_Evento = ?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, eventoName);
			pst.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (c != null) {
					c.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return filasAfectadas != 0;
	}
	public boolean Modificar(String titulo, Evento e) {
		int filasAfectadas = 0;
		Connection c = null;
		try {
			c = conectar();
			String Sql = "UPDATE `mydb2`.`evento` SET`titulo_Evento` = ?,`fecha_Evento` = ? ,`hora_inicio` = ?,`hora_Fin` = ?,`motivo_Evento` = ? WHERE `titulo_Evento` = ? ";
			PreparedStatement pst = c.prepareStatement(Sql);
			pst.setString(1, e.getNombreEvento());
			pst.setDate(2, new java.sql.Date(e.getFechaEvento().getTime()));
			pst.setInt(3, e.getHoraInicio());
			pst.setInt(4, e.getHoraFin());
			pst.setString(5, e.getMotivoEvento());
			pst.setString(6, titulo);
			
			filasAfectadas = pst.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (c != null) {
					c.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return filasAfectadas != 0;
	}
	public ArrayList<Evento> traerTodas() {
		// consultaSinParametros = SELECT *;o
		Connection c = null;
		ArrayList<Evento> eventos = new ArrayList<Evento>();
		try {
			c = conectar();
			String sql = "SELECT `titulo_Evento`,`fecha_Evento`,`hora_inicio`,`hora_Fin`,`motivo_Evento` FROM `mydb2`.evento ;";
			Statement st = c.createStatement();

			ResultSet rs = st.executeQuery(sql);
			CategoriaDAO ca = new CategoriaDAO();
			while (rs.next()) {

				String titulo = rs.getString("titulo_Evento");
				java.sql.Date fecha = rs.getDate("fecha_Evento");;
				int horaIn = rs.getInt("hora_inicio");
				int horaFin = rs.getInt("hora_Fin");
				String motivo_Evento = rs.getString("motivo_Evento");

				Evento e = new Evento(titulo,fecha,horaIn,horaFin,motivo_Evento);
				eventos.add(e);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (c != null) {
					c.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return eventos;
	}

}
