package hansolo.test.marioPartyJugador;




import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hansolo.marioparty.Partida;
import hansolo.marioparty.admin.Usuario;
import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.Tablero;








public class JugadorTest {
	
	private static final String pathTablero = "./recursos/map0.txt";
	private Tablero tablero;
	private Usuario user1;
	private Partida partida1;
	private Jugador j1; 
	

	@Before
	public void SetUp() {
		this.tablero = new Tablero(pathTablero);
		this.j1= new Jugador(user1,tablero.getStart(),partida1);
		
	}
	
	
	@Test
	public void avanzar() throws Exception {
			
		j1.avanzar(1);
		Assert.assertEquals(1, j1.getPosicion());
	}
	
	@Test
	public void getUserTest() {
		
		Assert.assertEquals(user1, j1.getUser());
	}
	@Test
	public void getMonedasTest() throws Exception {
		//j1 tendria  que avanzar hasta el casillero que gana monedas j1.avanzar(1);
		j1.setMonedas(3);
		Assert.assertEquals(3, j1.getMonedas());
	}
	
	@Test
	public void turnoJugadoTest() {
		
	}
}
