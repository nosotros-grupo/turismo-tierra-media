package tierra_Media;

<<<<<<< HEAD
public abstract class Promocion {
	private Atraccion[] atracciones;
	private int costoDeVisita;
	
	public Promocion(int cantidadDeAtracciones, int costoDeVisita) {
		this.atracciones = new Atraccion[cantidadDeAtracciones];
		this.costoDeVisita = costoDeVisita;
	}
	
	public Promocion() {
=======
public abstract class Promocion implements Producto{
	Atraccion[] atracciones;
	int costoDeVisita;
	public Promocion() {	
	}
	public Tipo_de_Atraccion getTipoDeAtraccion() {
		return atracciones[0].getTipoDeAtraccion();
	}
	public int getCostoDeVisita() {
		return this.costoDeVisita;
>>>>>>> main
	}
	
	public abstract double calcularDescuento();
}
