package municipales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import municipales.modelo.Categoria;

public class CategoriaDAO extends DAO {

	public ArrayList<Categoria> verCats() {
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		Connection c = null;
		try {
			c = conectar();
			
			String sql = ("SELECT NomCategoria FROM categoria ORDER BY idCATEGORIA");

			Statement stmt = c.createStatement();

			ResultSet resultado = stmt.executeQuery(sql);

			while (resultado.next()) {

				String nombreCat = resultado.getString("NomCategoria");
				Categoria cat = new Categoria(nombreCat);
				categorias.add(cat);
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
		return categorias;

	}

	public int verCatsconF(Categoria cat) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("SELECT idCATEGORIA FROM categoria WHERE NomCategoria = ? ");

			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, cat.getNomCategoria());

			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				return rs.getInt("idCATEGORIA");
				
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

	public int verCatsconF(String nombreCategoria) {
		Categoria c = new Categoria(nombreCategoria);
		return verCatsconF(c);
		
	}
}
