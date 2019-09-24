package hansolo.marioparty.tablero;

import hansolo.marioparty.entidades.Jugador;

public abstract class Casillero {
	private int id;
	private SiguienteCasillero[] next;
	private boolean efectoPasandoSobre;

	public Casillero(int idCasillero, SiguienteCasillero[] next, boolean efectoPasandoSobre) {
		this.id = idCasillero;
		this.next = next;
		this.efectoPasandoSobre = efectoPasandoSobre;
	}
	
	public abstract void efecto(Jugador jugador);

	public SiguienteCasillero[] getNext() {
		return next;
	}

	public void setNext(SiguienteCasillero[] next) {
		this.next = next;
	}

	public boolean isEfectoPasandoSobre() {
		return efectoPasandoSobre;
	}

	public void setEfectoPasandoSobre(boolean efectoPasandoSobre) {
		this.efectoPasandoSobre = efectoPasandoSobre;
	}
}
