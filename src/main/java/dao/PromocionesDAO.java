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

public class PromocionesDAO {

	public static LinkedList<Promocion> findAll(List<Atraccion> listaAtracciones) throws SQLException {
		String sql = "SELECT * FROM promocionabsoluta";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		LinkedList<Promocion> promociones = new LinkedList<Promocion>();
		while (resultados.next()) {
			promociones.add(toPromocionAbsoluta(resultados, listaAtracciones));
		}
		sql = "SELECT * FROM promocionporcentual";
		statement = conn.prepareStatement(sql);
		resultados = statement.executeQuery();
		while (resultados.next()) {
			promociones.add(toPromocionPorcentual(resultados, listaAtracciones));
		}
		sql = "SELECT * FROM promocionaxb";
		statement = conn.prepareStatement(sql);
		resultados = statement.executeQuery();
		while (resultados.next()) {
			promociones.add(toPromocionAxB(resultados, listaAtracciones));
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
		return new PromocionAbsoluta(resultados.getInt(1), atracciones);
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
		return new PromocionPorcentual(resultados.getDouble(2), atracciones);
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
		return new PromocionAxB(atraccionesPagas, atraccionesBonificadas);
	}
}
