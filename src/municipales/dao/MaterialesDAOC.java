package municipales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import municipales.modelo.Material;
import municipales.modelo.MaterialInstitucional;
import municipales.modelo.MaterialdePropuestas;
import municipales.modelo.Propuesta;
import municipales.dao.*;

public class MaterialesDAOC extends DAO {

	public void altaMatPropuesta(MaterialdePropuestas mat) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("INSERT INTO material (tituloMaterial, categoriaMaterial, descripcionMaterial, fuenteMaterial, enlaceAlDocMaterial, esMaterialPrioritario, idPropuestaAsoc) VALUES (?,?,?,?,?,?,?);");

			PreparedStatement pStmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, mat.getTitulo());
			CategoriaDAO cDao = new CategoriaDAO();
			int idCategoria = cDao.verCatsconF(mat.getCategoria());
			pStmt.setInt(2, idCategoria);
			pStmt.setString(3, mat.getDescripcion());
			pStmt.setString(4, mat.getFuente());
			pStmt.setString(5, mat.getEnlaceAlDoc());
			pStmt.setString(6, mat.getEsPrioritario());

			pStmt.executeUpdate();

			int idPropuesta = 0;
			ResultSet generatedKeys = pStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				idPropuesta = generatedKeys.getInt(1);
			}

			PropuestaDAO pDao = new PropuestaDAO();
			for (Propuesta p : mat.getPropuestasAsoc()) {
				int idPropuesta2 = pDao.obtenerIDPorTitulo(p);
				pStmt.setInt(7, idPropuesta2);

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
	}

	public void altaMatInstitucional(MaterialInstitucional mat) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("INSERT INTO material (tituloMaterial, categoriaMaterial, descripcionMaterial, fuenteMaterial, enlaceAlDocMaterial, esMaterialPrioritario, Procedencia) VALUES (?,?,?,?,?,?,?);");

			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, mat.getTitulo());
			CategoriaDAO cDao = new CategoriaDAO();
			int idCategoria = cDao.verCatsconF(mat.getCategoria());
			pStmt.setInt(2, idCategoria);
			pStmt.setString(3, mat.getDescripcion());
			pStmt.setString(4, mat.getFuente());
			pStmt.setString(5, mat.getEnlaceAlDoc());
			pStmt.setString(6, mat.getEsPrioritario());
			System.out.println(mat.getProcedencia());
			pStmt.setString(7, mat.getProcedencia());

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

	public void baja(String titulo) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("DELETE FROM material WHERE tituloMaterial =  ? ;");
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, titulo);
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

	public void modificacionMatPropuesta(Material mat, int numeroMaterial) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("UPDATE material SET tituloMaterial = ? , categoriaMaterial = ?, descripcionMaterial = ?, fuenteMaterial = ?, enlaceAlDocMaterial = ?, esMaterialPrioritario = ?, idPropuestaAsoc = ? WHERE idMaterial = ?;");
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, mat.getTitulo());
			CategoriaDAO cDao = new CategoriaDAO();
			int idCategoria = cDao.verCatsconF(mat.getCategoria());
			pStmt.setInt(2, idCategoria);
			pStmt.setString(3, mat.getDescripcion());
			pStmt.setString(4, mat.getFuente());
			pStmt.setString(5, mat.getEnlaceAlDoc());
			pStmt.setString(6, mat.getEsPrioritario());
			// hay que cargar la propuesta asignada pStmt.setString(7, mat.get);
			pStmt.setInt(8, numeroMaterial);

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

	public void modificacionMatInsti(MaterialInstitucional mat, int numeroMaterial) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("UPDATE material SET tituloMaterial = ? , categoriaMaterial = ?, descripcionMaterial = ?, fuenteMaterial = ?, enlaceAlDocMaterial = ?, esMaterialPrioritario = ?, Procedencia = ? WHERE idMaterial = ?;");
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, mat.getTitulo());
			CategoriaDAO cDao = new CategoriaDAO();
			int idCategoria = cDao.verCatsconF(mat.getCategoria());
			pStmt.setInt(2, idCategoria);
			pStmt.setString(3, mat.getDescripcion());
			pStmt.setString(4, mat.getFuente());
			pStmt.setString(5, mat.getEnlaceAlDoc());
			pStmt.setString(6, mat.getEsPrioritario());
			pStmt.setString(7, mat.getProcedencia());
			pStmt.setInt(8, numeroMaterial);

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

	public ArrayList<Material> verSauron() {
		ArrayList<Material> materiales = new ArrayList<Material>();
		Connection c = null;
		try {
			c = conectar();
			String sql = ("SELECT tituloMaterial, categoriaMaterial, descripcionMaterial, fuenteMaterial, enlaceAlDocMaterial, esMaterialPrioritario, procedencia FROM material");
			Statement stmt = c.createStatement();

			ResultSet resultado = stmt.executeQuery(sql);

			while (resultado.next()) {

				String titulo = resultado.getString("tituloMaterial");
				String categoriaMaterial = resultado.getString("categoriaMaterial");
				String descripcionMaterial = resultado.getString("descripcionMaterial");
				String fuenteMaterial = resultado.getString("fuenteMaterial");
				String enlaceAlDocMaterial = resultado.getString("enlaceAlDocMaterial");
				String esMaterialPrioritario = resultado.getString("esMaterialPrioritario");
				String procedencia = resultado.getString("procedencia");
				MaterialInstitucional mat = new MaterialInstitucional(titulo, categoriaMaterial, descripcionMaterial,
						fuenteMaterial, enlaceAlDocMaterial, esMaterialPrioritario, procedencia);
				materiales.add(mat);
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
		return materiales;

	}

	/*
	 * public ArrayList<MaterialdePropuestas> verMatsDePropuestas() {
	 * ArrayList<MaterialdePropuestas> materialesDePropuestas = new
	 * ArrayList<MaterialdePropuestas>(); Connection c = null; try { c = conectar();
	 * String sql =
	 * ("SELECT tituloMaterial FROM material WHERE procedencia = ''; "); Statement
	 * stmt = c.createStatement();
	 * 
	 * ResultSet resultado = stmt.executeQuery(sql);
	 * 
	 * while (resultado.next()) {
	 * 
	 * String titulo = resultado.getString("tituloMaterial");
	 * 
	 * MaterialdePropuestas mat = new MaterialdePropuestas(titulo);
	 * materialesDePropuestas.add(mat); }
	 * 
	 * } catch (SQLException ex) { // TODO Auto-generated catch block
	 * ex.printStackTrace(); } finally { try { if (c != null) { c.close(); } } catch
	 * (SQLException ex) { // TODO Auto-generated catch block ex.printStackTrace();
	 * } } return materialesDePropuestas;
	 * 
	 * }
	 */

	public ArrayList<MaterialInstitucional> verMatsInstitucionales() {
		ArrayList<MaterialInstitucional> materialesInstitucionales = new ArrayList<MaterialInstitucional>();
		Connection c = null;
		try {
			c = conectar();
			String sql = ("SELECT idMaterial, tituloMaterial, categoriaMaterial, descripcionMaterial, fuenteMaterial, enlaceAlDocMaterial, esMaterialPrioritario, Procedencia FROM material WHERE Procedencia <> '';");
			Statement stmt = c.createStatement();

			ResultSet resultado = stmt.executeQuery(sql);

			while (resultado.next()) {
				String numMat = resultado.getString("idMaterial");
				String titulo = resultado.getString("tituloMaterial");
				String categoriaMaterial = resultado.getString("categoriaMaterial");
				String descripcionMaterial = resultado.getString("descripcionMaterial");
				String fuenteMaterial = resultado.getString("fuenteMaterial");
				String enlaceAlDocMaterial = resultado.getString("enlaceAlDocMaterial");
				String esMaterialPrioritario = resultado.getString("esMaterialPrioritario");
				String procedencia = resultado.getString("Procedencia");
				MaterialInstitucional mat = new MaterialInstitucional(titulo, categoriaMaterial, descripcionMaterial,
						fuenteMaterial, enlaceAlDocMaterial, esMaterialPrioritario, procedencia, numMat);
				materialesInstitucionales.add(mat);
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
		return materialesInstitucionales;

	}

	public ArrayList<String> traerIDporTituloMats(ArrayList<String> materialAsignado) {
		ArrayList<String> idMateriales = new ArrayList<String>();
		Connection c = null;
		try {
			c = conectar();

			for (String hola : materialAsignado) {
				String sql = ("SELECT idMaterial FROM material WHERE tituloMaterial = ? ;");
				PreparedStatement pStmt = c.prepareStatement(sql);
				pStmt.setString(1, hola);
				ResultSet resultado = pStmt.executeQuery();
				if (resultado.next()) {

					idMateriales.add(resultado.getString("idMaterial"));
				}
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
		return idMateriales;

	}

	public void asignarMatsPropuestas(ArrayList<String> idMats, String titulo) {

		Connection c = null;
		c = conectar();
		try {

			for (String hola : traerIDporTituloMats(idMats)) {
				String sql = ("INSERT INTO material_propuesta (MATERIAL_idMaterial, PROPUESTA_idPropuesta) VALUES (?,?);");
				PreparedStatement pStmt = c.prepareStatement(sql);
				pStmt.setString(1, hola);
				PropuestaDAO pDAO = new PropuestaDAO();
				pStmt.setInt(2, pDAO.traerIDporTitulo(titulo));
				pStmt.executeUpdate();

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
	}

	public int obtenerMatPorTitulo(MaterialInstitucional mat) {
		return 0;
	}

}
