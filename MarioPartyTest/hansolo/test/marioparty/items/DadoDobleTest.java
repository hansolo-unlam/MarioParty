package hansolo.test.marioparty.items;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hansolo.marioparty.CondicionVictoria;
import hansolo.marioparty.Juego;
//import hansolo.marioparty.Partida;
import hansolo.marioparty.TipoCondicionVictoria;
import hansolo.marioparty.admin.Usuario;
import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.items.DadoDoble;
import hansolo.marioparty.items.Item;
import hansolo.marioparty.tablero.Tablero;

public class DadoDobleTest {

	private static final String pathTablero = "./recursos/map0.txt";
	private Tablero tablero;
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
		this.juego1 =  new Juego("Mario party", 1000, 768);;
		//this.partida1= new Partida(usuariosTest,tablero,condicionVictoriaTest);
		this.j1= new Jugador(1,usuariosTest[0],juego1);
	}

	@Test
	public void DadoDobleTestMonedas() {
		
		j1.setMonedas(5);
		DadoDoble dd = new DadoDoble(1);
		dd.usar(j1);
		Assert.assertEquals(2, j1.getMonedas());
		
	}
	
	@Test
	public void DadoDobleTestCantidad() {
		
		
		
		DadoDoble dd = new DadoDoble(3);
		dd.usar(j1);
		Assert.assertEquals(2, dd.getCantidad());
		
	}
	
	@Test
	public void cantidadInsuficienteDadoDobleTest() {
		DadoDoble dd = new DadoDoble(0);
		dd.usar(j1);
		dd.setCantidad(1);
		Assert.assertEquals(1, dd.getCantidad());
		
	}
	
	@Test
	public void monedasInsuficienteDadoDobleTest() {
		DadoDoble dd = new DadoDoble(3);
		j1.setMonedas(2);
		dd.usar(j1);
		Assert.assertEquals(2, j1.getMonedas());
		
	}

}
