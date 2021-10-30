package tierraMedia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscritorUsuarios {

	public static void escribirUsuariosTxt(Usuario u) throws IOException {
		String nombreArchivo = u.getName() + ".out";
//		System.out.println(nombreArchivo);

		PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivo));

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
		}

		salida.close();
	}
}
