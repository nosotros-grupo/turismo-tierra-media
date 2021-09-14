package tierraMedia;

import java.util.List;

public class PromocionAbsoluta extends Promocion {
	private double precioFinal;
	
	@Override
	public String toString() {
		return "PromocionAbsoluta [precioFinal=" + precioFinal + ", atraccionesEnPromo=" + atraccionesEnPromo + "]";
	}
	public PromocionAbsoluta(double precio, List<Atraccion> atracciones) {
		super(atracciones);
		this.precioFinal = precio;
	}
	public double getCostoDeVisita() {
		return this.precioFinal;
	}
	@Override
	public boolean contiene(Producto p) {
		// TODO Auto-generated method stub
		return false;
	}





}
