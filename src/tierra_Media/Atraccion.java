package tierra_Media;

import java.util.Comparator;

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
	public String getNombre() {
		return this.nombre;
	}
	public double getCostoDeVisita() {
		return this.costoDeVisita;
	}
	
	//agregue getters poque seguramente los necesitemos al momento de calcular los tiempos e itinerarios o simplemente para testear.
	
	public double getTiempoPromedioDeVisita() {
		return tiempoPromedioDeVisita;
	}

	public int getCupoDePersonasDiario() {
		return cupoDePersonasDiario;
	}

	@Override
	public TipoAtraccion getTipoAtraccion() {
		return this.tipoDeAtraccion;
	}

	@Override
	public int compare(Atraccion o1, Atraccion o2) {
		
		return 0;
	}
}
