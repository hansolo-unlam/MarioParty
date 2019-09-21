package hansolo.marioparty;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.minijuegos.Minijuego;
import hansolo.marioparty.tablero.Tablero;

public class Partida {
	private Jugador[] jugadores;
	private int cantJugadores;
	private Jugador jugadorJugando;
	
	private Tablero tablero;
	private CondicionVictoria condicionVictoria;
	private Minijuego[] minijuegos;
	
	private int rondaActual;
	
	public Partida(Usuario users[], Tablero tablero, CondicionVictoria condicionVictoria) {
		
		for(int i=0; i<users.length(); i++) {
			this.jugadores[i] = new Jugador(users[i], tablero.getStart())
		}
		
		this.cantJugadores = this.jugadores.length;
		jugadorJugando = null;
		
		this.tablero = tablero;
		this.condicionVictoria = condicionVictoria;
		this.minijuegos = cargarMinijuegos();
		
		this.rondaActual = 0;
	}

	private Minijuego[] cargarMinijuegos() {
		// TODO Auto-generated method stub
		return null;
	}
}
