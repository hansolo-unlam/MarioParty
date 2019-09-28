package hansolo.test.marioPartyCasillero;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.Tablero;
import hansolo.marioparty.tablero.casilleros.*;

public class TableroTest {

	private static final String pathTablero = "./recursos/map0.txt";
	private Tablero tab;

	@Before
	public void SetUp() {
		this.tab = new Tablero(pathTablero);

	}

	@Test
	public void testUbicarEstrella() {

		// Obtengo los id de casillero estrella
		List<Integer> estrellas = tab.getIdsCasillerosEstrella();
		int idAnteriorEstrella = -1;
		for (Integer x : estrellas) {
			// De todos los casilleros me traigo el que sea estrella
			EstrellaCasillero estreCas = ((EstrellaCasillero) tab.getCasilleros().get(x));
//			System.out.println(estreCas.getId() + "-> Tiene estrella?: " + estreCas.isTieneEstrella());

			// Si el casillero tiene estrella me guardo el Id para saber a quien sacarle la
			// estrella
			if (estreCas.isTieneEstrella() == true) {
				idAnteriorEstrella = estreCas.getId();
			}
		}

//		System.out.println("-----------------------");

		tab.ubicarEstrella(idAnteriorEstrella);

		for (Integer x : estrellas) {
			EstrellaCasillero estreCas = ((EstrellaCasillero) tab.getCasilleros().get(x));

			if (estreCas.isTieneEstrella() == false) {
				assertEquals(false, estreCas.isTieneEstrella());
//				System.out.println(estreCas.getId() + "-> Tiene estrella?: " + estreCas.isTieneEstrella());
			}
		}

	}

	// VERIFICO QUE SEA UN CASILLERO MONEDA +
	@Test
	public void cargarCasilleroMonedaPositivo() {
		assertEquals(tab.getCasilleros().get(1).getClass(), new MonedaCasillero(0, null, 1).getClass());
		MonedaCasillero casM = (MonedaCasillero) tab.getCasilleros().get(1);
		assertEquals(casM.getMoneda(), 3);
	}

	// VERIFICO QUE SEA UN CASILLERO MONEDA -
	@Test
	public void cargarCasilleroMonedaNegativo() {
		assertEquals(tab.getCasilleros().get(71).getClass(), new MonedaCasillero(0, null, 1).getClass());
		Casillero casM = tab.getCasilleros().get(71);
		assertEquals(((MonedaCasillero) casM).getMoneda(), -3);
	}

	// VERIFICO QUE LOS ID DE LA BIFURCACION SEAN LOS CORRECTOS
	@Test
	public void cargarCasilleroBifurcacion() {
		assertEquals(tab.getCasilleros().get(31).getClass(), new BifurcacionCasillero(0, null).getClass());
		Casillero cas = tab.getCasilleros().get(31);
		int bifurcacion[] = { 30, 32 };
		for (int i = 0; i < bifurcacion.length; i++) {
			assertEquals(cas.getSiguientes()[i].getId(), bifurcacion[i]);
		}
	}

	// VERIFICO QUE SEA UN CASILLERO TELEPORT
	@Test
	public void cargarCasilleroTeleport() {
		assertEquals(tab.getCasilleros().get(37).getClass(), new TeleportCasillero(0, null).getClass());
	}

	@Test
	public void cargarRandomMaloCasillero() {
		assertEquals(tab.getCasilleros().get(63).getClass(), new RandomMaloCasillero(0, null).getClass());
	}

	@Test
	public void cargarItemCasillero() {
		assertEquals(tab.getCasilleros().get(44).getClass(), new ItemCasillero(0, null).getClass());
	}

	@Test
	public void cargarTiendaCasillero() {
		assertEquals(tab.getCasilleros().get(38).getClass(), new TiendaCasillero(0, null).getClass());
	}

	@Test
	public void cargarHurtoCasillero() {
		assertEquals(tab.getCasilleros().get(67).getClass(), new HurtoCasillero(0, null).getClass());
	}

	@Test
	public void cargarEstrellaCasillero() {
		assertEquals(tab.getCasilleros().get(9).getClass(), new EstrellaCasillero(0, null, tab).getClass());
	}

}
