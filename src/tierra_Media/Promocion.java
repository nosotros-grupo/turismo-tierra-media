package tierra_Media;

public abstract class Promocion {
	private Atraccion[] atracciones;
	private int costoDeVisita;
	
	public Promocion(int cantidadDeAtracciones, int costoDeVisita) {
		this.atracciones = new Atraccion[cantidadDeAtracciones];
		this.costoDeVisita = costoDeVisita;
	}
	
	public Promocion() {
	}
	
	public abstract double calcularDescuento();
}
