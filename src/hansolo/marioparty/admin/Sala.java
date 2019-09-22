package hansolo.marioparty.admin;

import hansolo.marioparty.CondicionVictoria;
import hansolo.marioparty.Partida;
import hansolo.marioparty.tablero.Tablero;

public class Sala {
	
	private String nombre;
	private Usuario[] users;
	private Partida partida;
	private Tablero tablero;
	private CondicionVictoria condicionV;
	
	public Sala (String nombre, Usuario[] users) {
		
		this.nombre = nombre;
		this.users = users;
	}
	
	public void comenzarPartida() {
		
		this.partida = new Partida(users, tablero, condicionV);
	}
	
	//Deberia poder seleccionarse el tablero y la condicion desde la sala
	public void seleccionarCondicion() {
		
	}
	
	public void seleccionarTablero() {
		
	}
	
}
