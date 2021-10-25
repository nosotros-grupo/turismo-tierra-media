package tierraMedia;

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
		int largoNombre = this.nombre.length();
		int largoAtracc = this.getTipoDeAtraccion().name().length();
		int guiones = (80 - largoAtracc - largoNombre - 8) / 2;

//		String respuesta = "\n===============================================================================\n";
		String respuesta = "\n";
		for (int i = 0; i < guiones; i++) 
			respuesta += "=";
		respuesta += "  " + this.nombre + " (" + this.tipoDeAtraccion + ")  ";
		for (int i = 0; i < guiones; i++) 
			respuesta += "=";
		respuesta += "\n  Precio de lista: " + this.costoDeVisita + " monedas. "
				+ "--  Tiempo promedio de Visita : " + this.tiempoPromedioDeVisita + " hora";
		if (this.tiempoPromedioDeVisita > 1)
			respuesta += "s";
		respuesta += ".\n\n";
//		respuesta += "===============================================================================\n\n";
		
		return  respuesta;
		//"Atraccion [nombre=" + nombre + ", costoDeVisita=" + costoDeVisita + ", tiempoPromedioDeVisita="
			//	+ tiempoPromedioDeVisita + ", tipoDeAtraccion=" + tipoDeAtraccion + "]";
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
	
	@Override
	public boolean contiene(Producto p) {
		if(p.esPromocion()) {
			return p.contiene(this);
		}
		return this.equals(p);
	}
}
