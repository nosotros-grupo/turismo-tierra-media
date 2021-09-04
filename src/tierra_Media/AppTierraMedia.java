package tierra_Media;

import java.util.LinkedList;
import java.util.Scanner;

public class AppTierraMedia {
	static LinkedList<Usuario> usuarios;
	static LinkedList<Producto> productos;
	//para testeos rapidos
	
	public static void main(String[] args) {
		LinkedList<Promocion> promociones;
		LinkedList<Atraccion> atracciones;
		LectorAtracciones lectorA = new LectorAtracciones();
		LectorUsuarios lectorU = new LectorUsuarios();
		Scanner sc = new Scanner(System.in);
		
		

		// Pregunta el nombre del archivo de usuarios
		// Lee el archivo de usuarios
		System.out.println("Ingrese nombre de el archivo de usuarios...");
		String archivoUsuarios = sc.nextLine();
		usuarios = lectorU.leerUsuarios(archivoUsuarios);
		
		
		
		// Pregunta el nombre del archivo de Atracciones
		System.out.println("Ingrese nombre de el archivo de atracciones...");
		String archivoAtracciones= sc.nextLine();
		atracciones = lectorA.leerAtracciones(archivoAtracciones);
		
		
		
		// Pregunta el nombre del archivo de Promociones
		System.out.println("Ingrese nombre de el archivo de promociones...");
		System.out.println(atracciones.get(0).getCostoDeVisita());
		System.out.println(usuarios.get(0).getPresupuesto());
		
		
		
		//promociones = lectorPromociones.leerPromociones(archivo)
		// productos.addAll(atracciones);
		// productos.addAll(promociones);
		//for(int i = 0;i>usuarios.size();i ++) {
			// OrdenarProductos ordenarProductos = new OrdenarProductos(usuarios[i], productos)
			// LinkedList<Producto> productosOrdenados = ordenarProductos.getLlista() 
			// while tenga plata o tiempo y haya productos
				// Ofrecer prodcutosOrdenados[n] excepto que sea una atraccion que ya haya sido aceptada en una promocion(o quizas si es una promocion que tiene atracciones que ya haya usado)
			// guardar en un archivo su itinerario(creo que esto había que hacer)
		//}
		
		
	}
}
