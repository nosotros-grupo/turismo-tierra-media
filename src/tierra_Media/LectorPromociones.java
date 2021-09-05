package tierra_Media;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LectorPromociones {

	public List<Promocion> leerPromociones(String archivo) {
		List<Promocion> promos = new ArrayList<Promocion>();
		
		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {
				Promocion p = crearPromocion(sc);
				if (!promos.contains(p))
					promos.add(p);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();
		return promos;
		}
	
	private Promocion crearPromocion(Scanner sc) {
		Promocion promocion = null;
		String linea = sc.nextLine();
		String datos[] = linea.split(" ");
		if(datos[0].toUpperCase() == "PROMOCIONABSOLUTA") {
			switch(Integer.valueOf(datos[2])) 
			{
			case 1: promocion = new PromocionAbsoluta(Integer.valueOf(datos[1]), datos[3]));
				break;
			case 2: promocion = new PromocionAbsoluta(Integer.valueOf(datos[1]), datos[3], datos[4]);
				break;
			}
					
		}
		if(datos[0].toUpperCase() == "PROMOCIONAXB") {
			promocion = new PromocionAxB(null, null);
		}
		if(datos[0].toUpperCase() == "PROMOCIONPORCENTUAL") {
			promocion = new PromocionPorcentual(null, Double.valueOf(datos[1]));
		}
		return promocion;
	}
	
	public static void main(String[] args) {
		LectorPromociones lectorPro = new LectorPromociones();
		
	}
}
