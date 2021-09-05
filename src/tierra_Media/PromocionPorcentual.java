package tierra_Media;

public class PromocionPorcentual extends Promocion{
	private double descuento;
	
	public PromocionPorcentual(double descuento, Atraccion atraccion) {
		super(atraccion);
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


//Otro Constructor
/*
public PromocionPorcentual(Atraccion[] atracciones, double porcentaje) {
	super();
	this.atracciones = atracciones;
	int sumaDeCostos = 0;
	for(int i = 0; i < atracciones.length; i++) {
		sumaDeCostos += atracciones[i].getCostoDeVisita() * (porcentaje/100);
		}
	this.costoDeVisita = sumaDeCostos;
}
*/