package hansolo.marioparty.minijuegos.minijuegoObstaculo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import hansolo.marioparty.graficos.Texturas;
import hansolo.marioparty.input.KeyManager;

public class JugadorObstaculo {

	private final int Y_INICIAL_SUELO = 272;
	private final int HEIGHT = 320;
	private final int SIZE = 32;

	private int x;
	private int y = Y_INICIAL_SUELO;
	private int puntos = 0;

	private boolean saltando = false;

	private int velocidadY = 0;
	private int gravedad = 3;
	private int salto = 15;

	private int numero;
	private int idxTextura;
	private boolean muerto;
	private int posicion;

	private KeyManager keyManager;

	private Animation animation;

	public JugadorObstaculo(int posxInicial, int numero, KeyManager keyManager, BufferedImage[] textura) {
		this.x = posxInicial;
		this.keyManager = keyManager;
		this.numero = numero;
		this.animation = new Animation(50, textura);

	}

	public void salto() {
		if (saltando) {
			if (y - velocidadY - gravedad > Y_INICIAL_SUELO) {
				saltando = false;
				velocidadY = 0;
				y = Y_INICIAL_SUELO;
			} else {
				velocidadY -= gravedad;
				// Cuando la velocidad se vuelve negativa empiza a sumar
				y -= velocidadY;

				if (y <= SIZE + 16) {
					y = SIZE + 16;
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

	public void verificarTeclado() {
		this.keyManager.calcular();
		saltar();
	}

	public void dibujar(Graphics g) {

		if (muerto)
			return;

		animation.tick();
		switch (this.numero) {
		case 1:
			g.drawImage(animation.getCurrentFrame(), this.x, this.y, SIZE, SIZE, null);
			break;
		case 2:
			g.drawImage(animation.getCurrentFrame(), this.x, this.y, SIZE, SIZE, null);
			break;
		case 3:
			g.drawImage(animation.getCurrentFrame(), this.x, this.y, SIZE, SIZE, null);
			break;
		case 4:
			g.drawImage(animation.getCurrentFrame(), this.x, this.y, SIZE, SIZE, null);
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

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setMuerto(boolean b) {
		this.muerto = true;
	}

	public void dibujarPuntaje(Graphics g) {
		int decenas = this.puntos / 10;
		int unidades = this.puntos % 10;

		switch (this.numero) {
		case 1:
			g.drawImage(Texturas.iconoMario, 10, 10, 72, 35, null);
			g.drawImage(Texturas.numeros[decenas], 45, 20, 16, 16, null);
			g.drawImage(Texturas.numeros[unidades], 56, 20, 16, 16, null);
			break;
		case 2:
			g.drawImage(Texturas.iconoLuigi, 92, 10, 72, 35, null);
			g.drawImage(Texturas.numeros[decenas], 127, 20, 16, 16, null);
			g.drawImage(Texturas.numeros[unidades], 137, 20, 16, 16, null);
			break;
		case 3:
			g.drawImage(Texturas.iconoPeach, 174, 10, 72, 35, null);
			g.drawImage(Texturas.numeros[decenas], 209, 20, 16, 16, null);
			g.drawImage(Texturas.numeros[unidades], 219, 20, 16, 16, null);
			break;
		case 4:
			g.drawImage(Texturas.iconoYoshi, 256, 10, 72, 35, null);
			g.drawImage(Texturas.numeros[decenas], 291, 20, 16, 16, null);
			g.drawImage(Texturas.numeros[unidades], 301, 20, 16, 16, null);
			break;

		}
	}

	public boolean isMuerto() {
		return this.muerto;
	}

	public void setPosicion(int nro) {
		this.posicion = nro;

	}

	public void mostrarPosicion(Graphics g) {

		int decenas = this.puntos / 10;
		int unidades = this.puntos % 10;

		switch (this.numero) {
		case 1:
			g.drawImage(Texturas.iconoResultadoM, 50, 100, SIZE * 2, SIZE * 2, null);
			g.drawImage(Texturas.numeros[decenas], 50, 100 + 64, SIZE, SIZE, null);
			g.drawImage(Texturas.numeros[unidades], 82, 100 + 64, SIZE, SIZE, null);
			break;
		case 2:
			g.drawImage(Texturas.iconoResultadoL, 150, 100, SIZE * 2, SIZE * 2, null);
			g.drawImage(Texturas.numeros[decenas], 150, 100 + 64, SIZE, SIZE, null);
			g.drawImage(Texturas.numeros[unidades], 182, 100 + 64, SIZE, SIZE, null);
			break;
		case 3:
			g.drawImage(Texturas.iconoResultadoP, 250, 100, SIZE * 2, SIZE * 2, null);
			g.drawImage(Texturas.numeros[decenas], 250, 100 + 64, SIZE, SIZE, null);
			g.drawImage(Texturas.numeros[unidades], 282, 100 + 64, SIZE, SIZE, null);
			break;
		case 4:
			g.drawImage(Texturas.iconoResultadoY, 350, 100, SIZE * 2, SIZE * 2, null);
			g.drawImage(Texturas.numeros[decenas], 350, 100 + 64, SIZE, SIZE, null);
			g.drawImage(Texturas.numeros[unidades], 382, 100 + 64, SIZE, SIZE, null);
			break;
		default:
			break;
		}
	}

}
