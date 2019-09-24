package hansolo.marioparty.tablero.casilleros;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;

// Casillero que, si pagás una cantidad de monedas, te lleva a la posición de otro jugador
public class TeleportCasillero extends Casillero {

	public TeleportCasillero(int id, SiguienteCasillero[] next) {
		super(id, next, false);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void efecto(Jugador jugador) {
		// TODO Auto-generated method stub

	}

}
