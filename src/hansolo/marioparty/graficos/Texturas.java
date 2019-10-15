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
	public static BufferedImage casillero_bifurcacion, casillero_estrella, casillero_moneda, casillero_hurto, 
	casillero_random_malo, casillero_TP;
	
	// botones
	public static BufferedImage[] btnTirarDado;
	
	/*
	 * Método que carga en todas las BufferedImages sus correspondientes texturas
	 */
	public static void init() {
		HojaSprites hojaBotones = new HojaSprites(ImageLoader.cargarImagen("recursos/texturas/botones.png"));
		
		btnTirarDado = new BufferedImage[2];
		btnTirarDado[0] = hojaBotones.recortar(0, 0, 82, 32);
		btnTirarDado[1] = hojaBotones.recortar(0, 32, 82, 32);
		
		String path = System.getProperty("user.dir") + "//recursos//texturas//";
		try {
			casillero_moneda = ImageIO.read(new File(path,"Moneda.png"));
			casillero_estrella = ImageIO.read(new File(path,"Estrella.png"));
			casillero_hurto = ImageIO.read(new File(path,"Ladron.png"));
			casillero_random_malo = ImageIO.read(new File(path,"Random.png"));
			casillero_TP = ImageIO.read(new File(path,"TP.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
