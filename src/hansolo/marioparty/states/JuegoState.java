package hansolo.marioparty.states;

import java.awt.Color;
import java.awt.Graphics;

import hansolo.marioparty.Juego;
import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.Tablero;

public class JuegoState extends State {
	private Tablero tablero;
	private Jugador tieneTurno;
	
	private EnumEstadoJuego subEstado;
	
	public JuegoState(Juego juego) {
		super(juego);
		
		tablero = new Tablero("./recursos/map0.txt", juego);
		this.tieneTurno = juego.getJugadores().get(0);
		
		this.subEstado = EnumEstadoJuego.TIEMPO_DE_ACCIONES;
	}

	@Override
	public void calcular() {
		// acá calculo todo lo que tenga que ir cambiando
		tablero.calcular();
		
		
		for (Jugador j : juego.getJugadores())
			j.calcular();
	}

	@Override
	public void dibujar(Graphics g) {
		// acá dibujo tablero, jugadores, etc

		g.setColor(Color.white);
		g.drawString("Le toca jugar a " + tieneTurno.getUser().getNombre(), 20, 15);
		g.drawString("Monedas de " + tieneTurno.getUser().getNombre() + ": " + tieneTurno.getMonedas(), 20, 30);
		g.drawString("Estrellas de " + tieneTurno.getUser().getNombre() + ": " + tieneTurno.getEstrellas(), 20, 45);
		
		tablero.dibujar(g);
		
		for (Jugador j : juego.getJugadores())
			j.dibujar(g);
		
		if (subEstado == EnumEstadoJuego.TIEMPO_DE_ACCIONES) {
			// Dibujar botón de ver items y tirar dado
			
		} else if (subEstado == EnumEstadoJuego.VIENDO_ITEMS) {
			// Dibujar la ventanita donde están los items del jugador con turno
			
		}
	}
}
