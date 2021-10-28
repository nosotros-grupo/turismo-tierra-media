package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.TreeMap;

import jdbc.ConnectionProvider;
import tierraMedia.Atraccion;
import tierraMedia.TipoAtraccion;
import tierraMedia.Usuario;

public class ItinerariosDAO {
	
	public static TreeMap<Integer, LinkedList<Atraccion>> findAll() throws SQLException {
		String sql = "SELECT itinerario.id_usuario, itinerario.id_atraccion FROM itinerario";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		
		TreeMap<Integer, LinkedList<Atraccion>> itinerarios = new TreeMap<Integer, LinkedList<Atraccion>>();
		while (resultados.next()) {
			itinerarios.put(resultados.getInt(1), lista.add(resultado.getInt(2)) );
		}
		conn.close();
		return itinerarios;
	}
	
	
	
	/*
	public static TreeMap<Integer, LinkedList<Atraccion>> findAll() throws SQLException {
		String sql = "SELECT itinerario.id_usuario as id_usuario, atracciones.* FROM itinerario JOIN atracciones ON itinerario.id_atraccion = atracciones.id_atraccion";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		
		TreeMap<Integer, LinkedList<Atraccion>> itinerarios = new TreeMap<Integer, LinkedList<Atraccion>>();
		while (resultados.next()) {
			itinerarios.put(resultados.getInt(1), toItinerarioAtraccion(resultados) );
		}
		conn.close();
		return itinerarios;
	}
	*/
	
	private static Atraccion toItinerarioAtraccion(ResultSet resultados) throws SQLException {
		return new Atraccion(resultados.getString(2), resultados.getInt(3), resultados.getDouble(4),resultados.getInt(5), TipoAtraccion.valueOf(resultados.getString(6).toUpperCase()), resultados.getInt(7));
	}
	
	public static void actualizarItinerarios(Usuario usuario) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		String sql = "INSERT INTO itinerario (id_usuario, id_atraccion) VALUES (?,?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, usuario.getId());
		for (int i = 0; i < usuario.getItinerario().size(); i++) {
			statement.setInt(2, usuario.getItinerario().get(i).getId());
			statement.executeUpdate();
		}
		conn.close();
	}
}
