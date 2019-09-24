package hansolo.marioparty;

import hansolo.marioparty.tablero.Tablero;

public class Launcher {
	private static final String path = "./recursos/map0.txt";

	public static void main(String[] args) {
		// Linea que muestra el path de ejecución
		// System.out.println(new File(".").getCanonicalPath());
		
		Tablero tb = new Tablero(path);
		System.out.println();
	}
}
