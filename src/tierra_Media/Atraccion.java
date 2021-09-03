package tierra_Media;

public class Atraccion implements Producto{
	double costoDeVisita;
	double tiempoPromedioDeVisita;
	int cupoDePersonasDiario;
	Tipo_de_Atraccion tipoDeAtraccion;
	public Atraccion(double costoDeVisita, double tiempoPromedioDeVisita, int cupoDePersonasDiario,
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
	public double getCostoDeVisita() {
		return this.costoDeVisita;
	}
	
	public double getTiempoPromedioDeVisita() {
		return tiempoPromedioDeVisita;
	}

	public int getCupoDePersonasDiario() {
		return cupoDePersonasDiario;
	}
}