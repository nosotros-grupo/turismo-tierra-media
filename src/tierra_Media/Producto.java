package tierra_Media;

import java.util.List;

public interface Producto extends Comparable<Producto>{
	
	public TipoAtraccion getTipoDeAtraccion();
	public double getCostoDeVisita();
	
	public List<Atraccion> getListaDeAtracciones();
	public boolean esPromocion();
	public double getTiempoPromedioDeVisita();
	
}
