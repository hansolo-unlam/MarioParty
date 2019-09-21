package hansolo.marioparty.tablero.casilleros;

import hansolo.marioparty.entidades.Jugador;

// casillero que, al caer en él, te da o te quita una cierta cantidad de monedas (+3 o -3)
public class MonedaCasillero extends Casillero {
	private int cantMonedas; // positivo o negativo

	public MonedaCasillero(Casillero[] next, int cantMonedas) {
		super(next, false);
		this.cantMonedas = cantMonedas;
	}

	@Override
	public void efecto(Jugador jugador) {
		
	}

}
