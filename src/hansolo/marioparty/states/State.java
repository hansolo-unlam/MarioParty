package hansolo.marioparty.states;

import java.awt.Graphics;

import hansolo.marioparty.Juego;

public abstract class State {
	
	// en esta parte de la clase está definida la gestión de estados
	private static State estadoActual = null;
	
	public static void setState(State state) {
		estadoActual = state;
	}
	
	public static State getState() {
		return estadoActual;
	}
	
	// en esta parte de la clase está la parte abstracta que van a heredar las clases de estado (JuegoState, MinijuegoState, etc)
	protected Juego juego;
	
	public State(Juego juego) {
		this.juego = juego;
	}
	
	// todos los estados tienen que recalcular los cambios
	public abstract void calcular();
	
	// todos los estados tienen que dibujarse
	public abstract void dibujar(Graphics g);
}
