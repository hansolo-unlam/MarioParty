package hansolo.marioparty;

import hansolo.marioparty.admin.Usuario;
import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.Tablero;
import hansolo.marioparty.tablero.casilleros.EstrellaCasillero;
import hansolo.marioparty.tablero.casilleros.RandomMaloCasillero;

public class Launcher {

	private final static String path = "./recursos/map0.txt";

	public static void main(String[] args) {
//		// Linea que muestra el path de ejecución
//		// System.out.println(new File(".").getCanonicalPath());
//
//		Usuario usrs[] = new Usuario[4];
//		usrs[0] = new Usuario("mgonzalez");
//		usrs[1] = new Usuario("scilurzo");
//		usrs[2] = new Usuario("mmartinez");
//		usrs[3] = new Usuario("dgomez");
//
//		Partida p = new Partida(usrs, new Tablero(path),
//				new CondicionVictoria(TipoCondicionVictoria.ESTRELLAS, 3));
//		p.getJugadores().get(0).setMonedas(40);
//		p.getJugadores().get(0).setPosicion(p.getTablero().getCasilleros().get(35));
//		EstrellaCasillero star = (EstrellaCasillero) p.getTablero().getCasilleros().get(36);
//		star.setTieneEstrella(true);
//		// p.getTablero().getCasilleros().get(36)
//
//		System.out.println("a");
//		// GUARDA: Si se descomenta el loop de abajo y no se implemento la función que
//		// revise si ya ganó alguien
//		// va a entrar en un bucle infinito.
//		while (true) {
//			p.tick();
//
//		}

//		Tablero tab = new Tablero(path);
//		Jugador jug = new Jugador(new Usuario("diego"), tab.getCasilleros().get(27), null);
//		jug.setMonedas(100);
//		jug.setCantMovimientos(5);
//		jug.avanzar();

		Jugador jugador = new Jugador(new Usuario("diego"), null, null);
		RandomMaloCasillero casilleroMalo = new RandomMaloCasillero(5);
		jugador.setMonedas(10000);
		jugador.setEstrellas(5);

		casilleroMalo.efecto(jugador);

		System.out.println("Estrellas:" + jugador.getEstrellas());
		System.out.println("Monedas:" + jugador.getMonedas());
	}
}
