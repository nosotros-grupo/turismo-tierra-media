package tierraMedia;

import static org.junit.Assert.*;

import org.junit.Test;

public class TierraMediaTest {
	//Sumar test que fallen
	@Test
	public void creacionDeUsuarios() {
		Usuario Eowyn = new Usuario(10, 8, TipoAtraccion.AVENTURA, "Eowyn", 12);
		Usuario Gandalf = new Usuario(100, 5, TipoAtraccion.PAISAJE, "Gandalf",11);
		Usuario Sam = new Usuario(36, 1, TipoAtraccion.BANQUETE, "Sam",10);
		
		assertEquals(10, Eowyn.getPresupuesto());
		assertEquals(5, Gandalf.getTiempoDisponible(), 0);
		assertEquals(TipoAtraccion.BANQUETE, Sam.getTipoPreferidoDeAtraccion());
	}
	/*
	@Test
	public void creacionDeAtracciones() {
		Atraccion Moria = new Atraccion(10, 2, 6, TipoAtraccion.AVENTURA);
		Atraccion MinasTirith = new Atraccion(5, 2.5, 25,TipoAtraccion.PAISAJE);
		
		assertEquals(10, Moria.getCostoDeVisita(), 0);
		assertEquals(2.5, MinasTirith.getTiempoPromedioDeVisita(), 0);
		assertEquals(6, Moria.getCupoDePersonasDiario());
		assertEquals(TipoAtraccion.PAISAJE, MinasTirith.getTipoAtraccion());
	}
	*/
	
	@Test
	public void lecturaDeUsuarios() {
		TierraMedia tierra = new TierraMedia();
		tierra.registrarUsuarios("usuarios.in");
		
		assertEquals(TipoAtraccion.DEGUSTACION, tierra.usuarios.get(0).getTipoPreferidoDeAtraccion());
		assertEquals(7, tierra.usuarios.get(1).getTiempoDisponible(), 0);
		assertEquals(50, tierra.usuarios.get(2).getPresupuesto());
	}
	
	@Test
	public void lecturaDeAtracciones() {
		TierraMedia tierra = new TierraMedia();
		tierra.registrarAtracciones("atracciones.in");
		assertEquals(TipoAtraccion.AVENTURA, tierra.atracciones.get(0).getTipoDeAtraccion());
		assertEquals(16, tierra.atracciones.get(1).getCostoDeVisita(), 0);
		assertEquals(2.5, tierra.atracciones.get(1).getTiempoPromedioDeVisita(), 0.001);
	}

}
