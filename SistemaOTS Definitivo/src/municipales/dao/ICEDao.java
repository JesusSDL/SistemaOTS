package municipales.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import municipales.modelo.Categoria;
import municipales.modelo.ICE;
import municipales.modelo.*;

public class ICEDao extends DAOHerenceR {

	public void altaEstudiante(ICE estudiante) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("INSERT INTO cestudiante (nombreApellido, fechaNacimiento) VALUES(?,?);");
			// Date fecha = Date.valueOf(ice.getFechaNacimiento());
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, estudiante.getNombreApe());
			pStmt.setString(2, estudiante.getFechaNacimiento());
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
	public void altaEstudianteRelacional(int idEstudiante, int idClub) {
		Connection c = null;
		try {
			c = conectar();
			String sqlRelacional = ("INSERT INTO cestudiante_has_club (cestudiante_idCestudiante, CLUB_idClub ) VALUES (?,?)");
			PreparedStatement pStmt2 = c.prepareStatement(sqlRelacional);
			pStmt2.setInt(1, idEstudiante);
			pStmt2.setInt(2, idClub);
			pStmt2.executeUpdate();

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
	public int verIdEstudiante(ICE ice) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("SELECT idCestudiante FROM cestudiante WHERE nombreApellido = ? ");

			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, ice.getNombreApe());

			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				return rs.getInt("idCestudiante");

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

	public int verIdEstudiante(String nombreApellido) {
		ICE ice = new ICE(nombreApellido);
		return verIdEstudiante(ice);

	}
	

	public void alta(ICE ice) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("INSERT INTO cestudiante (nombreApellido, rol, fechaNacimiento) VALUES(?,?,?);");
			// Date fecha = Date.valueOf(ice.getFechaNacimiento());
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, ice.getNombreApe());
			pStmt.setString(2, ice.getRol());
			pStmt.setString(3, ice.getFechaNacimiento());
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

	public void modificacion(ICE ice) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("UPDATE cestudiante SET nombreApellido = ?, rol = ?, fechaNacimiento = ? WHERE idCestudiante = ?;");
			// Date fecha = Date.valueOf(ice.getFechaNacimiento());
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, ice.getNombreApe());
			pStmt.setString(2, ice.getRol());
			pStmt.setString(4, ice.getFechaNacimiento());
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

	public void baja(ICE ice) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("DELETE FROM cestudiante WHERE idCestudiante = ?;");

			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setInt(1, ice.getId());

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

	public ArrayList<ICE> verSauron() {
		ArrayList<ICE> losICE = new ArrayList<ICE>();
		Connection c = null;
		try {
			c = conectar();
			String sql = ("SELECT idCestudiante, nombreApellido, rol, fechaNacimiento FROM cestudiante;");
			Statement stmt = c.createStatement();

			ResultSet resultado = stmt.executeQuery(sql);

			while (resultado.next()) {

				int id = resultado.getInt("idCestudiante");
				String nombreApe = resultado.getString("nombreApellido");
				String rol = resultado.getString("rol");
				String fechaNacimiento = resultado.getString("fechaNacimiento");

				ICE ice = new ICE(id, nombreApe, rol, fechaNacimiento);
				losICE.add(ice);
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
		return losICE;

	}

}
