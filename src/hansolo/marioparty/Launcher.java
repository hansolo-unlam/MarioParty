package hansolo.marioparty;

public class Launcher {
	public static void main(String[] args) {
		Juego juego = new Juego("Mario party", 640, 640);
		juego.start();
	}
}
