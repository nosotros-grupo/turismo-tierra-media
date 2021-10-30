package tierraMedia;

import java.util.List;

public class PromocionAxB extends Promocion {
	private List<Atraccion> atraccionesBonificadas;
	private String nombre;

	public PromocionAxB(List<Atraccion> atracciones, List<Atraccion> atraccionesBonificadas, String nombre) {
		super(atracciones);
		this.atraccionesBonificadas = atraccionesBonificadas;
		this.nombre = nombre;
	}

	public TipoAtraccion getTipoAtraccion() {
		return atraccionesEnPromo.get(0).getTipoDeAtraccion();
	}

	public double getCostoDeVisita() {
		double costoDeVisita = 0;
		for (Atraccion atrac : atraccionesEnPromo) {
//			if (!atraccionesBonificadas.contains(atrac)) {
			costoDeVisita += atrac.getCostoDeVisita();
//			}
		}
		return costoDeVisita;
	}

	@Override
	public boolean contiene(Producto p) {
		return false;
	}

	@Override
	public String toString() {
		Integer costoMonedas = (int) this.getCostoDeVisita();
		String frase2 = String.format("%1$" + 2 + "s", costoMonedas.toString());

		return "\n Promo \"" + this.nombre + "\"  << Precio Promocional " + frase2 +" "+ this.getCostoDeVisita() + " monedas >>   Incluye  "
				+ atraccionesEnPromo + "\n Y SIN CARGO!!    Esta atracción para que disfrute al máximo:   " 
				+ atraccionesBonificadas + "\n";

//		return "\n Promo" + numeroPromoTxt + " ==  Precio Promocional " + numCosto + " monedas  ==  Incluye:  "
//				+ atraccionesEnPromo + "\n\";
	}
}
