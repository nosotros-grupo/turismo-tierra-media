package tierraMedia;

import java.util.List;

public interface Producto extends Comparable<Producto>{
	
	public TipoAtraccion getTipoDeAtraccion();
	public double getCostoDeVisita();
	
	public List<Atraccion> getListaDeAtracciones();
	public boolean esPromocion();
	
	public abstract boolean contiene(Producto p);
	
	public double getTiempoPromedioDeVisita();
	
	int compareTo(Producto o2);
	
	public void disminuirCupo();
	
	public boolean tieneCupo();
	
}
