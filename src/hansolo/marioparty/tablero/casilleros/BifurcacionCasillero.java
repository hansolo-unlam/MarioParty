package hansolo.marioparty.tablero.casilleros;

import hansolo.marioparty.entidades.Jugador;

public class BifurcacionCasillero extends Casillero {

	public BifurcacionCasillero(Casillero[] next) {
		super(next, true);
	}

	// Tiene que preguntar en qu� direcci�n quiere seguir el jugador
	@Override
	public void efecto(Jugador jugador) {
		
	}
}
