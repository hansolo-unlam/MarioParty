package hansolo.marioparty.tablero.casilleros;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;

/**
 * Casillero que, al pasar o caer en él, te deja comprar una estrella
 * @author H1N1
 *
 */
public class EstrellaCasillero extends Casillero {
	private final int PRECIO_ESTRELLA = 30;

	public EstrellaCasillero(int id, SiguienteCasillero[] next) {
		super(id, next, true);
	}

	@Override
	public void efecto(Jugador jugador) {
		System.out.println(jugador.getUser().getNombre() + " pasó o calló en un casillero de estrella");
		//Por ahora que compre la mayor cantidad de estrellas que pueda
//		if (jugador.getMonedas() >= this.PRECIO_ESTRELLA) {
//			int estrellasGanadas = jugador.getMonedas() / this.PRECIO_ESTRELLA;
//			jugador.setEstrellas(estrellasGanadas);
//			jugador.setMonedas(-(this.PRECIO_ESTRELLA * estrellasGanadas));
//		}
	}

}
