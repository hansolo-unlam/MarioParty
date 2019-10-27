package hansolo.marioparty.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	private boolean[] teclas;
	public boolean teclaA, teclaS, teclaD, teclaW;
	public boolean teclaG, teclaH, teclaJ, teclaY;
	public boolean izquierda, abajo, derecha, arriba;
	public boolean tecla4, tecla5, tecla6, tecla8;
	public boolean enter;
	public boolean espacio;

	public KeyManager() {
		teclas = new boolean[256];
	}

	public void calcular() {

		espacio = teclas[KeyEvent.VK_SPACE];
		enter = teclas[KeyEvent.VK_ENTER];

		// controles jugador 1
		teclaW = teclas[KeyEvent.VK_W];
		teclaS = teclas[KeyEvent.VK_S];
		teclaA = teclas[KeyEvent.VK_A];
		teclaD = teclas[KeyEvent.VK_D];

		// controles jugador 2
		teclaY = teclas[KeyEvent.VK_Y];
		teclaH = teclas[KeyEvent.VK_H];
		teclaG = teclas[KeyEvent.VK_G];
		teclaJ = teclas[KeyEvent.VK_J];

		// controles jugador 3
		arriba = teclas[KeyEvent.VK_UP];
		abajo = teclas[KeyEvent.VK_DOWN];
		izquierda = teclas[KeyEvent.VK_LEFT];
		derecha = teclas[KeyEvent.VK_RIGHT];

		// controles jugador 4
		tecla8 = teclas[KeyEvent.VK_8];
		tecla5 = teclas[KeyEvent.VK_5];
		tecla4 = teclas[KeyEvent.VK_4];
		tecla6 = teclas[KeyEvent.VK_6];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		teclas[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Cuando sueltan una tecla
		teclas[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
