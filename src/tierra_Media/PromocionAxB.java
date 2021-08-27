package tierra_Media;

public class PromocionAxB extends Promocion{
	public PromocionAxB(Atraccion[] atracciones, Atraccion[] atraccionesPagas) {
		this.atracciones = atracciones;
		int sumaDeCostos = 0;
		for(int i = 0; i < atraccionesPagas.length; i++) {
			sumaDeCostos += atraccionesPagas[i].getCostoDeVisita();
			}
		this.costoDeVisita = sumaDeCostos;
		
	}

}
