package hansolo.test.marioPartyCasillero;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import hansolo.marioparty.CondicionVictoria;
import hansolo.marioparty.Partida;
import hansolo.marioparty.TipoCondicionVictoria;
import hansolo.marioparty.admin.Usuario;
import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.Tablero;

public class BifurcacionCasilleroTest {
	private final String pathTablero = "./recursos/map0.txt";
	private Partida partida;
	private Jugador jugadorPrueba;	
	
	@Before
	public void setUp() {
		// Carga de tablero y partida
				//this.partida = new Partida(new Usuario[] {new Usuario("Jugador_de_prueba")}, new Tablero(pathTablero), new CondicionVictoria(TipoCondicionVictoria.RONDAS, 5));
				this.jugadorPrueba = partida.getJugadores().get(0);
	}

	@Test
	public void jugadorCaeEnBifurcacionYAvanza() {
		//busco que el jugador tenga que moverse 2 posiciones para caer en el casillero 2 que tiene bifurcacion
		while (jugadorPrueba.getCantMovimientos() != 2) {
			jugadorPrueba.tirarDado();
		}
		jugadorPrueba.avanzar();
		/*Dado que de momento en una bifurcacion  se resuelve con un random hacia donde se dirige
		 * voy a verificar que luego de moverme 2 casilleros desde el origen, no termine en el 2
		 * sino que dado que es una bifurcacion me envio al 3 o 45
		*/

		assertTrue(jugadorPrueba.getPosicion().getId()==3||jugadorPrueba.getPosicion().getId()==45);
	}

}
