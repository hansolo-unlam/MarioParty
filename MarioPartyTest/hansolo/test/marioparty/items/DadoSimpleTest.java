package hansolo.test.marioparty.items;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import hansolo.marioparty.items.*;

public class DadoSimpleTest {


	/*
	 * @Before public void SetUp() { this.tab = new Tablero(pathTablero);
	 * 
	 * }
	 */
	

	@Test
	public void CasilleroMonedaPositivo() {
		final int maximoNumero = 12;
		int resultado = DadoSimple.tirarDado(maximoNumero);
		
		assertTrue(resultado > 0 && resultado <= maximoNumero);
		System.out.println(resultado);
	}

}
