package hansolo.marioparty.tablero.casilleros;

import java.util.Random;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;

/**
 * Casillero que le hace algo malo al jugador que cae en él
 * 
 * @author facundotourn
 *
 */
public class RandomMaloCasillero extends Casillero {

	public RandomMaloCasillero(int id) {
		super(id, false);
	}

	@Override
	public void efecto(Jugador jugador) {
		// Si la probabilidad es mayor 0.85 verifica si le puedo sacar estrellas si es
		// menor le saca monedas.
		double probabilidad = Math.random();

		if (probabilidad < 0.85) {

			if (jugador.getMonedas() > 0) {
				Random r = new Random();

				int monedasEliminadas = jugador.getMonedas() * r.nextInt(5) / 10;

				if (jugador.getMonedas() < monedasEliminadas) {
					jugador.setMonedas(0);
				} else {
					jugador.setMonedas(-monedasEliminadas);
				}
			}
		} else {
			if (jugador.getEstrellas() > 0) {
				jugador.setEstrellas(-1);
			}
		}
	}

}
