package hansolo.marioparty.tablero.casilleros;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;

/**
 * Casillero que al caer en él, te permite pagar para sacarle un item o una estrella a otro jugador
 * @author facundotourn
 *
 */
public class HurtoCasillero extends Casillero {
	public HurtoCasillero(int id, SiguienteCasillero[] next) {
		super(id, next, false);
	}

	@Override
	public void efecto(Jugador jugador) {
		System.out.println(jugador.getUser().getNombre() + " calló en un casillero de hurto");
	}

}
