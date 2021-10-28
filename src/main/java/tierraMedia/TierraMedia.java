package tierraMedia;

import java.util.LinkedList;
import java.util.List;

//construi esta clase porque pense que Tierra Media es quien debe saber poder brindar los itinerarios y registrar los usuarios.

public class TierraMedia {
	//se que esta mal pero es para testear que no este privado pero es para testear
	LinkedList<Usuario> usuarios;
	List<Atraccion> atracciones;
	// hacer lista de promociones reemplazando a atracciones como atributo
	
	
	public void registrarUsuarios(String archivo) {
		LectorUsuarios lU = new LectorUsuarios();
		usuarios = lU.leerUsuarios(archivo);
		}
	public void registrarAtracciones(String archivo) {
		LectorAtracciones lA = new LectorAtracciones();
		atracciones = lA.leerAtracciones(archivo);
	}
	
}