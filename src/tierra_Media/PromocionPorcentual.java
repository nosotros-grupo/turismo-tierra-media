package tierra_Media;

import java.util.List;

public class PromocionPorcentual extends Promocion{
	private double descuento;
	
	public PromocionPorcentual(double descuento, List<Atraccion> atracciones) {
		super(atracciones);
		this.descuento = descuento;
	}
	
	public PromocionPorcentual(double descuento, Atraccion a1, Atraccion a2) {
		super();
		this.atraccionesEnPromo.add(a1);
		this.atraccionesEnPromo.add(a2);
		this.descuento = descuento;
	}
	
	public PromocionPorcentual(double descuento, Atraccion a1, Atraccion a2, Atraccion a3) {
		super();
		this.atraccionesEnPromo.add(a1);
		this.atraccionesEnPromo.add(a2);
		this.atraccionesEnPromo.add(a3);
		this.descuento = descuento;
	}
	
	@Override
	public double calcularPrecioFinal() {
		double costo = this.getCostoDeVisita();
		return costo - costo * descuento;
	}

	@Override
	public TipoAtraccion getTipoAtraccion() {
		return atraccionesEnPromo.get(0).getTipoAtraccion();
	};
}


