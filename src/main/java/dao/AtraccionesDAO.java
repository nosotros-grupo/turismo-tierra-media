package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import jdbc.ConnectionProvider;
import tierraMedia.Atraccion;
import tierraMedia.TipoAtraccion;

public class AtraccionesDAO {
	protected static TreeMap<Integer, Atraccion> map = new TreeMap<Integer, Atraccion>();
	
	
	public static LinkedList<Atraccion> findAll() throws SQLException {
		String sql = "SELECT * FROM atracciones";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		
		
		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
		while (resultados.next()) {
			atracciones.add(toAtraccion(resultados));
			map.put(resultados.getInt(6), toAtraccion(resultados));
		}
		conn.close();
		return atracciones;
	}
	
	private static Atraccion toAtraccion(ResultSet resultados) throws SQLException {
		return new Atraccion(resultados.getString(1), resultados.getInt(2), resultados.getDouble(3),resultados.getInt(4), TipoAtraccion.valueOf(resultados.getString(5).toUpperCase()), resultados.getInt(6));
	}
	
	public static void actualizarAtracciones(List<Atraccion> atracciones) throws SQLException {
		String sql = "UPDATE atracciones SET cupoDePersonasDiario = ? WHERE nombre = ?";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		for (int i = 0; i < atracciones.size(); i++) {
			statement.setInt(1, atracciones.get(i).getCupoDePersonasDiario());
			statement.setString(2, atracciones.get(i).getNombre());
			statement.executeUpdate();
		}
		conn.close();
	}

}
