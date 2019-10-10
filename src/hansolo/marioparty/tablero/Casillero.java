package hansolo.marioparty.tablero;

import java.awt.Graphics;

import hansolo.marioparty.entidades.Jugador;

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
	protected int x;
	protected int y;

	private SiguienteCasillero norte;
	private SiguienteCasillero sur;
	private SiguienteCasillero oeste;
	private SiguienteCasillero este;

	private boolean efectoPasandoSobre;

	public Casillero(int idCasillero, boolean efectoPasandoSobre) {
		this.id = idCasillero;
		this.efectoPasandoSobre = efectoPasandoSobre;

		this.norte = null;
		this.este = null;
		this.oeste = null;
		this.sur = null;
	}

	public abstract void efecto(Jugador jugador);

	protected abstract void dibujar(Graphics g);

	/**
	 * Retorna un SiguienteCasillero que es el casillero al que corresponde
	 * avanzar ya sea porque se seleccionó (y el casillero actual es una
	 * bifurcación) o porque no había más opciones.
	 * 
	 * @return SiguienteCasillero al que hay que avanzar
	 */
	public SiguienteCasillero getSiguiente() {
		if (norte != null && norte.isSeleccionado())
			return norte;
		if (sur != null && sur.isSeleccionado())
			return sur;
		if (oeste != null && oeste.isSeleccionado())
			return oeste;
		if (este != null && este.isSeleccionado())
			return este;
		
		return null;
	}

	/**
	 * Debería setear uno de los SiguienteCasilleros de siguientes[] como el
	 * casillero seleccionado y dejar al resto en false. Cuando se arme debería
	 * reemplazar a la función que hay en BifurcacionCasillero
	 * (seleccionarNext()).
	 */
	public void setSiguiente() {
		// En desarrollo.
	}

	/**
	 * Retorna el atributo de casillero o casilleros siguientes. No indica a qué
	 * casillero hay que ir, únicamente indica qué casilleros le siguen a this
	 * en el mapa.
	 * 
	 * @return array de SiguienteCasillero
	 */
	public SiguienteCasillero[] getSiguientes() {
		SiguienteCasillero[] arr = new SiguienteCasillero[4];
		
		
		return null;
	}

	public void setSiguientes(SiguienteCasillero[] nexts) {
		// this.siguientes = nexts;
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
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void cardinalidad(Casillero siguiente, char orientacion) {

		switch (orientacion) {
		case 'N':
			norte = new SiguienteCasillero(siguiente, EnumDireccion.N);
			break;
		case 'S':
			sur = new SiguienteCasillero(siguiente, EnumDireccion.S);
			break;
		case 'E':
			este = new SiguienteCasillero(siguiente, EnumDireccion.E);
			break;
		case 'O':
			oeste = new SiguienteCasillero(siguiente, EnumDireccion.O);
			break;
		default:
			break;
		}
	}

	public SiguienteCasillero getNorte() {
		return norte;
	}

	public void setNorte(SiguienteCasillero norte) {
		this.norte = norte;
	}

	public SiguienteCasillero getSur() {
		return sur;
	}

	public void setSur(SiguienteCasillero sur) {
		this.sur = sur;
	}

	public SiguienteCasillero getOeste() {
		return oeste;
	}

	public void setOeste(SiguienteCasillero oeste) {
		this.oeste = oeste;
	}

	public SiguienteCasillero getEste() {
		return este;
	}

	public void setEste(SiguienteCasillero este) {
		this.este = este;
	}
}
