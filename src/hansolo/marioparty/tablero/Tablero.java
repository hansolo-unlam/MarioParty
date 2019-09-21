package hansolo.marioparty.tablero;
import java.io.FileNotFoundException;
import java.util.Map;

import hansolo.marioparty.tablero.casilleros.Casillero;
import hansolo.marioparty.utils.LeerArchivo;
import hansolo.marioparty.utils.LoaderMapa;

public class Tablero {
	private Map<Integer, Casillero> casilleros;

	public Tablero(String path) {
		cargarCasilleros(path);
	}
	
	private void cargarCasilleros(String path) {
		LeerArchivo leer;
		try {
			leer = new LeerArchivo(path);
			LoaderMapa loader = new LoaderMapa(leer, this);
			
			loader.leerCasilleros();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No se encontró el archivo del mapa");
			e.printStackTrace();
		}
	}
	
	public Casillero getStart() {
		return casilleros.get(0);
	}

	public Map<Integer, Casillero> getCasilleros() {
		return casilleros;
	}

	public void setCasilleros(Map<Integer, Casillero> casilleros) {
		this.casilleros = casilleros;
	}
}
