package tierra_Media;

import java.util.List;

public class PromocionAxB extends Promocion{
	private List<Atraccion> atraccionesBonificadas;
	
	
	public PromocionAxB(List<Atraccion> atracciones, List<Atraccion> atraccionesBonificadas) {
		super(atracciones);
		this.atraccionesBonificadas = atraccionesBonificadas;
	}
	
	public PromocionAxB(Atraccion ap1, Atraccion ab1, Atraccion ab2) {
		super();
		this.atraccionesEnPromo.add(ap1);
		this.atraccionesBonificadas.add(ab1);
		this.atraccionesBonificadas.add(ab2);
	}
	
	public PromocionAxB(Atraccion ap1, Atraccion ab1, Atraccion ab2, Atraccion ab3) {
		super();
		this.atraccionesEnPromo.add(ap1);
		this.atraccionesBonificadas.add(ab1);
		this.atraccionesBonificadas.add(ab2);
		this.atraccionesBonificadas.add(ab3);
	}

	@Override
	public double calcularPrecioFinal() {
		return this.getCostoDeVisita() - this.getCostoDeAtraccionesBonificadas();
	}

	@Override
	public TipoAtraccion getTipoAtraccion() {
		return atraccionesEnPromo.get(0).getTipoAtraccion();
	}
	
	private double getCostoDeAtraccionesBonificadas() {
		double costoDeVisita = 0;
		int i = 0;
		while(!atraccionesBonificadas.isEmpty())
			costoDeVisita += atraccionesBonificadas.get(i).getCostoDeVisita();
			i++;
		return costoDeVisita;
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