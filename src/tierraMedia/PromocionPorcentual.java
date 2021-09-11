package tierraMedia;

import java.util.List;

public class PromocionPorcentual extends Promocion{
	private double descuento;
	
	public PromocionPorcentual(double descuento, List<Atraccion> atracciones) {
		super(atracciones);
		this.descuento = descuento;
	}
	
	@Override
	public String toString() {
		String nombreDeAtracciones = "";
		for(int i = 0 ; i < atraccionesEnPromo.size();i++) {
			nombreDeAtracciones += atraccionesEnPromo.get(i).getNombre() + " ";
			
			}
		return "Promocion Porcentual, con un costo total de " + this.getCostoDeVisita() + " Monedas de Oro, gracias al descuento de " + descuento + " porciento. Dura aproximadamente " + this.getTiempoPromedioDeVisita() + " horas. Incluye las siguientes atracciones: " + nombreDeAtracciones;
	}

	public PromocionPorcentual(double descuento, Atraccion a1, Atraccion a2) {
		super();
		this.atraccionesEnPromo.add(a1);
		this.atraccionesEnPromo.add(a2);
		this.descuento = descuento;
	}
	
	public PromocionPorcentual(double descuento, Atraccion a1, Atraccion a2, Atraccion a3) {
		super();
		this.atraccionesEnPromo.add(a1);
		this.atraccionesEnPromo.add(a2);
		this.atraccionesEnPromo.add(a3);
		this.descuento = descuento;
	}
	
	public double getCostoDeVisita() {
		double costo = 0;
		for(int i = 0; i<atraccionesEnPromo.size();i++) {
			costo += atraccionesEnPromo.get(i).getCostoDeVisita();
		}
		return costo * descuento;
	}


}


