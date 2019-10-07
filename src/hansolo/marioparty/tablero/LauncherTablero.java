package hansolo.marioparty.tablero;

import hansolo.marioparty.admin.Usuario;
import hansolo.marioparty.entidades.Jugador;

public class LauncherTablero {

	private final static String path = "./recursos/map0.txt";

	public static void main(String[] args) {

		Tablero tab = new Tablero(path);
//		System.out.println();
		Jugador jug = new Jugador(new Usuario("diego"), tab.getCasilleros().get(27), null);
		jug.setMonedas(100);
		jug.setCantMovimientos(5);
		jug.avanzar();
		System.out.println(jug.getEstrellas());
	}
}
