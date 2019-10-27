package hansolo.marioparty.minijuegos.minijuegoObstaculo;

import java.awt.Graphics;

import hansolo.marioparty.graficos.Texturas;

public class Obstaculo implements Colisionable {

	private final int X_INCIAL = 1024;
	private final int Y_INICIAL = 272;
	private final int SIZE = 32;

	private int posX = X_INCIAL;

	public Obstaculo(int desplazamiento) {
		this.posX += desplazamiento;
	}

	public void dibujar(Graphics g) {
		g.drawImage(Texturas.tubo, posX, Y_INICIAL, SIZE, SIZE, null);
	}

	public void calcularPosicion(int desplazamiento) {
		if (this.posX <= 0) {
			posX = X_INCIAL;
		} else {
			posX -= desplazamiento;
		}
	}

	public boolean isPosicionFinal() {
		if (this.posX <= 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean colisiona(int x, int y) {

		if (this.posX >= x && this.posX <= x + SIZE) {
			if (y >= this.Y_INICIAL) {
				return true;
			}

		}
		return false;
	}
}
