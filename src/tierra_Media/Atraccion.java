package tierra_Media;

public class Atraccion {
	private int costoDeVisita;
	private double tiempoPromedioDeVisita;
	private int cupoDePersonasDiario;
	private Tipo_de_Atraccion tipoDeAtraccion;

	public Atraccion(int costoDeVisita, double tiempoPromedioDeVisita, int cupoDePersonasDiario,
			Tipo_de_Atraccion tipoDeAtraccion) {
		this.costoDeVisita = costoDeVisita;
		this.tiempoPromedioDeVisita = tiempoPromedioDeVisita;
		this.cupoDePersonasDiario = cupoDePersonasDiario;
		this.tipoDeAtraccion = tipoDeAtraccion;
	}
	
	public Tipo_de_Atraccion getTipoDeAtraccion() {
		return this.tipoDeAtraccion;
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
}
