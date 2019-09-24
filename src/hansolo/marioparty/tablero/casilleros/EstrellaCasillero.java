package hansolo.marioparty.tablero.casilleros;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;

// casillero que, al pasar o caer en él, te deja comprar una estrella
public class EstrellaCasillero extends Casillero {
	private final int PRECIO_ESTRELLA = 30;

	public EstrellaCasillero(int id, SiguienteCasillero[] next) {
		super(id, next, true);
	}

	@Override
	public void efecto(Jugador jugador) {
		System.out.println(jugador.getUser().getNombre() + " pasó por casillero de estrella");
		//Por ahora que compre la mayor cantidad de estrellas que pueda
//		if (jugador.getMonedas() >= this.PRECIO_ESTRELLA) {
//			int estrellasGanadas = jugador.getMonedas() / this.PRECIO_ESTRELLA;
//			jugador.setEstrellas(estrellasGanadas);
//			jugador.setMonedas(-(this.PRECIO_ESTRELLA * estrellasGanadas));
//		}
	}

}
