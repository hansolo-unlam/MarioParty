package hansolo.marioparty.tablero.casilleros;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.Casillero;

// Casillero que cuando ca�s en �l te aplica algo malo, dentro de 5 posibles opciones
public class RandomMaloCasillero extends Casillero {

	public RandomMaloCasillero(int id, int[] next) {
		super(id, next, false);
	}

	@Override
	public void efecto(Jugador jugador) {
		System.out.println(jugador.getUser().getNombre() + " pas� por casillero malo");

	}

}
