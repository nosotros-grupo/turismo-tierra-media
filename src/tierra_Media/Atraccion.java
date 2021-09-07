package tierra_Media;

import java.util.ArrayList;
import java.util.List;

public class Atraccion implements Producto{
	private String nombre;
	private double costoDeVisita;
	private double tiempoPromedioDeVisita;
	private int cupoDePersonasDiario;
	private TipoAtraccion tipoDeAtraccion;

	public Atraccion(String nombre, int costoDeVisita, double tiempoPromedioDeVisita, int cupoDePersonasDiario,
			TipoAtraccion tipoDeAtraccion) {
		this.costoDeVisita = costoDeVisita;
		this.tiempoPromedioDeVisita = tiempoPromedioDeVisita;
		this.cupoDePersonasDiario = cupoDePersonasDiario;
		this.tipoDeAtraccion = tipoDeAtraccion;
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Atraccion [nombre=" + nombre + ", costoDeVisita=" + costoDeVisita + ", tiempoPromedioDeVisita="
				+ tiempoPromedioDeVisita + ", tipoDeAtraccion=" + tipoDeAtraccion + "]";
	}
	public String getNombre() {
		return this.nombre;
	}
	public double getCostoDeVisita() {
		return this.costoDeVisita;
	}
	
	public boolean esPromocion() {
		return false;
	}
	public List<Atraccion> getListaDeAtracciones() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(this);
		return atracciones;
	}
	//agregue getters poque seguramente los necesitemos al momento de calcular los tiempos e itinerarios o simplemente para testear.
	
	public double getTiempoPromedioDeVisita() {
		return tiempoPromedioDeVisita;
	}

	public int getCupoDePersonasDiario() {
		return cupoDePersonasDiario;
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
	public TipoAtraccion getTipoDeAtraccion() {
		return this.tipoDeAtraccion;
	}

}
