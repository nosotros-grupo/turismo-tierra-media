package tierra_Media;

public class Usuario {
	private int presupuesto;
	private double	tiempoDisponible;
	private Tipo_de_Atraccion tipoPreferidoDeAtraccion; //para no generar confusion con los atributos de Atraccion
	
	public Usuario(int presupuesto, double tiempoDisponible, Tipo_de_Atraccion tipoDeAtraccion) {
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoPreferidoDeAtraccion = tipoDeAtraccion;
	}

	public int getPresupuesto() {
		return presupuesto;
	}
	
	//agregue getters poque seguramente los necesitemos al momento de calcular los tiempos e itinerarios o simplemente para testear.
	
	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public Tipo_de_Atraccion getTipoPreferidoDeAtraccion() {
		return tipoPreferidoDeAtraccion;
	}
}
