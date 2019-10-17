package hansolo.marioparty.entidades;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import hansolo.marioparty.Juego;
import hansolo.marioparty.Partida;
import hansolo.marioparty.admin.Usuario;
import hansolo.marioparty.graficos.Texturas;
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
	
	private BufferedImage spriteTablero;

	private int numero;
	private Usuario user;
	private int monedas, estrellas;
	private Casillero posicion;
	private List<Item> items;
	
	private int cantMovimientos;
	private boolean avanzando = false;

	private Juego juego;

	public Jugador(int numero, Usuario user, Juego juego) {
		this.numero = numero;
		this.posicion = null;
		this.x = 0;
		this.y = 0;
		
		this.monedas = 0;
		this.estrellas = 0;
		this.items = new ArrayList<Item>();

		this.juego = juego;
		this.user = user;
		this.cantMovimientos = 0;
		
		cargarSprites();
	}
	
	public void calcular() {
		// si el jugador esta parado en el [x,y] de su casillero y le quedan movimientos,
		if (estoyParadoEnMiPosicion() && avanzando) {// cantMovimientos != 0) {
			cantMovimientos--;
			
			if (posicion.isEfectoPasandoSobre())
				posicion.efecto(this);
			
			if (cantMovimientos == 0) {
				// Antes de terminar el turno, deber�a ejecutar el efecto del casillero en donde termin�
				posicion.efecto(this);
				avanzando = false;
				juego.pasarTurno(this);
				//System.out.println("AC� DEBER�A TERMINAR EL TURNO");
			}
			else {
			posicion = posicion.getSiguiente().getCasillero();
			
			}
			
		// si no estoy parado en mi posicion y me quedan movimientos, tengo que ir hacia mi posicion
		} else if (!estoyParadoEnMiPosicion() && avanzando) { // cantMovimientos != 0) {
			avanzarHaciaPosicion();
		}
	}
	
	public void cargarSprites() {
		switch (numero) {
		case 1:
			spriteTablero = Texturas.jugador_1;
			break;
		case 2:
			spriteTablero = Texturas.jugador_2;
			break;
		case 3:
			spriteTablero = Texturas.jugador_3;
			break;
		case 4:
			spriteTablero = Texturas.jugador_4;
			break;
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
		g.drawImage(spriteTablero, x, y, null);
	}
	
	/**
	 * M�todo que tira el dado del jugador. Deber�a ser ac� donde se le deja elegir al jugador cu�l de sus dados tirar. Si es que agregamos m�s dados.
	 * @return int n�mero que sali� en el dado
	 */
	public void tirarDado() {
		cantMovimientos = DadoSimple.tirar();
	}
	
	public void startAvanzar() {
		// Setteo la posici�n siguiente y lo hago avanzar un pixel as� no entra en el primer if del .dibujar();
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
//			// En el primer ciclo, yo s� que no est� parado en un casillero de bifurcaci�n
//			avanzarAlSiguienteCasillero();
//			
//			// Si quedan movimientos y ca� en un casillero que se activa solo pasando, ejecuto el efecto del casillero antes de moverme de nuevo
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
//		// Ac� deber�a moverse al jugador hasta el siguiente casillero, con la direcci�n ya se puede calcular la nueva ubicaci�n del jugador
//		
//		this.posicion = sig.getCasillero();
//		
//		if (cantMovimientos > 1 && this.posicion.isEfectoPasandoSobre())
//			this.posicion.efecto(this);
//	}

//	public void terminarTurno() {
//		//partida.pasarTurno();
//	}

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
