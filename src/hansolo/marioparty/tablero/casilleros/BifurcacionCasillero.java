package hansolo.marioparty.tablero.casilleros;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.Casillero;

// Casillero que, cuando pasas o caés, te pregunta a cual de los next querés moverte
public class BifurcacionCasillero extends Casillero {

	public BifurcacionCasillero(int id, int[] next) {
		super(id, next, true);
	}

	// Tiene que preguntar en qué dirección quiere seguir el jugador
	@Override
	public void efecto(Jugador jugador) {
		System.out.println(jugador.getUser().getNombre() + " pasó por una bifurcación");
	}
}
