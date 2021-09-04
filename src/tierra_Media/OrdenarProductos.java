package tierra_Media;

import java.util.LinkedList;

public class OrdenarProductos {
	LinkedList<Producto> productosOrdenados;
	
	
	public OrdenarProductos(Usuario usuario, LinkedList<Producto> productos) {
		productosOrdenados = productos;
		//Ahora no esta ordenando nada				
	}
	public LinkedList<Producto> getLista(){
		return productosOrdenados; 
	}
}
