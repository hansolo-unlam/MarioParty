package hansolo.marioparty.minijuegos.minijuegoObstaculo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import hansolo.marioparty.graficos.Texturas;
import hansolo.marioparty.input.KeyManager;

public class JugadorObstaculo {

	private final int YinicialSuelo = 192;
	private final int height = 256;
	private final int size = 32;

	private int Xinicial;
	private int posYjug = YinicialSuelo;
	private int puntos = 0;

	private boolean muerto = false;
	private boolean saltando = false;

	private int velocidadY = 0;
	private int gravedad = 3;
	private int salto = 15;

	private int numero;
	private int idxTextura;

	private KeyManager keyManager;

	public JugadorObstaculo(int posXinicial, int numero, KeyManager keyManager) {
		this.Xinicial = posXinicial;
		this.keyManager = keyManager;
		this.numero = numero;
	}

	public void gravedad() {
		if (saltando) {
			if (posYjug - velocidadY - gravedad > YinicialSuelo) {
				saltando = false;
				velocidadY = 0;
				posYjug = YinicialSuelo;
			} else {
				velocidadY -= gravedad;
				posYjug -= velocidadY;

			}
		}
	}

	// Teclas para saltar de izquierda a derecha
	private void saltar() {

		if (keyManager.arriba && numero == 1) {
			saltando = true;
			velocidadY = salto;
		}

		if (keyManager.teclaW && numero == 2) {
			saltando = true;
			velocidadY = salto;
		}

		if (keyManager.teclaD && numero == 3) {
			saltando = true;
			velocidadY = salto;
		}

		if (keyManager.derecha && numero == 4) {
			saltando = true;
			velocidadY = salto;
		}
	}

	public void colision(int obstaculoXTierra) {

		if (obstaculoXTierra >= Xinicial && obstaculoXTierra <= Xinicial + size) {
			if (posYjug >= height - size * 2) {
				muerto = true;
				return;
			}
		}
		if (!muerto) {
			puntos++;
		}
	}

	public void verificarTeclado() {
		this.keyManager.calcular();
		saltar();
	}

	public void dibujar(Graphics g) {

		if (muerto == true) {
			return;
		}
		switch (this.numero) {
		case 1:
			g.drawImage(Texturas.mario[idxTextura++], this.Xinicial, this.posYjug, size, size, null);
			break;
		case 2:
			g.drawImage(Texturas.luigi[idxTextura++], this.Xinicial, this.posYjug, size, size, null);
			break;
		case 3:
			g.drawImage(Texturas.luigi[idxTextura++], this.Xinicial, this.posYjug, size, size, null);
			break;
		case 4:
			g.drawImage(Texturas.luigi[idxTextura++], this.Xinicial, this.posYjug, size, size, null);
			break;
		}

		if (idxTextura == Texturas.mario.length) {
			idxTextura = 0;
		}
	}

	public boolean getMuerto() {
		return this.muerto;

	}

}
