package hansolo.marioparty.tablero.casilleros;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;

// Casillero que le da o le saca un item al jugador que cae
public class ItemCasillero extends Casillero {

	public ItemCasillero(int id, SiguienteCasillero[] next) {
		super(id, next, false);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void efecto(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

}
