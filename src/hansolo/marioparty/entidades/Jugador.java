package hansolo.marioparty.entidades;

import java.util.Random;

import hansolo.marioparty.tablero.casilleros.Casillero;

public class Jugador {
	
	private Usuario user;
	private int monedas, orden, estrellas;
	private boolean turnoJugado;
	private Casillero posicion;
	private Item[] items;
	
	public Jugador(Usuario user, Casillero start) {
		
		this.user = user;
		this.monedas = this.estrellas = 0;
		this.turnoJugado = false;
		this.posicion = start;
	}
	
	public void tirarDado() {
		
		int randomInt;
		Random r = new Random();
		if(dado normal)					//en las condiciones puse lo que deberia comprobar 
			randomInt = r.nextInt(6-1);//dado los tipos de dados que tenemosno se como enviariamos un item o si creamos una clase dado
		else							//no se como enviariamos un item o si creamos una clase dado
			if(dado doble)				//segun eso habria que generar las condiciones y agregar mas si me falta algun dado
				randomInt = r.nextInt(6-1)*2;
			else
				randomInt = r.nextInt(6-1)+5;
		this.avanzar(randomInt);
	}
	
	public void avanzar(int cant) {
		
		this.posicion = this.posicion.next;
		for(int i=1; i<cant; i++) {
			//aca falta chequear si es una bifurcacion y elegir un camino 
			this.posicion = this.posicion.next;
		}
		this.posicion.efecto();
	}
	
	public void terminarTurno() {
		
		this.turnoJugado = true;
	}
}
