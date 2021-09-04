package tierra_Media;

import java.util.LinkedList;

public class AppTierraMedia {
	static LinkedList<Usuario> usuarios;
	static LinkedList<Producto> productos;
	//para testeos rapidos
	
	public static void main(String[] args) {
		// Acá iría el funcionamiento del programa haciendo las preguntas y respondiendo
		Lector lector = new Lector();
		// Pregunta el nombre del archivo de usuarios
		// Lee el archivo de usuarios
		// usuarios = lectorUsuarios.leerUsuarios(archivo);
		// Pregunta el nombre del archivo de Atracciones
		LinkedList<Atraccion> atracciones;
		// atracciones = lectorAtracciones.leerAtracciones(archivo);
		LinkedList<Promocion> promociones;
		// Pregunta el nombre del archivo de Promociones
		// promociones = lectorPromociones.leerPromociones(archivo)
		// productos.addAll(atracciones);
		// productos.addAll(promociones);
		for(int i = 0;i>usuarios.size();i ++) {
			// OrdenarProductos ordenarProductos = new OrdenarProductos(usuarios[i], productos)
			// LinkedList<Producto> productosOrdenados = ordenarProductos.getLlista() 
			// while tenga plata o tiempo y haya productos
				// Ofrecer prodcutosOrdenados[n] excepto que sea una atraccion que ya haya sido aceptada en una promocion(o quizas si es una promocion que tiene atracciones que ya haya usado)
			// guardar en un archivo su itinerario(creo que esto había que hacer)
		}
		
		
	}
}
