package hansolo.marioparty.tablero;

/**
 * Objeto que tiene información de un casillero siguiente, en particular su id y
 * en qué dirección se encuentra relativo al casillero anterior También tiene
 * información con respecto a si este es el casillero seleccionado para avanzar.
 * 
 * @author facundotourn
 *
 */
public class SiguienteCasillero {
	private Casillero casilleroSiguiente;
	private EnumDireccion direccion;
	private boolean seleccionado;

	public SiguienteCasillero(Casillero siguiente, EnumDireccion orientacion) {
		this.casilleroSiguiente = siguiente;
		this.direccion = orientacion;
		this.seleccionado = true;
	}

	public Casillero getSiguiente() {
		return casilleroSiguiente;
	}

	public void setCasillero(Casillero siguiente) {
		this.casilleroSiguiente = siguiente;
	}

	public EnumDireccion getDireccion() {
		return direccion;
	}

	public void setDireccion(EnumDireccion direccion) {
		this.direccion = direccion;
	}

	public boolean isSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
}
