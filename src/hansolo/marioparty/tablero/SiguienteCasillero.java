package hansolo.marioparty.tablero;

/**
 * Objeto que tiene información de un casillero siguiente, en particular su id y en qué dirección se encuentra relativo al casillero anterior
 * También tiene información con respecto a si este es el casillero seleccionado para avanzar.
 * @author facundotourn
 *
 */
public class SiguienteCasillero {
	private int id;
	private EnumDireccion direccion;
	private boolean seleccionado;
	
	public SiguienteCasillero(int id, EnumDireccion direccion) {
		this.id = id;
		this.direccion = direccion;
		this.seleccionado = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
