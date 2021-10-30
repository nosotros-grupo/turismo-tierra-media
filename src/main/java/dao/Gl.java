package dao;

import java.util.LinkedList;
import java.util.TreeMap;

import tierraMedia.Atraccion;
import tierraMedia.Promocion;
import tierraMedia.Usuario;

/**
 * ultima revision 30-10-21
 */
public class Gl {

	// relacion entre id_atraccion y objeto Atraccion
	static TreeMap<Integer, Atraccion> atraccionMap = new TreeMap<Integer, Atraccion>();

	// relacion entre id_usuario y objeto Usuario
	static TreeMap<Integer, Usuario> usuarioMap = new TreeMap<Integer, Usuario>();

	// relacion entre id_promocion y objeto Promocion
	static TreeMap<Integer, Promocion> promoMap = new TreeMap<Integer, Promocion>();
}
