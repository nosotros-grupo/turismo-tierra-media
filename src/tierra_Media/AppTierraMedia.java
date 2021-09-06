package tierra_Media;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;

public class AppTierraMedia {
	static LinkedList<Usuario> usuarios;
	static LinkedList<Producto> productos;
	//para testeos rapidos
	
	public static void main(String[] args) {
		List<Promocion> promociones;
		List<Atraccion> atracciones;
		LectorAtracciones lectorA = new LectorAtracciones();
		LectorUsuarios lectorU = new LectorUsuarios();
		
		Scanner sc = new Scanner(System.in);
		

		// Pregunta el nombre del archivo de usuarios
		// Lee el archivo de usuarios

		while(true) {
			try{
				System.out.println("Ingrese nombre de el archivo de usuarios...(Enter para el nombre por defecto)");
			
				String archivoUsuarios = sc.nextLine();
				if(archivoUsuarios.equals("")) {
					archivoUsuarios = "usuarios.in";
				}
				usuarios = lectorU.leerUsuarios(archivoUsuarios);
				if(usuarios.size()>0) {
					break;
				}else {
					System.out.println("El archivo no contiene usuarios, intente nuevamente");
				}
			}catch(NullPointerException e) {
				System.out.println("El archivo no existe, intente nuevamente");
			}
		}
		
		// Pregunta el nombre del archivo de Atracciones
		while(true) {
			try{
				System.out.println("Ingrese nombre de el archivo de atracciones...(Enter para el nombre por defecto)");
				String archivoAtracciones= sc.nextLine();
				if(archivoAtracciones.equals("")) {
					archivoAtracciones = "atracciones.in";
				}
				atracciones = lectorA.leerAtracciones(archivoAtracciones);
				if(atracciones.size()>0) {
					break;
				}else {
					System.out.println("El archivo no contiene atracciones, intente nuevamente");
				}
			}catch(NullPointerException e) {
				System.out.println("El archivo no existe, intente nuevamente");
			}
		}
		
		// Pregunta el nombre del archivo de Promociones
		while(true) {
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
				if(promociones.size()>0) {
					break;
				}else {
					System.out.println("El archivo no contiene promociones, intente nuevamente");
				}
			}catch(NullPointerException e) {
				System.out.println("El archivo no existe, intente nuevamente");
			}
		}
		productos = new LinkedList<Producto>();
		productos.addAll(atracciones);
		productos.addAll(promociones);
		System.out.println("usuarios:");
		System.out.println(usuarios.toString());
		System.out.println("Productos");
		System.out.println(productos.toString());
		System.out.println("Promociones");
		System.out.println(promociones.toString());
		//for(int i = 0;i>usuarios.size();i ++) {
			// OrdenarProductos ordenarProductos = new OrdenarProductos(usuarios[i], productos)
			// LinkedList<Producto> productosOrdenados = ordenarProductos.getLlista() 
			// while tenga plata o tiempo y haya productos
				// Ofrecer prodcutosOrdenados[n] excepto que sea una atraccion que ya haya sido aceptada en una promocion(o quizas si es una promocion que tiene atracciones que ya haya usado)
			// guardar en un archivo su itinerario(creo que esto había que hacer)
		//}
		
		
	}
}
