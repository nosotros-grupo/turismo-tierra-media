package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import tierraMedia.Atraccion;
import tierraMedia.Promocion;
import tierraMedia.PromocionAbsoluta;
import tierraMedia.PromocionAxB;
import tierraMedia.PromocionPorcentual;

/**
 * ultima revision 30-10-21
 */
public class PromocionesDAO {

	public static LinkedList<Promocion> findAll(List<Atraccion> listaAtracciones) throws SQLException {
		// Lista de Promos
		LinkedList<Promocion> promociones = new LinkedList<Promocion>();

		// se conecta la BD
		Connection conn = ConnectionProvider.getConnection();

		// se recuperan las promociones absolutas desde la BD
		String sql = "SELECT * FROM promocionabsoluta";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		// se agregan las promociones absolutas al listado de promociones
		while (resultados.next()) {
			Promocion promoTemp = toPromocionAbsoluta(resultados, listaAtracciones);
			promociones.add(promoTemp);

			Gl.promoMap.put(resultados.getInt(3), promoTemp);
		}

		// se recuperan las promociones porcentuales desde la BD
		sql = "SELECT * FROM promocionporcentual";
		statement = conn.prepareStatement(sql);
		resultados = statement.executeQuery();

		// se agregan las promociones porcentuales al listado de promociones
		while (resultados.next()) {
			Promocion promoTemp = toPromocionPorcentual(resultados, listaAtracciones);
			promociones.add(promoTemp);

			Gl.promoMap.put(resultados.getInt(3), promoTemp);
		}

		// se recuperan las promociones AxB desde la BD
		sql = "SELECT * FROM promocionaxb";
		statement = conn.prepareStatement(sql);
		resultados = statement.executeQuery();

		// se agregan las promociones AxB al listado de promociones
		while (resultados.next()) {
			Promocion promoTemp = toPromocionAxB(resultados, listaAtracciones);
			promociones.add(promoTemp);

			Gl.promoMap.put(resultados.getInt(3), promoTemp);
		}
		conn.close();
		return promociones;

	}

	private static PromocionAbsoluta toPromocionAbsoluta(ResultSet resultados, List<Atraccion> listaAtracciones)
			throws SQLException {

		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
		String atraccionesAsString = resultados.getString(2);
		for (Atraccion i : listaAtracciones) {
			if (atraccionesAsString.contains(i.getNombre())) {
				atracciones.add(i);
			}
		}
		return new PromocionAbsoluta(resultados.getInt(1), atracciones, resultados.getString(4));
	}

	private static PromocionPorcentual toPromocionPorcentual(ResultSet resultados, List<Atraccion> listaAtracciones)
			throws SQLException {
		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
		String atraccionesAsString = resultados.getString(1);
		for (Atraccion i : listaAtracciones) {
			if (atraccionesAsString.contains(i.getNombre())) {
				atracciones.add(i);
			}
		}
		return new PromocionPorcentual(resultados.getDouble(2), atracciones, resultados.getString(4));
	}

	private static PromocionAxB toPromocionAxB(ResultSet resultados, List<Atraccion> listaAtracciones)
			throws SQLException {
		ArrayList<Atraccion> atraccionesPagas = new ArrayList<Atraccion>();
		String atraccionesPagasAsString = resultados.getString(1);
		for (Atraccion i : listaAtracciones) {
			if (atraccionesPagasAsString.contains(i.getNombre())) {
				atraccionesPagas.add(i);
			}
		}
		ArrayList<Atraccion> atraccionesBonificadas = new ArrayList<Atraccion>();
		String atraccionesBonificadasAsString = resultados.getString(2);
		for (Atraccion i : listaAtracciones) {
			if (atraccionesBonificadasAsString.contains(i.getNombre())) {
				atraccionesBonificadas.add(i);
			}
		}
		return new PromocionAxB(atraccionesPagas, atraccionesBonificadas, resultados.getString(4));
	}
}
