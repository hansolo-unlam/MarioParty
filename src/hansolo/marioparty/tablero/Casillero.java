package hansolo.marioparty.tablero;

import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.casilleros.BifurcacionCasillero;

/**
 * Clase abstracta que define lo que comparten en común todos los tipos de
 * casilleros. Un casillero es una ubicación del mapa donde puede estar parado
 * un jugador en un momento dado. Para mayor claridad se puede ver la imagen
 * ./docs/map0.png
 * 
 * @author facundotourn
 *
 */
public abstract class Casillero {
	protected int id;
	private SiguienteCasillero siguienteNorte;
	private SiguienteCasillero siguienteSur;
	private SiguienteCasillero siguienteOeste;
	private SiguienteCasillero siguienteEste;

	private boolean efectoPasandoSobre;

	public Casillero(int idCasillero, boolean efectoPasandoSobre) {
		this.id = idCasillero;
		this.efectoPasandoSobre = efectoPasandoSobre;
		this.siguienteNorte = null;
		this.siguienteEste = null;
		this.siguienteOeste = null;
		this.siguienteSur = null;
	}

	public abstract void efecto(Jugador jugador);

	/**
	 * Retorna un SiguienteCasillero que es el casillero al que corresponde avanzar
	 * ya sea porque se seleccionó (y el casillero actual es una bifurcación) o
	 * porque no había más opciones.
	 * 
	 * @return SiguienteCasillero al que hay que avanzar
	 */
//	public SiguienteCasillero getSiguiente() {
//		 for (SiguienteCasillero sig : siguientes) {
//		if (sig.isSeleccionado())
//		 return sig;
//		 }
//		return null;
//	}

	public SiguienteCasillero getSiguiente() {
		if (this.siguienteEste != null) {
			return this.siguienteEste;
		}
		if (this.siguienteNorte != null) {
			return this.siguienteNorte;
		}

		if (this.siguienteOeste != null) {
			return this.siguienteOeste;
		}

		if (this.siguienteSur != null) {
			return this.siguienteSur;
		}

		return null;
	}

	/**
	 * Debería setear uno de los SiguienteCasilleros de siguientes[] como el
	 * casillero seleccionado y dejar al resto en false. Cuando se arme debería
	 * reemplazar a la función que hay en BifurcacionCasillero (seleccionarNext()).
	 * 
	 * @param siguienteCasillero
	 */
	public void setSiguiente(SiguienteCasillero siguiente) {
	}

	/**
	 * Retorna el atributo de casillero o casilleros siguientes. No indica a qué
	 * casillero hay que ir, únicamente indica qué casilleros le siguen a this en el
	 * mapa.
	 * 
	 * @return array de SiguienteCasillero
	 */
	public List<SiguienteCasillero> getSiguientes() {
		ArrayList<SiguienteCasillero> siguientes = new ArrayList<SiguienteCasillero>();

		if (this.siguienteEste != null) {
			siguientes.add(siguienteEste);
		}
		if (this.siguienteNorte != null) {
			siguientes.add(siguienteNorte);
		}

		if (this.siguienteOeste != null) {
			siguientes.add(siguienteNorte);
		}

		if (this.siguienteSur != null) {
			siguientes.add(siguienteSur);
		}

		return siguientes;
	}

	public void setSiguientes() {
	}

	public boolean isEfectoPasandoSobre() {
		return efectoPasandoSobre;
	}

	public void setEfectoPasandoSobre(boolean efectoPasandoSobre) {
		this.efectoPasandoSobre = efectoPasandoSobre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void cardinalidad(Casillero siguiente, char orientacion) {

		switch (orientacion) {
		case 'N':
			siguienteNorte = new SiguienteCasillero(siguiente, EnumDireccion.N);
			break;
		case 'S':
			siguienteSur = new SiguienteCasillero(siguiente, EnumDireccion.S);
			break;
		case 'E':
			siguienteEste = new SiguienteCasillero(siguiente, EnumDireccion.E);
			break;
		case 'O':
			siguienteOeste = new SiguienteCasillero(siguiente, EnumDireccion.O);
			break;
		default:
			break;
		}
	}
}
