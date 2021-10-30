package tierraMedia;

import java.util.ArrayList;
import java.util.List;

/**
 * @param nombre
 * @param costoDeVisita
 * @param tiempoPromedioDeVisita
 * @param cupoDePersonasDiario
 * @param tipoDeAtraccion
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
		String frase1 = this.stringNombreYcostoYduracion();
		return "\n       ==> " + frase1;
	}

	public String stringNombreYcostoYduracion() {
		Integer costoMonedas = (int) this.costoDeVisita;
		String frase1 = String.format("%1$" + 18 + "s", this.nombre);
		String frase2 = String.format("%1$" + 2 + "s", costoMonedas.toString());
		return frase1 + "  (" + frase2 + " monedas  //  Dur. aprox.: " + tiempoAstring(this.tiempoPromedioDeVisita)
				+ ")";
	}

	public String stringNombreYduracion() {
		String frase1 = String.format("%1$" + 18 + "s", this.nombre);
		return frase1 + "  (Dur. aprox.: " + tiempoAstring(this.tiempoPromedioDeVisita) + ")";
	}

	private String tiempoAstring(double horas) {
		String salida = "";
		Integer intHora = (int) horas;
		double doubleDecHora = 60 * (10 * horas - 10 * intHora) / 10;
		Integer decHora = (int) doubleDecHora;
		if (decHora == 0) {
			if (horas <= 1) {
				salida = intHora.toString() + "h";
			} else {
				salida = intHora.toString() + "hs";
			}
		} else {
			salida = intHora.toString() + "h" + decHora.toString() + "m";
		}
		return salida;
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
