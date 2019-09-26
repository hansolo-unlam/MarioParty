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
		int resultado = DadoSimple.tirar();
		
		assertTrue(resultado > 0 && resultado <= 6);
		System.out.println(resultado);
	}

}
