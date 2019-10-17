package hansolo.test.marioparty.items;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hansolo.marioparty.CondicionVictoria;
import hansolo.marioparty.Partida;
import hansolo.marioparty.TipoCondicionVictoria;
import hansolo.marioparty.admin.Usuario;
import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.items.DadoDoble;
import hansolo.marioparty.tablero.Tablero;

public class DadoDobleTest {

	private static final String pathTablero = "./recursos/map0.txt";
	private Tablero tablero;
	private Partida partida1;
	private Jugador j1; 
	private CondicionVictoria condicionVictoriaTest;
	private Usuario[] usuariosTest=new Usuario[2];
	

	@Before
	public void SetUp() {
		//this.tablero = new Tablero(pathTablero);
		Usuario uTest1=new Usuario("test1");
		Usuario uTest2=new Usuario("test2");
		this.usuariosTest[0]=uTest1;
		this.usuariosTest[1]=uTest2;
		this.condicionVictoriaTest=new CondicionVictoria(TipoCondicionVictoria.ESTRELLAS,3);
		this.partida1= new Partida(usuariosTest,tablero,condicionVictoriaTest);
		//this.j1= new Jugador(usuariosTest[0],tablero.getStart(),partida1);
	}

	@Test
	public void DadoDobleTest() {
		j1.getItem(0).setCantidad(5);
		j1.setMonedas(8);
		
		j1.getItem(0).usar(j1);
		
		Assert.assertEquals(5, j1.getMonedas());
		Assert.assertEquals(4, j1.getItem(0).getCantidad());
	}
	
	
	@Test
	public void cantidadInsuficienteDadoDobleTest() {
		j1.getItem(0).setCantidad(0);
		j1.setMonedas(8);
		
		j1.getItem(0).usar(j1);
		
		Assert.assertEquals(8, j1.getMonedas());
		Assert.assertEquals(0, j1.getItem(0).getCantidad());
	}
	
	@Test
	public void monedasInsuficienteDadoDobleTest() {
		j1.getItem(0).setCantidad(3);
		j1.setMonedas(DadoDoble.PRECIO-1);
		
		j1.getItem(0).usar(j1);
		
		Assert.assertEquals(DadoDoble.PRECIO-1, j1.getMonedas());
		Assert.assertEquals(3, j1.getItem(0).getCantidad());
	}

}
