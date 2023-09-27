package municipales.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import municipales.modelo.ICE;
import municipales.modelo.Reunion;

public class ICEDao extends DAOHerenceR {
	
	public void alta(ICE ice){
		Connection c = null;
		try {
			c = conectar();
			String sql = ("INSERT INTO cestudiante (nombreApellido, rol, fechaNacimiento) VALUES(?,?,?);");
			//Date fecha = Date.valueOf(ice.getFechaNacimiento());
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, ice.getNombreApe());
			pStmt.setString(2, ice.getRol());
			pStmt.setDate(3, (Date) ice.getFechaNacimiento());
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
			//Date fecha = Date.valueOf(ice.getFechaNacimiento());
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, ice.getNombreApe());
			pStmt.setString(2, ice.getRol());
			pStmt.setDate(4, (Date) ice.getFechaNacimiento());
			pStmt.executeUpdate();
		}  catch (SQLException ex) {

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
		}  catch (SQLException ex) {

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
				Date fechaNacimiento = resultado.getDate("fechaNacimiento");
				

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
