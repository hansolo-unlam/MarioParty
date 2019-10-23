package hansolo.marioparty;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import hansolo.marioparty.admin.Usuario;
import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.graficos.ImageLoader;
import hansolo.marioparty.graficos.Texturas;
import hansolo.marioparty.graficos.Ventana;
import hansolo.marioparty.input.KeyManager;
import hansolo.marioparty.input.MouseManager;
import hansolo.marioparty.minijuegos.JuegoDados;
import hansolo.marioparty.minijuegos.Minijuego;
import hansolo.marioparty.states.TableroState;
import hansolo.marioparty.states.MinijuegoState;
import hansolo.marioparty.states.State;

public class Juego implements Runnable {
	private Ventana ventana;
	private int width, height;
	private String title;
	
	private boolean ejecutando = false; // boolean que setea en true el método start() y en false el método stop()
	private Thread thread;
	
	private List<Jugador> jugadores; // lista de los jugadores que están participando del juego
	
	// estados
	// private MenuState menuState;
	private TableroState tableroState;
	private MinijuegoState minijuegoState;
	
	//cuando tengamos mas minijuegos se cargarian en el vector
	private Minijuego[] minijuegos = new Minijuego[1];
	
	// input
	private MouseManager mouseManager;
	private KeyManager keyManager;
	
	// Gráficos
	private BufferStrategy bs;
	private Graphics g;
	
	private BufferedImage background;
	
	public Juego(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		mouseManager = new MouseManager();
		keyManager = new KeyManager();
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
	
	private void init() {
		// creo la ventana
		ventana = new Ventana(title, width, height);
		//no pude meterlo adentro de una carpeta, por alguna razon no me dejaba hacer /recursos/texturas
		background = ImageLoader.cargarImagen("recursos/texturas/MPHanSolo.png"); 
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
		jugadores.add(new Jugador(1, new Usuario("facundo"), this));
		jugadores.add(new Jugador(2, new Usuario("miguel"), this));
		jugadores.add(new Jugador(3, new Usuario("susana"), this));
		jugadores.add(new Jugador(4, new Usuario("gabriel"), this));
		
		// inicializo los estados
		tableroState = new TableroState(this);
		minijuegoState = new MinijuegoState(this);
		minijuegos[0] = new JuegoDados(this);
		
		State.setState(tableroState);
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
		g.drawImage(background, 20, 20, null);

		// mando a dibujar el state (y a partir del state, todo el resto)
		if (State.getState() != null)
			State.getState().dibujar(g);
		
		// terminó de dibujar
		bs.show();
		g.dispose();

	}

	/*
	 * Método que le permite a un jugador terminar su turno, no hace otra cosa que ejecutar un handle definido en el JuegoState
	 */
	public void pasarTurno() {
		tableroState.handleTerminoTurno();
	}
	
	public void iniciarMinijuego() {
		//aca deberiamos seleccionar un minijuego al azar para llamar
		minijuegos[0].getFrame().setVisible(true);
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
	
	public void premiar(int posiciones[]) {
		int monedas = 10;
		for (int i = 0; i < posiciones.length; i++) {
			this.jugadores.get(posiciones[i]).setMonedas(monedas+this.jugadores.get(posiciones[i]).getMonedas());
			monedas = monedas%2 + (monedas/2);
		}
		
	}

	public TableroState getJuegoState() {
		return tableroState;
	}

	public void setJuegoState(TableroState tableroState) {
		this.tableroState = tableroState;
	}
}
