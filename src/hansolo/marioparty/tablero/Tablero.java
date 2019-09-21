package hansolo.marioparty.tablero;
import java.util.HashMap;
import java.util.Map;

import hansolo.marioparty.tablero.casilleros.Casillero;

public class Tablero {
	private Map<Integer, Casillero> casilleros;
	
	public Tablero(String path) {
		this.casilleros = cargarCasilleros(path);
	}
	
	private Map<Integer, Casillero> cargarCasilleros(String path) {
		return new HashMap<Integer, Casillero>();
	}
	
	public Casillero getStart() {
		return casilleros.get(0);
	}
}
