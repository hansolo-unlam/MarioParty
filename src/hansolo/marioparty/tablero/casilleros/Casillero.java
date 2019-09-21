package hansolo.marioparty.tablero.casilleros;

import hansolo.marioparty.entidades.Jugador;

public abstract class Casillero {
	private Casillero[] next;
	private boolean efectoPasandoSobre;
	
	public Casillero(Casillero[] next, boolean efectoPasandoSobre) {
		this.next = next;
		this.efectoPasandoSobre = efectoPasandoSobre;
	}
	
	public abstract void efecto(Jugador jugador);
}
