package tierra_Media;

public class PromocionAxB extends Promocion{
	
	
	public PromocionAxB(int cantidadAtracciones, int costoDeVisita ) {
		super(cantidadAtracciones, costoDeVisita);
	}

	@Override
	public double calcularDescuento() {
		// TODO Auto-generated method stub
		return 0;
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