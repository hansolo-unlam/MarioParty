package hansolo.marioparty.tablero.casilleros;

import java.util.List;
import java.util.Random;
import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;

/**
 * Casillero que, cuando pasas o ca�s, te pregunta a cual de los next quer�s
 * moverte
 * 
 * @author facundotourn
 *
 */
public class BifurcacionCasillero extends Casillero {
	private Random r;

	public BifurcacionCasillero(int id) {
		super(id, true);
		this.r = new Random();
	}

	/**
	 * El efecto de la bifurcaci�n consiste en confirmar en qu� direcci�n quiere
	 * avanzar el jugador y moverlo al casillero siguiente. De esta forma, el
	 * jugador nunca va a terminar un turno parado sobre una bifurcaci�n.
	 */
	@Override
	public void efecto(Jugador jugador) {
		System.out.println(jugador.getUser().getNombre() + " pas� por una bifurcaci�n");

		jugador.setPosicion(seleccionarNext());

//		jugador.avanzarAlSiguienteCasillero();
	}

	/**
	 * Setea los boolean de seleccionado de los SiguienteCasillero del array
	 * 'siguientes' para que quede en true unicamente el seleccionado por el
	 * usuario. TEMPORALMENTE SE ELIGE UN VALOR ALEATORIO, IGNORANDO EL ID QUE SE
	 * RECIBE COMO PAR�METRO. DEBER�A SER UN M�TODO DEL CASILLERO.
	 * 
	 * @param id del Casillero seleccionado
	 */

	private Casillero seleccionarNext() {
		List<SiguienteCasillero> opciones = this.getSiguientes();
		int id = r.nextInt(opciones.size()); // Hay que cambiar esto por la eleccion del usuario.
		Casillero sig = opciones.get(id).getSiguiente();
		System.out.println("Despues de la bifurcacion quede en: " + sig.getId());
		return sig;

//		for (int i = 0; i < opciones.size(); i++) {
//			if (i == 0) {
//				return
//			} else {
//				opciones.get(1).setSeleccionado(false);
//			}
//		}

//		this.setSiguiente(opciones.get(0));

//	 	id = opciones[r.nextInt(opciones.length)].getId();
//		for (int i = 0; i < opciones.length; i++) {
//			if (opciones[i].getId() == id)
//				opciones[i].setSeleccionado(true);
//			else
//				opciones[i].setSeleccionado(false);
//		}
//		this.setSiguientes(opciones);
	}
}
