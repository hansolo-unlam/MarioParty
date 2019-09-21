package hansolo.marioparty.tablero;

import hansolo.marioparty.entidades.Jugador;

// casillero que, al pasar o caer en él, te deja comprar una estrella
public class EstrellaCasillero extends Casillero {
	private final int PRECIO_ESTRELLA = 30;

	public EstrellaCasillero(Casillero[] next) {
		super(next, true);
	}

	@Override
	public void efecto(Jugador jugador) {
		
	}

}
