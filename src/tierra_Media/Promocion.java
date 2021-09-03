package tierra_Media;


public abstract class Promocion implements Producto{
	Atraccion[] atracciones;
	int costoDeVisita;
	public Promocion() {	
	}
	public Tipo_de_Atraccion getTipoDeAtraccion() {
		return atracciones[0].getTipoDeAtraccion();
	}
	public Promocion(int cantidadDeAtracciones, int costoDeVisita) {
		this.atracciones = new Atraccion[cantidadDeAtracciones];
		this.costoDeVisita = costoDeVisita;
	}
	public double getCostoDeVisita() {
		return this.costoDeVisita;
	}
	
	public abstract double calcularDescuento();
}
