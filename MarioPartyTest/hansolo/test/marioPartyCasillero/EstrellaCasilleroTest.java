package hansolo.test.marioPartyCasillero;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hansolo.marioparty.CondicionVictoria;
import hansolo.marioparty.TipoCondicionVictoria;
import hansolo.marioparty.admin.Usuario;
import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.Tablero;
import hansolo.marioparty.tablero.casilleros.EstrellaCasillero;

public class EstrellaCasilleroTest {
	private final String pathTablero = "./recursos/map0.txt";
	private Jugador jugadorPrueba;
	
	private int monedasPrincipio;
	private int estrellasPrincipio;
	
	private Casillero casilleroOrigen;
	private Casillero expectedCasilleroFinal;
	private EstrellaCasillero casilleroEstrella;
	
	@Before
	public void setUp() {
		// Carga de tablero, partida y el casillero donde se para al jugador para los tests
		//this.partida = new Partida(new Usuario[] {new Usuario("Jugador_de_prueba")}, new Tablero(pathTablero), new CondicionVictoria(TipoCondicionVictoria.RONDAS, 5));
		//this.casilleroOrigen = this.partida.getTablero().getCasilleros().get(35);
		//this.casilleroEstrella = (EstrellaCasillero) this.partida.getTablero().getCasilleros().get(36);
		
		//this.partida.getJugadorConTurno().setPosicion(casilleroOrigen);
		
		//this.jugadorPrueba = partida.getJugadores().get(0);
	}
	
	@Test
	public void jugadorPasaNoHayEstrella() {
		monedasPrincipio = this.jugadorPrueba.getMonedas();
		estrellasPrincipio = this.jugadorPrueba.getEstrellas();
		
		// Mientras tenga estrella este casillero, reubicar la estrella en algún otro casillero estrella
		while (casilleroEstrella.isTieneEstrella()) {
			//partida.getTablero().ubicarEstrella(casilleroEstrella.getId());
		}
		
		// Tirar el dado hasta sacar un 2
		while (jugadorPrueba.getCantMovimientos() != 2) {
			jugadorPrueba.tirarDado();
		}
		
		//jugadorPrueba.avanzar();
		
		Assert.assertEquals(0, monedasPrincipio - jugadorPrueba.getMonedas()); // Misma cantidad de monedas
		Assert.assertEquals(0, estrellasPrincipio - jugadorPrueba.getEstrellas()); // Misma cantidad de estrellas
		
		expectedCasilleroFinal = casilleroOrigen.getSiguiente().getCasillero();
		expectedCasilleroFinal = expectedCasilleroFinal.getSiguiente().getCasillero();
		expectedCasilleroFinal = expectedCasilleroFinal.getSiguiente().getCasillero();
		
		Assert.assertEquals(expectedCasilleroFinal.getId(), jugadorPrueba.getPosicion().getId()); // El casillero estrella sin estrella lo hizo avanzar un casillero
	}
	
	@Test
	public void jugadorCaeNoHayEstrella() {
		monedasPrincipio = this.jugadorPrueba.getMonedas();
		estrellasPrincipio = this.jugadorPrueba.getEstrellas();
		
		// Mientras tenga estrella este casillero, reubicar la estrella en algún otro casillero estrella
		while (casilleroEstrella.isTieneEstrella()) {
			//partida.getTablero().ubicarEstrella(casilleroEstrella.getId());
		}
		
		// Tirar el dado hasta sacar un 1
		while (jugadorPrueba.getCantMovimientos() != 1) {
			jugadorPrueba.tirarDado();
		}
		
		//jugadorPrueba.avanzar();
		
		Assert.assertEquals(0, monedasPrincipio - jugadorPrueba.getMonedas()); // Misma cantidad de monedas
		Assert.assertEquals(0, estrellasPrincipio - jugadorPrueba.getEstrellas()); // Misma cantidad de estrellas
		
		expectedCasilleroFinal = casilleroOrigen.getSiguiente().getCasillero();
		expectedCasilleroFinal = expectedCasilleroFinal.getSiguiente().getCasillero();
		
		Assert.assertEquals(expectedCasilleroFinal.getId(), jugadorPrueba.getPosicion().getId()); // El casillero estrella sin estrella lo hizo avanzar un casillero
	}

	@Test
	public void jugadorPasaNoPuedeComprarEstrella() {
		// Le doy 29 monedas al jugador
		jugadorPrueba.setMonedas(29);
		
		monedasPrincipio = this.jugadorPrueba.getMonedas();
		estrellasPrincipio = this.jugadorPrueba.getEstrellas();
		
		// Reubicar la estrella hasta que esté en mi casillero estrella
		while (!casilleroEstrella.isTieneEstrella()) {
			//partida.getTablero().ubicarEstrella(-1);
		}
		
		// Tirar el dado hasta sacar un 2
		while (jugadorPrueba.getCantMovimientos() != 2) {
			jugadorPrueba.tirarDado();
		}
		
		//jugadorPrueba.avanzar();
		
		Assert.assertEquals(0, monedasPrincipio - jugadorPrueba.getMonedas()); // Misma cantidad de monedas
		Assert.assertEquals(0, estrellasPrincipio - jugadorPrueba.getEstrellas()); // Misma cantidad de estrellas
		
		expectedCasilleroFinal = casilleroOrigen.getSiguiente().getCasillero();
		expectedCasilleroFinal = expectedCasilleroFinal.getSiguiente().getCasillero();
		
		Assert.assertEquals(expectedCasilleroFinal.getId(), jugadorPrueba.getPosicion().getId()); // El casillero estrella con estrella no lo hizo avanzar un casillero
	}
	
