package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import tierraMedia.Atraccion;
import tierraMedia.TipoAtraccion;

public class AtraccionesDAO {
	public static LinkedList<Atraccion> findAll() throws SQLException {
		String sql = "SELECT * FROM atracciones";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
		while (resultados.next()) {
			atracciones.add(toAtraccion(resultados));
		}
		return atracciones;
	}
	private static Atraccion toAtraccion(ResultSet resultados) throws SQLException {
		return new Atraccion(resultados.getString(1), resultados.getInt(2), resultados.getDouble(3),resultados.getInt(4), TipoAtraccion.valueOf(resultados.getString(5).toUpperCase()));
	}

}
