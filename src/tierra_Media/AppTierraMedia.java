package tierra_Media;

public class AppTierraMedia {
	
	
	
	public static void main(String[] args) {
		TierraMedia tierra = new TierraMedia();
		tierra.registrarUsuarios("usuarios.in");
		System.out.println(tierra.usuarios.get(0));
	}
}
