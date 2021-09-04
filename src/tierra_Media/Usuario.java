package tierra_Media;

import java.util.LinkedList;

public class Usuario {
	private int presupuesto;
	private double	tiempoDisponible;
	private TipoAtraccion tipoPreferidoDeAtraccion; //para no generar confusion con los atributos de Atraccion
	private LinkedList<Atraccion> itinerario;
	
	public Usuario(int presupuesto, double tiempoDisponible, TipoAtraccion tipoDeAtraccion) {
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
	
	public void agregarAtraccion(Atraccion a) {
		itinerario.add(a);
	}
	
	public TipoAtraccion getTipoPreferidoDeAtraccion() {
		return tipoPreferidoDeAtraccion;
	}
}
