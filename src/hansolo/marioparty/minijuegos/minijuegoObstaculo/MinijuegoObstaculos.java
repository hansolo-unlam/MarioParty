package hansolo.marioparty.minijuegos.minijuegoObstaculo;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import hansolo.marioparty.Juego;
import hansolo.marioparty.graficos.Texturas;
import hansolo.marioparty.input.KeyManager;
import hansolo.marioparty.minijuegos.Minijuego;

public class MinijuegoObstaculos extends Minijuego implements Runnable {

	private JFrame frame;
	private Canvas canvas;

	private final int HEIGHT = 256;
	private final int WIDTH = 1024;
	private int size = 32;

	private KeyManager keyManager;
	private BufferStrategy bs;
	private Graphics g;
	private Thread thread;
	private boolean ejecutando = false;

	// ------------JUEGO-------------------
	// Constantes
	private final int Y_INICIAL_SUELO = 192;
	private final int X_INICIAL_OBS = 1024;

	// Variables jugador
	private int obstaculoXTierra = X_INICIAL_OBS;
	private int obstaculoXTierra1 = X_INICIAL_OBS + 160;
	private int obstaculoXTierra2 = X_INICIAL_OBS + 288;

	private int velocidadObst = 4;

	private List<JugadorObstaculo> jugadoresMinijuego;

	public MinijuegoObstaculos(Juego juego) {
		super(juego);
		keyManager = new KeyManager();
		jugadoresMinijuego = new ArrayList<JugadorObstaculo>();

		jugadoresMinijuego.add(new JugadorObstaculo(0, 1, keyManager));
		jugadoresMinijuego.add(new JugadorObstaculo(64, 2, keyManager));
		jugadoresMinijuego.add(new JugadorObstaculo(128, 3, keyManager));
		jugadoresMinijuego.add(new JugadorObstaculo(192, 4, keyManager));
//
		Texturas.init();
	}

