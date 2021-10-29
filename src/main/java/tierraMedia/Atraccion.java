package tierraMedia;

import java.util.ArrayList;
import java.util.List;

/**
 * @param costoDeVisita
 * @param tiempoPromedioDeVisita
 * @param cupoDePersonasDiario
 * @param tipoDeAtraccion
 * @param nombre
 * @param id
 * 
 * @see getListaDeAtracciones
 */
public class Atraccion implements Producto {
	private String nombre;
	private int id;
	private double costoDeVisita;
	private double tiempoPromedioDeVisita;
	private int cupoDePersonasDiario;
	private TipoAtraccion tipoDeAtraccion;

	public Atraccion(String nombre, int costoDeVisita, double tiempoPromedioDeVisita, int cupoDePersonasDiario,
			TipoAtraccion tipoDeAtraccion, int id) {
		this.costoDeVisita = costoDeVisita;
		this.tiempoPromedioDeVisita = tiempoPromedioDeVisita;
		this.cupoDePersonasDiario = cupoDePersonasDiario;
		this.tipoDeAtraccion = tipoDeAtraccion;
		this.nombre = nombre;
		this.id = id;
	}

	@Override
	public String toString() {
		int largoNombre = this.nombre.length();
		int largoAtracc = this.getTipoDeAtraccion().name().length();
		int guiones = (80 - largoAtracc - largoNombre - 8) / 2;

		String respuesta = "\n";
		for (int i = 0; i < guiones; i++)
			respuesta += "=";
		respuesta += "  " + this.nombre + " (" + this.tipoDeAtraccion + ")  ";
		for (int i = 0; i < guiones; i++)
			respuesta += "=";
		respuesta += "\n  Precio lista: " + (int) this.costoDeVisita + " monedas. " + "--  Tiempo prom. de Visita : "
				+ this.tiempoPromedioDeVisita + " hora";
		if (this.tiempoPromedioDeVisita > 1)
			respuesta += "s";
		respuesta += ".\n";

		return respuesta;
	}

	public String getNombre() {
		return this.nombre;
	}

	public double getCostoDeVisita() {
		return this.costoDeVisita;
	}

	public boolean esPromocion() {
		return false;
	}

	public List<Atraccion> getListaDeAtracciones() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(this);
		return atracciones;
	}

	public int getId() {
		return this.id;
	}

	public double getTiempoPromedioDeVisita() {
		return this.tiempoPromedioDeVisita;
	}

	public void disminuirCupo() {
		cupoDePersonasDiario -= 1;
	}

	public int getCupoDePersonasDiario() {
		return cupoDePersonasDiario;
	}

	public int compareTo(Producto o2) {
		// Primero Ofrece Promociones
		if (this.esPromocion() && !o2.esPromocion()) {
			return -1;
		} else if (!this.esPromocion() && o2.esPromocion()) {
			return 1;
		}
		// si no se da ese caso se prioriza la más cara
		double diferencia = o2.getCostoDeVisita() - this.getCostoDeVisita();
		if (diferencia != 0) {
			return (int) diferencia;
		}
		// Si tienen el mismo precio prioriza el mas largo
		return (int) (o2.getTiempoPromedioDeVisita() - this.getTiempoPromedioDeVisita());
	}

	public TipoAtraccion getTipoDeAtraccion() {
		return this.tipoDeAtraccion;
	}

	public boolean contiene(Producto p) {
		if (p.esPromocion()) {
			return p.contiene(this);
		}
		return this.equals(p);
	}

	public boolean tieneCupo() {
		return cupoDePersonasDiario > 0;
	}
}
