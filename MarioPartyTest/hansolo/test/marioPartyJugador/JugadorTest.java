package hansolo.test.marioPartyJugador;




import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hansolo.marioparty.CondicionVictoria;
import hansolo.marioparty.Partida;
import hansolo.marioparty.TipoCondicionVictoria;
import hansolo.marioparty.admin.Usuario;
import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.Tablero;








public class JugadorTest {
	
	private static final String pathTablero = "./recursos/map0.txt";
	private Tablero tablero;
	//private Usuario user1;
	private Partida partida1;
	private Jugador j1; 
	private CondicionVictoria condicionVictoriaTest;
	private Usuario[] usuariosTest=new Usuario[2];
	

	@Before
	public void SetUp() {
		this.tablero = new Tablero(pathTablero);
		Usuario uTest1=new Usuario("test1");
		Usuario uTest2=new Usuario("test2");
		this.usuariosTest[0]=uTest1;
		this.usuariosTest[1]=uTest2;
		this.condicionVictoriaTest=new CondicionVictoria(TipoCondicionVictoria.ESTRELLAS,3);
		this.partida1= new Partida(usuariosTest,tablero,condicionVictoriaTest);
		this.j1= new Jugador(usuariosTest[0],tablero.getStart(),partida1);
		//this.j2= new Jugador(usuariosTest[1],tablero.getStart(),partida1);
	}
	
	
	@Test
	public void avanzar() throws Exception {
			
		j1.avanzar(1);
		Assert.assertEquals(1, j1.getPosicion().getId());
	}
	
	@Test
	public void getUserTest() {
		
		Assert.assertEquals(usuariosTest[0], j1.getUser());
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
