package hansolo.marioparty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import hansolo.marioparty.admin.Usuario;
import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.minijuegos.Minijuego;
import hansolo.marioparty.tablero.Tablero;


public class Partida {
	private List<Jugador> jugadores;
	private int cantJugadores;
	private Jugador jugadorJugando;
	private int turnoActual;
	
	private Tablero tablero;
	private CondicionVictoria condicionVictoria;
	private Minijuego[] minijuegos;
	
	private int rondaActual;
	
	private HashMap<Integer,Jugador> orden = new HashMap<Integer,Jugador>();
	
	public Partida(Usuario users[], Tablero tablero, CondicionVictoria condicionVictoria) {
		jugadores = new ArrayList<Jugador>();
		
		for (int i = 0; i < users.length; i++) {
			jugadores.add(new Jugador(users[i], tablero.getStart(), this));
		}
		
		this.cantJugadores = this.jugadores.size();
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
	
	public void definirOrdenJugador() {
		// Hace un shuffle de la lista de jugadores y define al orden en el que queden como el orden de los turnos
		Collections.shuffle(jugadores);
	}
	
	// Termina el turno del jugador actual y comienza el turno del jugador siguiente
	public void pasarTurno() {
		this.turnoActual++;
		if(this.turnoActual > this.cantJugadores)
			this.pasarRonda();
		
		this.jugadorJugando = getJugadorConTurno();
	}
	
	// Termina la ronda actual y comienza la siguiente, le da comienzo al turno del primer jugador
	public void pasarRonda() {
		this.rondaActual++;
		this.turnoActual = 1;
		
		this.jugadorJugando = getJugadorConTurno();
	}
	
	// ***** ** GETTERS Y SETTERS ** ***** //
	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
	
	// Devuelve el jugador que tiene que jugar su turno
	public Jugador getJugadorConTurno() {
		return jugadores.get(turnoActual - 1);
	}
	
}
