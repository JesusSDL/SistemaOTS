package municipales.dao;

import java.sql.Connection;
import java.sql.Date;
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

public class PropuestaDAO extends DAO {

	public void alta(Propuesta p) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("INSERT INTO propuesta (origenPropuesta, tituloPropuesta, categoria, breveDescripcion, autorPropuesta, fechaPropuesta, estadoPropuesta) VALUES(?, ?, ?, ?, ?, ?, ?)");

			Date fecha = Date.valueOf(p.getFecha());
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, p.getOrigen());
			pStmt.setString(2, p.getTitulo());
			CategoriaDAO cDao = new CategoriaDAO();
			int idCategoria = cDao.verCatsconF(p.getCat());
			pStmt.setInt(3, idCategoria);
			pStmt.setString(4, p.getDescripcion());
			pStmt.setString(5, p.getAutor());
			pStmt.setDate(6, fecha);
			pStmt.setString(7, p.getEstado());


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
			String sql = ("DELETE FROM propuesta WHERE tituloPropuesta =  ? ;");
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

	public void modificacion(Propuesta p, int numeroPropuesta) {
		Connection c = null;
		try {
			c = conectar();
			String sql = ("UPDATE propuesta SET origenPropuesta = ?, tituloPropuesta = ? ,categoria = ?, breveDescripcion = ?, autorPropuesta = ?, fechaPropuesta = ?, estadoPropuesta = ?, motivoRechazo = ? WHERE idPropuesta = ?;");
			PreparedStatement pStmt = c.prepareStatement(sql);

			pStmt.setString(1, p.getOrigen());
			pStmt.setString(2, p.getTitulo());
			pStmt.setString(3, p.getCat());
			pStmt.setString(4, p.getDescripcion());
			pStmt.setString(5, p.getAutor());
			Date fecha = Date.valueOf(p.getFecha());
			pStmt.setDate(6, fecha);
			pStmt.setString(7, p.getEstado());
			pStmt.setString(8, p.getMotivo());
		
			pStmt.setInt(10, numeroPropuesta);

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

	public ArrayList<Propuesta> verSauron() {
		ArrayList<Propuesta> propuestas = new ArrayList<Propuesta>();
		Connection c = null;
		try {
			c = conectar();
			String sql = ("SELECT idPropuesta,  origenPropuesta, tituloPropuesta, categoria, breveDescripcion, autorPropuesta, fechaPropuesta, estadoPropuesta, motivoRechazo FROM propuesta");
			Statement stmt = c.createStatement();

			ResultSet resultado = stmt.executeQuery(sql);

			while (resultado.next()) {

				int id = resultado.getInt("idPropuesta");
				String origen = resultado.getString("origenPropuesta");
				String titulo = resultado.getString("tituloPropuesta");
				String cat = Integer.toString(resultado.getInt("categoria"));
				String descripcion = resultado.getString("breveDescripcion");
				String autor = resultado.getString("autorPropuesta");
				LocalDate fecha = resultado.getDate("fechaPropuesta").toLocalDate();
				String estado = resultado.getString("estadoPropuesta");
				String motivo = resultado.getString("motivoRechazo");
				

				Propuesta p = new Propuesta(id, origen, titulo, cat, descripcion, autor, fecha, estado, motivo);
				propuestas.add(p);
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
		return propuestas;

	}

	public ArrayList<Propuesta> verPendientes() {
		ArrayList<Propuesta> propuestas = new ArrayList<Propuesta>();
		Connection c = null;
		try {
			c = conectar();
			String sql = ("SELECT origenPropuesta, tituloPropuesta, categoria, breveDescripcion, autorPropuesta, fechaPropuesta, estadoPropuesta, motivoRechazo FROM propuesta WHERE estadoPropuesta = LOWER('pendiente');");
			Statement stmt = c.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);

			while (resultado.next()) {

				String origen = resultado.getString("origenPropuesta");
				String titulo = resultado.getString("tituloPropuesta");
				String cat = Integer.toString(resultado.getInt("categoria"));
				String descripcion = resultado.getString("breveDescripcion");
				String autor = resultado.getString("autorPropuesta");
				LocalDate fecha = resultado.getDate("fechaPropuesta").toLocalDate();
				String estado = resultado.getString("estadoPropuesta");
				String motivo = resultado.getString("motivoRechazo");
				

				Propuesta p = new Propuesta(origen, titulo, cat, descripcion, autor, fecha, estado, motivo);
				propuestas.add(p);
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
		return propuestas;

	}

	public ArrayList<Propuesta> verAprobadas() {
		ArrayList<Propuesta> propuestas = new ArrayList<Propuesta>();
		Connection c = null;
		try {
			c = conectar();
			String sql = ("SELECT origenPropuesta, tituloPropuesta, categoria, breveDescripcion, autorPropuesta, fechaPropuesta, estadoPropuesta, motivoRechazo FROM propuesta WHERE estadoPropuesta = LOWER('aprobada');");
			Statement stmt = c.createStatement();

			ResultSet resultado = stmt.executeQuery(sql);

			while (resultado.next()) {

				String origen = resultado.getString("origenPropuesta");
				String titulo = resultado.getString("tituloPropuesta");
				String cat = Integer.toString(resultado.getInt("categoria"));
				String descripcion = resultado.getString("breveDescripcion");
				String autor = resultado.getString("autorPropuesta");
				LocalDate fecha = resultado.getDate("fechaPropuesta").toLocalDate();
				String estado = resultado.getString("estadoPropuesta");
				String motivo = resultado.getString("motivoRechazo");

				Propuesta p = new Propuesta(origen, titulo, cat, descripcion, autor, fecha, estado, motivo);
				propuestas.add(p);
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
		return propuestas;

	}

	public ArrayList<Propuesta> verRechazadas() {
		ArrayList<Propuesta> propuestas = new ArrayList<Propuesta>();
		Connection c = null;
		try {
			c = conectar();
			String sql = ("SELECT origenPropuesta, tituloPropuesta, categoria, breveDescripcion, autorPropuesta, fechaPropuesta, estadoPropuesta, motivoRechazo FROM propuesta WHERE estadoPropuesta = LOWER('rechazada');");
			Statement stmt = c.createStatement();

			ResultSet resultado = stmt.executeQuery(sql);

			while (resultado.next()) {

				String origen = resultado.getString("origenPropuesta");
				String titulo = resultado.getString("tituloPropuesta");
				String cat = Integer.toString(resultado.getInt("categoria"));
				String descripcion = resultado.getString("breveDescripcion");
				String autor = resultado.getString("autorPropuesta");
				LocalDate fecha = resultado.getDate("fechaPropuesta").toLocalDate();
				String estado = resultado.getString("estadoPropuesta");
				String motivo = resultado.getString("motivoRechazo");

				Propuesta p = new Propuesta(origen, titulo, cat, descripcion, autor, fecha, estado, motivo);
				propuestas.add(p);
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
		return propuestas;

	}

	public ArrayList<Propuesta> verMatsConPropuesta() {
		ArrayList<Propuesta> propuestas = new ArrayList<Propuesta>();
		Connection c = null;
		try {
			c = conectar();
			String sql = ("SELECT propuesta.tituloPropuesta FROM propuesta;");
			Statement stmt = c.createStatement();

			ResultSet resultado = stmt.executeQuery(sql);

			while (resultado.next()) {

				String titulo = resultado.getString("propuesta.tituloPropuesta");

				Propuesta p = new Propuesta(titulo);
				propuestas.add(p);
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
		return propuestas;

	}

	public int traerIDporTitulo(String p) {
		int numPropuesta = 0;
		Connection c = null;
		try {
			c = conectar();

			String sql = ("SELECT idPropuesta FROM propuesta WHERE tituloPropuesta = ?");
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, p);
			ResultSet resultado = pStmt.executeQuery();
			if (resultado.next()) {
				numPropuesta = resultado.getInt("idPropuesta");
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
		return numPropuesta;
	}

	public int obtenerIDPorTitulo(Propuesta p) {
		return 0;
	}

}
