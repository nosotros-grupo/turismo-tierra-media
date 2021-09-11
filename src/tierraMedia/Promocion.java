package tierraMedia;

import java.util.List;

public abstract class Promocion implements Producto{
	protected List<Atraccion> atraccionesEnPromo;
	
	public Promocion(List<Atraccion> atracciones) {
		this.atraccionesEnPromo = atracciones;
	}
	
	public Promocion() {	
	}
	
	public TipoAtraccion getTipoDeAtraccion() {
		return atraccionesEnPromo.get(0).getTipoDeAtraccion();
	}
	public boolean esPromocion() {
		return true;
	}
	public List<Atraccion> getListaDeAtracciones() {
		return this.atraccionesEnPromo;
	}
	
	@Override
	public int compareTo(Producto o2) {
		//Primero Ofrece Promociones
		if(this.esPromocion() && !o2.esPromocion()) {
			return -1;
		}else if (!this.esPromocion() && o2.esPromocion()) {
			return 1;
		}
		// si no se da ese caso se prioriza la más maca
		double diferencia = o2.getCostoDeVisita() - this.getCostoDeVisita();
		if(diferencia != 0) {
			return (int) diferencia;
		}
		//Si tienen el mismo precio
		return (int) (o2.getTiempoPromedioDeVisita() - this.getTiempoPromedioDeVisita());
	}
	
	public double getTiempoPromedioDeVisita() {
		double tiempoPromedioDeVisita = 0;
		for(int i = 0; i<atraccionesEnPromo.size();i++) {
			tiempoPromedioDeVisita += atraccionesEnPromo.get(i).getTiempoPromedioDeVisita();
		}
		return tiempoPromedioDeVisita;
	}

	
}
