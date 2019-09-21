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
	
	public Partida(Jugador jugadores[], Tablero tablero, CondicionVictoria condicionVictoria) {
		this.jugadores = jugadores;
		this.cantJugadores = jugadores.length;
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
