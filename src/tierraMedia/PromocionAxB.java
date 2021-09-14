package tierraMedia;

import java.util.List;

public class PromocionAxB extends Promocion{
	private List<Atraccion> atraccionesBonificadas;
	
	
	@Override
	public String toString() {
		return "PromocionAxB [atraccionesBonificadas=" + atraccionesBonificadas + ", atraccionesEnPromo="
				+ atraccionesEnPromo + "]";
	}

	public PromocionAxB(List<Atraccion> atracciones, List<Atraccion> atraccionesBonificadas) {
		super(atracciones);
		this.atraccionesBonificadas = atraccionesBonificadas;
	}
	
	public TipoAtraccion getTipoAtraccion() {
		return atraccionesEnPromo.get(0).getTipoDeAtraccion();
	}
	
	public double getCostoDeVisita() {
		double costoDeVisita = 0;
		for(int i = 0; i<atraccionesEnPromo.size();i++) {
			if(!atraccionesBonificadas.contains(atraccionesEnPromo.get(i))){
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
}





//Otro Constructor
/*
	public PromocionAxB(Atraccion[] atracciones, Atraccion[] atraccionesPagas) {
		super();
		super.atracciones = atracciones;
		int sumaDeCostos = 0;
		for(int i = 0; i < atraccionesPagas.length; i++) {
			sumaDeCostos += atraccionesPagas[i].getCostoDeVisita();
			}
		super.costoDeVisita = sumaDeCostos;
		
	}
*/