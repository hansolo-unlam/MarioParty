package minijuego;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Soundbank;

import hansolo.marioparty.admin.Usuario;
import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.graficos.Ventana;
import hansolo.marioparty.input.KeyManager;
import hansolo.marioparty.states.MinijuegoState;
import hansolo.marioparty.states.State;

public class Minijuego implements Runnable {

	// Ventana
	private Ventana ventana;
	public static int width, height;
	private String title;

	private boolean ejecutando = false;
	private Thread thread;

	private List<Jugador> jugadores;

	// Input usuario
	private KeyManager keyManager;

	// Graficos
	private BufferStrategy bs;
	private Graphics g;

	// Estados
	private MinijuegoState minijuegosStates;

	public Minijuego(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;

		keyManager = new KeyManager();
	}

	private void init() {
		// Creo la ventana
		this.ventana = new Ventana(title, width, height);

		// Agrego el listener del teclado
		ventana.getFrame().addKeyListener(keyManager);

		TexturasMinijuego.init();

		this.jugadores = new ArrayList<Jugador>();
		this.jugadores.add(new Jugador(1, new Usuario("diego"), null));

		minijuegosStates = new MinijuegoState(this);

		State.setState(minijuegosStates);
	}

	private void calcular() {
		keyManager.calcular();

		if (State.getState() != null) {
			State.getState().calcular();
		}

	}

	public void dibujar() {
		bs = this.ventana.getCanvas().getBufferStrategy();

		// si es la primera vez que ejecuta y el canvas no tiene un bs, le creo un bs al
		// canvas
		if (bs == null) {
			ventana.getCanvas().createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics();

		// limpiar pantalla
		g.clearRect(0, 0, width, height);
		g.fillRect(0, 0, width, height);

		if (State.getState() != null) {
			State.getState().dibujar(g);
		}

		bs.show();
		g.dispose();
	}

	public synchronized void start() {

		if (ejecutando) {
			return;
		}

		this.ejecutando = true;
		this.thread = new Thread(this);
		// Llama al metodo run
		thread.start();
	}

	public synchronized void stop() {
		// Si no está corriendo, salimos
		if (!ejecutando)
			return;

		ejecutando = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
				calcular();

				// dibuja el juego
				dibujar();

				ticks++;
				delta--;
			}

			// cada 1 segundo muestro por consola la cantidad de ticks
			if (timer >= 1000000000) {
//				System.out.println("fps: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}

		stop();

	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public void setKeyManager(KeyManager keyManager) {
		this.keyManager = keyManager;
	}
}
