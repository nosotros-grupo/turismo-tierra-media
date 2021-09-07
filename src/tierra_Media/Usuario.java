package tierra_Media;

import java.util.LinkedList;

public class Usuario {
	private int presupuesto;
	private double	tiempoDisponible;
	private TipoAtraccion tipoPreferidoDeAtraccion; //para no generar confusion con los atributos de Atraccion
	private LinkedList<Atraccion> itinerario = new LinkedList<Atraccion>();
	
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

	public void compra(Producto producto) {
		this.presupuesto -= producto.getCostoDeVisita();
		this.tiempoDisponible -= producto.getTiempoPromedioDeVisita();
		for(int i = 0; i < producto.getListaDeAtracciones().size(); i++) {
			this.itinerario.add(producto.getListaDeAtracciones().get(i));
		}
		
	}

	public LinkedList<Atraccion> getItinerario() {
		return this.itinerario;
	}
}
