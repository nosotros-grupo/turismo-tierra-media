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
			for (int j = 0; j < productos.size(); j++) {
				Producto producto = productos.get(j);
				if (esPrimeraOpcion(producto, usuario)) {
					System.out.println("Desea adquirir " + producto.toString() + "?");
						System.out.println("Pulse S para si, N para no.");
						String respuesta = sc.nextLine();
						while(!esRespuestaAceptable(respuesta)) {
							System.out.println("\n\nNo ha ingresado una respuesta procesable.\nRecuerde S para Si, N para no.");
							respuesta = sc.nextLine();
						}
						if (respuesta.toUpperCase().equals("S")) {
							usuario.compra(producto);
							System.out.println("Gracias por su compra!\n");
							
						} else if (respuesta.toUpperCase().equals("N")) {
							System.out.println("De acuerdo!\n");
						}
					}
				}
			for (int j = 0; j < productos.size(); j++) {
				Producto producto = productos.get(j);
				if (esOpcionAlternativa(producto, usuario)) {
					System.out.println("Le podemos ofrecer " + producto.toString()
							+ "\nSabemos que no es de su preferencia.\nPulse S para si, N para no.");
					String respuesta = sc.nextLine();
					while(!esRespuestaAceptable(respuesta)) {
						System.out.println("No ha ingresado una respuesta procesable.\n Recuerde S para Si, N para no.");
						respuesta = sc.nextLine();
					}
					if (respuesta.toUpperCase().equals("S")) {
						usuario.compra(producto);
						System.out.println("Gracias por su compra!\n");
					} else if (respuesta.toUpperCase().equals("N")) {
						System.out.println("De acuerdo!\n");
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
	
	public static boolean esPrimeraOpcion(Producto producto, Usuario usuario) {
		return producto.getTipoDeAtraccion() == usuario.getTipoPreferidoDeAtraccion()
				&& usuario.getPresupuesto() >= producto.getCostoDeVisita()
				&& usuario.getTiempoDisponible() >= producto.getTiempoPromedioDeVisita()
				&& Collections.disjoint(usuario.getItinerario(), producto.getListaDeAtracciones())
				&& producto.tieneCupo();
	}
	
	public static boolean esOpcionAlternativa(Producto producto, Usuario usuario) {
		return producto.getTipoDeAtraccion() != usuario.getTipoPreferidoDeAtraccion()
				&& usuario.getPresupuesto() >= producto.getCostoDeVisita()
				&& usuario.getTiempoDisponible() >= producto.getTiempoPromedioDeVisita()
				&& Collections.disjoint(usuario.getItinerario(), producto.getListaDeAtracciones())
				&& producto.tieneCupo();
	}
	
	public static boolean esRespuestaAceptable(String respuesta) {
		return respuesta.toUpperCase().equals("S") || respuesta.toUpperCase().equals("N");
	}
}
