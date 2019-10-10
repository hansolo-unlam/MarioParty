package hansolo.marioparty.states;

import java.awt.Graphics;

import hansolo.marioparty.Juego;
import hansolo.marioparty.tablero.Tablero;

public class JuegoState extends State {
	private Tablero tablero;
	
	public JuegoState(Juego juego) {
		super(juego);
		tablero = new Tablero("./recursos/map0.txt");
	}

	@Override
	public void calcular() {
		// acá calculo todo lo que tenga que ir cambiando
		tablero.calcular();
	}

	@Override
	public void dibujar(Graphics g) {
		// acá dibujo tablero, jugadores, etc
		
		tablero.dibujar(g);
	}
}
