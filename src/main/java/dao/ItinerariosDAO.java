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

		TreeMap<Integer, LinkedList<Atraccion>> mapaItinerarios;
		mapaItinerarios = new TreeMap<Integer, LinkedList<Atraccion>>();
		LinkedList<Atraccion> listaAtracciones = null;

		String sql = "SELECT itinerario.id_usuario, itinerario.id_atraccion FROM itinerario";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		while (resultados.next()) {
			// cada resultado se compone de id_atraccion, id_usuario
			// se convierten en Atraccion, Usuario
			Atraccion resultadosAtraccion = Gl.atraccionMap.get(resultados.getInt(1));
			Usuario resultadosUsuario = Gl.usuarioMap.get(resultados.getInt(2));

			// se agrega a la lista del itinerario del usuario
			resultadosUsuario.getItinerario().add(resultadosAtraccion);

			// se agrega la atraccion a la lista de Atracciones
			listaAtracciones.add(resultadosAtraccion);
			mapaItinerarios.replace(resultados.getInt(1), listaAtracciones);

		}
		conn.close();

		return mapaItinerarios;
	}

	/*
	 * public static TreeMap<Integer, LinkedList<Atraccion>> findAll() throws
	 * SQLException { String sql =
	 * "SELECT itinerario.id_usuario as id_usuario, atracciones.* FROM itinerario JOIN atracciones ON itinerario.id_atraccion = atracciones.id_atraccion"
	 * ; Connection conn = ConnectionProvider.getConnection(); PreparedStatement
	 * statement = conn.prepareStatement(sql); ResultSet resultados =
	 * statement.executeQuery();
	 * 
	 * TreeMap<Integer, LinkedList<Atraccion>> itinerarios = new TreeMap<Integer,
	 * LinkedList<Atraccion>>(); while (resultados.next()) {
	 * itinerarios.put(resultados.getInt(1), toItinerarioAtraccion(resultados) ); }
	 * conn.close(); return itinerarios; }
	 */

	private static Atraccion toItinerarioAtraccion(ResultSet resultados) throws SQLException {
		return new Atraccion(resultados.getString(2), resultados.getInt(3), resultados.getDouble(4),
				resultados.getInt(5), TipoAtraccion.valueOf(resultados.getString(6).toUpperCase()),
				resultados.getInt(7));
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
