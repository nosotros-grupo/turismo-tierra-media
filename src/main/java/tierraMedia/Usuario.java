package tierraMedia;

import java.util.LinkedList;
import java.util.List;

/**
 * @author nosotros.grupo
 * 
 * @param presupuesto
 * @param tiempoDisponible
 * @param tipoDeAtraccion
 * @param nombre
 * @param id
 */
public class Usuario {
	private int id;
	private String name;
	private int presupuesto;
	private double tiempoDisponible;
	private TipoAtraccion tipoPreferidoDeAtraccion;
	private LinkedList<Atraccion> itinerario = new LinkedList<Atraccion>();

	public Usuario(int presupuesto, double tiempoDisponible, TipoAtraccion tipoDeAtraccion, String nombre, int id) {
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoPreferidoDeAtraccion = tipoDeAtraccion;
		this.name = nombre;
		this.id = id;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public int getId() {
		return this.id;
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

	/**
	 * @param producto Descuenta el monto del producto al presupuesto - Descuenta el
	 *                 tiempo que le ocupa el producto
	 */
	public void compra(Producto producto) {
		this.presupuesto -= producto.getCostoDeVisita();
		this.tiempoDisponible -= producto.getTiempoPromedioDeVisita();
		producto.disminuirCupo();
		for (Atraccion atrac : producto.getListaDeAtracciones()) {
			this.itinerario.add(atrac);
		}
	}

	public int getCostoTotalDeVisita() {
		int costo = 0;
		for (Atraccion atrac : itinerario) {
			costo += atrac.getCostoDeVisita();
		}
		return costo;
	}

	public double getTiempoTotalDeVisita() {
		int tiempo = 0;
		for (Atraccion atrac : itinerario) {
			tiempo += atrac.getTiempoPromedioDeVisita();
		}
		return tiempo;
	}

	public List<Atraccion> getAtraccionesCompradas() {
		LinkedList<Atraccion> atraccionesCompradas = new LinkedList<Atraccion>();
		for (Atraccion atrac : itinerario) {
			atraccionesCompradas.add(atrac);
		}
		return atraccionesCompradas;
	}

	public String getStringAtraccionesCompradas() {
		String atraccionesCompradas = "";
		for (Atraccion atrac : itinerario) {
			atraccionesCompradas += "     ==>" + atrac.stringNombreYduracion() + "\n";
		}
		return atraccionesCompradas;
	}

	public String getListaAtracciones() {
		return "";
//		Arrays.toString(getAtraccionesCompradas()).replace("]", "").replace("[", "");
	}

	public LinkedList<Atraccion> getItinerario() {
		return this.itinerario;
	}

	public String getName() {
		return name;
	}
}
