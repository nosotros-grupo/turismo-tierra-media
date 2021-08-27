package tierra_Media;

public class Atraccion {
	int costoDeVisita;
	double tiempoPromedioDeVisita;
	int cupoDePersonasDiario;
	Tipo_de_Atraccion tipoDeAtraccion;
	public Atraccion(int costoDeVisita, double tiempoPromedioDeVisita, int cupoDePersonasDiario,
			Tipo_de_Atraccion tipoDeAtraccion) {
		super();
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
