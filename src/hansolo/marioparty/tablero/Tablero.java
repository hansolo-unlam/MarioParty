package hansolo.marioparty.tablero;
import java.util.HashMap;
import java.util.Map;

import hansolo.marioparty.tablero.casilleros.Casillero;
import hansolo.marioparty.utils.LeerArchivo;

public class Tablero {
	private Map<Integer, Casillero> casilleros;
	
	
	private Map<Integer, Casillero> cargarCasilleros(String path) {
		return new HashMap<Integer, Casillero>();
	}
	
	public Casillero getStart() {
		return casilleros.get(0);
	private List<Casillero> casilleros;

	public Tablero(String path) {
		this.casilleros = cargarCasilleros(path);
	}

	private List<Casillero> cargarCasilleros(String path) {
		LeerArchivo leer = new LeerArchivo(path);
		return casilleros =  leer.leerCasilleros();
		
		
	}
}
