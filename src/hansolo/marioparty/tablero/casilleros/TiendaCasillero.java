package hansolo.marioparty.tablero.casilleros;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;

/**
 * Casillero que, cuando un jugador cae en �l, le permite comprar un item de una lista de items a cambio de una cantidad de monedas, dependiendo del item.
 * @author facundotourn
 *
 */
public class TiendaCasillero extends Casillero {

	public TiendaCasillero(int id, SiguienteCasillero[] next) {
		super(id, next, true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void efecto(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

}
