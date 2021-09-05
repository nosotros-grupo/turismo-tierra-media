package tierra_Media;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LectorAtracciones {
	
	public List<Atraccion> leerAtracciones(String archivo) {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		
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
		String nombre = datos[0];
		int costoDeVisita = Integer.parseInt(datos[1]);
		double tiempoPromedioDeVisita = Double.parseDouble(datos[2]);
		int cupoDePersonasDiario = Integer.parseInt(datos[3]);
		TipoAtraccion tipoDeAtracción = TipoAtraccion.valueOf(datos[4].toUpperCase());
		Atraccion atraccion = new Atraccion(nombre, costoDeVisita, tiempoPromedioDeVisita, cupoDePersonasDiario, tipoDeAtracción);
		
		return atraccion;
	}
}

