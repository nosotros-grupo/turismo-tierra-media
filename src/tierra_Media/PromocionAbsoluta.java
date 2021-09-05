package tierra_Media;

import java.util.List;

public class PromocionAbsoluta extends Promocion {
	private int precioFinal;
	
	public PromocionAbsoluta(int precio, List<Atraccion> atracciones) {
		super(atracciones);
		this.precioFinal = precio;
	}
	

	@Override
	public double calcularPrecioFinal() {
		return this.precioFinal;
	}

	@Override
	public TipoAtraccion getTipoAtraccion() {
		return atraccionesEnPromo.get(0).getTipoAtraccion();
	}

}
