package hansolo.marioparty.tablero;

public class SiguienteCasillero {
	private int id;
	private EnumDireccion direccion;
	
	public SiguienteCasillero(int id, EnumDireccion direccion) {
		this.id = id;
		this.direccion = direccion;
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
}
