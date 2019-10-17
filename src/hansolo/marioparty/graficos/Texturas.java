package hansolo.marioparty.graficos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * Clase que carga las texturas para que otros objetos puedan tener acceso a ellas.
 */
public class Texturas {
	// Ancho y alto de las texturas
	public static final int width = 64, height = 64;
	
	// texturas de jugadores
	public static BufferedImage jugador_1, jugador_2, jugador_3, jugador_4;
	
	// texturas de casilleros
	public static BufferedImage casillero_bifurcacion, casillero_estrella, casillero_moneda_positivo, casillero_moneda_negativo, casillero_hurto, 
	casillero_random_malo, casillero_TP, casillero_tienda, casillero_item;
	
	public static BufferedImage casillero_conexion_este, casillero_conexion_norte, casillero_conexion_sur, casillero_conexion_oeste;
	
	// botones
	public static BufferedImage[] btnTirarDado, btnTerminarTurno;
	
	/*
	 * Método que carga en todas las BufferedImages sus correspondientes texturas
	 */
	public static void init() {
		// botones
		HojaSprites hojaBotonTirarDado = new HojaSprites(ImageLoader.cargarImagen("recursos/texturas/botones/boton-tirardado.png"));
		btnTirarDado = new BufferedImage[2];
		btnTirarDado[0] = hojaBotonTirarDado.recortar(0, 0, 82, 32);
		btnTirarDado[1] = hojaBotonTirarDado.recortar(0, 32, 82, 32);

		HojaSprites hojaBotonTerminarTurno = new HojaSprites(ImageLoader.cargarImagen("recursos/texturas/botones/boton-terminarturno.png"));
		btnTerminarTurno = new BufferedImage[2];
		btnTerminarTurno[0] = hojaBotonTerminarTurno.recortar(0, 0, 115, 32);
		btnTerminarTurno[1] = hojaBotonTerminarTurno.recortar(0, 32, 115, 32);
		
		// jugadores
		HojaSprites hojaJugador1 = new HojaSprites(ImageLoader.cargarImagen("recursos/texturas/jugadores/jugador1/sprite-tablero.png"));
		jugador_1 = hojaJugador1.recortar(0, 0, width, height);
		
		HojaSprites hojaJugador2 = new HojaSprites(ImageLoader.cargarImagen("recursos/texturas/jugadores/jugador2/sprite-tablero.png"));
		jugador_2 = hojaJugador2.recortar(0, 0, width, height);
		
		HojaSprites hojaJugador3 = new HojaSprites(ImageLoader.cargarImagen("recursos/texturas/jugadores/jugador3/sprite-tablero.png"));
		jugador_3 = hojaJugador3.recortar(0, 0, width, height);
		
		HojaSprites hojaJugador4 = new HojaSprites(ImageLoader.cargarImagen("recursos/texturas/jugadores/jugador4/sprite-tablero.png"));
		jugador_4 = hojaJugador4.recortar(0, 0, width, height);
		
		// casilleros
		HojaSprites hojaCasilleros = new HojaSprites(ImageLoader.cargarImagen("recursos/texturas/sprites-casilleros.png"));
		casillero_moneda_positivo = hojaCasilleros.recortar(0 * width, 0 * height, width, height);
		casillero_moneda_negativo = hojaCasilleros.recortar(1 * width, 0 * height, width, height);
		casillero_estrella = hojaCasilleros.recortar(4 * width, 1 * height, width, height);
		casillero_tienda = hojaCasilleros.recortar(2 * width, 1 * height, width, height);
		casillero_random_malo = hojaCasilleros.recortar(4 * width, 0 * height, width, height);
		casillero_TP = hojaCasilleros.recortar(3 * width, 0 * height, width, height);
		casillero_hurto = hojaCasilleros.recortar(3 * width, 1 * height, width, height);
		casillero_item = hojaCasilleros.recortar(1 * width, 1 * height, width, height);
		
		// conexiones casilleros
		casillero_conexion_norte = hojaCasilleros.recortar(1 * width, 2 * height, width, height);
		casillero_conexion_este = hojaCasilleros.recortar(0 * width, 2 * height, width, height);
		casillero_conexion_sur = hojaCasilleros.recortar(3 * width, 2 * height, width, height);
		casillero_conexion_oeste = hojaCasilleros.recortar(2 * width, 2 * height, width, height);
		
//		String path = System.getProperty("user.dir") + "//recursos//texturas//";
//		try {
//			casillero_moneda = ImageIO.read(new File(path,"Moneda.png"));
//			casillero_estrella = ImageIO.read(new File(path,"Estrella.png"));
//			casillero_hurto = ImageIO.read(new File(path,"Ladron.png"));
//			casillero_random_malo = ImageIO.read(new File(path,"Random.png"));
//			casillero_TP = ImageIO.read(new File(path,"TP.png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
