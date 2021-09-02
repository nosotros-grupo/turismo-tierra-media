package tierra_Media;

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
	}
}
