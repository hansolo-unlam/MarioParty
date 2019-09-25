package hansolo.marioparty.tablero;

import hansolo.marioparty.entidades.Jugador;

/**
 * Clase abstracta que define lo que comparten en común todos los tipos de casilleros. Un casillero es una ubicación del mapa donde puede estar parado un jugador en un momento dado.
 * Para mayor claridad se puede ver la imagen ./docs/map0.png
 * @author facundotourn
 *
 */
public abstract class Casillero {
	private int id;
	private SiguienteCasillero[] siguientes;
	private boolean efectoPasandoSobre;

	public Casillero(int idCasillero, SiguienteCasillero[] next, boolean efectoPasandoSobre) {
		this.id = idCasillero;
		this.siguientes = next;
		this.efectoPasandoSobre = efectoPasandoSobre;
	}
	
	public abstract void efecto(Jugador jugador);
	
	/**
	 * Retorna un SiguienteCasillero que es el casillero al que corresponde avanzar ya sea porque se seleccionó (y el casillero actual es una bifurcación) o porque no había más opciones.
	 * @return SiguienteCasillero al que hay que avanzar
	 */
	public SiguienteCasillero getSiguiente() {
		for (SiguienteCasillero sig : siguientes) {
			if (sig.isSeleccionado())
				return sig;
		}
		return null;
	}
	
	/**
	 * Debería setear uno de los SiguienteCasilleros de siguientes[] como el casillero seleccionado y dejar al resto en false.
	 * Cuando se arme debería reemplazar a la función que hay en BifurcacionCasillero (seleccionarNext()).
	 */
	public void setSiguiente() {
		// En desarrollo.
	}
	
	/**
	 * Retorna el atributo de casillero o casilleros siguientes. No indica a qué casillero hay que ir, únicamente indica qué casilleros le siguen a this en el mapa.
	 * @return array de SiguienteCasillero
	 */
	public SiguienteCasillero[] getSiguientes() {
		return siguientes;
	}

	public void setSiguientes(SiguienteCasillero[] nexts) {		
		this.siguientes = nexts;
	}

	public boolean isEfectoPasandoSobre() {
		return efectoPasandoSobre;
	}

	public void setEfectoPasandoSobre(boolean efectoPasandoSobre) {
		this.efectoPasandoSobre = efectoPasandoSobre;
	}
}
