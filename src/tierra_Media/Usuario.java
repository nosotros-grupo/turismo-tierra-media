package tierra_Media;

public class Usuario {
	private double presupuesto;
	private double	tiempoDisponible;
	private Tipo_de_Atraccion tipoDePreferidoAtraccion;
	public Usuario(double presupuesto, double tiempoDisponible, Tipo_de_Atraccion tipoDeAtraccion) {
		super();
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoDePreferidoAtraccion = tipoDeAtraccion;
	}
	
	public double getPresupuesto() {
		return presupuesto;
	}
	
	public double getTiempoDisponible() {
		return tiempoDisponible;
	}
	
	public Tipo_de_Atraccion getTipoPreferidoDeAtraccion() {
		return tipoDePreferidoAtraccion;
	}
	
}