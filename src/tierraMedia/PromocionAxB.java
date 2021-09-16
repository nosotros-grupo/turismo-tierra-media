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
		return false;
	}

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
		int numCosto = (int) this.getCostoDeVisita();
		int numPromoInt = (int) numeroPromo;
		String numeroPromoTxt = String.format("%04d", numPromoInt);
		return "\n ####### Promo" + numeroPromoTxt + " (promo AxB)  ==  Precio Promocional " + numCosto
				+ " monedas  ==  Incluye:  " + atraccionesEnPromo + "     ===     L A     U L T I M A     G R A T I S     ! ! ! !      ===     [\n";
	}
}
