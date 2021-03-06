package tierraMedia;

import java.util.Arrays;
import java.util.LinkedList;

public class Usuario {
	private int presupuesto;
	private double tiempoDisponible;
	private TipoAtraccion tipoPreferidoDeAtraccion; 
	private LinkedList<Atraccion> itinerario = new LinkedList<Atraccion>();
	private String name;
	
	public Usuario(int presupuesto, double tiempoDisponible, TipoAtraccion tipoDeAtraccion, String nombre) {
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoPreferidoDeAtraccion = tipoDeAtraccion;
		this.name = nombre;
	}
	
	public int getPresupuesto() {
		return presupuesto;
	}
	
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
	
	public int getCostoTotalDeVisita() {
		int costo = 0;
		for (int i = 0; i < itinerario.size(); i++) {
			costo += itinerario.get(i).getCostoDeVisita();
		}
		return costo;
	}
	
	public double getTiempoTotalDeVisita() {
		int tiempo = 0;
		for (int i = 0; i < itinerario.size(); i++) {
			tiempo += itinerario.get(i).getTiempoPromedioDeVisita();
		}
		return tiempo;
	}
	
	public String[] getAtraccionesCompradas() {
		String[] atraccionesCompradas = new String[itinerario.size()];
		for (int i = 0; i < itinerario.size(); i++) {
			atraccionesCompradas[i] = itinerario.get(i).getNombre();
		}
		return atraccionesCompradas;
	}

	public String getListaAtracciones() {
		return Arrays.toString(getAtraccionesCompradas()).replace("]", "").replace("[", "") ;
	}

	public LinkedList<Atraccion> getItinerario() {
		return this.itinerario;
	}

	public String getName() {
		return name;
	}
}
