package hansolo.marioparty.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	private boolean[] teclas;
	public boolean arriba, abajo, izquierda, derecha, teclaA, teclaS, teclaD, teclaW;
	
	public KeyManager() {
		teclas = new boolean[256];
	}
	
	public void calcular() {
		// Controles jugador 1
		teclaW = teclas[KeyEvent.VK_W];
		teclaS = teclas[KeyEvent.VK_S];
		teclaA = teclas[KeyEvent.VK_A];
		teclaD = teclas[KeyEvent.VK_D];
		
		// Controles jugador 2
		arriba = teclas[KeyEvent.VK_UP];
		abajo = teclas[KeyEvent.VK_DOWN];
		izquierda = teclas[KeyEvent.VK_LEFT];
		derecha = teclas[KeyEvent.VK_RIGHT];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// Cuando aprietan cualquier tecla
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