	private void init() {
		frame = new JFrame("Minijuego Obstaculos");
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));

		frame.addKeyListener(keyManager);
		frame.add(canvas);
		frame.pack();

	}

	@Override
	public void run() {
		init();

		// A cuantos fps queremos limitar
		int fps = 60;

		// Cuanto tiempo debería llevarme COMO MÁXIMO procesar y dibujar cada tick para
		// cumplir (en nanosegundos)
		double tiempoPorTick = 1000000000 / fps;

		// Valor que uso para ver si ya tengo que hacer un tick (si es menor a 1 todavía
		// falta)
		double delta = 0;

		// el tiempo en nanosegundos al momento en el que está ejecutando el ciclo
		long nanosegundosAhora;

		// el tiempo en nanosegundos de la última vez que ejecutó el ciclo
		// (nanosegundosAhora del ciclo anterior)
		long nanosegundosUltimaVez = System.nanoTime();

		// acá voy acumulando los nanosegundos que pasan entre tick y tick
		long timer = 0;

		// La cantidad de ticks que hice
		int ticks = 0;
		while (ejecutando) {
			nanosegundosAhora = System.nanoTime();
			delta += (nanosegundosAhora - nanosegundosUltimaVez) / tiempoPorTick;
			timer += nanosegundosAhora - nanosegundosUltimaVez;
			nanosegundosUltimaVez = nanosegundosAhora;

			if (delta >= 1) {
				// actualiza variables
				verificarTeclado();
				// dibuja el juego
				render();
				ticks++;
				delta--;
			}

			// cada 1 segundo muestro por consola la cantidad de ticks
			if (timer >= 1000000000) {
				ticks = 0;
				timer = 0;
			}
		}

		stop();
	}

	private void verificarTeclado() {
		for (JugadorObstaculo jugadorObstaculo : jugadoresMinijuego) {
			jugadorObstaculo.verificarTeclado();
		}
	}

	private void render() {
		bs = canvas.getBufferStrategy();

		if (bs == null) {
			canvas.createBufferStrategy(10);
			return;
		}

		g = bs.getDrawGraphics();

		borrarCanvas(g);

		// DIBUJAR

		// SI NO HAY MAS JUGADORES SIGNIFICA QUE TERMINO EL JUEGO
//		if (jugadoresMinijuego.isEmpty()) {
//			System.out.println("Se termino");
//			this.ejecutando = false;
//			// ASIGNAR PUNTUACIONES
//			return;
//
//		}

		// Calcula la posY del jugador;
		calcularSalto();
		// Calcula la nueva posicion del obstaculo
		calcularPosObstaculoTierra();
		// Verifica si un jugador colisiono con un obstaculo
		calcularColisiones();

		dibujarFondo(g);
		dibujarSuelo(g);
		dibujarObstaculos();
		dibujarJugadores(g);

		// DEJAR DE DIBUJAR
		bs.show();
		g.dispose();

	}

	private void dibujarObstaculos() {
		g.drawImage(Texturas.tubo, obstaculoXTierra, Y_INICIAL_SUELO, 32, 32, null);
//		g.drawImage(Texturas.tubo, obstaculoXTierra1, Y_INICIAL_SUELO, size, size, null);
//		g.drawImage(Texturas.tubo, obstaculoXTierra2, Y_INICIAL_SUELO, 32, 32, null);
	}

	private void dibujarJugadores(Graphics g) {
		for (JugadorObstaculo jugadorObstaculo : jugadoresMinijuego) {
			jugadorObstaculo.dibujar(g);
		}
	}

	private void calcularColisiones() {
		for (JugadorObstaculo jugadorObstaculo : jugadoresMinijuego) {
			if (jugadorObstaculo.colision(obstaculoXTierra)) {
				jugadoresMinijuego.remove(jugadorObstaculo);
				return;
			}
			if (jugadorObstaculo.colision(obstaculoXTierra1)) {
				jugadoresMinijuego.remove(jugadorObstaculo);
				return;
			}

			if (jugadorObstaculo.colision(obstaculoXTierra2)) {
				jugadoresMinijuego.remove(jugadorObstaculo);
				return;
			}
		}
	}

	private void calcularSalto() {
		for (JugadorObstaculo jugadorObstaculo : jugadoresMinijuego) {
			jugadorObstaculo.gravedad();
		}
	}

	private void dibujarFondo(Graphics g) {

		g.drawImage(Texturas.escenario[0], 0, 0, WIDTH, HEIGHT - 32, null);
	}

	private void dibujarSuelo(Graphics g) {

		for (int i = 0; i < WIDTH / size; i++) {
			g.drawImage(Texturas.suelo, i * 32, HEIGHT - size, null);
		}
	}

	private void calcularPosObstaculoTierra() {
		if (obstaculoXTierra < 0) {
			obstaculoXTierra = X_INICIAL_OBS;
			asignarPuntos();
		} else {
			obstaculoXTierra -= velocidadObst;
		}

//		if (obstaculoXTierra1 < 0) {
//			obstaculoXTierra1 = X_INICIAL_OBS + 160;
//		} else {
//			obstaculoXTierra1 -= velocidadObst;
//		}
//
//		if (obstaculoXTierra2 < 0) {
//			obstaculoXTierra2 = X_INICIAL_OBS + 288;
//		} else {
//			obstaculoXTierra2 -= velocidadObst;
//		}
	}

	private void asignarPuntos() {
		for (JugadorObstaculo jugadorObstaculo : jugadoresMinijuego) {
			jugadorObstaculo.setPuntos(jugadorObstaculo.getPuntos() + 1);
		}
	}

	private void borrarCanvas(Graphics g) {
		g.clearRect(0, 0, WIDTH, HEIGHT);
	}

	public synchronized void start() {
		ejecutando = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {

		if (!ejecutando) {
			return;
		}

		ejecutando = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MinijuegoObstaculos min = new MinijuegoObstaculos(null);
		min.start();
	}

}
