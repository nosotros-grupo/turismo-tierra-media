package tierraMedia;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import dao.UsuariosDAO;
import dao.AtraccionesDAO;
import dao.PromocionesDAO;

public class AppTierraMedia {
	private static LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
	private static LinkedList<Producto> productos = new LinkedList<Producto>();
	
	public static void main(String[] args) throws IOException, SQLException {
		List<Promocion> promociones = new ArrayList<Promocion>();
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		//LectorAtracciones lectorA = new LectorAtracciones();
		//LectorUsuarios lectorU = new LectorUsuarios();
		
		Scanner sc = new Scanner(System.in);
		usuarios.addAll(UsuariosDAO.findAll());
		atracciones.addAll(AtraccionesDAO.findAll());
		promociones.addAll(PromocionesDAO.findAll(atracciones));
		//do {
			//String archivoUsuarios;
			//try{
//				System.out.print(Color.RESET);
//				System.out.print(Color.CYAN_BRIGHT + "Nombre del archivo de " + Color.YELLOW_BRIGHT + "Usuarios"
//						+ Color.CYAN_BRIGHT + "\n    (o " + Color.RED_BOLD_BRIGHT + "\"Enter\"" + Color.CYAN_BRIGHT
//						+ " para el nombre por defecto):");
				//System.out.print("Nombre del archivo de Usuarios\n    (o \"Enter\" para el nombre por defecto):");

				//archivoUsuarios = sc.nextLine();
				// Toma el archivo por defecto
				//if(archivoUsuarios.equals("")) {
				//	archivoUsuarios = "usuarios.in";
				//}
				//usuarios = lectorU.leerUsuarios(archivoUsuarios);
				//if(usuarios.isEmpty()) {
//				//	System.out.println(Color.GREEN_BOLD_BRIGHT);
				//	System.out.println("El archivo no contiene usuarios, intente nuevamente..");
//				//	System.out.print(Color.RESET);
				//	archivoUsuarios = "";
				//}
			//} catch (NullPointerException e) {
//				System.out.println(Color.GREEN_BOLD_BRIGHT);
				//System.out.println("El archivo no existe, presione una tecla para volver a intentarlo..");
//				System.out.print(Color.RESET);
				//archivoUsuarios = "";
			//}
		//} while(usuarios.isEmpty());
		
		// Pregunta el nombre del archivo de Atracciones
		//do {
		//	String archivoAtracciones;
		//	try{
//		//		System.out.print(Color.RESET);
//		//		System.out.print(Color.CYAN_BRIGHT + "Nombre del archivo de " + Color.YELLOW_BRIGHT + "Atracciones"
//		//				+ Color.CYAN_BRIGHT + "\n    (o " + Color.RED_BOLD_BRIGHT + "\"Enter\"" + Color.CYAN_BRIGHT
//		//				+ " para el nombre por defecto):");
		//		System.out.print("Nombre del archivo de Atracciones\n    (o \"Enter\" para el nombre por defecto):");
		//
//
	//			archivoAtracciones = sc.nextLine();
		//		if(archivoAtracciones.equals("")) {
			//		archivoAtracciones = "atracciones.in";
//				}
	//			atracciones = lectorA.leerAtracciones(archivoAtracciones);
		//		System.out.println(atracciones);
			//	if(atracciones.isEmpty()) {
//					System.out.println(Color.GREEN_BOLD_BRIGHT);
			//		System.out.println("El archivo no contiene atracciones, intente nuevamente..");
//					System.out.print(Color.RESET);
	//			}
//			}catch(NullPointerException e) {
//				System.out.println(Color.GREEN_BOLD_BRIGHT);
	//			System.out.println("El archivo no existe, intente nuevamente..");
//				System.out.print(Color.RESET);
		//		archivoAtracciones = "";
			//}
	//	} while(atracciones.isEmpty());
		
		// Pregunta el nombre del archivo de Promociones
//		do {
	//		String archivoPromociones;
		//	try{
//				System.out.print(Color.CYAN_BRIGHT + "Nombre del archivo de " + Color.YELLOW_BRIGHT + "Promociones"
//						+ Color.CYAN_BRIGHT + "\n    (o " + Color.RED_BOLD_BRIGHT + "\"Enter\"" + Color.CYAN_BRIGHT
//						+ " para el nombre por defecto,\n     o " + Color.RED_BOLD_BRIGHT + "\"*\"" + Color.CYAN_BRIGHT
//						+ " si no se desean agregar Promociones):");
//				System.out.print("Nombre del archivo de Promociones\n    (o \"Enter\" para el nombre por defecto,\n     "
	//					+ "o \" * \" si no se desean agregar Promociones): ");
//
	//			LectorPromociones lectorP = new LectorPromociones(atracciones);
				
		//		archivoPromociones = sc.nextLine();
			//	if(archivoPromociones.equals("")) {
				//	archivoPromociones = "promociones.in";
		//		}
//				if(archivoPromociones.equals("n")) {
	//				promociones = null;
		//			break;
			//	}
				//promociones = lectorP.leerPromociones(archivoPromociones);
//				if(promociones.size()<0) {
//					System.out.println(Color.GREEN_BOLD_BRIGHT);
	//				System.out.println("El archivo no contiene promociones, intente nuevamente..");
		//			archivoPromociones = "";
			//	}
	//		}catch(NullPointerException e) {
//				System.out.println(Color.GREEN_BOLD_BRIGHT);
//				System.out.println("El archivo no existe, intente nuevamente..");
////				System.out.print(Color.RESET);
	//			archivoPromociones = "";
		//	}
//		} while(promociones.isEmpty());
		
		productos = new LinkedList<Producto>();
		productos.addAll(atracciones);
		productos.addAll(promociones);
		Collections.sort(productos);
		for(int i = 0;i<usuarios.size();i ++) {
			Usuario usuario = usuarios.get(i);
			System.out.print("\n\n\n\n  == Presiona una tecla para continuar ==       ");
			sc.nextLine();
			System.out.print("\n\n");
			
			System.out.println("Bienvenido, " + usuarios.get(i).getName() + "!\n\n");
			for(int i2 = 0; i2 < productos.size(); i2++) {
				Producto producto = productos.get(i2);
				if(producto.getTipoDeAtraccion() == usuario.getTipoPreferidoDeAtraccion() 
						&& usuario.getPresupuesto() >= producto.getCostoDeVisita() 
						&& usuario.getTiempoDisponible() >= producto.getTiempoPromedioDeVisita() 
						&& Collections.disjoint(usuario.getItinerario(), producto.getListaDeAtracciones()))
					{
					System.out.println ("Desea adquirir " + producto.toString() + "?");
					boolean saleDelDo = false;
					do {
						System.out.println ("Pulse S para si, N para no.");
						String acepta= sc.nextLine();
						if(acepta.toUpperCase().equals("S")) {
							usuario.compra(producto);
							System.out.println("Gracias por su compra!\n");
							saleDelDo = true;
						} else if(acepta.toUpperCase().equals("N")) {
							System.out.println("De acuerdo!\n");
							saleDelDo = true;
						}
					} while (!saleDelDo);
					}}
			// Cambiar la logica de ordenar las atracciones
			for (int i2 = 0; i2 < productos.size(); i2++) {
				Producto producto = productos.get(i2);
				if(producto.getTipoDeAtraccion() != usuario.getTipoPreferidoDeAtraccion() 
						&& usuario.getPresupuesto() >= producto.getCostoDeVisita() 
						&& usuario.getTiempoDisponible() >= producto.getTiempoPromedioDeVisita() 
						&& Collections.disjoint(usuario.getItinerario(), producto.getListaDeAtracciones()))
				{
					System.out.println("Le podemos ofrecer " + producto.toString() + "\nSabemos que no es de su preferencia.\nPulse S para si, N para no.");
					String acepta= sc.nextLine();
					if(acepta.toUpperCase().equals("S")) {
						usuario.compra(producto);
						System.out.println("Gracias por su compra!\n");
					}
				}
			}
			EscritorUsuarios.escribirUsuarios(usuario, i);
		}
		sc.close();
		System.out.println();
	}
}
