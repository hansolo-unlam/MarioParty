package hansolo.marioparty;

import hansolo.marioparty.tablero.Tablero;

public class Launcher {
	private static final String path = "C:\\Users\\Diego\\Desktop\\Eclipse\\MarioParty\\docs\\mapa.txt";

	public static void main(String[] args) {
		Tablero tb = new Tablero(path);
		System.out.println();
	}
}
