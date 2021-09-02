package tierra_Media;

import static org.junit.Assert.*;

import org.junit.Test;

public class TierraMediaTest {
	
	@Test
	public void creaciónDeUsuarios() {
		Usuario Eowyn = new Usuario(10, 8, Tipo_de_Atraccion.AVENTURA);
		Usuario Gandalf = new Usuario(100, 5, Tipo_de_Atraccion.PAISAJE);
		Usuario Sam = new Usuario(36, 1, Tipo_de_Atraccion.BANQUETE);
		
		assertEquals(10, Eowyn.getPresupuesto());
		assertEquals(5, Gandalf.getTiempoDisponible(), 0);
		assertEquals(Tipo_de_Atraccion.BANQUETE, Sam.getTipoPreferido());
	}
	
	@Test
	public void creaciónDeAtracciones() {
		Atraccion Moria = new Atraccion(10, 2, 6, Tipo_de_Atraccion.AVENTURA);
		Atraccion MinasTirith = new Atraccion(5, 2.5, 25,Tipo_de_Atraccion.PAISAJE);
		
		assertEquals(10, Moria.getCostoDeVisita(), 0);
		assertEquals(2.5, MinasTirith.getTiempoPromedioDeVisita(), 0);
		assertEquals(6, Moria.getCupoDePersonasDiario());
		assertEquals(Tipo_de_Atraccion.PAISAJE, MinasTirith.getTipoDeAtraccion());
	}
}