	@Test
	public void jugadorPasaPuedeComprarEstrella() {
		// Le doy 30 monedas al jugador y una estrella
		jugadorPrueba.setMonedas(30);
		jugadorPrueba.setEstrellas(1);
		
		monedasPrincipio = this.jugadorPrueba.getMonedas();
		estrellasPrincipio = this.jugadorPrueba.getEstrellas();
		
		// Reubicar la estrella hasta que esté en mi casillero estrella
		while (!casilleroEstrella.isTieneEstrella()) {
			//partida.getTablero().ubicarEstrella(-1);
		}
		
		// Tirar el dado hasta sacar un 2
		while (jugadorPrueba.getCantMovimientos() != 2) {
			jugadorPrueba.tirarDado();
		}
		
		//jugadorPrueba.avanzar();
		
		Assert.assertEquals(EstrellaCasillero.PRECIO_ESTRELLA, monedasPrincipio - jugadorPrueba.getMonedas()); // Se le sacó una cant de monedas igual al precio de la estrella
		Assert.assertEquals(-1, estrellasPrincipio - jugadorPrueba.getEstrellas()); // Tiene una estrella más que antes
		
		expectedCasilleroFinal = casilleroOrigen.getSiguiente().getCasillero();
		expectedCasilleroFinal = expectedCasilleroFinal.getSiguiente().getCasillero();
		
		Assert.assertEquals(expectedCasilleroFinal.getId(), jugadorPrueba.getPosicion().getId()); // El casillero estrella con estrella no lo hizo avanzar un casillero
	}
	
	@Test
	public void jugadorCaeNoPuedeComprarEstrella() {
		// Le doy 29 monedas al jugador y una estrella
		jugadorPrueba.setMonedas(29);
		jugadorPrueba.setEstrellas(1);
		
		monedasPrincipio = this.jugadorPrueba.getMonedas();
		estrellasPrincipio = this.jugadorPrueba.getEstrellas();
		
		// Reubicar la estrella hasta que esté en mi casillero estrella
		while (!casilleroEstrella.isTieneEstrella()) {
			//partida.getTablero().ubicarEstrella(-1);
		}
		
		// Tirar el dado hasta sacar un 1
		while (jugadorPrueba.getCantMovimientos() != 1) {
			jugadorPrueba.tirarDado();
		}
		
		//jugadorPrueba.avanzar();

		Assert.assertEquals(0, monedasPrincipio - jugadorPrueba.getMonedas()); // Misma cantidad de monedas
		Assert.assertEquals(0, estrellasPrincipio - jugadorPrueba.getEstrellas()); // Misma cantidad de estrellas
		
		expectedCasilleroFinal = casilleroOrigen.getSiguiente().getCasillero();
		
		Assert.assertEquals(casilleroEstrella.getId(), jugadorPrueba.getPosicion().getId()); // Se quedó en el casillero estrella
		
	}
	
	@Test
	public void jugadorCaePuedeComprarEstrella() {
		// Le doy 30 monedas al jugador y una estrella
		jugadorPrueba.setMonedas(30);
		jugadorPrueba.setEstrellas(1);
		
		monedasPrincipio = this.jugadorPrueba.getMonedas();
		estrellasPrincipio = this.jugadorPrueba.getEstrellas();
		
		// Reubicar la estrella hasta que esté en mi casillero estrella
		while (!casilleroEstrella.isTieneEstrella()) {
			//partida.getTablero().ubicarEstrella(-1);
		}
		
		// Tirar el dado hasta sacar un 1
		while (jugadorPrueba.getCantMovimientos() != 1) {
			jugadorPrueba.tirarDado();
		}
		
		//jugadorPrueba.avanzar();

		Assert.assertEquals(EstrellaCasillero.PRECIO_ESTRELLA, monedasPrincipio - jugadorPrueba.getMonedas()); // Se le sacó una cant de monedas igual al precio de la estrella
		Assert.assertEquals(-1, estrellasPrincipio - jugadorPrueba.getEstrellas()); // Misma cantidad de estrellas
		
		expectedCasilleroFinal = casilleroOrigen.getSiguiente().getCasillero();
		
		Assert.assertEquals(casilleroEstrella.getId(), jugadorPrueba.getPosicion().getId()); // Se quedó en el casillero estrella
	}

}
