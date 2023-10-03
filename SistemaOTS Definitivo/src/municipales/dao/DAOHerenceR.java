package municipales.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DAOHerenceR {
	
	public Connection conectar() {
		String url = "jdbc:mysql://localhost:3306/reuniones";
		String usr = "root";
		String pass = "Administrador.";
		Connection c = null;
		try {
			c = DriverManager.getConnection(url, usr, pass);
		} catch (SQLException ex) {

			ex.printStackTrace();
		}
		return c;

	}
}
