package hansolo.marioparty.tablero.casilleros;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;

// Casillero que al caer en él, te permite pagar para sacarle un item o una estrella a otro jugador
public class HurtoCasillero extends Casillero {
	public HurtoCasillero(int id, SiguienteCasillero[] next) {
		super(id, next, false);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void efecto(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

}
