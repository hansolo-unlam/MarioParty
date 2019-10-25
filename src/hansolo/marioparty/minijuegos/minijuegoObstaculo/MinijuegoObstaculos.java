package hansolo.marioparty.minijuegos.minijuegoObstaculo;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Iterator;
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
	private final int SIZE = 32;

	private KeyManager keyManager;
	private BufferStrategy bs;
	private Graphics g;
	private Thread thread;
	private boolean ejecutando = false;

	// ------------JUEGO-------------------
	private List<Obstaculo> obstaculos;
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

		obstaculos = new ArrayList<Obstaculo>();
		obstaculos.add(new Obstaculo(0));
		obstaculos.add(new Obstaculo(128));
		obstaculos.add(new Obstaculo(512));

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

		// Calcula la posY del jugador;
		calcularSalto();
		// Calcula la nueva posicion del obstaculo
		calcularPosObstaculoTierra();
		// Verifica si un jugador colisiono con un obstaculo , si colisiono lo elimina
		calcularColisiones();

		// Verifica si el obstaculo llego al final de su recorrido le debo asignar un
		// punto al jugador
		asignarPuntos();

		if (jugadoresMinijuego.isEmpty()) {
			borrarCanvas(g);
			ejecutando = false;
			return;
		}
		dibujarFondo();
		dibujarSuelo();
		dibujarObstaculos();
//		dibujarPuntajes();
		dibujarJugadores();

		// DEJAR DE DIBUJAR
		bs.show();
		g.dispose();

	}

	private void dibujarObstaculos() {
		for (Obstaculo obs : obstaculos) {
			obs.dibujar(g);
		}
	}

	private void dibujarJugadores() {
		for (JugadorObstaculo jugadorObstaculo : jugadoresMinijuego) {
			jugadorObstaculo.dibujar(g);
		}
	}

	// ESE RETURN NO VA AHI
	private void calcularColisiones() {
		Iterator<JugadorObstaculo> iteradorJug = jugadoresMinijuego.iterator();

		while (iteradorJug.hasNext()) {
			JugadorObstaculo jug = iteradorJug.next();
			for (Obstaculo obs : obstaculos) {
				if (obs.colisiona(jug.getX(), jug.getY())) {
					iteradorJug.remove();
				}
			}
		}

	}

	private void calcularSalto() {
		for (JugadorObstaculo jugadorObstaculo : jugadoresMinijuego) {
			jugadorObstaculo.salto();
		}
	}

	private void dibujarFondo() {

		g.drawImage(Texturas.escenario[0], 0, 0, WIDTH, HEIGHT - 32, null);
	}

	private void dibujarSuelo() {

		for (int i = 0; i < WIDTH / SIZE; i++) {
			g.drawImage(Texturas.suelo, i * 32, HEIGHT - SIZE, null);
		}
	}

	private void calcularPosObstaculoTierra() {
		for (Obstaculo obs : obstaculos) {
			obs.calcularPosicion(velocidadObst);
		}
	}

	private void asignarPuntos() {
		for (Obstaculo obs : obstaculos) {
			for (JugadorObstaculo jugador : jugadoresMinijuego) {
				if (obs.isPosicionFinal()) {
					jugador.setPuntos(jugador.getPuntos() + 1);
				}
			}
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
