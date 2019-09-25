package hansolo.marioparty.tablero.casilleros;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;

/**
 * Casillero que, al caer en él, te da o te quita una cierta cantidad de monedas (+3 o -3)
 * @author facundotourn
 *
 */
public class MonedaCasillero extends Casillero {
	private int cantMonedas; // positivo o negativo

	public MonedaCasillero(int id, SiguienteCasillero[] next, int signo) {
		super(id, next, false);
		this.cantMonedas = 3 * signo;
	}

	@Override
	public void efecto(Jugador jugador) {
		System.out.println(jugador.getUser().getNombre() + " calló en un casillero de monedas");

		jugador.setMonedas(this.cantMonedas);
	}

	public int getMoneda() {
		return this.cantMonedas;
	}

}
