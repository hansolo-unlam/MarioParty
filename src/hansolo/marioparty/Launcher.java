package hansolo.marioparty;

import hansolo.marioparty.admin.Usuario;
import hansolo.marioparty.items.DadoSimple;
import hansolo.marioparty.tablero.Tablero;

public class Launcher {

	public static void main(String[] args) {
		// Linea que muestra el path de ejecución
		// System.out.println(new File(".").getCanonicalPath());
		
		Usuario usrs[] = new Usuario[4];
		usrs[0] = new Usuario("mgonzalez");
		usrs[1] = new Usuario("scilurzo");
		usrs[2] = new Usuario("mmartinez");
		usrs[3] = new Usuario("dgomez");
		
		Partida p = new Partida(usrs, new Tablero("./recursos/map0.txt"), new CondicionVictoria(TipoCondicionVictoria.ESTRELLAS, 3));
		
		// GUARDA: Si se descomenta el loop de abajo y no se implemento la función que revise si ya ganó alguien 
		//         va a entrar en un bucle infinito.
//		while(true) {
//			p.tick();
//		}
	}
}
