package hansolo.marioparty.states;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import hansolo.marioparty.Juego;
import hansolo.marioparty.entidades.Jugador;
import minijuego.Minijuego;
import minijuego.MinijuegoObstaculos;

public class MinijuegoState extends State {

	private List<Jugador> jugadores;
	private MinijuegoObstaculos gameObst;
	private Minijuego minijuego;

	public MinijuegoState(Juego juego) {
		super(juego);
	}

	// Provisorio
	public MinijuegoState(Minijuego minijuego) {
		super(null);
		gameObst = new MinijuegoObstaculos(minijuego);
	}

	@Override
	public void calcular() {

	}

	@Override
	public void dibujar(Graphics g) {
		gameObst.dibujar(g);
	}

}
