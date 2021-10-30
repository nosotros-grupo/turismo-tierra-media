package tierraMedia;

import java.util.List;

public class PromocionAbsoluta extends Promocion {

	private double precioFinal;
	private String nombre;

	public PromocionAbsoluta(double precio, List<Atraccion> atracciones, String nombre) {
		super(atracciones);
		this.precioFinal = precio;
		this.nombre = nombre;
	}

	public double getCostoDeVisita() {
		return this.precioFinal;
	}

	@Override
	public boolean contiene(Producto p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
//		// genera el numero de promo
//		double numeroPromo = this.getTiempoPromedioDeVisita() * 21; // Promo Absoluta
//		switch (this.getTipoDeAtraccion()) {
//		case AVENTURA:
//			numeroPromo *= 5;
//			break;
//		case DEGUSTACION:
//			numeroPromo *= 7;
//			break;
//		case PAISAJE:
//			numeroPromo *= 11;
//			break;
//		default:
//			break;
//		}
//		
//		// frase a imprimir
//		int numPromo = (int) numeroPromo;
//		String numeroPromoTxt = String.format("%04d", numPromo);
//		return "\n   Promo" + numeroPromoTxt + " ==  Precio Promocional " 
//				+ this.precioFinal + " monedas  ==  Incluye:  " + atraccionesEnPromo;
		return "\n Promo \"" + this.nombre + "\" == Precio Promocional " + this.precioFinal + " monedas == Incluye: "
				+ atraccionesEnPromo;
	}
}
