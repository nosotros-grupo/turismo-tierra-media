package tierraMedia;

import java.util.List;

public class PromocionAxB extends Promocion {
	private List<Atraccion> atraccionesBonificadas;

	public PromocionAxB(List<Atraccion> atracciones, List<Atraccion> atraccionesBonificadas) {
		super(atracciones);
		this.atraccionesBonificadas = atraccionesBonificadas;
	}

	public TipoAtraccion getTipoAtraccion() {
		return atraccionesEnPromo.get(0).getTipoDeAtraccion();
	}

	public double getCostoDeVisita() {
		double costoDeVisita = 0;
		for (int i = 0; i < atraccionesEnPromo.size(); i++) {
			if (!atraccionesBonificadas.contains(atraccionesEnPromo.get(i))) {
				costoDeVisita += atraccionesEnPromo.get(i).getCostoDeVisita();
			}
		}
		return costoDeVisita;
	}

	@Override
	public boolean contiene(Producto p) {
		// TODO Auto-generated method stub
		return false;
	}
<<<<<<< HEAD
}
=======

	@Override
	public String toString() {
		double numeroPromo = this.getTiempoPromedioDeVisita() * 13; // Promo Absoluta
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
		int numPromo = (int) this.getCostoDeVisita();
		String numeroPromoTxt = String.format("%04d", numPromo);
		return "\n ####### Promo" + numeroPromoTxt + "  ==  Precio Promocional " + numPromo
				+ " monedas  ==  Incluye:  " + atraccionesEnPromo + "  ===     L A      U L T I M A      G R A T I S    !!!!  ===  [\n";

//		
//		return "PromocionAxB [atraccionesBonificadas=" + atraccionesBonificadas + ", atraccionesEnPromo="
//				+ atraccionesEnPromo + "]";
	}
}

//Otro Constructor
/*
 * public PromocionAxB(Atraccion[] atracciones, Atraccion[] atraccionesPagas) {
 * super(); super.atracciones = atracciones; int sumaDeCostos = 0; for(int i =
 * 0; i < atraccionesPagas.length; i++) { sumaDeCostos +=
 * atraccionesPagas[i].getCostoDeVisita(); } super.costoDeVisita = sumaDeCostos;
 * 
 * }
 */
>>>>>>> 6985441d244cf66857a5045d3c565ffe24ae5315
