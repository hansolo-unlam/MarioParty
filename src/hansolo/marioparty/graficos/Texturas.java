package hansolo.marioparty.graficos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

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
	public static BufferedImage casillero_bifurcacion, casillero_estrella, casillero_moneda_positivo,
			casillero_moneda_negativo, casillero_hurto, casillero_random_malo, casillero_TP, casillero_tienda,
			casillero_item;

	public static BufferedImage casillero_conexion_este_out, casillero_conexion_norte_out, casillero_conexion_sur_out,
			casillero_conexion_oeste_out;
	public static BufferedImage casillero_conexion_este_in, casillero_conexion_norte_in, casillero_conexion_sur_in,
			casillero_conexion_oeste_in;

	// botones
	public static BufferedImage[] btnTirarDado, btnTerminarTurno;

	// flechas
	public static BufferedImage[] flecha_arriba, flecha_abajo, flecha_izquierda, flecha_derecha;

	// MinijuegoObstaculos
	public static BufferedImage[] mario;
	public static BufferedImage[] luigi;
	public static BufferedImage[] escenario;
	public static BufferedImage tubo;
	public static BufferedImage suelo;
	public static BufferedImage iconoMario;
	public static BufferedImage iconoLuigi;
	public static BufferedImage iconoPeach;
	public static BufferedImage iconoYoshi;
	public static BufferedImage[] numeros;

	// moneda casillero
	public static BufferedImage moneda;

	/*
	 * Método que carga en todas las BufferedImages sus correspondientes texturas
	 */
	public static void init() {
		// botones
		HojaSprites hojaBotonTirarDado = new HojaSprites(
				ImageLoader.cargarImagen("recursos/texturas/botones/boton-tirardado.png"));
		btnTirarDado = new BufferedImage[2];
		btnTirarDado[0] = hojaBotonTirarDado.recortar(0, 0, 82, 32);
		btnTirarDado[1] = hojaBotonTirarDado.recortar(0, 32, 82, 32);

		HojaSprites hojaBotonTerminarTurno = new HojaSprites(
				ImageLoader.cargarImagen("recursos/texturas/botones/boton-terminarturno.png"));
		btnTerminarTurno = new BufferedImage[2];
		btnTerminarTurno[0] = hojaBotonTerminarTurno.recortar(0, 0, 115, 32);
		btnTerminarTurno[1] = hojaBotonTerminarTurno.recortar(0, 32, 115, 32);

		// jugadores
		HojaSprites hojaJugador1 = new HojaSprites(
				ImageLoader.cargarImagen("recursos/texturas/jugadores/jugador1/sprite-tablero.png"));
		jugador_1 = hojaJugador1.recortar(0, 0, width, height);

		HojaSprites hojaJugador2 = new HojaSprites(
				ImageLoader.cargarImagen("recursos/texturas/jugadores/jugador2/sprite-tablero.png"));
		jugador_2 = hojaJugador2.recortar(0, 0, width, height);

		HojaSprites hojaJugador3 = new HojaSprites(
				ImageLoader.cargarImagen("recursos/texturas/jugadores/jugador3/sprite-tablero.png"));
		jugador_3 = hojaJugador3.recortar(0, 0, width, height);

		HojaSprites hojaJugador4 = new HojaSprites(
				ImageLoader.cargarImagen("recursos/texturas/jugadores/jugador4/sprite-tablero.png"));
		jugador_4 = hojaJugador4.recortar(0, 0, width, height);

		// casilleros
		HojaSprites hojaCasilleros = new HojaSprites(
				ImageLoader.cargarImagen("recursos/texturas/sprites-casilleros.png"));
		casillero_moneda_positivo = hojaCasilleros.recortar(0 * width, 0 * height, width, height);
		casillero_moneda_negativo = hojaCasilleros.recortar(1 * width, 0 * height, width, height);
		casillero_estrella = hojaCasilleros.recortar(4 * width, 1 * height, width, height);
		casillero_tienda = hojaCasilleros.recortar(2 * width, 1 * height, width, height);
		casillero_random_malo = hojaCasilleros.recortar(4 * width, 0 * height, width, height);
		casillero_TP = hojaCasilleros.recortar(3 * width, 0 * height, width, height);
		casillero_hurto = hojaCasilleros.recortar(3 * width, 1 * height, width, height);
		casillero_item = hojaCasilleros.recortar(1 * width, 1 * height, width, height);

		// conexiones casilleros
		casillero_conexion_norte_in = hojaCasilleros.recortar(1 * width, 2 * height, width, height);
		casillero_conexion_este_in = hojaCasilleros.recortar(0 * width, 2 * height, width, height);
		casillero_conexion_sur_in = hojaCasilleros.recortar(3 * width, 2 * height, width, height);
		casillero_conexion_oeste_in = hojaCasilleros.recortar(2 * width, 2 * height, width, height);

		casillero_conexion_norte_out = hojaCasilleros.recortar(1 * width, 3 * height, width, height);
		casillero_conexion_este_out = hojaCasilleros.recortar(0 * width, 3 * height, width, height);
		casillero_conexion_sur_out = hojaCasilleros.recortar(3 * width, 3 * height, width, height);
		casillero_conexion_oeste_out = hojaCasilleros.recortar(2 * width, 3 * height, width, height);

		// flechas
		HojaSprites hojaFlechas = new HojaSprites(ImageLoader.cargarImagen("recursos/texturas/sprites-flechas.png"));
		flecha_arriba = new BufferedImage[2];
		flecha_arriba[0] = hojaFlechas.recortar(3 * width, 0 * height, width, height);
		flecha_arriba[1] = hojaFlechas.recortar(3 * width, 0 * height, width, height);
		flecha_abajo = new BufferedImage[2];
		flecha_abajo[0] = hojaFlechas.recortar(1 * width, 0 * height, width, height);
		flecha_abajo[1] = hojaFlechas.recortar(1 * width, 0 * height, width, height);
		flecha_izquierda = new BufferedImage[2];
		flecha_izquierda[0] = hojaFlechas.recortar(2 * width, 0 * height, width, height);
		flecha_izquierda[1] = hojaFlechas.recortar(2 * width, 0 * height, width, height);
		flecha_derecha = new BufferedImage[2];
		flecha_derecha[0] = hojaFlechas.recortar(0 * width, 0 * height, width, height);
		flecha_derecha[1] = hojaFlechas.recortar(0 * width, 0 * height, width, height);

		// Mario Minijuego
		HojaSprites hojaMario = new HojaSprites(ImageLoader.cargarImagen("recursos/texturaMinijuego/marios.png"));
		mario = new BufferedImage[4];
		mario[0] = hojaMario.recortar(0, 0, 15, 33);
		mario[1] = hojaMario.recortar(15, 0, 15, 33);
		mario[2] = hojaMario.recortar(30, 0, 15, 33);
		mario[3] = hojaMario.recortar(45, 0, 15, 33);

		// Luigi Minijuego
		HojaSprites hojaLuigi = new HojaSprites(ImageLoader.cargarImagen("recursos/texturaMinijuego/luigi32.png"));
		luigi = new BufferedImage[4];

		for (int i = 0; i < luigi.length; i++) {
			luigi[i] = hojaLuigi.recortar(32 * i, 0, 32, 32);
		}

		// Iconos de minijuego
		iconoMario = ImageLoader.cargarImagen("recursos/texturaMinijuego/iconoMario.png");
		iconoLuigi = ImageLoader.cargarImagen("recursos/texturaMinijuego/iconoLuigi.png");
		iconoPeach = ImageLoader.cargarImagen("recursos/texturaMinijuego/iconoPeach.png");
		iconoYoshi = ImageLoader.cargarImagen("recursos/texturaMinijuego/iconoYoshi.png");
//		 Array de numeros
		HojaSprites hojaNumeros = new HojaSprites(ImageLoader.cargarImagen("recursos/texturaMinijuego/numeros.png"));
		numeros = new BufferedImage[10];
		numeros[0] = hojaNumeros.recortar(0, 0, 10, 15);
		numeros[1] = hojaNumeros.recortar(10, 0, 10, 15);
		numeros[2] = hojaNumeros.recortar(20, 0, 10, 15);
		numeros[3] = hojaNumeros.recortar(30, 0, 10, 15);
		numeros[4] = hojaNumeros.recortar(40, 0, 10, 15);
		numeros[5] = hojaNumeros.recortar(50, 0, 10, 15);
		numeros[6] = hojaNumeros.recortar(60, 0, 10, 15);
		numeros[7] = hojaNumeros.recortar(70, 0, 10, 15);
		numeros[8] = hojaNumeros.recortar(80, 0, 10, 15);
		numeros[9] = hojaNumeros.recortar(90, 0, 10, 15);
		// Escenario minijuego

		escenario = new BufferedImage[4];
		escenario[0] = ImageLoader.cargarImagen("recursos/texturaMinijuego/fondo.png");
		tubo = ImageLoader.cargarImagen("recursos/texturaMinijuego/tubo32.png");
		suelo = ImageLoader.cargarImagen("recursos/texturaMinijuego/piso.png");

		////////////////

		moneda = ImageLoader.cargarImagen("recursos/texturas/Carteles/monedaCasillero.png");

	}
}
