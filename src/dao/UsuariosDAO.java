package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import tierraMedia.Usuario;
import tierraMedia.TipoAtraccion;

public class UsuariosDAO {
	public static LinkedList<Usuario> findAll() throws SQLException {
		String sql = "SELECT * FROM usuarios";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
		while (resultados.next()) {
			usuarios.add(toUser(resultados));
		}

		return usuarios;
	
	}
	private static Usuario toUser(ResultSet resultados) throws SQLException {
		return new Usuario(resultados.getInt(1), resultados.getDouble(2), TipoAtraccion.valueOf(resultados.getString(3)), resultados.getString(4));
	}
}

