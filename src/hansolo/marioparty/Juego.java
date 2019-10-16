package hansolo.marioparty;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import hansolo.marioparty.admin.Usuario;
import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.graficos.Texturas;
import hansolo.marioparty.graficos.Ventana;
import hansolo.marioparty.input.KeyManager;
import hansolo.marioparty.input.MouseManager;
import hansolo.marioparty.states.JuegoState;
import hansolo.marioparty.states.MinijuegoState;
import hansolo.marioparty.states.State;

public class Juego implements Runnable {
	private Ventana ventana;
	private int width, height;
	private String title;
	
	private boolean ejecutando = false;
	private Thread thread;
	
	
	private List<Jugador> jugadores;
	
	// estados
	private JuegoState juegoState;
	private MinijuegoState minijuegoState;
	
	// input
	private MouseManager mouseManager;
	private KeyManager keyManager;
	
	// Gráficos
	private BufferStrategy bs;
	private Graphics g;
	
	public Juego(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		mouseManager = new MouseManager();
		keyManager = new KeyManager();
	}
	
	private void init() {
		// creo la ventana
		ventana = new Ventana(title, width, height);
		
		// agrego los keyListener a la ventana
		ventana.getFrame().addKeyListener(keyManager);
		
		ventana.getFrame().addMouseListener(mouseManager);
		ventana.getFrame().addMouseMotionListener(mouseManager);
		ventana.getCanvas().addMouseListener(mouseManager);
		ventana.getCanvas().addMouseMotionListener(mouseManager);
		
		// cargo las texturas
		Texturas.init();
		
		// TEMPORAL: inicializo el array de jugadores con jugadores hardcodeados
		jugadores = new ArrayList<Jugador>();
		jugadores.add(new Jugador(new Usuario("facundo"), this));
		jugadores.add(new Jugador(new Usuario("miguel"), this));
		jugadores.add(new Jugador(new Usuario("susana"), this));
		jugadores.add(new Jugador(new Usuario("gabriel"), this));
		
		// inicializo los estados
		juegoState = new JuegoState(this);
		minijuegoState = new MinijuegoState(this);
		
		State.setState(juegoState);
	}
	
	private void calcular() {
		keyManager.calcular();
		
		if (State.getState() != null)
			State.getState().calcular();
	}
	
	public void dibujar() {
		bs = ventana.getCanvas().getBufferStrategy();
		
		// si es la primera vez que ejecuta y el canvas no tiene un bs, le creo un bs al canvas
		if (bs == null) {
			ventana.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		// limpiar pantalla
		g.clearRect(0, 0, width, height);
		g.fillRect(0, 0, width, height);
		
		// mando a dibujar el state (y a partir del state, todo el resto)
		if (State.getState() != null)
			State.getState().dibujar(g);
		
		// terminó de dibujar
		bs.show();
		g.dispose();		
	}
	
	/*
	 * Este método es donde está la salsa.
	 */
	@Override
	public void run() {
		init();
		
		// A cuantos fps queremos limitar
		int fps = 60;
		
		// Cuanto tiempo debería llevarme COMO MÁXIMO procesar y dibujar cada tick para cumplir (en nanosegundos)
		double tiempoPorTick = 1000000000 / fps;
		
		// Valor que uso para ver si ya tengo que hacer un tick (si es menor a 1 todavía falta)
		double delta = 0;
		
		// el tiempo en nanosegundos al momento en el que está ejecutando el ciclo
		long nanosegundosAhora;
		
		// el tiempo en nanosegundos de la última vez que ejecutó el ciclo (nanosegundosAhora del ciclo anterior)
		long nanosegundosUltimaVez = System.nanoTime();
		
		// acá voy acumulando los nanosegundos que pasan entre tick y tick
		long timer = 0;
		
		// La cantidad de ticks que hice
		int ticks = 0;
		
		while(ejecutando) {
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
				System.out.println("fps: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	/*
	 * Entry point del objeto. Esto es lo que ejecuta el launcher. Cuando ejecuta "thread.start()" se manda a ejecutar el metodo run()
	 */
	public synchronized void start() {
		// Si ya está corriendo, salimos
		if (ejecutando) return;
		
		ejecutando = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		// Si no está corriendo, salimos
		if (!ejecutando) return;
		
		ejecutando = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	public void pasarTurno(Jugador jugador) {
		
		int id = jugadores.indexOf(jugador);
		id++;
		if(id<jugadores.size()) {
			juegoState.pasarJugador(jugadores.get(id));
		}
		else
			juegoState.pasarJugador(jugadores.get(0));
	}
	
	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public void setMouseManager(MouseManager mouseManager) {
		this.mouseManager = mouseManager;
	}
	
}
