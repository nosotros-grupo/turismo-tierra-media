package tierraMedia;

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
			sc = new Scanner(new File(archivo), "Cp1252");

			while (sc.hasNext()) {
				Atraccion a = null;
				try {
					a = crearAtraccion(sc);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (!atracciones.contains(a))
					atracciones.add(a);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error de lectura");
		} 
		sc.close();
		return atracciones;
		}
		
	
		//crear errorCrearAtraccion
	private Atraccion crearAtraccion(Scanner sc) {
		String linea = sc.nextLine();
		String datos[] = linea.split(",");
		String nombre = datos[0];
		int columnaLeida = 1;
		Atraccion atraccion = null;
		try{
		int costoDeVisita = Integer.parseInt(datos[1]);
		columnaLeida++;
		double tiempoPromedioDeVisita = Double.parseDouble(datos[2]);
		columnaLeida++;
		int cupoDePersonasDiario = Integer.parseInt(datos[3]);
		columnaLeida++;
		TipoAtraccion tipoDeAtraccion = TipoAtraccion.valueOf(datos[4].toUpperCase());
		int id = Integer.parseInt(datos[5]);
		atraccion = new Atraccion(nombre, costoDeVisita, tiempoPromedioDeVisita, cupoDePersonasDiario, tipoDeAtraccion, id);
		
		
		}catch(NumberFormatException e){
			System.out.println(datos[0] + " Contiene el dato " + datos[columnaLeida] + " que no puede ser leido correctamente");
		}catch(IllegalArgumentException e) {
			System.out.println(datos[0] + " Contiene el tipo de atraccion " + datos[4] + " que no existe");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(datos[0] + "No contiene todos los datos necesarios");
		}
		return atraccion;
	}
}

