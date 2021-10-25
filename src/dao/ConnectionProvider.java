package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static String url = "jdbc:sqlite:db.sqlite";
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url);			
		}
		return connection;
	}
	
	// para cerrar la conexion con la BDD y que no haya errores. (lo hicimos con fabian en clase) 
	public static void cerrarConexion() throws SQLException {
		if(!connection.isClosed()) {
			connection.close();
		}
	}
}
