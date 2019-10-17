package minijuego.launcher;

import minijuego.Minijuego;

public class LauncherMinijuego {

	public static void main(String[] args) {
		Minijuego minijuego = new Minijuego("Minijuego", 600, 300);
		minijuego.start();
	}
}
