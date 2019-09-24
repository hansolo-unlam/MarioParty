package hansolo.marioparty.tablero.casilleros;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;

// casillero que, al caer en �l, te da o te quita una cierta cantidad de monedas (+3 o -3)
public class MonedaCasillero extends Casillero {
	private int cantMonedas; // positivo o negativo

	public MonedaCasillero(int id, SiguienteCasillero[] next, int signo) {
		super(id, next, false);
		this.cantMonedas = 3 * signo;
	}

	@Override
	public void efecto(Jugador jugador) {
		System.out.println(jugador.getUser().getNombre() + " pas� por casillero de monedas");

		jugador.setEstrellas(this.cantMonedas);
	}

	public int getMoneda() {
		return this.cantMonedas;
	}

}
