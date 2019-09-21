package hansolo.marioparty.tablero.casilleros;

import hansolo.marioparty.entidades.Jugador;

// casillero que, al pasar o caer en �l, te deja comprar una estrella
public class EstrellaCasillero extends Casillero {
	private final int PRECIO_ESTRELLA = 30;

	public EstrellaCasillero(int id, int[] next) {
		super(id, next, true);
	}

	@Override
	public void efecto(Jugador jugador) {
		
	}

}
