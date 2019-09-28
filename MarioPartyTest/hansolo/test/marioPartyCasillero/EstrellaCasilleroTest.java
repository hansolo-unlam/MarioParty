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

public class EstrellaCasilleroTest {
	private final String pathTablero = "./recursos/map0.txt";
	private Partida partida;
	private Tablero tablero;
	private Jugador unJugador;
	
	@Before
	public void setUp() {
		this.tablero = new Tablero(pathTablero);
		this.partida = new Partida(new Usuario[] {new Usuario("Jugador_de_prueba")}, this.tablero, new CondicionVictoria(TipoCondicionVictoria.RONDAS, 5));
	}

	@Test
	public void jugadorPasaNoPuedeComprarEstrella() {
		fail("Not yet implemented");
	}

}
