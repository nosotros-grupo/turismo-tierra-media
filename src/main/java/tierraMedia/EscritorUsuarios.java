package tierraMedia;

public class EscritorUsuarios {

	public static void escribirUsuariosTxt(Usuario u) /* throws IOException */ {
//		String nombreArchivo = u.getName() + ".out";
//		System.out.println(nombreArchivo);
//		List<Atraccion> listaAtracciones = new LinkedList<Atraccion>();
//		PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivo));

		if (u.getCostoTotalDeVisita() > 0) {
//			listaAtracciones = u.getAtraccionesCompradas();

			String frase = " Su visita está compuesta de las siguientes atracciones\n"
					+ "==============================================================\n"
					+ u.getStringAtraccionesCompradas() + "";
			System.out.println(frase + "==============================================================\n"+
					"\n\n\n\n\n");
		} else {
			String frase = "==============================================================\n"
					+ "  Usted no ha realizado compras en esta oportunidad..\n"
					+ "     Esperamos su próxima visita!!  Que tenga un buen día!!";
//			salida.print(frase);
			System.out.println(frase + "\n==============================================================\n\n\n\n\n\n");
		}

//		salida.close();
	}
}
