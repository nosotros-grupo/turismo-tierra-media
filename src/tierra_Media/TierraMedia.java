package tierra_Media;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

//construi esta clase porque pense que Tierra Media es quien debe saber poder brindar los itinerarios y registrar los usuarios.

public class TierraMedia {
	//se que esta mal pero es para testear que no este privado pero es para testear
	LinkedList<Usuario> usuarios;
	
	public void registrarUsuarios(String archivo) {
		LinkedList<Usuario> ingresantes = new LinkedList<Usuario>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String datos[] = linea.split(" ");
				int presupuesto = Integer.parseInt(datos[0]);
				double tiempoDisponible = Double.parseDouble(datos[1]);
				Tipo_de_Atraccion tipoDeAtracción = Enum.valueOf(Tipo_de_Atraccion.class, datos[2]);
				Usuario u = new Usuario(presupuesto, tiempoDisponible, tipoDeAtracción);

				if (!ingresantes.contains(u))
					ingresantes.add(u);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();

		this.usuarios = ingresantes;
	}
	
}
