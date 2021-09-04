package tierra_Media;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class LectorAtracciones {
	
	public LinkedList<Atraccion> leerAtracciones(String archivo) {
		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
		
		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {
				Atraccion a = crearAtraccion(sc);
				if (!atracciones.contains(a))
					atracciones.add(a);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();
		return atracciones;
		}
	
	private Atraccion crearAtraccion(Scanner sc) {
		String linea = sc.nextLine();
		String datos[] = linea.split(" ");
		int costoDeVisita = Integer.parseInt(datos[0]);
		double tiempoPromedioDeVisita = Double.parseDouble(datos[1]);
		int cupoDePersonasDiario = Integer.parseInt(datos[2]);
		TipoAtraccion tipoDeAtracción = TipoAtraccion.valueOf(datos[3].toUpperCase());
		Atraccion atraccion = new Atraccion(costoDeVisita, tiempoPromedioDeVisita, cupoDePersonasDiario, tipoDeAtracción);
		
		return atraccion;
	}
}

