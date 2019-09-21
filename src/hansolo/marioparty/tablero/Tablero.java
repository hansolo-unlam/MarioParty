package hansolo.marioparty.tablero;

import java.util.ArrayList;
import java.util.List;

import hansolo.marioparty.tablero.casilleros.Casillero;

public class Tablero {
	private List<Casillero> casilleros;
	
	public Tablero(String path) {
		this.casilleros = cargarCasilleros(path);
	}
	
	private List<Casillero> cargarCasilleros(String path) {
		return new ArrayList<Casillero>();
	}
}
