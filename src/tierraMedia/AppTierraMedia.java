package tierraMedia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;

public class AppTierraMedia {
	private static LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
	private static LinkedList<Producto> productos = new LinkedList<Producto>();
	//para testeos rapidos
	
	public static void main(String[] args) throws IOException {
		List<Promocion> promociones = new ArrayList<Promocion>();
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		LectorAtracciones lectorA = new LectorAtracciones();
		LectorUsuarios lectorU = new LectorUsuarios();
		
		Scanner sc = new Scanner(System.in);
		

		// Pregunta el nombre del archivo de usuarios
		// Lee el archivo de usuarios

		
		//cambiar por alguna condicion que necesitemos
		while(usuarios.isEmpty()) {
			try{
				System.out.println("Ingrese nombre de el archivo de usuarios...(Enter para el nombre por defecto)");
			
				String archivoUsuarios = sc.nextLine();
				if(archivoUsuarios.equals("")) {
					archivoUsuarios = "usuarios.in";
				}
				usuarios = lectorU.leerUsuarios(archivoUsuarios);
				if(usuarios.size()<0) {
					System.out.println("El archivo no contiene usuarios, intente nuevamente");
				}
			}catch(NullPointerException e) {
				System.out.println("El archivo no existe, intente nuevamente");
			}
		}
		
		// Pregunta el nombre del archivo de Atracciones
		while(atracciones.isEmpty()) {
			try{
				System.out.println("Ingrese nombre de el archivo de atracciones...(Enter para el nombre por defecto)");
				String archivoAtracciones= sc.nextLine();
				if(archivoAtracciones.equals("")) {
					archivoAtracciones = "atracciones.in";
				}
				atracciones = lectorA.leerAtracciones(archivoAtracciones);
				System.out.println(atracciones);
				if(atracciones.size()<0) {
					System.out.println("El archivo no contiene atracciones, intente nuevamente");
				}
			}catch(NullPointerException e) {
				System.out.println("El archivo no existe, intente nuevamente");
			}
		}
		
		// Pregunta el nombre del archivo de Promociones
		while(promociones.isEmpty()) {
			try{
				System.out.println("Ingrese nombre de el archivo de promociones...(Enter para el nombre por defecto, tecla n si no se desean promociones)");
				LectorPromociones lectorP = new LectorPromociones(atracciones);
				String archivoPromociones = sc.nextLine();
				if(archivoPromociones.equals("")) {
					archivoPromociones = "promociones.in";
				}
				if(archivoPromociones.equals("n")) {
					promociones = null;
					break;
				}
				promociones = lectorP.leerPromociones(archivoPromociones);
				if(promociones.size()<0) {
					System.out.println("El archivo no contiene promociones, intente nuevamente");
				}
			}catch(NullPointerException e) {
				System.out.println("El archivo no existe, intente nuevamente");
			}
		}
		productos = new LinkedList<Producto>();
		productos.addAll(atracciones);
		productos.addAll(promociones);
		Collections.sort(productos);
		for(int i = 0;i<usuarios.size();i ++) {
			Usuario usuario = usuarios.get(i);
			System.out.println("Comenzamos con un nuevo usuario. Saludos");
			for(int i2 = 0; i2 < productos.size(); i2++) {
				Producto producto = productos.get(i2);
				if(producto.getTipoDeAtraccion() == usuario.getTipoPreferidoDeAtraccion() && usuario.getPresupuesto() >= producto.getCostoDeVisita() && usuario.getTiempoDisponible() >= producto.getTiempoPromedioDeVisita() && Collections.disjoint(usuario.getItinerario(), producto.getListaDeAtracciones())){
					System.out.println("Desea adquirir " + producto.toString() + "pulse y para si y n para no");
					String acepta= sc.nextLine();
					if(acepta.equals("y")) {
						usuario.compra(producto);
						System.out.println("gracias");
					}
				}
			}
			for(int i2 = 0; i2 < productos.size(); i2++) {
				Producto producto = productos.get(i2);
				if(producto.getTipoDeAtraccion() != usuario.getTipoPreferidoDeAtraccion() && usuario.getPresupuesto() >= producto.getCostoDeVisita() && usuario.getTiempoDisponible() >= producto.getTiempoPromedioDeVisita() && Collections.disjoint(usuario.getItinerario(), producto.getListaDeAtracciones())){
					System.out.println("Desea adquirir " + producto.toString() + " pese a que no es de su preferencia. pulse y para si y n para no");
					String acepta= sc.nextLine();
					if(acepta.equals("y")) {
						usuario.compra(producto);
						System.out.println("gracias");
					}
				}
			}
			
			//chequear que no haya atracciones con promociones en comun y que no entren atracciones que ya esten.
			
			System.out.println("Gracias por adquirir " + usuario.getItinerario());
			EscritorUsuarios.escribirUsuarios(usuario, i);
		}
		sc.close();
		System.out.println();
	}
}
