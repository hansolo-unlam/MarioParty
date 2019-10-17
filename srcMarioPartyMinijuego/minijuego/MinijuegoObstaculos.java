package minijuego;

import java.awt.Color;
import java.awt.Graphics;


public class MinijuegoObstaculos {

	private final int desplazamiento = 74;
	private final int tamaño = 64;
	// Posicion inicial de jugadores
	private final int JUG_POS_X_INI = 20;
	private final int JUG_POS_Y_INI = 150;

	// Posicion inicial de obstaculos

	private final int OBS_POS_X_INI = Minijuego.width - 100;
	private final int OBS_POS_Y_INI = 150;
	private int obsPosX = OBS_POS_X_INI;

	private Minijuego minijuego;

	public MinijuegoObstaculos(Minijuego minijuego) {
		this.minijuego = minijuego;
	}

	@SuppressWarnings("static-access")
	public void dibujar(Graphics g) {

		int jugadorY = this.JUG_POS_Y_INI;

		g.setColor(Color.white);

		if (minijuego.getKeyManager().arriba) {
			jugadorY -= desplazamiento;
		}

		g.drawRect(JUG_POS_X_INI, jugadorY, tamaño, tamaño);

		if (this.obsPosX == 0) {
			this.obsPosX = OBS_POS_X_INI;
		} else {
			this.obsPosX -= 2;
		}
		g.drawRect(obsPosX, OBS_POS_Y_INI, tamaño, tamaño);
		jugadorY = this.JUG_POS_Y_INI;
	}

}
