package municipales.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import municipales.modelo.*;

public class ReunionDAO extends DAOHerenceR {

	public void alta(Reunion r){
		Connection c = null;
		try {
			c = conectar();
			String sql = ("INSERT INTO reunion (temaTratado, detalleAsamblea, resumenAsamblea, fechaAsamblea) VALUES(?,?,?,?);");
			Date fecha = Date.valueOf(r.getFechaAsamblea());
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, r.getTemaTratado());
			pStmt.setString(2, r.getDetalleAsamblea());
			pStmt.setString(3, r.getResumenAsamblea());
			pStmt.setDate(4, fecha);
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

	public void modificacion(Reunion r, int id) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("UPDATE reunion SET temaTratado = ?, detalleAsamblea = ?, resumenAsamblea = ?, fechaAsamblea = ? WHERE idReunion = ?;");

			Date fecha = Date.valueOf(r.getFechaAsamblea());
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, r.getTemaTratado());
			pStmt.setString(2, r.getDetalleAsamblea());
			pStmt.setString(3, r.getResumenAsamblea());
			pStmt.setDate(4, fecha);
			pStmt.setInt(5, id);
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
	public void baja(Reunion r) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("DELETE FROM reunion WHERE idReunion = ?;");

			
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setInt(1, r.getId());

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
	public ArrayList<Reunion> verSauron() {
		ArrayList<Reunion> lasReuniones = new ArrayList<Reunion>();
		Connection c = null;
		try {
			c = conectar();
			String sql = ("SELECT idReunion, temaTratado, detalleAsamblea, resumenAsamblea, fechaAsamblea FROM reunion;");
			Statement stmt = c.createStatement();

			ResultSet resultado = stmt.executeQuery(sql);

			while (resultado.next()) {

				int id = resultado.getInt("idReunion");
				String tema = resultado.getString("temaTratado");
				String detalle = resultado.getString("detalleAsamblea");
				String resumen = resultado.getString("resumenAsamblea");
				LocalDate fecha = resultado.getDate("fechaAsamblea").toLocalDate();
				

				Reunion r = new Reunion(id, tema, detalle, resumen, fecha);
				lasReuniones.add(r);
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
		return lasReuniones;

	}
	
}
