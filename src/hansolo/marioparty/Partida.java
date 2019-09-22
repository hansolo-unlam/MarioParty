package hansolo.marioparty;

import java.util.HashMap;

import hansolo.marioparty.admin.Usuario;
import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.minijuegos.Minijuego;
import hansolo.marioparty.tablero.Tablero;


public class Partida {
	private Jugador[] jugadores;
	private int cantJugadores;
	private Jugador jugadorJugando;
	private int turnoActual;
	
	private Tablero tablero;
	private CondicionVictoria condicionVictoria;
	private Minijuego[] minijuegos;
	
	private int rondaActual;
	
	private HashMap<Integer,Jugador> orden = new HashMap<Integer,Jugador>();
	
	public Partida(Usuario users[], Tablero tablero, CondicionVictoria condicionVictoria) {
		
		for (int i = 0; i < users.length; i++) {
			this.jugadores[i] = new Jugador(users[i], tablero.getStart(), this);
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
	
	public void definirOrdenJugador() {
		int clave = 1;
		for(int i=0; i<this.cantJugadores;i++) {
			orden.put(clave, this.jugadores[i]);
			clave++;
		}
	}
	
	public void pasarTurno() {
		this.turnoActual++;
		if(this.turnoActual>this.cantJugadores)
			this.pasarRonda();
	}
	
	public void pasarRonda() {
		this.rondaActual++;
		this.turnoActual = 1;
	}
	
	// ***** ** GETTERS Y SETTERS ** ***** //
	public Jugador[] getJugadores() {
		return jugadores;
	}

	public void setJugadores(Jugador[] jugadores) {
		this.jugadores = jugadores;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
	
	public Jugador getProximoJugador() {
		int turnoSiguiente;
		if(this.turnoActual < this.cantJugadores)
			turnoSiguiente = this.turnoActual + 1;
		else
			turnoSiguiente = 1;
		return orden.get(turnoSiguiente);
	}
	
}
