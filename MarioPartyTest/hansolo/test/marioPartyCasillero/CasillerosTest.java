package hansolo.test.marioPartyCasillero;

import static org.junit.Assert.*;
	
import org.junit.Before;
import org.junit.Test;

import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.Tablero;
import hansolo.marioparty.tablero.casilleros.*;

public class CasillerosTest {

	private static final String pathTablero = "./recursos/map0.txt";
	private Tablero tab;

	@Before
	public void SetUp() {
		this.tab = new Tablero(pathTablero);

	}

	// VERIFICO QUE SEA UN CASILLERO MONEDA +
	@Test
	public void CasilleroMonedaPositivo() {
		assertEquals(tab.getCasilleros().get(1).getClass(), new MonedaCasillero(0, null, 1).getClass());
		MonedaCasillero casM = (MonedaCasillero) tab.getCasilleros().get(1);
		assertEquals(casM.getMoneda(), 3);
	}

	// VERIFICO QUE SEA UN CASILLERO MONEDA -
	@Test
	public void CasilleroMonedaNegativo() {
		assertEquals(tab.getCasilleros().get(71).getClass(), new MonedaCasillero(0, null, 1).getClass());
		Casillero casM = tab.getCasilleros().get(71);
		assertEquals(((MonedaCasillero) casM).getMoneda(), -3);
	}

	// VERIFICO QUE LOS ID DE LA BIFURCACION SEAN LOS CORRECTOS
	@Test
	public void CasilleroBifurcacion() {
		assertEquals(tab.getCasilleros().get(31).getClass(), new BifurcacionCasillero(0, null).getClass());
		Casillero cas = tab.getCasilleros().get(31);
		int bifurcacion[] = { 30, 32 };
		for (int i = 0; i < bifurcacion.length; i++) {
			assertEquals(cas.getNext()[i], bifurcacion[i]);
		}
	}

	// VERIFICO QUE SEA UN CASILLERO TELEPORT
	@Test
	public void CasilleroTeleport() {
		assertEquals(tab.getCasilleros().get(37).getClass(), new TeleportCasillero(0, null).getClass());
	}

	@Test
	public void RandomMaloCasillero() {
		assertEquals(tab.getCasilleros().get(63).getClass(), new RandomMaloCasillero(0, null).getClass());
	}

	@Test
	public void ItemCasiller() {
		assertEquals(tab.getCasilleros().get(44).getClass(), new ItemCasillero(0, null).getClass());
	}

	@Test
	public void TiendaCasillero() {
		assertEquals(tab.getCasilleros().get(38).getClass(), new TiendaCasillero(0, null).getClass());
	}

	@Test
	public void HurtoCasiller() {
		assertEquals(tab.getCasilleros().get(67).getClass(), new HurtoCasillero(0, null).getClass());
	}

	@Test
	public void EstrellaCasillero() {
		assertEquals(tab.getCasilleros().get(9).getClass(), new EstrellaCasillero(0, null).getClass());
	}

}
