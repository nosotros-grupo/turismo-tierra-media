package tierraMedia;

import java.util.List;

public class PromocionPorcentual extends Promocion {
	private double descuento;

	public PromocionPorcentual(double descuento, List<Atraccion> atracciones) {
		super(atracciones);
		this.descuento = descuento;
	}

	@Override
	public String toString() {

		// genera el numero de promo
		double numeroPromo = this.getTiempoPromedioDeVisita() * 17; // Promo Porcentual
		switch (this.getTipoDeAtraccion()) {
		case AVENTURA:
			numeroPromo *= 5;
			break;
		case DEGUSTACION:
			numeroPromo *= 7;
			break;
		case PAISAJE:
			numeroPromo *= 11;
			break;
		default:
			break;
		}
		int numPromo = (int) numeroPromo;
		
		// frase a imprimir
		String numeroPromoTxt = String.format("%04d", numPromo);
		int descuentoInt = (int) this.descuento;
		return "\n Promo" + numeroPromoTxt + " ==  Precio Promocional " + this.getCostoDeVisita()
				+ " monedas (" + descuentoInt + "% de descuento)  ==  Incluye:  " + atraccionesEnPromo;
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

	public double getCostoDeVisita() {
		double costo = 0;
		for (int i = 0; i < atraccionesEnPromo.size(); i++) {
			costo += atraccionesEnPromo.get(i).getCostoDeVisita();
		}
		return costo - (costo * (descuento / 100));
	}

	@Override
	public boolean contiene(Producto p) {
		return false;
	}

}
