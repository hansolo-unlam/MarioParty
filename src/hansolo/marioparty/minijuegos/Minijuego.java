package hansolo.marioparty.minijuegos;

import javax.swing.JFrame;

import hansolo.marioparty.Juego;

public abstract class Minijuego {
	
	
	protected Juego juego;
	protected JFrame frame;
	
	public Minijuego(Juego juego){
		this.juego = juego;
	}
	public JFrame getFrame() {
		return frame;
	}

	
	
	
}
