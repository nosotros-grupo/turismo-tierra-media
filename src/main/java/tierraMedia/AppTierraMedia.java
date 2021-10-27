package tierraMedia;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import dao.AtraccionesDAO;
import dao.PromocionesDAO;
import dao.UsuariosDAO;

/**
 * 
 * @author nosotros.grupo
 *
 */
public class AppTierraMedia {
	private static LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
	private static LinkedList<Producto> productos = new LinkedList<Producto>();

	// app principal
	public static void main(String[] args) throws IOException, SQLException {
		List<Promocion> promociones = new ArrayList<Promocion>();
		List<Atraccion> atracciones = new ArrayList<Atraccion>();

		Scanner sc = new Scanner(System.in);

		// se traen los datos a las listas desde la DB
		usuarios.addAll(UsuariosDAO.findAll());
		atracciones.addAll(AtraccionesDAO.findAll());
		promociones.addAll(PromocionesDAO.findAll(atracciones));

		// se genera la lista de productos y se lo ordena
		productos = new LinkedList<Producto>();
		productos.addAll(atracciones);
		productos.addAll(promociones);
		Collections.sort(productos);

		for (int i = 0; i < usuarios.size(); i++) {
			Usuario usuario = usuarios.get(i);
			System.out.print("\n\n\n\n  == Presiona una tecla para continuar ==       ");
			sc.nextLine();
			System.out.print("\n\n");

			System.out.println("Bienvenido, " + usuarios.get(i).getName() + "!\n\n");
			for (int i2 = 0; i2 < productos.size(); i2++) {
				Producto producto = productos.get(i2);
				if (producto.getTipoDeAtraccion() == usuario.getTipoPreferidoDeAtraccion()
						&& usuario.getPresupuesto() >= producto.getCostoDeVisita()
						&& usuario.getTiempoDisponible() >= producto.getTiempoPromedioDeVisita()
						&& Collections.disjoint(usuario.getItinerario(), producto.getListaDeAtracciones())) {
					System.out.println("Desea adquirir " + producto.toString() + "?");
					boolean saleDelDo = false;
					do {
						System.out.println("Pulse S para si, N para no.");
						String acepta = sc.nextLine();
						if (acepta.toUpperCase().equals("S")) {
							usuario.compra(producto);
							System.out.println("Gracias por su compra!\n");
							saleDelDo = true;
						} else if (acepta.toUpperCase().equals("N")) {
							System.out.println("De acuerdo!\n");
							saleDelDo = true;
						}
					} while (!saleDelDo);
				}
			}
			// Cambiar la logica de ordenar las atracciones
			for (int i2 = 0; i2 < productos.size(); i2++) {
				Producto producto = productos.get(i2);
				if (producto.getTipoDeAtraccion() != usuario.getTipoPreferidoDeAtraccion()
						&& usuario.getPresupuesto() >= producto.getCostoDeVisita()
						&& usuario.getTiempoDisponible() >= producto.getTiempoPromedioDeVisita()
						&& Collections.disjoint(usuario.getItinerario(), producto.getListaDeAtracciones())) {
					System.out.println("Le podemos ofrecer " + producto.toString()
							+ "\nSabemos que no es de su preferencia.\nPulse S para si, N para no.");
					String acepta = sc.nextLine();
					if (acepta.toUpperCase().equals("S")) {
						usuario.compra(producto);
						System.out.println("Gracias por su compra!\n");
					}
				}
			}
			UsuariosDAO.escribirUsuario(usuario);
			EscritorUsuarios.escribirUsuariosTxt(usuario, i);
		}
		AtraccionesDAO.escribirAtracciones(atracciones);
		sc.close();
		System.out.println();
	}
}
