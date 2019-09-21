package hansolo.marioparty.tablero.casilleros;

import hansolo.marioparty.entidades.Jugador;

// Casillero que, cuando pasas o caés, te pregunta a cual de los next querés moverte
public class BifurcacionCasillero extends Casillero {

	public BifurcacionCasillero(Casillero[] next) {
		super(next, true);
	}

	// Tiene que preguntar en qué dirección quiere seguir el jugador
	@Override
	public void efecto(Jugador jugador) {
		
	}
}
