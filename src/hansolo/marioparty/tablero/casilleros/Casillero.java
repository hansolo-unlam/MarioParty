package hansolo.marioparty.tablero.casilleros;

import hansolo.marioparty.entidades.Jugador;

public abstract class Casillero {
	private int id;
	private int[] next;
	private boolean efectoPasandoSobre;

	public Casillero(int idCasillero, int[] next, boolean efectoPasandoSobre) {
		this.id = idCasillero;
		this.next = next;
		this.efectoPasandoSobre = efectoPasandoSobre;
	}
	
	public abstract void efecto(Jugador jugador);

	public int[] getNext() {
		return next;
	}

	public void setNext(int[] next) {
		this.next = next;
	}

	public boolean isEfectoPasandoSobre() {
		return efectoPasandoSobre;
	}

	public void setEfectoPasandoSobre(boolean efectoPasandoSobre) {
		this.efectoPasandoSobre = efectoPasandoSobre;
	}
}
