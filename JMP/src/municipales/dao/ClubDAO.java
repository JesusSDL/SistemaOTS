package municipales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import municipales.modelo.*;

public class ClubDAO extends DAOHerenceR {
	
	public void alta(Club cb) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("INSERT INTO club (nombre, profesor, actividades, descripcionActividad) VALUES(?,?,?,?);");
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, cb.getNombre());
			pStmt.setString(2, cb.getProfesor());
			pStmt.setString(3, cb.getActividades());
			pStmt.setString(4, cb.getDescripcionActividades());
			pStmt.executeUpdate();

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

	}

	public void modificacion(Club cb, int id) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("UPDATE club SET nombre = ?, profesor = ?, actividades = ?, descripcionActividad = ? WHERE idClub = ?;");
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, cb.getNombre());
			pStmt.setString(2, cb.getProfesor());
			pStmt.setString(3, cb.getActividades());
			pStmt.setString(5, cb.getDescripcionActividades());
			pStmt.setInt(6, id);
			pStmt.executeUpdate();
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

	}

	public void baja(Club cb) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("DELETE FROM club WHERE idClub = ?;");

			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setInt(1, cb.getIdClub());

			pStmt.executeUpdate();
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

	}
	public int verIdClub(Club cb) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("SELECT idClub FROM club WHERE nombre = ? ");

			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, cb.getNombre());

			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				return rs.getInt("idClub");

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
		return 0;
	}

	public int verIdClub(String nombre) {
		Club cb = new Club(nombre);
		return verIdClub(cb);

	}

	public ArrayList<Club> verSauron() {
		ArrayList<Club> losClubes = new ArrayList<Club>();
		Connection c = null;
		try {
			c = conectar();
			String sql = ("SELECT idClub, nombre, profesor, actividades, descripcionActividad FROM club;");
			Statement stmt = c.createStatement();

			ResultSet resultado = stmt.executeQuery(sql);

			while (resultado.next()) {

				int id = resultado.getInt("idClub");
				String nombre = resultado.getString("nombre");
				String profesor = resultado.getString("profesor");
				String actividades = resultado.getString("actividades");
				String descripcionActividad = resultado.getString("descripcionActividad");

				Club cb = new Club(id, nombre, profesor, actividades, descripcionActividad);
				losClubes.add(cb);
			}

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			try {
				if (c != null) {
					c.close();
				}
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
		return losClubes;

	}
/*	public ArrayList<Club> verDetalleClub(String nombre) {
		ArrayList<Club> losClubes = new ArrayList<Club>();
		Connection c = null;
		try {
			c = conectar();
			 String insertarNombre = nombre;
			String sql = ("SELECT actividades, descripcionActividad WHERE nombre = insertarNombre FROM club;");
			
			Statement stmt = c.createStatement();
			
			ResultSet resultado = stmt.executeQuery(sql);

			while (resultado.next()) {

				String actividades = resultado.getString("actividades");
				String descripcionActividad = resultado.getString("descripcionActividad");

				Club cb = new Club( actividades, descripcionActividad);
				losClubes.add(cb);
			}

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			try {
				if (c != null) {
					c.close();
				}
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
		return losClubes;

	}*/
	
	/*public String verDetalleClub(Club cb) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("SELECT actividades, descripcionActividad FROM club WHERE nombre = ? ");

			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, cb.getNombre());

			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				return rs.getString("actividades");
				
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
		return "olo";
	}

	public String traerDetalles(String nombreClub) {
		Club cb = new Club(nombreClub);
		return verDetalleClub(cb);
		
	}*/
	
	public int traerIdPorNombreClub(Club cb) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("SELECT IdClub FROM club WHERE nombre = ? ");

			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, cb.getNombre());

			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				return rs.getInt("IdClub");
				
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
		return 0;
	}

	public int verNombreconF(String nombreClub) {
		Club cb = new Club(nombreClub);
		return traerIdPorNombreClub(cb);
		
	}
}
