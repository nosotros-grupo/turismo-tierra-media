package tierra_Media;

public class PromocionAbsoluta extends Promocion {
	private int precioFinal;
	
	public PromocionAbsoluta(int precio, Atraccion atraccion) {
		super(atraccion);
		this.precioFinal = precio;
	}
	
	public PromocionAbsoluta(int precio, Atraccion a1, Atraccion a2) {
		super();
		this.atraccionesEnPromo.add(a1);
		this.atraccionesEnPromo.add(a2);
		this.precioFinal = precio;
	}
	
	public PromocionAbsoluta(int precio, Atraccion a1, Atraccion a2, Atraccion a3) {
		super();
		this.atraccionesEnPromo.add(a1);
		this.atraccionesEnPromo.add(a2);
		this.atraccionesEnPromo.add(a3);
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
