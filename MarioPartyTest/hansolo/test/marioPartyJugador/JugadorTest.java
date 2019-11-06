package hansolo.test.marioPartyJugador;




import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hansolo.marioparty.CondicionVictoria;
import hansolo.marioparty.Juego;
import hansolo.marioparty.TipoCondicionVictoria;
import hansolo.marioparty.admin.Usuario;
import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.items.DadoDoble;
import hansolo.marioparty.items.DadoSimple;
import hansolo.marioparty.states.TableroState;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.Tablero;
import hansolo.marioparty.tablero.casilleros.MonedaCasillero;

public class JugadorTest {
	
	private static final String pathTablero = "./recursos/map0.txt";
	private Tablero tablero;
	//private Partida partida1;
	private Jugador j1; 
	private CondicionVictoria condicionVictoriaTest;
	private Usuario[] usuariosTest=new Usuario[2];
	private Juego juego1;

	@Before
	public void SetUp() {
		//this.tablero = new Tablero(pathTablero);
		Usuario uTest1=new Usuario("test1");
		Usuario uTest2=new Usuario("test2");
		this.usuariosTest[0]=uTest1;
		this.usuariosTest[1]=uTest2;
		this.condicionVictoriaTest=new CondicionVictoria(TipoCondicionVictoria.ESTRELLAS,3);
		this.juego1 = new Juego("Mario party", 1000, 768);
		
		this.j1= new Jugador(1,usuariosTest[0],juego1);
	}
	
	
	@Test
	public void avanzar() throws Exception {
		j1.setCantMovimientos(5);
		int resultado = DadoSimple.tirar();
		j1.setCantMovimientos(resultado);
		Assert.assertEquals(resultado, j1.getCantMovimientos());
	}
	
	@Test
	public void getUserTest() {
		
		Assert.assertEquals(usuariosTest[0], j1.getUser());
	}
	@Test
	public void getMonedasTest() throws Exception {
		MonedaCasillero mc = new MonedaCasillero(1,1);
		j1.setMonedas(mc.getMoneda());
		Assert.assertEquals(3, j1.getMonedas());
	}
	
	@Test
	public void terminarTurno() {
		
		
	}

}
