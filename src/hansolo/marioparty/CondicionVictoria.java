package hansolo.marioparty;

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
