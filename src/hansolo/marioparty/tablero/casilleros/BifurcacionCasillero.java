package hansolo.marioparty.tablero.casilleros;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.Casillero;

// Casillero que, cuando pasas o ca�s, te pregunta a cual de los next quer�s moverte
public class BifurcacionCasillero extends Casillero {

	public BifurcacionCasillero(int id, int[] next) {
		super(id, next, true);
	}

	// Tiene que preguntar en qu� direcci�n quiere seguir el jugador
	@Override
	public void efecto(Jugador jugador) {
		System.out.println(jugador.getUser().getNombre() + " pas� por una bifurcaci�n");
	}
}
