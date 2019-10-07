package hansolo.marioparty.tablero;

import java.util.ArrayList;
import java.util.List;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.casilleros.BifurcacionCasillero;

/**
 * Clase abstracta que define lo que comparten en com�n todos los tipos de
 * casilleros. Un casillero es una ubicaci�n del mapa donde puede estar parado
 * un jugador en un momento dado. Para mayor claridad se puede ver la imagen
 * ./docs/map0.png
 * 
 * @author facundotourn
 *
 */
public abstract class Casillero {
	protected int id;
	private List<SiguienteCasillero> siguientes;
	private SiguienteCasillero siguienteNorte;
	private SiguienteCasillero siguienteSur;
	private SiguienteCasillero siguienteOeste;
	private SiguienteCasillero siguienteEste;

	private boolean efectoPasandoSobre;

	public Casillero(int idCasillero, boolean efectoPasandoSobre) {
		this.id = idCasillero;
		this.efectoPasandoSobre = efectoPasandoSobre;
		this.siguientes = new ArrayList<SiguienteCasillero>();
		this.siguienteNorte = null;
		this.siguienteEste = null;
		this.siguienteOeste = null;
		this.siguienteSur = null;
	}

	public abstract void efecto(Jugador jugador);

	/**
	 * Retorna un SiguienteCasillero que es el casillero al que corresponde avanzar
	 * ya sea porque se seleccion� (y el casillero actual es una bifurcaci�n) o
	 * porque no hab�a m�s opciones.
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

	public List<SiguienteCasillero> getSiguiente() {
		return siguientes;
	}

	/**
	 * Deber�a setear uno de los SiguienteCasilleros de siguientes[] como el
	 * casillero seleccionado y dejar al resto en false. Cuando se arme deber�a
	 * reemplazar a la funci�n que hay en BifurcacionCasillero (seleccionarNext()).
	 * 
	 * @param siguienteCasillero
	 */
	public void setSiguiente(SiguienteCasillero siguiente) {
	}

	/**
	 * Retorna el atributo de casillero o casilleros siguientes. No indica a qu�
	 * casillero hay que ir, �nicamente indica qu� casilleros le siguen a this en el
	 * mapa.
	 * 
	 * @return array de SiguienteCasillero
	 */
	public List<SiguienteCasillero> getSiguientes() {
		return siguientes;
	}

	public void setSiguientes(List<SiguienteCasillero> siguienteCasillero) {
		this.siguientes = siguienteCasillero;
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
			siguientes.add(siguienteNorte);
			break;
		case 'S':
			siguienteSur = new SiguienteCasillero(siguiente, EnumDireccion.S);
			siguientes.add(siguienteSur);
			break;
		case 'E':
			siguienteEste = new SiguienteCasillero(siguiente, EnumDireccion.E);
			siguientes.add(siguienteEste);
			break;
		case 'O':
			siguienteOeste = new SiguienteCasillero(siguiente, EnumDireccion.O);
			siguientes.add(siguienteOeste);
			break;
		default:
			break;
		}
	}
}
