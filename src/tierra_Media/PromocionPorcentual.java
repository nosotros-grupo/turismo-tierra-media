package tierra_Media;

public class PromocionPorcentual extends Promocion{

	public PromocionPorcentual(Atraccion[] atracciones, double porcentaje) {
		super();
		this.atracciones = atracciones;
		int sumaDeCostos = 0;
		for(int i = 0; i < atracciones.length; i++) {
			sumaDeCostos += atracciones[i].getCostoDeVisita() * (porcentaje/100);
			}
		this.costoDeVisita = sumaDeCostos;
	};
}
