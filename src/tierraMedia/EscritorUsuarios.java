package tierraMedia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscritorUsuarios {

	public static void escribirUsuarios(Usuario u, int i) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter("salida" + i + ".out"));

		if (u.getCostoTotalDeVisita() > 0) {
			String frase = "===============================================================================\n  Compro "
					+ u.getListaAtracciones() + "\n  a " + u.getCostoTotalDeVisita() + " monedas, "
					+ "la visita durara " + u.getTiempoTotalDeVisita() + " horas.";
			salida.print(frase);
			System.out.println(frase
					+ "\n===============================================================================\n\n\n\n\n\n");
		} else {
			String frase = "===============================================================================\n"
					+ "  Usted no ha realizado compras en esta oportunidad..\n"
					+ "     Esperamos su próxima visita!!  Que tenga un buen día!!";
			salida.print(frase);
			System.out.println(frase
					+ "\n===============================================================================\n\n\n\n\n\n");
//			salida.print("Usted no ha realizado compras en esta oportunidad, esperamos que en su proxima visita podamos cumplir con sus expectativas o bien puede darle una oportunidad a nuestro parque.");
//			System.out.println("Usted no ha realizado compras en esta oportunidad, esperamos que en su proxima visita podamos cumplir con sus expectativas o bien puede darle una oportunidad a nuestro parque.");
		}

		salida.close();
	}
}
