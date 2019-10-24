package hansolo.marioparty;

public class Launcher {
	public static void main(String[] args) {
		Juego juego = new Juego("Mario party", 1000, 768);
		juego.start();
	}
}
