package hansolo.marioparty.admin;

import hansolo.marioparty.CondicionVictoria;
import hansolo.marioparty.tablero.Tablero;

/**
 * FUERA DE IMPLEMENTACIÓN, POR AHORA
 * @author facundotourn
 *
 */
public class Sala {
	
	private String nombre;
	private Usuario[] users;
	private Tablero tablero;
	private CondicionVictoria condicionV;
	
	public Sala (String nombre, Usuario[] users) {
		
		this.nombre = nombre;
		this.users = users;
	}
	
	public void comenzarPartida() {
		
	}
	
	//Deberia poder seleccionarse el tablero y la condicion desde la sala
	public void seleccionarCondicion() {
		
	}
	
	public void seleccionarTablero() {
		
	}
	
}
