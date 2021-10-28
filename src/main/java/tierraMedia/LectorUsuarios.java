package tierraMedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class LectorUsuarios {

	public LinkedList<Usuario> leerUsuarios(String archivo) {

		LinkedList<Usuario> ingresantes = new LinkedList<Usuario>();

		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {
				Usuario u = null;
				try {
					u = crearUsuario(sc);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (!ingresantes.contains(u))
					ingresantes.add(u);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error de lectura ");
		}
		sc.close();
		return ingresantes;
	}

	private Usuario crearUsuario(Scanner linea) {
		String lin = linea.nextLine();
		String datos[] = lin.split(" ");
		int presupuesto = Integer.parseInt(datos[0]);
		double tiempoDisponible = Double.parseDouble(datos[1]);
		TipoAtraccion tipoDeAtraccion = TipoAtraccion.valueOf(datos[2].toUpperCase());
		String nombre = datos[3];
		int id = Integer.parseInt(datos[4]);
		Usuario user = new Usuario(presupuesto, tiempoDisponible, tipoDeAtraccion, nombre, id);

		return user;
	}
}
