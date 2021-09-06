package tierra_Media;

import java.util.List;

public interface Producto {
	
	public TipoAtraccion getTipoDeAtraccion();
	public double getCostoDeVisita();
	public List<Atraccion> getListaDeAtracciones();
	public boolean esPromocion();
	
}
