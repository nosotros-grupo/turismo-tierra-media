package tierra_Media;

public class Usuario {
	private int presupuesto;
	private double	tiempoDisponible;
	private Tipo_de_Atraccion tipoDeAtraccion;
	
	public Usuario(int presupuesto, double tiempoDisponible, Tipo_de_Atraccion tipoDeAtraccion) {
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoDeAtraccion = tipoDeAtraccion;
	}
	
}
