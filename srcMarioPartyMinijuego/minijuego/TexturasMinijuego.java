package minijuego;

import java.awt.Image;
import java.awt.image.BufferedImage;

import hansolo.marioparty.graficos.HojaSprites;
import hansolo.marioparty.graficos.ImageLoader;

public class TexturasMinijuego {

	private static final String pathTexturaJugador1 = "recursos/texturaMinijuego/Trex.png";
	private static final String pathTexturaSuelo = "recursos/texturaMinijuego/suelo.jpg";
	private static final String pathObstaculoAire = "recursos/texturaMinijuego/6.png";
	private static final String pathObstaculoSuelo = "recursos/texturaMinijuego/5.png";

	public static final int width = 64, height = 64;

	// texturas de jugadores
	public static BufferedImage jugador_1;
	public static BufferedImage suelo;
	public static BufferedImage obstaculoSuelo;
	public static BufferedImage obstaculoAire;

	// Metodo que carga en los buffers las imagenes
	public static void init() {
		HojaSprites hojaJugador_1 = new HojaSprites(ImageLoader.cargarImagen(pathTexturaJugador1));

		HojaSprites hojaObsSuelo = new HojaSprites(ImageLoader.cargarImagen(pathObstaculoSuelo));
		HojaSprites hojaObsAire = new HojaSprites(ImageLoader.cargarImagen(pathObstaculoAire));
		HojaSprites hojaSuelo = new HojaSprites(ImageLoader.cargarImagen(pathTexturaSuelo));
	}

}
