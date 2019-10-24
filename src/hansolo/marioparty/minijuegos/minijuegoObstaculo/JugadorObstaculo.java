package hansolo.marioparty.minijuegos.minijuegoObstaculo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.xml.soap.Text;

import hansolo.marioparty.graficos.Texturas;
import hansolo.marioparty.input.KeyManager;

public class JugadorObstaculo {

	private final int Y_INICIAL_SUELO = 192;
	private final int HEIGHT = 256;
	private final int SIZE = 32;

	private int xInicial;
	private int posYjug = Y_INICIAL_SUELO;
	private int puntos = 0;

	private boolean saltando = false;

	private int velocidadY = 0;
	private int gravedad = 3;
	private int salto = 15;

	private int numero;
	private int idxTextura;

	private KeyManager keyManager;

	public JugadorObstaculo(int posxInicial, int numero, KeyManager keyManager) {
		this.xInicial = posxInicial;
		this.keyManager = keyManager;
		this.numero = numero;
	}

	public void gravedad() {
		if (saltando) {
			if (posYjug - velocidadY - gravedad > Y_INICIAL_SUELO) {
				saltando = false;
				velocidadY = 0;
				posYjug = Y_INICIAL_SUELO;
			} else {
				velocidadY -= gravedad;
				posYjug -= velocidadY;

				if (posYjug <= SIZE + 16) {
					posYjug = SIZE + 16;
				}

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

	public boolean colision(int obstaculoXTierra) {

		if (obstaculoXTierra >= xInicial && obstaculoXTierra <= xInicial + SIZE) {
			if (posYjug >= HEIGHT - SIZE * 2) {
				return true;
			}
		}
		return false;
	}

	public void verificarTeclado() {
		this.keyManager.calcular();
		saltar();
	}

	public void dibujar(Graphics g) {
		int decenas = this.puntos / 10;
		int unidades = this.puntos % 10;

		switch (this.numero) {
		case 1:
			g.drawImage(Texturas.mario[idxTextura++], this.xInicial, this.posYjug, SIZE, SIZE, null);
			g.drawImage(Texturas.iconoMario, 10, 10, 72, 35, null);
			g.drawImage(Texturas.numeros[decenas], 45, 20, 16, 16, null);
			g.drawImage(Texturas.numeros[unidades], 56, 20, 16, 16, null);
			break;
		case 2:
			g.drawImage(Texturas.luigi[idxTextura++], this.xInicial, this.posYjug, SIZE, SIZE, null);
			g.drawImage(Texturas.iconoLuigi, 92, 10, 72, 35, null);
			g.drawImage(Texturas.numeros[decenas], 127, 20, 16, 16, null);
			g.drawImage(Texturas.numeros[unidades], 137, 20, 16, 16, null);
			break;
		case 3:
			g.drawImage(Texturas.luigi[idxTextura++], this.xInicial, this.posYjug, SIZE, SIZE, null);
			g.drawImage(Texturas.iconoPeach, 174, 10, 72, 35, null);
			g.drawImage(Texturas.numeros[decenas], 209, 20, 16, 16, null);
			g.drawImage(Texturas.numeros[unidades], 219, 20, 16, 16, null);
			break;
		case 4:
			g.drawImage(Texturas.luigi[idxTextura++], this.xInicial, this.posYjug, SIZE, SIZE, null);
			g.drawImage(Texturas.iconoYoshi, 256, 10, 72, 35, null);
			g.drawImage(Texturas.numeros[decenas], 291, 20, 16, 16, null);
			g.drawImage(Texturas.numeros[unidades], 301, 20, 16, 16, null);
			break;
		}

		if (idxTextura == Texturas.mario.length) {
			idxTextura = 0;
		}
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
}
