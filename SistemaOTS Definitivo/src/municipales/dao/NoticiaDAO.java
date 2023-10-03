package municipales.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;

import municipales.modelo.*;


public class NoticiaDAO extends Conexion{
	public boolean agregar(Noticia n) {
		int filasAfectadas = 0;
		Connection c = null;
		try {
			c = conectar();
			Date fecha = Date.valueOf(n.getFechaNoticia());
			String Sql = "INSERT INTO `mydb2`.`noticia`(`titulo_Noticia`,`contenidoNoticia`,`fechaNoticia`)VALUES(?, ?, ?)";
			PreparedStatement pst = c.prepareStatement(Sql);
			pst.setString(1, n.getTituloNoticia());
			pst.setString(2, n.getContenidoNoticia());
			pst.setDate(3, fecha);
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
	public boolean eliminar(String titulo) {
		int filasAfectadas = 0;
		Connection c = null;
		try {
			c = conectar();
			String sql = "DELETE FROM `mydb2`.`noticia` WHERE titulo_Noticia = ?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, titulo);
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
	public boolean modificar(String titulo, Noticia n) {
		int filasAfectadas = 0;
		Date fecha = Date.valueOf(n.getFechaNoticia());
		Connection c = null;
		try {
			c = conectar();
			String Sql = "UPDATE `mydb2`.`noticia` SET`titulo_Noticia` = ?,`contenidoNoticia` = ? ,`fechaNoticia` = ? WHERE `titulo_Noticia` = ? ";
			PreparedStatement pst = c.prepareStatement(Sql);
			pst.setString(1, n.getTituloNoticia());
			pst.setString(2, n.getContenidoNoticia());
			pst.setDate(3, fecha);
			pst.setString(4, titulo);
			
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
	public ArrayList<Noticia> traerTodas() {
		// consultaSinParametros = SELECT *;o
		Connection c = null;
		ArrayList<Noticia> noticias = new ArrayList<Noticia>();
		try {
			c = conectar();
			String sql = "SELECT `titulo_Noticia`,`contenidoNoticia`,`fechaNoticia` FROM `mydb2`.noticia ;";
			Statement st = c.createStatement();

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {

				String titulo = rs.getString("titulo_Noticia");
				String contenido = rs.getString("contenidoNoticia");
				LocalDate fecha = rs.getDate("fechaNoticia").toLocalDate();;

				Noticia n = new Noticia(titulo,contenido,fecha);
				noticias.add(n);
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
		return noticias;
	}
}
