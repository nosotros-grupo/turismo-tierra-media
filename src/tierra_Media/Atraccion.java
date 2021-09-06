package tierra_Media;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Atraccion implements Producto, Comparator<Atraccion>{
	String nombre;
	double costoDeVisita;
	double tiempoPromedioDeVisita;
	int cupoDePersonasDiario;
	TipoAtraccion tipoDeAtraccion;

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
	public int compare(Atraccion o1, Atraccion o2) {
		
		return 0;
	}
	public TipoAtraccion getTipoDeAtraccion() {
		return this.tipoDeAtraccion;
	}
}
