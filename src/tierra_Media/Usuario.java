package tierra_Media;

public class Usuario {
	private int presupuesto;
	private double	tiempoDisponible;
	private Tipo_de_Atraccion tipoPreferido;
	
	public Usuario(int presupuesto, double tiempoDisponible, Tipo_de_Atraccion tipoDeAtraccion) {
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoPreferido = tipoDeAtraccion;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public Tipo_de_Atraccion getTipoPreferido() {
		return tipoPreferido;
	}
}
