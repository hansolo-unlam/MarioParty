package hansolo.marioparty.tablero.casilleros;

import hansolo.marioparty.entidades.Jugador;

// Casillero que cuando ca�s en �l te aplica algo malo, dentro de 5 posibles opciones
public class RandomMaloCasillero extends Casillero {

	public RandomMaloCasillero(int id, int[] next) {
		super(id, next, false);
	}

	@Override
	public void efecto(Jugador jugador) {
		// TODO Auto-generated method stub

	}

}
