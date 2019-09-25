package hansolo.marioparty;

/**
 * Define bajo qué condiciones algún jugador puede ser considerado como el ganador de una partida.
 * Ej: Si tipo es ESTRELLA y cant es 3, ganará el jugador que alcance primero la cantidad de 3 estrellas.
 * @author facundotourn
 * 
 */
public class CondicionVictoria {
	private TipoCondicionVictoria tipo;
	private int cant;
	
	public CondicionVictoria(TipoCondicionVictoria tipo, int cant) {
		this.tipo = tipo;
		this.cant = cant;
	}

	public TipoCondicionVictoria getTipo() {
		return tipo;
	}

	public void setTipo(TipoCondicionVictoria tipo) {
		this.tipo = tipo;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}
}
