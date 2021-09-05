package tierra_Media;

import java.util.List;

public abstract class Promocion implements Producto{
	protected List<Atraccion> atraccionesEnPromo;
	
	public Promocion(List<Atraccion> atracciones) {
		this.atraccionesEnPromo = atracciones;
	}
	
	public Promocion() {	
	}
	
	public TipoAtraccion getTipoDeAtraccion() {
		return atraccionesEnPromo.get(0).getTipoAtraccion();
	}
	
	public double getCostoDeVisita() {
		double costoDeVisita = 0;
		int i = 0;
		while(!atraccionesEnPromo.isEmpty())
			costoDeVisita += atraccionesEnPromo.get(i).getCostoDeVisita();
			i++;
		return costoDeVisita;
	}
	
	public abstract double calcularPrecioFinal();
}
