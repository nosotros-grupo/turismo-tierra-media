package tierra_Media;

import java.util.LinkedList;

//construi esta clase porque pense que Tierra Media es quien debe saber poder brindar los itinerarios y registrar los usuarios.

public class TierraMedia {
	//se que esta mal pero es para testear que no este privado pero es para testear
	LinkedList<Usuario> usuarios;
	LinkedList<Atraccion> atracciones;
	
	
	public void registrarUsuarios(String archivo) {
		usuarios = Lector.leerUsuarios(archivo);
		}
	public void registrarAtracciones(String archivo) {
		atracciones = Lector.leerAtracciones(archivo);
	}
	
}
