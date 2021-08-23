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
	public int getCostoDeVisita() {
		return this.costoDeVisita;
	}
}
