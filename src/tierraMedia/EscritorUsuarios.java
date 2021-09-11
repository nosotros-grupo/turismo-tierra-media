package tierraMedia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscritorUsuarios {
	
	
	public static void escribirUsuarios(Usuario u, int i) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter("salida" + i + ".out"));
		
		if (u.getCostoTotalDeVisita() > 0) {
			salida.print("Compro " + u.getListaAtracciones() + " a " + u.getCostoTotalDeVisita() + " monedas, la visita durara " + u.getTiempoTotalDeVisita() + " minutos. ");
			System.out.println(("Compr� " + u.getListaAtracciones() + " a " + u.getCostoTotalDeVisita() + " monedas, la visita durara " + u.getTiempoTotalDeVisita() + " minutos. "));
		} else {
			salida.print("Usted no ha realizado compras en esta oportunidad, esperamos que en su proxima visita podamos cumplir con sus expectativas o bien puede darle una oportunidad a nuestro parque.");
			System.out.println("Usted no ha realizado compras en esta oportunidad, esperamos que en su proxima visita podamos cumplir con sus expectativas o bien puede darle una oportunidad a nuestro parque.");
		}
		
		salida.close();
	}
}
