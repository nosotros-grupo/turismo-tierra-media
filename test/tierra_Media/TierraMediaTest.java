package tierra_Media;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TierraMediaTest {
	
	@Before
	public void before() {
	Usuario Eowyn = new Usuario(10, 8, Tipo_de_Atraccion.AVENTURA);
	Usuario Gandalf = new Usuario(100, 5, Tipo_de_Atraccion.PAISAJES);
	Usuario Sam = new Usuario(36, 1, Tipo_de_Atraccion.BANQUETES);
	Usuario Galadriel = new Usuario(120, 8, Tipo_de_Atraccion.PASEOS_CONTEMPLATIVOS);
	Atraccion Moria = new Atraccion(10,2,6,Tipo_de_Atraccion.AVENTURA);
	Atraccion MinasTirith = new Atraccion(5,2.5,25,Tipo_de_Atraccion.PAISAJES);
	}

	@Test
	public void test() {
	
	}
}

