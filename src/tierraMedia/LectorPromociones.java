package tierraMedia;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LectorPromociones {
	private List<Atraccion> atracciones;
	
	public LectorPromociones(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}
	public List<Promocion> leerPromociones(String archivo) {
		List<Promocion> promos = new ArrayList<Promocion>();
		
		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {
				Promocion p = null;
				try {
					p = crearPromocion(sc);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (!promos.contains(p))
					promos.add(p);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error de lectura");
		}
		sc.close();
		return promos;
		}
	
	private Promocion crearPromocion(Scanner sc) {
		Promocion promocion = null;
		String linea = sc.nextLine();
		String datos[] = linea.split(",");
		
		if(datos[0].toUpperCase().equals("PROMOCIONABSOLUTA")) {
			List<Atraccion> atraccionesIncluidas = new ArrayList<Atraccion>();
			for(int i = 3; i<Integer.valueOf(datos[2])+3;i++) {
				for(int i2 = 0; i2 < atracciones.size();i2++ ) {
					if(datos[i].equals(atracciones.get(i2).getNombre())) {
						atraccionesIncluidas.add(atracciones.get(i2));
					}
				}
			}
			promocion = new PromocionAbsoluta(Integer.valueOf(datos[1]), atraccionesIncluidas);
		}else {
			if(datos[0].toUpperCase().equals("PROMOCIONAXB")) {
				List<Atraccion> atraccionesTotales = new ArrayList<Atraccion>();
				List<Atraccion> atraccionesBonificadas = new ArrayList<Atraccion>();
				Boolean gratis = false; 
				for(int i = 1; i < datos.length;i++) {
						if(datos[i].equals("Gratis")) {gratis=true;}else { 
						for(int i2 = 0; i2 < atracciones.size();i2++ ) {
							if(datos[i].equals(atracciones.get(i2).getNombre())) {
								atraccionesTotales.add(atracciones.get(i2));
								if(gratis) {
									atraccionesBonificadas.add(atracciones.get(i2));
									}
								}
							}
						}
					}
				promocion = new PromocionAxB(atraccionesTotales, atraccionesBonificadas);
			}else {
				if(datos[0].toUpperCase().equals("PROMOCIONPORCENTUAL")) {
					List<Atraccion> atraccionesIncluidas = new ArrayList<Atraccion>();
					for(int i = 2; i < datos.length;i++) {
						for(int i2 = 0; i2 < atracciones.size();i2++ ) {
							if(datos[i].equals(atracciones.get(i2).getNombre())) {
								atraccionesIncluidas.add(atracciones.get(i2));
							}
						}
					}
					int descuento = Integer.valueOf(datos[1]);
					promocion = new PromocionPorcentual(descuento, atraccionesIncluidas);
				}else {
					System.out.println(datos[0] + " no es un tipo de promocion válida");
					}
			}
		}
		return promocion;
	}
}
