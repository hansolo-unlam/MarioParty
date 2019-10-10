package hansolo.marioparty.graficos;

import java.awt.image.BufferedImage;

/*
 * Clase que carga las texturas para que otros objetos puedan tener acceso a ellas.
 */
public class Texturas {
	// Ancho y alto de las texturas
	private static final int width = 32, height = 32;
	
	// texturas de jugadores
	public static BufferedImage jugador_1, jugador_2, jugador_3, jugador_4;
	
	// texturas de casilleros
	public static BufferedImage casillero_bifurcacion, casillero_estrella, casillero_moneda_positivo, casillero_moneda_negativo;
	
	/*
	 * Método que carga en todas las BufferedImages sus correspondientes texturas
	 */
	public static void init() {
		
	}
}
