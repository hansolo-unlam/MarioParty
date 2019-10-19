package hansolo.marioparty.entidades;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import hansolo.marioparty.Juego;
import hansolo.marioparty.admin.Usuario;
import hansolo.marioparty.graficos.Texturas;
import hansolo.marioparty.items.DadoSimple;
import hansolo.marioparty.items.Item;
import hansolo.marioparty.tablero.Casillero;

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
	private boolean pierdeTurno = false;
	
	private Juego juego;

	public Jugador(int numero, Usuario user, Juego juego) {
		this.numero = numero;
		this.posicion = null;
		this.x = 0;
		this.y = 0;
		
		this.monedas = 30;
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
				juego.getJuegoState().activarEfectoCasillero();
			
			if (cantMovimientos == 0) {
				// Antes de terminar el turno, debería ejecutar el efecto del casillero en donde terminé
				juego.getJuegoState().activarEfectoCasillero();
				avanzando = false;
				
				juego.pasarTurno();
				//System.out.println("ACÁ DEBERÍA TERMINAR EL TURNO");
			} else {
				posicion = posicion.getSiguiente().getCasillero();
			}
			
		// si no estoy parado en mi posicion y me quedan movimientos, tengo que ir hacia mi posicion
		} else if (!estoyParadoEnMiPosicion() && avanzando) { // cantMovimientos != 0) {
			avanzarHaciaPosicion();
		}
	}

	public void dibujar(Graphics g) {
		g.drawImage(spriteTablero, x, y, null);
		g.drawString(String.valueOf(cantMovimientos), x, y - 20);
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

	public int getMonedas() {
		return monedas;
	}

	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}
	
	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
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

	public boolean isAvanzando() {
		return avanzando;
	}

	public void setAvanzando(boolean avanzando) {
		this.avanzando = avanzando;
	}
	
	public Juego getJuego() {
		return juego;
	}

	public boolean isPierdeTurno() {
		return pierdeTurno;
	}

	public void setPierdeTurno(boolean pierdeTurno) {
		this.pierdeTurno = pierdeTurno;
	}
	
	
}
