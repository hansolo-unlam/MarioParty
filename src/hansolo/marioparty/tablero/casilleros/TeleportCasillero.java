package hansolo.marioparty.tablero.casilleros;

import hansolo.marioparty.entidades.Jugador;

// Casillero que, si pag�s una cantidad de monedas, te lleva a la posici�n de otro jugador
public class TeleportCasillero extends Casillero {

	public TeleportCasillero(int id, int[] next, boolean efectoPasandoSobre) {
		super(id, next, false);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void efecto(Jugador jugador) {
		// TODO Auto-generated method stub

	}

}
