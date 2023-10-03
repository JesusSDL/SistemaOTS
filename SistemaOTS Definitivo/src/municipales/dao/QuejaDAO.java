package municipales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import municipales.modelo.*;

public class QuejaDAO extends DAOHerenceR {

	public void alta(Queja qj) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("INSERT INTO Queja (descripcion, nombreApellido, añoDivision) VALUES(?,?,?);");
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, qj.getDescripcion());
			pStmt.setString(2, qj.getNombreApellido());
			pStmt.setString(3, qj.getCursoDivision());
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

	public void modificacion(Queja qj, int id) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("UPDATE queja SET descripcion = ?, nombreApellido= ?, añoDivision= ? WHERE idQueja = ?;");
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, qj.getDescripcion());
			pStmt.setString(2, qj.getNombreApellido());
			pStmt.setString(3, qj.getCursoDivision());
			pStmt.setInt(5, id);
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

	public void baja(Queja qj) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("DELETE FROM queja WHERE idqueja = ?;");

			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setInt(1, qj.getIdQueja());

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

	public ArrayList<Queja> verSauron() {
		ArrayList<Queja> lasQuejas = new ArrayList<Queja>();
		Connection c = null;
		try {
			c = conectar();
			String sql = ("SELECT idQueja, descripcion, nombreApellido, añoDivision FROM queja;");
			Statement stmt = c.createStatement();

			ResultSet resultado = stmt.executeQuery(sql);

			while (resultado.next()) {

				int id = resultado.getInt("idQueja");
				String descripcion = resultado.getString("descripcion");
				String nombreApellido = resultado.getString("nombreApellido");
				String añoDivision = resultado.getString("añoDivision");

				Queja qj = new Queja(id, descripcion, nombreApellido, añoDivision);
				lasQuejas.add(qj);
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
		return lasQuejas;

	}
}
