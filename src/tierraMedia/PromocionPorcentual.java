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
		String numeroPromoTxt = String.format("%04d", numPromo);
		int descuentoInt = (int) this.descuento;
		
		return "\n ####### Promo" + numeroPromoTxt + " (promo Porc)  ==  Precio Promocional " + this.getCostoDeVisita()
				+ " monedas (" + descuentoInt + " monedas de descuento)  ==  Incluye:  " + atraccionesEnPromo;

//		String nombreDeAtracciones = "";
//		for (int i = 0; i < atraccionesEnPromo.size(); i++) {
//			nombreDeAtracciones += atraccionesEnPromo.get(i).getNombre() + " ";
//
//		}
//		return "Promocion Porcentual, con un costo total de " + this.getCostoDeVisita()
//				+ " Monedas de Oro, gracias al descuento de " + descuento + " porciento. Dura aproximadamente "
//				+ this.getTiempoPromedioDeVisita() + " horas. Incluye las siguientes atracciones: "
//				+ nombreDeAtracciones;
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
		return costo - (costo * (descuento/100));
	}

	@Override
	public boolean contiene(Producto p) {
		// TODO Auto-generated method stub
		return false;
	}

}
