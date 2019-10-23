package hansolo.marioparty;

public class Launcher {
	public static void main(String[] args) {
		Juego juego = new Juego("Mario party", 900, 768);
		juego.start();
	}
}
