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

public class UsuariosDAO {

	public static void cargarItinerario (Usuario usuario,  TreeMap <Integer, Atraccion> itinerarios) {
		usuario.agregarAtraccion(itinerarios.get(usuario.getId()));
	}

	public static LinkedList<Usuario> findAll() throws SQLException {
		String sql = "SELECT * FROM usuarios";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
		while (resultados.next()) {
			Usuario userTemp = toUser(resultados);
			Gl.usuarioMap.put(resultados.getInt(5), userTemp);
			usuarios.add(userTemp);
		}
		conn.close();
		return usuarios;

	}

	private static Usuario toUser(ResultSet resultados) throws SQLException {
		return new Usuario(resultados.getInt(1), resultados.getDouble(2),
				TipoAtraccion.valueOf(resultados.getString(3)), resultados.getString(4), resultados.getInt(5));
	}

	public static void actualizarUsuarios(Usuario usuario) throws SQLException {
		String sql = "UPDATE usuarios SET presupuesto = ?, tiempoDisponible = ? WHERE Nombre = ?";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, usuario.getPresupuesto());
		statement.setDouble(2, usuario.getTiempoDisponible());
		statement.setString(3, usuario.getName());
		statement.executeUpdate();

		conn.close();
	}
}
