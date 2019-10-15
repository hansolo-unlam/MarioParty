package hansolo.marioparty.entidades;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import hansolo.marioparty.Juego;
import hansolo.marioparty.Partida;
import hansolo.marioparty.admin.Usuario;
import hansolo.marioparty.items.DadoDoble;
import hansolo.marioparty.items.DadoSimple;
import hansolo.marioparty.items.Item;
import hansolo.marioparty.states.JuegoState;
import hansolo.marioparty.states.State;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.EnumDireccion;
import hansolo.marioparty.tablero.SiguienteCasillero;

public class Jugador {
	private int x;
	private int y;

	private Usuario user;
	private int monedas, estrellas;
	private Casillero posicion;
	private List<Item> items;
	
	private int cantMovimientos;
	private boolean avanzando = false;

	private Juego juego;

	public Jugador(Usuario user, Juego juego) {
		this.posicion = null;
		this.x = 0;
		this.y = 0;
		
		this.monedas = 0;
		this.estrellas = 0;
		this.items = new ArrayList<Item>();

		this.juego = juego;
		this.user = user;
		this.cantMovimientos = 0;
	}
	
	public void calcular() {
		// si el jugador esta parado en el [x,y] de su casillero y le quedan movimientos,
		if (estoyParadoEnMiPosicion() && avanzando) {// cantMovimientos != 0) {
			
			if (cantMovimientos == 0) {
				// Antes de terminar el turno, debería ejecutar el efecto del casillero en donde terminé
				posicion.efecto(this);
				avanzando = false;
				juego.pasarTurno(this);
				//System.out.println("ACÁ DEBERÍA TERMINAR EL TURNO");
			}
			
			// Antes de moverme, debería fijarme si este casillero tiene efecto al pasar sobre él
			if (posicion.isEfectoPasandoSobre())
				posicion.efecto(this);
			
			// Tengo que moverme al siguiente casillero
			posicion = posicion.getSiguiente().getCasillero();
			cantMovimientos--;
			
			
		// si no estoy parado en mi posicion y me quedan movimientos, tengo que ir hacia mi posicion
		} else if (!estoyParadoEnMiPosicion() && avanzando) { // cantMovimientos != 0) {
			avanzarHaciaPosicion();
		}
	}
	
	private void avanzarHaciaPosicion() {
		if (posicion.getX() > x)
			x++;
		else
			x--;
		
		if (posicion.getY() > y)
			y++;
		else
			y--;
	}

	private boolean estoyParadoEnMiPosicion() {
		return this.x == posicion.getX() && this.y == posicion.getY();
	}

	public void dibujar(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
	}
	
	/**
	 * Método que tira el dado del jugador. Debería ser acá donde se le deja elegir al jugador cuál de sus dados tirar. Si es que agregamos más dados.
	 * @return int número que salió en el dado
	 */
	public void tirarDado() {
		cantMovimientos = DadoSimple.tirar();
	}
	
	public void startAvanzar() {
		// Setteo la posición siguiente y lo hago avanzar un pixel así no entra en el primer if del .dibujar();
		posicion = posicion.getSiguiente().getCasillero();
		
		avanzarHaciaPosicion();
		avanzando = true;
		
	}
	
	public void tiempoAcciones() {
//		 *	PREGUNTAR SI EJECUTARA ACCIONES (CON TIEMPO)
//		 * 	SI								
//		 *		PREGUNTAR QUE ITEM USARA
				Item item = this.items.get(0);
				item.usar(this);
//		 * 	No
//		 * 		... sin acciones ...
//		 *
	}
	
	/**
	 * Mueve al jugador una cierta cantidad de casilleros
	 * @param cant la cantidad de casilleros que hay que avanzar
	 */
//	public void avanzar() {
//		while (cantMovimientos > 0) {
//			// En el primer ciclo, yo sé que no está parado en un casillero de bifurcación
//			avanzarAlSiguienteCasillero();
//			
//			// Si quedan movimientos y caí en un casillero que se activa solo pasando, ejecuto el efecto del casillero antes de moverme de nuevo
//			// Este puede ser el efecto tanto de una BifurcacionCasillero, EstrellaCasillero o TiendaCasillero
//			cantMovimientos--;
//		}
//		this.posicion.efecto(this);
//	}
//
//	/**
//	 * Mueve al jugador desde su casillero actual al casillero al que corresponde avanzar
//	 */
//	public void avanzarAlSiguienteCasillero() {
//		SiguienteCasillero sig = this.posicion.getSiguiente();
//		EnumDireccion dir = this.posicion.getSiguiente().getDireccion();
//		
//		// Acá debería moverse al jugador hasta el siguiente casillero, con la dirección ya se puede calcular la nueva ubicación del jugador
//		
//		this.posicion = sig.getCasillero();
//		
//		if (cantMovimientos > 1 && this.posicion.isEfectoPasandoSobre())
//			this.posicion.efecto(this);
//	}

	public void terminarTurno() {
		//partida.pasarTurno();
	}

	public int getMonedas() {
		return monedas;
	}
	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellasGanadas) {
		estrellas = estrellasGanadas;
	}

	public void setMonedas(int monedasGanadas) {
		//this.monedas += (-monedasGanadas > this.monedas ? -this.monedas : monedasGanadas);
		monedas = monedasGanadas;
	}
	
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Casillero getPosicion() {
		return posicion;
	}

	public void setPosicion(Casillero posicion) {
		this.posicion = posicion;
	}
	
	public int getCantMovimientos() {
		return cantMovimientos;
	}

	public void setCantMovimientos(int cantMovimientos) {
		this.cantMovimientos = cantMovimientos;
	}
	
	public Item getItem(int pos) {
		return items.get(pos);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
	
}
